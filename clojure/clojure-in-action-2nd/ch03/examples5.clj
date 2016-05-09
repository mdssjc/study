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

(defn print-amounts [[amount-1 amount-2]]
  (println "Amounts are:" amount-1 "and" amount-2))
(print-amounts [10.95 31.45])

(defn print-amounts-multiple [[amount-1 amount-2 & remaining]]
  (println "Amounts are:" amount-1 "," amount-2 "and" remaining))
(print-amounts-multiple [10.95 31.45 22.36 2.95])

(defn print-all-multiple [[amount-1 amount-2 & remaining :as all]]
  (println "Amounts are:" amount-1 "," amount-2 "and" remaining)
  (println "Also, all the amounts are:" all))
(print-all-multiple [10.95 31.45 22.36 2.95])

(defn print-first-category [[[category amount] & _]]
  (println "First category was:" category)
  (println "First amount was:" amount))
(def expenses [[:books 49.95] [:coffee 4.95] [:caltrain 2.25]])
(print-first-category expenses)
