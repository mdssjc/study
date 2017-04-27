(ns picture-gallery.core
  (:require [picture-gallery.components.common :as c]
            [picture-gallery.components.registration :as reg])
  (:import goog.History))

(defn page []
  [:div
   [reg/registration-form-example]
   [(pages (session/get :page))]])

(defn mount-components []
  (r/render [#'navbar] (.getElementById js/document "navbar"))
  (r/render [#'page] (.getElementById js/document "app")))

(defn init! []
  (load-interceptors!)
  (hook-browser-navigation!)
  (mount-components))
