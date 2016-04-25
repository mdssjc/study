;; Metadata
(def untrusted ^{:safe false :io true} {:command "delete-table" :subject "users"})
(def trusted {:command "delete-table" :subject "users"})
untrusted
trusted
(= trusted untrusted)

(meta untrusted)
(meta trusted)

(def still-untrusted (assoc untrusted :complete? false))
still-untrusted

(meta still-untrusted)

(defn ^{:safe true :console true
        :doc "testing metadata for functions"}
  testing-meta
  []
  (println "Hello from meta!"))

(meta testing-meta)
(meta (var testing-meta))

(set! *warn-on-reflection* true)
(defn string-length [x] (.length x))
(time (reduce + (map string-length (repeat 10000 "12345"))))
(defn fast-string-length [^String x] (.length x))
(time (reduce + (map fast-string-length (repeat 10000 "12345"))))
(meta #'fast-string-length)
(meta (first (first (:arglists (meta #'fast-string-length)))))

(defn array-type [klass]
  (.getName (class (make-array klass 0))))
(array-type BigDecimal)
(def bigdec-arr
  ^"[Ljava.math.BigDecimal;"
  (into-array BigDecimal [1.0M]))

(defn average [numbers]
  (let [total (apply + numbers)]
    (/ total (count numbers))))
(average [])                            ; wrong
(defn safe-average [numbers]
  (let [total (apply + numbers)]
    (try
      (/ total (count numbers))
      (catch ArithmeticException e
        (println "Divided by zero!")
        0)
      (finally
        (println "done.")))))
(safe-average [])
(throw (Exception. "this is an error!"))
