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
