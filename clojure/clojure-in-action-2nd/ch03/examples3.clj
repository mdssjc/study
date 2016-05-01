(def users
  [{:username "kyle"
    :firstname "Kyle"
    :lastname "Smith"
    :balance 175.00M ; Use BigDecimals for money!
    :member-since "2009-04-16"}
   {:username "zak"
    :firstname "Zackary"
    :lastname "Jones"
    :balance 12.95M
    :member-since "2009-02-01"}
   {:username "rob"
    :firstname "Robert"
    :lastname "Jones"
    :balance 98.50M
    :member-since "2009-03-30"}])
(defn sorter-using [ordering-fn]
  (fn [collection]
    (sort-by ordering-fn collection)))
(defn lastname-firstname [user]
  [(user :lastname) (user :firstname)])
(defn balance [user] (user :balance))
(defn username [user] (user :username))
(def poorest-first (sorter-using balance))
(def alphabetically (sorter-using username))
(def last-then-firstname (sorter-using lastname-firstname))

(map username users)
(sort *1)
(sort-by username users)
(poorest-first users)
(map lastname-firstname users)
(sort *1)
(last-then-firstname users)
