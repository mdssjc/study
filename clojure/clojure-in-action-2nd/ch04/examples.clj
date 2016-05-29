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

(defmulti affiliate-fee (fn [user] (:referrer user)))
(defmethod affiliate-fee "mint.com" [user]
  (fee-amount 0.03M user))
(defmethod affiliate-fee "google.com" [user]
  (fee-amount 0.01M user))
(defmethod affiliate-fee :default [user]
  (fee-amount 0.02M user))
(affiliate-fee example-user)

(ns-unmap 'user 'affiliate-fee)
(defmulti affiliate-fee :referrer :default "*")
(defmethod affiliate-fee "*" [user]
  (fee-amount 0.02M user))
(affiliate-fee example-user)

(defmethod my-multi :default [arg] "body")
(defmethod my-many-arity-multi :default
  ([] "no argument")
  ([x] "one argument")
  ([x & etc] "many arguments"))

(defmethod affiliate-fee "mint.com" [user]
  (fee-amount 0.03M user))
(defmethod affiliate-fee "google.com" [user]
  (fee-amount 0.01M user))
(methods affiliate-fee)
(get-method affiliate-fee "mint.com")
(get (methods affiliate-fee) "example.org")
(get-method affiliate-fee "example.org")
((get-method affiliate-fee "mint.com") example-user)

(def user-1 {:login "rob" :referrer "mint.com" :salary 100000
             :rating :rating/bronze})
(def user-2 {:login "gordon" :referrer "mint.com" :salary 80000
             :rating :rating/silver})
(def user-3 {:login "kyle" :referrer "google.com" :salary 90000
             :rating :rating/gold})
(def user-4 {:login "celeste" :referrer "yahoo.com" :salary 70000
             :rating :rating/platinum})

(defn fee-category [user]
  [(:referrer user) (:rating user)])
(map fee-category [user-1 user-2 user-3 user-4])

(defmulti profit-based-affiliate-fee fee-category)
(defmethod profit-based-affiliate-fee ["mint.com" :rating/bronze]
  [user] (fee-amount 0.03M user))
(defmethod profit-based-affiliate-fee ["mint.com" :rating/silver]
  [user] (fee-amount 0.04M user))
(defmethod profit-based-affiliate-fee ["mint.com" :rating/gold]
  [user] (fee-amount 0.05M user))
(defmethod profit-based-affiliate-fee ["mint.com" :rating/platinum]
  [user] (fee-amount 0.05M user))
(defmethod profit-based-affiliate-fee ["google.com" :rating/gold]
  [user] (fee-amount 0.03M user))
(defmethod profit-based-affiliate-fee ["google.com" :rating/platinum]
  [user] (fee-amount 0.03M user))
(defmethod profit-based-affiliate-fee :default
  [user] (fee-amount 0.02M user))
(map profit-based-affiliate-fee [user-1 user-2 user-3 user-4])

;; Subtype polymorphism using multimethods
(derive :rating/bronze :rating/basic)
(derive :rating/silver :rating/basic)
(derive :rating/gold :rating/premier)
(derive :rating/platinum :rating/premier)
(derive :rating/basic :rating/ANY)
(derive :rating/premier :rating/ANY)

(isa? :rating/gold :rating/premier)
(isa? :rating/gold :rating/ANY)
(isa? :rating/ANY :rating/premier)
(isa? :rating/gold :rating/gold)
(parents :rating/premier)
(ancestors :rating/gold)
(descendants :rating/ANY)

(defmulti greet-user :rating)
(defmethod greet-user :rating/basic [user]
  (str "Hello " (:login user) \.))
(defmethod greet-user :rating/premier [user]
  (str "Welcome, " (:login user) ", valued affiliate member!"))
(map greet-user [user-1 user-2 user-3 user-4])

(remove-method profit-based-affiliate-fee ["mint.com" :rating/gold])
(remove-method profit-based-affiliate-fee ["mint.com" :rating/platinum])
(remove-method profit-based-affiliate-fee ["google.com" :rating/gold])
(remove-method profit-based-affiliate-fee ["google.com" :rating/platinum])

(defmethod profit-based-affiliate-fee ["mint.com" :rating/premier]
  [user] (fee-amount 0.05M user))
(defmethod profit-based-affiliate-fee ["google.com" :rating/premier]
  [user] (fee-amount 0.03M user))
(map profit-based-affiliate-fee [user-1 user-2 user-3 user-4])
