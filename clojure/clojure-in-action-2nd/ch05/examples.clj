(import 'java.text.SimpleDateFormat)
(import '[java.util Date Calendar Random])

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
