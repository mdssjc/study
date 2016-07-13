(defn method-spec [sexpr]
  (let [name (keyword (second sexpr))
        body (next sexpr)]
    [name (conj body 'fn)]))
(method-spec '(method age [] (* 2 10)))

(defn method-specs [sexprs]
  (->> sexprs
       (filter #(= 'method (first %)))
       (mapcat method-spec)
       (apply hash-map)))
(method-specs '((method age [] (* 2 10))
                (method greet [visitor] (str "Hello there, " visitor))))
