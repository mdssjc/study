;; FUTURES
(defn long-calculation [num1 num2]
  (Thread/sleep 5000)
  (* num1 num2))

(defn long-run []
  (let [x (long-calculation 11 13)
        y (long-calculation 13 17)
        z (long-calculation 17 19)]
    (* x y z)))
(time (long-run))

(defn fast-run []
  (let [x (future (long-calculation 11 13))
        y (future (long-calculation 13 17))
        z (future (long-calculation 17 19))]
    (* @x @y @z)))
(time (fast-run))

;; PROMISES
(def p (promise))
(def value (deref p))
@p
(deliver promise value)

(let [p (promise)]
  (future (Thread/sleep 5000)
          (deliver p :done))
  @p)
