(defn parent-class-spec [sexprs]
  (let [extends-spec (filter #(= 'extends (first %)) sexprs)
        extends (first extends-spec)]
    (if (empty? extends)
      'OBJECT
      (last extends))))

(defmacro defclass [class-name & specs]
  (let [parent-class (parent-class-spec specs)
        fns (or (method-specs specs) {})]
    `(def ~class-name (new-class '~class-name #'~parent-class ~fns))))

(defn find-method [method-name klass]
  (or ((klass :methods) method-name)
      (if-not (= #'OBJECT klass)
        (find-method method-name (klass :parent)))))

(defn new-class [class-name parent methods]
  (fn klass [command & args]
    (case command
      :name (name class-name)
      :parent parent
      :new (new-object klass)
      :methods methods
      :method (let [[method-name] args]
                (find-method method-name klass)))))

(def OBJECT (new-class :OBJECT nil {}))

(parent-class-spec '((extends Person)
                     (method age [] (* 2 9))))

(defclass Person
  (method age [] (* 2 10))
  (method about [diff]
          (str "I was born about " (+ diff (this :age)) " years ago")))

(defclass Woman
  (extends Person)
  (method greet [v] (str "Hello, " v))
  (method age [] (* 2 9)))

(var map)
(def donna (Woman :new))
(donna :greet "Shelly")
(donna :age)
(donna :about 3)
