(def MAX-CONNECTIONS 10)

(def ^:dynamic RABBITMQ-CONNECTION)
(binding [RABBITMQ-CONNECTION (new-connection)]
  (
   ;; do something here with RABBITMQ-CONNECTION
   ))

(def ^:dynamic *db-host* "localhost")
(defn expense-report [start-date end-date]
  (println *db-host*))
(binding [*db-host* "production"]
  (expense-report "2010-01-01" "2010-01-07"))
(expense-report "2010-01-01" "2010-01-07")

(def ^:dynamic *eval-me* 10)
(defn print-the-var [label]
  (println label *eval-me*))
(print-the-var "A:")
(binding [*eval-me* 20] ;; the first binding
  (print-the-var "B:")
  (binding [*eval-me* 30] ;; the second binding
    (print-the-var "C:"))
  (print-the-var "D:"))
(print-the-var "E:")

(defn ^:dynamic twice [x]
  (println "original function")
  (* 2 x))
(defn call-twice [y]
  (twice y))
(defn with-log [function-to-call log-statement]
  (fn [& args]
    (println log-statement)
    (apply function-to-call args)))
(call-twice 10)
(binding [twice (with-log twice "Calling the twice function")]
  (call-twice 20))
(call-twice 30)

(def ^:dynamic *factor* 10)
(defn multiply [x]
  (* x *factor*))
(map multiply [1 2 3 4 5])
(binding [*factor* 20]
  (doall (map multiply [1 2 3 4 5])))

(let [x 10
      y 20]
  (println "x, y: " x "," y))
(defn upcased-names [names]
  (let [up-case (fn [name] (.toUpperCase name))]
    (map up-case names)))
(upcased-names ["foo" "bar" "baz"])

(def ^:dynamic *factor* 10)
(binding [*factor* 20]
  (println *factor*)
  (doall (map multiply [1 2 3 4 5])))
(let [*factor* 20]
  (println *factor*)
  (doall (map multiply [1 2 3 4 5])))

(defn create-scaler [scale]
  (fn [x]
    (* x scale)))
(def percent-scaler (create-scaler 100))
(percent-scaler 0.59)
