(import 'java.text.SimpleDateFormat)
(import '[java.util Date Calendar Random TimeZone])

(def sdf (new SimpleDateFormat "yyyy-MM-dd"))
(def sdf (SimpleDateFormat. "yyyy-MM-dd"))

(defn date-from-date-string [date-string]
  (let [sdf (SimpleDateFormat. "yyyy-MM-dd")]
    (.parse sdf date-string)))
(date-from-date-string "2018-06-04")

(Long/parseLong "12321")

Calendar/JANUARY
Calendar/FEBRUARY

(. System getenv "PATH")
(. System (getenv "PATH"))

(def rnd (Random.))
(. rnd nextInt 10)
(. rnd (nextInt 10))

(. Calendar DECEMBER)

(. (. (Calendar/getInstance) (getTimeZone)) (getDisplayName))
(. (. (Calendar/getInstance) getTimeZone) getDisplayName)
(.. (Calendar/getInstance) (getTimeZone) (getDisplayName))
(.. (Calendar/getInstance) getTimeZone getDisplayName)
(.. (Calendar/getInstance)
    getTimeZone
    (getDisplayName true TimeZone/SHORT))

(defn the-past-midnight-1 []
  (let [calendar-obj (Calendar/getInstance)]
    (.set calendar-obj Calendar/AM_PM Calendar/AM)
    (.set calendar-obj Calendar/HOUR 0)
    (.set calendar-obj Calendar/MINUTE 0)
    (.set calendar-obj Calendar/SECOND 0)
    (.set calendar-obj Calendar/MILLISECOND 0)
    (.getTime calendar-obj)))
(defn the-past-midnight-2 []
  (let [calendar-obj (Calendar/getInstance)]
    (doto calendar-obj
      (.set Calendar/AM_PM Calendar/AM)
      (.set Calendar/HOUR 0)
      (.set Calendar/MINUTE 0)
      (.set Calendar/SECOND 0)
      (.set Calendar/MILLISECOND 0))
    (.getTime calendar-obj)))
