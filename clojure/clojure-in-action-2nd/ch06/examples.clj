;; REFS
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

;; AGENTS
(def total-cpu-time (agent 0))

(deref total-cpu-time)
@total-cpu-time

(send total-cpu-time + 700)

(def bad-agent (agent 10))
(send bad-agent / 0)
(deref bad-agent)
(send bad-agent / 2)
(agent-error bad-agent)

(let [e (agent-error bad-agent)
      st (.getStackTrace e)]
  (println (.getMessage e))
  (println (clojure.string/join "\n" st)))

(clear-agent-errors bad-agent)

;; ATOMS
(def total-rows (atom 0))

(deref total-rows)
@total-rows

(reset! total-rows 0)
(swap! total-rows + 100)
(compare-and-set! total-rows 100 101)

;; VARS
(def hbase-master "localhost")
(def ^:dynamic *hbase-master* "localhost")

(def ^:dynamic *mysql-host*)
(defn db-query [db]
  (binding [*mysql-host* db]
    (count *mysql-host*)))
(def mysql-hosts ["test-mysql" "dev-mysql" "staging-mysql"])
(pmap db-query mysql-hosts)
