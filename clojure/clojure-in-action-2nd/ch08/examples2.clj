(defn adder [num1 num2]
  (let [x (+ num1 num2)]
    (fn [y]
      (+ x y))))
(def add-5 (adder 2 3))
(add-5 10)

(defn new-user [login password email]
  (fn [a]
    (case a
      :login login
      :password password
      :email email
      nil)))
(def arjun (new-user "arjun" "secret" "arjun@zololabs.com"))
(arjun :login)
(arjun :password)
(arjun :email)
(arjun :name)

(defn new-user [login password email]
  (fn [a]
    (case a
      :login login
      :email email
      :password-hash (hash password)
      nil)))
(def arjun (new-user "arjun" "secret" "arjun@zololabs.com"))
(arjun :password)
(arjun :password-hash)

(defn new-user [login password email]
  (fn [a & args]
    (case a
      :login login
      :email email
      :authenticate (= password (first args)))))
(def adi (new-user "adi" "secret" "adi@currylogic.com"))
(adi :authenticate "blah")
(adi :authenticate "secret")
