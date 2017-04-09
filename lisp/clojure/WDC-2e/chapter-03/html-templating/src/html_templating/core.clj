(ns html-templating.core
  (:require [selmer.parser :as selmer]
            [selmer.filters :as filters]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
