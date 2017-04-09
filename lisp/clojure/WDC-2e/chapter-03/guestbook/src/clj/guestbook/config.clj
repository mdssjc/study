(ns guestbook.config
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [guestbook.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[guestbook started successfully using the development profile]=-"))
   :middleware wrap-dev})

;; (defstate env :start (load-config
;;                        :merge
;;                        [(args)
;;                         (source/from-system-props)
;;                         (source/from-env)]))
