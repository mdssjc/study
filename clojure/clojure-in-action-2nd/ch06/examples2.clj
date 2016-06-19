(def a-ref (ref 0))
(def an-agent (agent 0))
(def an-atom (atom 0))

(deref a-ref)
@a-ref
(deref an-agent)
@an-agent
(deref an-atom)
@an-atom

(dosync
 (ref-set a-ref 1))
(dosync
 (alter a-ref + 1))
(dosync
 (commute a-ref + 1))

(send an-agent + 1)
(send-off an-agent + 1)

(reset! an-atom 1)
(swap! an-atom + 1)
(compare-and-set! an-atom 1 1)

;;;

(def adi (atom 0))
(defn on-change [the-key the-ref old-value new-value]
  (println "Hey, seeing change from" old-value "to" new-value))
(add-watch adi :adi-watcher on-change)
(remove-watch adi :adi-watcher)

@adi
(swap! adi inc)
