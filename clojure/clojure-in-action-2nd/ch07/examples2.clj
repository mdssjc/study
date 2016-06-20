(defmacro infix [expr]
  (let [[left op right] expr]
    (list op left right)))

(defmacro randomly [& exprs]
  (let [len (count exprs)
        index (rand-int len)
        conditions (map #(list '= index %) (range len))]
    `(cond ~@(interleave conditions exprs))))
(macroexpand-1
 '(randomly (println "amit") (println "deepthi") (println "adi")))
(randomly (println "amint") (println "deepthi") (println "adi"))

(defmacro randomly-2 [& exprs]
  (nth exprs (rand-int (count exprs))))
(defmacro randomly-2 [& exprs]
  (let [c (count exprs)]
    `(case (rand-int ~c) ~@(interleave (range c) exprs))))
(randomly-2 (println "amint") (println "deepthi") (println "adi"))

(def request {:username "amit" :password "123456"})

(defn check-credentials [username password]
  true)
(defn login-user [request]
  (let [username (:username request)
        password (:password request)]
    (if (check-credentials username password)
      (str "Welcome back, " username ", " password " is correct!")
      (str "Login failed!"))))
(login-user request)

(defmacro defwebmethod [name args & exprs]
  `(defn ~name [{:keys ~args}]
     ~@exprs))
(defwebmethod login-user [username password]
  (if (check-credentials username password)
    (str "Welcome, " username ", " password " is still correct!")
    (str "Login failed!")))
(login-user request)

(defmacro defnn [fname [& names] & body]
  (let [ks {:keys (vec names)}]
    `(defn ~fname [& {:as arg-map#}]
       (let [~ks arg-map#]
         ~@body))))
(defnn print-details [name salary start-date]
  (println "Name:" name)
  (println "Salary:" salary)
  (println "Started on:" start-date))
(print-details :start-date "10/22/2009" :name "Rob" :salary 1000000)

(defmacro assert-true [test-expr]
  (let [[operator lhs rhs] test-expr]
    `(let [rhsv# ~rhs ret# ~test-expr]
       (if-not ret#
         (throw (RuntimeException.
                 (str '~lhs " is not " '~operator " " rhsv#)))
         true))))
(defmacro assert-true [test-expr]
  (if-not (= 3 (count test-expr))
    (throw (RuntimeException.
            "Argument must be of the form
(operator test-expr expected-expr)")))
  (if-not (some #{(first test-expr)} '(< > <= >= = not=))
    (throw (RuntimeException.
            "operator must be one of < > <= >= = not=")))
  (let [[operator lhs rhs] test-expr]
    `(let [rhsv# ~rhs ret# ~test-expr]
       (if-not ret#
         (throw (RuntimeException.
                 (str '~lhs " is not " '~operator " " rhsv#)))
         true))))
(assert-true (>= (* 2 4) (/ 18 2)))
(assert-true (>= (* 2 4) (/ 18 2) (+ 2 5)))
(assert-true (<> (* 2 4) (/ 16 2)))
