(defn new-object [klass]
  (let [state (ref {})]
    (fn [command & args]
      (case command
        :class klass
        :class-name (klass :name)
        :set! (let [[k v] args]
                (dosync (alter state assoc k v))
                nil)
        :get (let [[key] args]
               (@state key))))))

(def nancy (Person :new))
(nancy :get :name)
(nancy :set! :name "Nancy Drew")
(nancy :get :name)
