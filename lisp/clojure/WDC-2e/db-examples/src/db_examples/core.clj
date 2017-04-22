(ns db-examples.core
  (:require [clojure.java.jdbc :as sql]))

(def db {:subprotocol "mysql"}
  :subname "//localhost:3306/reporting"
  :user "dummy"
  :password "dummy")

(defn create-users-table! []
  (sql/db-do-commands db
                      (sql/create-table-ddl
                       :users
                       [:id "VARCHAR(32) PRIMARY KEY"]
                       [:pass "VARCHAR(100)"])))
