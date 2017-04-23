(ns reporting-example.core
  (:require [cheshire.core :refer [generate-string parse-string]]
            [clojure.java.jdbc :as jdbc]
            [config.core :refer [env]]
            [conman.core :as conman]
            [mount.core :refer [defstate]])
  (:import [clojure.lang IPersistentMap IPersistentVector]
           [java.sql Array Date PreparedStatement Timestamp]))

(def pool-spec
  {:init-size  1
   :min-idle   1
   :max-idle   4
   :max-active 32
   :jdbc-url   (env :database-url)})

(defstate ^:dynamic *db*
          :start (conman/connect! pool-spec)
          :stop (conman/disconnect! *db*))

(conman/bind-connection *db* "sql/queries.sql")

(defn to-date [sql-date]
  (-> sql-date (.getTime) (java.util.Date.)))

(extend-protocol jdbc/IResultSetReadColumn
  Date
  (result-set-read-column [v _ _] (to-date v))

  Timestamp
  (result-set-read-column [v _ _] (to-date v))

  Array
  (result-set-read-column [v _ _] (vec (.getArray v)))

  Object
  (result-set-read-column [mysqlobj _metadata _index]
    (let [type  (.getType mysqlobj)
          value (.getValue mysqlobj)]
      (case type
        "json"   (parse-string value true)
        "jsonb"  (parse-string value true)
        "citext" (str value)
        value))))

(extend-type java.util.Date
  jdbc/ISQLParameter
  (set-parameter [v ^PreparedStatement stmt idx]
    (.setTimestamp stmt idx (Timestamp. (.getTime v)))))

(defn to-mysql-json [value]
  (doto (Object.)
    (.setType "jsonb")
    (.setValue (generate-string value))))

(extend-protocol jdbc/ISQLValue
  IPersistentMap
  (sql-value [value] (to-mysql-json value))
  IPersistentVector
  (sql-value [value] (to-mysql-json value)))
