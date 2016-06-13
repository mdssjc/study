(def all-users (ref {}))

(deref all-users)
@all-users
all-users

(ref-set all-users {})
(dosync
 (ref-set all-users {}))

(defn new-user [id login monthly-budget]
  {:id id
   :login login
   :monthly-budget monthly-budget
   :total-expenses 0})

(defn add-new-user [login budget-amount]
  (dosync
   (let [current-number (count @all-users)
         user (new-user (inc current-number) login budget-amount)]
     (alter all-users assoc login user))))

(add-new-user "amit" 1000000)
(add-new-user "deepthi" 2000000)
