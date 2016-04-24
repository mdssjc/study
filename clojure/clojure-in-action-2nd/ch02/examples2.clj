;; Conditionals
(if (> 5 2) "yes" "no")
(if-not (> 5 2) "yes" "no")

(def x 1)
(cond
 (> x 0) "greater!"
 (= x 0) "zero!"
 :default "lesser!")

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

;; Logical Functions
(and)
(and :a :b :c)
(and :a nil :c)
(and :a false :c)
(and 0 "")

(or)
(or :a :b :c)
(or :a nil :c)
(or nil false)
(or false nil)

(not true)
(not 1)
(not nil)

(< 2 4 6 8)
(< 2 4 3 8)

(= 1 1N 1/1)
(= 0.5 1/2)
(= 0.5M 0.5)
(= 0.5M 1/2)

(== 1 1N 1/1)
(== 1/2 0.5M 0.5)
1.9999999999999999
(== 2.0M 1.9999999999999999)
(== :a 1)                               ; wrong
(== nil 1)                              ; wrong

;; Functional Iteration
(defn fact-loop [n]
  (loop [current n fact 1]
    (if (= current 1)
      fact
      (recur (dec current ) (* fact current)))))
(fact-loop 5)
(defn sum-loop [n]
  (loop [current n sum 0]
    (if (= current 0)
      sum
      (recur (dec current) (+ sum current)))))
(sum-loop 5)

(def user (list "A" "B" "C" "D"))
(defn run-report [user]
  (println "Running report for " user))
(defn dispatch-reporting-jobs [all-users]
  (doseq [user all-users]
    (run-report user)))
(dispatch-reporting-jobs user)

(dotimes [x 5]
  (println "X is" x))

(map inc [0 1 2 3])
(map + [0 1 2 3] [0 1 2 3])
(map + [0 1 2 3] [0 1 2])

(defn non-zero-expenses [expenses]
  (let [non-zero? (fn [e] (not (zero? e)))]
    (filter non-zero? expenses)))
(non-zero-expenses [-2 -1 0 1 2 3])
(defn non-zero-expenses [expenses]
  (remove zero? expenses))
(non-zero-expenses [-2 -1 0 1 2 3])

(defn factorial [n]
  (let [numbers (range 1 (+ n 1))]
    (reduce * numbers)))
(factorial 5)
(defn factorial-steps [n]
  (let [numbers (range 1 (+ n 1))]
    (reductions * numbers)))
(factorial-steps 5)
(map factorial (range 1 6))

(def chessboard-labels
  (for [alpha "abcdefgh"
        num (range 19)]
    (str alpha num)))
chessboard-labels

(defn prime? [x]
  (let [divisors (range 2 (inc (int (Math/sqrt x))))
        remainders (map (fn [d] (rem x d)) divisors)]
    (not (some zero? remainders))))
(prime? 3)
(defn primes-less-than [n]
  (for [x (range 2 (inc n)) :when (prime? x)]
    x))
(primes-less-than 50)
(defn pairs-for-primes [n]
  (let [z (range 2 (inc n))]
    (for [x z y z :when (prime? (+ x y))]
      (list x y))))
(pairs-for-primes 5)
