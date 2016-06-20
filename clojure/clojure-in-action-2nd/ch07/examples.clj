(def a-ref (ref 0))

(defmacro sync-set [r v]
  (list 'dosync
        (list 'ref-set r v)))

(dosync
 (ref-set a-ref 1))
(sync-set a-ref 1)

(defmacro unless [test then]
  (list 'if (list 'not test)
        then))
(defmacro unless [test then]
  `(if (not ~test)
     ~then))

(defn exhibits-oddity? [x]
  (unless (even? x)
          (println "Very odd, indeed!")))
(macroexpand
 '(unless (even? x) (println "Very odd, indeed!")))
(exhibits-oddity? 11)

(defmacro unless [test & exprs]
  `(if (not ~test)
     (do ~@exprs)))

(defn exhibits-oddity? [x]
  (unless (even? x)
          (println "Odd!")
          (println "Very odd!")))
(macroexpand-1  '(unless (even? x)
                         (println "Odd!")
                         (println "Very odd!")))
(exhibits-oddity? 11)
