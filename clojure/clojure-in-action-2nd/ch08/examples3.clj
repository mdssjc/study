(defn new-class [class-name]
  (fn [command & args]
    (case command
      :name (name class-name))))
(defmacro defclass [class-name]
  `(def ~class-name (new-class '~class-name)))

(defclass Person)
(Person :name)

(def some-class Person)
(some-class :name)

(defn new-object [klass]
  (fn [command & args]
    (case command
      :class klass
      :class-name (klass :name))))
(def cindy (new-object Person))
(new-object Person)
((cindy :class) :name)
(cindy :class-name)

(defn new-class [class-name]
  (fn klass [command & args]
    (case command
      :name (name class-name)
      :new (new-object klass))))

(defclass Person)
(def nancy (Person :new))
(nancy :class-name)
