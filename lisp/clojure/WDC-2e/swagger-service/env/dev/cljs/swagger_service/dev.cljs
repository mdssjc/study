(ns ^:figwheel-no-load swagger-service.app
  (:require [swagger-service.core :as core]
            [figwheel.client :as figwheel :include-macros true]))

(enable-console-print!)

(figwheel/watch-and-reload
 :websocket-url "ws://localhost:3449/figwheel-ws"
 :on-jsload core/mount-components)

(core/init!)
