(ns reporting-example.handler
  (:require [clojure.tools.logging :as log]
            [compojure.core :refer [defroutes routes wrap-routes]]
            [compojure.route :as route]
            [config.core :refer [env]]
            [luminus.logger :as logger]
            [mount.core :as mount]
            [reporting-example.config :refer [defaults]]
            [reporting-example.layout :refer [error-page]]
            [reporting-example.middleware :as middleware]
            [reporting-example.routes.home :refer [home-routes]]))

(defn init
  "init will be called once when
   app is deployed as a servlet on
   an app server such as Tomcat
   put any initialization code here"
  []
  (logger/init env)
  (doseq [component (:started (mount/start))]
    (log/info component "started"))
  ((:init defaults)))

(defn destroy
  "destroy will be called when your application
   shuts down, put any clean up code here"
  []
  (log/info "reporting-example is shutting down...")
  (doseq [component (:stopped (mount/stop))]
    (log/info component "stopped"))
  (log/info "shutdown complete!"))

(def app-routes
  (routes
    #'home-routes
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))

(def app (middleware/wrap-base #'app-routes))
