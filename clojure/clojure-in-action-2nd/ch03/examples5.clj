(ns org.currylogic.damages.http.expenses)
(require '(clojure.data [json :as json-lib]))
(require '(clojure [xml :as xml-core]))
;;(use 'clojure.data.json)
;;(use 'clojure.xml)

(declare load-totals)

(defn import-transactions-xml-from-bank [url]
  (let [xml-document (xml-core/parse url)]))

(defn totals-by-day [start-date end-date]
  (let [expenses-by-day (load-totals start-date end-date)]
  (json-lib/json-str expenses-by-day)))
