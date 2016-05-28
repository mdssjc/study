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
