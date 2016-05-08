(ns org.currylogic.damages.http.expenses
  (:require [clojure.data.json :as json-lib]
            [clojure.xml :as xml-core]))
;; (require '(clojure.data [json :as json-lib]))
;; (require '(clojure [xml :as xml-core]))
;; (use 'clojure.data.json)
;; (use 'clojure.xml)

(declare load-totals)

(defn import-transactions-xml-from-bank [url]
  (let [xml-document (xml-core/parse url)]))

(defn totals-by-day [start-date end-date]
  (let [expenses-by-day (load-totals start-date end-date)]
  (json-lib/json-str expenses-by-day)))

;; ---
(def mds {:first-name "Marcelo"
          :last-name "dos Santos"
          :salary 100})

(defn describe-salary [person]
  (let [first (:first-name person)
        last (:last-name person)
        annual (:salary person)]
    (println first last "earns" annual)))

(defn describe-salary2 [{first :first-name
                         last :last-name
                         annual :salary}]
  (println first last "earns" annual))

(describe-salary mds)
(describe-salary2 mds)
