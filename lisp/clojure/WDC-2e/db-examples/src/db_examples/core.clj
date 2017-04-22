(ns db-examples.core
  (:require [clojure.java.jdbc :as sql]))

(def db {:subprotocol "postgresql"}
  :subname "//localhost:3306/reporting"
  :user "dummy"
  :password "dummy")

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
