(ns org.currylogic.damages.http.expenses)
(use 'clojure.data.json)
(use 'clojure.xml)

(declare load-totals)

(defn import-transactions-xml-from-bank [url]
  (let [xml-document (parse url)]))

(defn totals-by-day [start-date end-date]
  (let [expenses-by-day (load-totals start-date end-date)]
  (json-str expenses-by-day)))
