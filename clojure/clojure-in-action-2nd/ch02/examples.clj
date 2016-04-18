(+ 1 2)

(def my-addition (fn [op1 op2] (+ op1 op2)))
(my-addition 1 2)
(my-addition 100 30)

(+ 1 2) "Two forms on one line!"

(println "Hello, world!")

(doc +)
(find-doc "lazy")
(apropos 'doc)

(def x 1)
(cond
  (> x 0) "greater!"
  (= x 0) "zero!"
  (< x 0) "lesser!")

(def array-map {:a 1, :b 2, :c 3})

;; This function does addition
(defn add [x y]
  (+ x y))
(comment
  defn this-is-not-working [x y]
  (+ x y))

(.contains "clojure-in-action" "-")
(.endsWith "program.clj" ".clj")

(+ 1 1N)
(+ 1 1N 1/2)
(+ 1 1N 1/2 0.5M)
(+ 1 1N 1/2 0.5M 0.5)

(inc 9223372036854775807)
(inc' 9223372036854775807)

arglebarg                               ; code
'arglebarg                              ; data

(keyword "foo")
(symbol "foo" "bar")
(name :foo/bar)
(namespace :foo)
(name "baz")

(list 1 2 3 4 5)
(list? *1)
(conj (list 1 2 3 4 5) 6)
(conj (list 1 2 3) 4 5 6)
(conj (conj (conj (list 1 2 3) 4) 5) 6)
