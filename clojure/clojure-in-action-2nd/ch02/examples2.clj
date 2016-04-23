;; Conditionals
;; if
(if (> 5 2) "yes" "no")
(if-not (> 5 2) "yes" "no")

;; cond
(def x 1)
(cond
 (> x 0) "greater!"
 (= x 0) "zero!"
 :default "lesser!")

;; when
(when (> 5 2)
  (println "five")
  (println "is")
  (println "greater")
  "done")
(when-not (< 5 2)
  (println "two")
  (println "is")
  (println "smaller")
  "done")
