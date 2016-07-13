(declare ^:dynamic this)

(defn new-object [klass]
  (let [state (ref {})]
    (fn thiz [command & args]
      (case command
        :class klass
        :class-name (klass :name)
        :set! (let [[k v] args]
                (dosync (alter state assoc k v))
                nil)
        :get (let [[key] args] (@state key))
        (let [method (klass :method command)]
          (if-not method
            (throw (RuntimeException.
                    (str "Unable to respond to " command))))
          (binding [this thiz]
            (apply method args)))))))

(defn find-method [method-name instance-methods]
  (instance-methods method-name))

(defn new-class [class-name methods]
  (fn klass [command & args]
    (case command
      :name (name class-name)
      :new (new-object klass)
      :method (let [[method-name] args]
                (find-method method-name methods)))))

(defclass Person
  (method age [] (* 2 10))
  (method about [diff]
          (str "I was born about " (+ diff (this :age)) " years ago")))

(Person :method :age)
((Person :method :age))

(def shelly (Person :new))
(shelly :age)
(shelly :about 2)
