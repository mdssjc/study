(map (fn [x] (.getBytes x)) ["amit" "rob" "kyle"])
(map #(.getBytes %) ["amit" "rob" "kyle"])

(memfn ^String getBytes)
(map (memfn getBytes) ["amit" "rob" "kyle"])

(.subSequence "Clojure" 2 5)
((memfn ^String subSequence ^Long start ^Long end) "Clojure" 2 5)

(bean (Calendar/getInstance))
