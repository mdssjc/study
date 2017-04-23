(ns db-examples.core
  (:require [clojure.java.jdbc :as sql]))

(def db {:subprotocol "mysql"
         :subname "//localhost:3306/reporting"
         :user "dummy"
         :password "dummy"})

(defn create-users-table! []
  (sql/db-do-commands db
                      (sql/create-table-ddl
                       :users
                       [[:id "VARCHAR(32) PRIMARY KEY"]
                        [:pass "VARCHAR(100)"]])))

;(create-users-table!)

(defn get-user [id]
  (first (sql/query db ["SELECT * FROM users WHERE id = ?" id])))

(get-user "foo")

(defn add-user! [user]
  (sql/insert! db :users user))

(add-user! {:id "foo" :pass "bar"})

(defn add-users! [& users]
  (sql/insert-multi! db :users users))

(add-users! {:id "foo1" :pass "bar"}
            {:id "foo2" :pass "bar"}
            {:id "foo3" :pass "bar"})

(defn set-pass! [id pass]
  (sql/update!
   db
   :users
   {:pass pass}
   ["id=?" id]))

(set-pass! "foo" "bar")
