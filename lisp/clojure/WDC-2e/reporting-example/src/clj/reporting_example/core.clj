(ns reporting-example.core
  (:gen-class)
  (:require [config.core :refer [env]]
            [luminus
             [http-server :as http]
             [repl-server :as repl]]
            [reporting-example.db.migrations :as migrations]
            [reporting-example.handler :refer [app destroy init]]))

(defn parse-port [port]
  (when port
    (cond
      (string? port) (Integer/parseInt port)
      (number? port) port
      :else          (throw (Exception. (str "invalid port value: " port))))))

(defn http-port [port]
  ;;default production port is set in
  ;;env/prod/resources/config.edn
  (parse-port (or port (env :port))))

(defn stop-app []
  (repl/stop)
  (http/stop destroy)
  (shutdown-agents))

(defn start-app
  "e.g. lein run 3000"
  [[port]]
  (let [port (http-port port)]
    (.addShutdownHook (Runtime/getRuntime) (Thread. stop-app))
    (when-let [repl-port (env :nrepl-port)]
      (repl/start {:port (parse-port repl-port)}))
    (http/start {:handler app
                 :init    init
                 :port    port})))

(defn -main [& args]
  (cond
    (some #{"migrate" "rollback"} args)
    (do (migrations/migrate args) (System/exit 0))
    :else
    (start-app args)))
