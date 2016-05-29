;; Ad hoc Polymorphism
(defn ad-hoc-type-namer [thing]
  (condp = (type thing)
    java.lang.String "string"
    clojure.lang.PersistentVector "vector"))
(ad-hoc-type-namer "I'm a string")
(ad-hoc-type-namer [])
(ad-hoc-type-namer {})

(def type-namer-implementations
  {java.lang.String (fn [thing] "string")
   clojure.lang.PersistentVector (fn [thing] "vector")})
(defn open-ad-hoc-type-namer [thing]
  (let [dispatch-value (type thing)]
    (if-let [implementation
             (get type-namer-implementations dispatch-value)]
      (implementation thing)
      (throw (IllegalArgumentException
              (str "No implementation found for " dispatch-value))))))
(open-ad-hoc-type-namer "I'm a string")
(open-ad-hoc-type-namer [])
(open-ad-hoc-type-namer {})

(def type-namer-implementations
  (assoc type-namer-implementations
         clojure.lang.PersistentArrayMap (fn [thing] "map")))
(open-ad-hoc-type-namer {})

;; Subtype polymorphism
(defn map-type-namer [thing]
  (condp = (type thing)
    clojure.lang.PersistentArrayMap "map"
    clojure.lang.PersistentHashMap "map"))
(map-type-namer (hash-map))
(map-type-namer (array-map))
(map-type-namer (sorted-map))

(defn subtyping-map-type-namer [thing]
  (cond
    (instance? clojure.lang.APersistentMap thing) "map"
    :else (throw (IllegalArgumentException.
                  (str "No implementation found for ") (type thing)))))
(subtyping-map-type-namer (hash-map))
(subtyping-map-type-namer (array-map))
(subtyping-map-type-namer (sorted-map))

;; Polymorphism using multimethods
(def example-user {:login "rob" :referrer "mint.com" :salary 100000})

(defn fee-amount [percentage user]
  (with-precision 16 :rounding HALF_EVEN
    (* 0.01M percentage (:salary user))))
(defn affiliate-fee [user]
  (case (:referrer user)
    "google.com" (fee-amount 0.01M user)
    "mint.com" (fee-amount 0.03M user)
    (fee-amount 0.02M user)))
(affiliate-fee example-user)
