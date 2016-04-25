;; Functions
(defn total-cost
  "return line-item total of the item and quantity provided"
  [item-cost number-of-items]
  (* item-cost number-of-items))
;; (def total-cost (fn [item-cost number-of-items]
;;                   (* item-cost number-of-items)))
(total-cost 12.3 5)
(doc total-cost)
(meta #'total-cost)

(meta (defn myfn-attr-map {:a 1} []))
(meta (defn ^{:a 1} myfn-metadata []))
(meta (defn ^{:a 1} myfn-both {:a 2 :b 3} []))
(meta (defn ^{:a 1 :doc "doc 1"} myfn-redundant-docs "doc 2" {:a 2 :b 3 :doc "doc 3"} []))

(defn item-total [price quantity discount-percentage]
  {:pre [(> price 0) (> quantity 0)]
   :post [(> % 0)]}
  (->> (/ discount-percentage 100)
    (- 1)
    (* price quantity)
    float))
(item-total 100 2 0)
(item-total 100 2 10)
(item-total 100 -2 10)                  ; wrong
(item-total 100 2 110)                  ; wrong

(defn total-cost
  ([item-cost number-of-items]
   (* item-cost number-of-items))
  ([item-cost]
   (total-cost item-cost 1)))
(total-cost 12.3 5)
(total-cost 12.3)

(defn total-all-numbers [& numbers]
  (apply + numbers))
(total-all-numbers 1 2 3 4 5)

(defn many-arities
  ([] 0)
  ([a] 1)
  ([a b c] 3)
  ([a b c & more] "variadic"))
(many-arities)
(many-arities "one argument")
(many-arities "two" "arguments")        ; wrong
(many-arities "three" "argu-" "ments")
(many-arities "many" "more" "argu-" "ments")

(defn count-down [n]
  (when-not (zero? n)
    (when (zero? (rem n 100))
      (println "count-down:" n))
    (count-down (dec n))))
(count-down 10000)                      ; Stack Overflow Error
(defn count-down [n]
  (when-not (zero? n)
    (if (zero? (rem n 100))
      (println "count-down:" n))
    (recur (dec n))))
(count-down 10000)

(declare hat)
(defn cat [n]
  (when-not (zero? n)
    (when (zero? (rem n 100))
      (println "cat:" n))
    (fn [] (hat (dec n)))))
(defn hat [n]
  (when-not (zero? n)
    (when (zero? (rem n 100))
      (println "hat:" n))
    (fn [] (cat (dec n)))))
(trampoline cat 10000)
