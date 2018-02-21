;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |5-Adding Structure|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 5-Adding Structure.rkt
;; I - Fixed-Size Data
;; 5 - Adding Structure

(require 2htdp/image)
(require 2htdp/universe)


;; 5.1 - From Positions to posn Structures



;; 5.2 - Computing with posns



;; 5.3 - Programming with posn

;; =================
;; Functions:

; computes the distance of ap to the origin
(check-expect (distance-to-0 (make-posn 0 5))  5)
(check-expect (distance-to-0 (make-posn 7 0))  7)
(check-expect (distance-to-0 (make-posn 3 4))  5)
(check-expect (distance-to-0 (make-posn 8 6))  10)
(check-expect (distance-to-0 (make-posn 5 12)) 13)

(define (distance-to-0 ap)
  (sqrt
   (+ (sqr (posn-x ap))
      (sqr (posn-y ap)))))

;; Exercise 63

(distance-to-0 (make-posn 3 4))
(sqrt
 (+ (sqr (posn-x (make-posn 3 4)))
    (sqr (posn-y (make-posn 3 4)))))
(sqrt
 (+ (sqr 3)
    (sqr (posn-y (make-posn 3 4)))))
(sqrt
 (+ 9
    (sqr (posn-y (make-posn 3 4)))))
(sqrt
 (+ 9
    (sqr 4)))
(sqrt
 (+ 9
    16))
(sqrt 25)
5

(distance-to-0 (make-posn 6 (* 2 4)))
(distance-to-0 (make-posn 6 8))
(sqrt
 (+ (sqr (posn-x (make-posn 6 8)))
    (sqr (posn-y (make-posn 6 8)))))
(sqrt
 (+ (sqr 6)
    (sqr (posn-y (make-posn 6 8)))))
(sqrt
 (+ 36
    (sqr (posn-y (make-posn 6 8)))))
(sqrt
 (+ 36
    (sqr 8)))
(sqrt
 (+ 36
    64))
(sqrt 100)
10

(+ (distance-to-0 (make-posn 12 5)) 10)
(+ (sqrt
    (+ (sqr (posn-x (make-posn 12 5)))
       (sqr (posn-y (make-posn 12 5))))) 10)
(+ (sqrt
    (+ (sqr 12)
       (sqr (posn-y (make-posn 12 5))))) 10)
(+ (sqrt
    (+ 144
       (sqr (posn-y (make-posn 12 5))))) 10)
(+ (sqrt
    (+ 144
       (sqr 5))) 10)
(+ (sqrt
    (+ 144
       25)) 10)
(+ (sqrt 169) 10)
(+ 13 10)
23

;; Exercise 64

;; =================
;; Functions:

;; measures the Manhattan distance of the given posn to the origin
(check-expect (manhattan-distance (make-posn 3 4)) 5)

(define (manhattan-distance p)
  (distance-to-0 p))



;; 5.4 - Defining Structure Types

;; Exercise 65

(define-struct movie [title producer year])
(define-struct person [name hair eyes phone])
(define-struct pet [name number])
(define-struct CD [artist title price])
(define-struct sweater [material size producer])

;; Exercise 66

; constructors
(define M  (make-movie "Title" "Producer" 2017))
(define P1 (make-person "Name" "Hair" "Eyes" "Phone"))
(define P2 (make-pet "Name" 123))
(define C  (make-CD "Artist" "Title" 1.99))
(define S  (make-sweater "Material" 4 "Producer"))

; selectors
(movie-title    M)
(movie-producer M)
(movie-year     M)

(person-name  P1)
(person-hair  P1)
(person-eyes  P1)
(person-phone P1)

(pet-name   P2)
(pet-number P2)

(CD-artist C)
(CD-title  C)
(CD-price  C)

(sweater-material S)
(sweater-size     S)
(sweater-producer S)

; predicates
(movie?   M)
(person?  P1)
(pet?     P2)
(CD?      C)
(sweater? S)

;; Exercise 67

(define SPEED 3)
(define-struct balld [location direction])
(make-balld 10 "up")

(make-balld 5 "left")
(make-balld 2 "right")
(make-balld 8 "down")


(define-struct ball [location velocity])
; A Ball-1d is a structure:
;   (make-ball Number Number)
; interpretation 1 distance to top and velocity
; interpretation 2 distance to left and velocity

(define-struct vel [deltax deltay])
; A Vel is a structure:
;   (make-vel Number Number)
; interpretation (make-vel dx dy) means a velocity of
; dx pixels [per tick] along the horizontal and
; dy pixels [per tick] along the vertical direction

(define ball1
  (make-ball (make-posn 30 40) (make-vel -10 5)))

;; Exercise 68

(define-struct ballf [x y deltax deltay])

(define ball2 (make-ballf 30 40 -10 5))



;; 5.5 - Computing with Structures

;; Exercise 69

; (define-struct movie [title producer year])
; (make-movie "Title" "Producer" 2017)
;                  +-----+
;                  |movie|
;+-------+---------++----+
;|title  |producer  |year|
;| ----- | -------- | -- |
;|"Title"|"Producer"|2017|
;+-------+----------+----+

; (define-struct person [name hair eyes phone])
; (make-person "Name" "Hair" "Eyes" "Phone")
;                      +------+
;                      |person|
;+------+------+------++------+
;|name  |hair  |eyes  |phone  |
;| ---- | ---- | ---- | ----- |
;|"Name"|"Hair"|"Eyes"|"Phone"|
;+------+------+------+-------+

; (define-struct pet [name number])
; (make-pet "Name" 123)
;          +---+
;          |pet|
;+------+--+---+
;|name  |number|
;| ---- | ---- |
;|"Name"|123   |
;+------+------+

; (define-struct CD [artist title price])
; (make-CD "Artist" "Title" 1.99)
;                    +--+
;                    |CD|
;+--------+-------+--+--+
;|artist  |title  |price|
;| ------ | ----- | --- |
;|"Artist"|"Title"|1.99 |
;+--------+-------+-----+

; (define-struct sweater [material size producer])
; (make-sweater "Material" 4 "Producer")
;                   +-------+
;                   |sweater|
;+----------+----+--+-------+
;|material  |size|producer  |
;| -------- | -- | -------- |
;|"Material"|4   |"Producer"|
;+----------+----+----------+

;; Exercise 70

(define-struct centry [name home office cell])
(define-struct phone [area number])

(phone-area
 (centry-office
  (make-centry
   "Shriram Fisler"
   (make-phone 207 "363-2421")
   (make-phone 101 "776-1099")
   (make-phone 208 "112-9981"))))
(phone-area
 (make-phone 101 "776-1099"))
101

;; Exercise 71

; distances in terms of pixels:
(define HEIGHT 200)
(define MIDDLE (quotient HEIGHT 2))
(define WIDTH  400)
(define CENTER (quotient WIDTH 2))

(define-struct game [left-player right-player ball])

(define game0
  (make-game MIDDLE MIDDLE (make-posn CENTER CENTER)))


(game-ball game0)
(game-ball (make-game 100 100 (make-posn 200 200)))
(make-posn 200 200)

(posn? (game-ball game0))
(posn? (game-ball (make-game 100 100 (make-posn 200 200))))
(posn? (make-posn 200 200))
#true

(game-left-player game0)
(game-left-player (make-game 100 100 (make-posn 200 200)))
100



;; 5.6 - Programming with Structures

;; Exercise 72

; (define-struct phone [area number])
; A Phone is a structure:
;   (make-phone Number[1..999] Number[1..9999])
; interpretation area means first three digits of phone, between 1 and 999
;                number means last four number of phone, between 1 and 9999

(define-struct phone# [area switch num])
; A Phone# is a structure:
;   (make-phone# Number[1..999] Number[1..999] Number[1..9999])
; interpretation area means first three digits of phone, between 1 and 999
;                switch means next three code of phone,  between 1 and 999
;                number means last four number of phone, between 1 and 9999

;; Exercise 73

;; Exercise 74

;; =================
;; Constants:

(define MTS (empty-scene 100 100))
(define DOT (circle 3 "solid" "red"))


;; =================
;; Data definitions:

; A Posn represents the state of the world.


;; =================
;; Functions:

; Posn -> Posn
; starts the world with (main (make-posn 0 0))
(define (main p0)
  (big-bang p0
            [on-tick  x+]
            [on-mouse reset-dot]
            [to-draw  scene+dot]))

; Posn -> Posn
; increases the x-coordinate of p by 3
(check-expect (x+ (make-posn 10 0)) (make-posn 13 0))

(define (x+ p)
  (posn-up-x p (+ (posn-x p) 3)))

; Posn Number -> Posn
; produces a posn like p with n in the x field
(check-expect (posn-up-x (make-posn 2 3) 4) (make-posn 4 3))

(define (posn-up-x p n)
  (make-posn n (posn-y p)))

; Posn Number Number MouseEvt -> Posn
; for mouse clicks, (make-posn x y); otherwise p
(check-expect (reset-dot (make-posn 10 20) 29 31 "button-down") (make-posn 29 31))
(check-expect (reset-dot (make-posn 10 20) 29 31 "button-up")   (make-posn 10 20))

(define (reset-dot p x y me)
  (cond
    [(mouse=? me "button-down") (make-posn x y)]
    [else p]))

; Posn -> Image
; adds a red spot to MTS at p
(check-expect (scene+dot (make-posn 10 20))
              (place-image DOT 10 20 MTS))
(check-expect (scene+dot (make-posn 88 73))
              (place-image DOT 88 73 MTS))

(define (scene+dot p)
  (place-image DOT (posn-x p) (posn-y p) MTS))

;; Exercise 75

;; =================
;; Data definitions:

(define-struct ufo [loc vel])
; A UFO is a structure:
;   (make-ufo Posn Vel)
; interpretation (make-ufo p v) is at location
; p moving at velocity v.
(define v1 (make-vel 8  -3))
(define v2 (make-vel -5 -3))

(define p1 (make-posn 22 80))
(define p2 (make-posn 30 77))

(define u1 (make-ufo p1 v1))
(define u2 (make-ufo p1 v2))
(define u3 (make-ufo p2 v1))
(define u4 (make-ufo p2 v2))


;; =================
;; Functions:

; UFO -> UFO
; determines where u moves in one clock tick;
; leaves the velocity as is
(check-expect (ufo-move-1 u1) u3)
(check-expect (ufo-move-1 u2)
              (make-ufo (make-posn 17 77) v2))

(define (ufo-move-1 u)
  (make-ufo (posn+ (ufo-loc u) (ufo-vel u))
            (ufo-vel u)))

; Posn Vel -> Posn
; adds v to p
(check-expect (posn+ p1 v1) p2)
(check-expect (posn+ p1 v2) (make-posn 17 77))

(define (posn+ p v)
  (make-posn (+ (posn-x p) (vel-deltax v))
             (+ (posn-y p) (vel-deltay v))))



;; 5.7 - The Universe of Data

;; Exercise 76

; (define-struct movie [title producer year])
; Movie is (make-movie String String Number[0..9999])
; interpretation title is a string
;                producer is a string
;                year is a number, between 0 and 9999

; (define-struct person [name hair eyes phone])
; Person is (make-person String String String String)
; interpretation name is a string
;                hair is a string
;                eyes is a string
;                phone is a string in format ###-####

; (define-struct pet [name number])
; Pet is (make-pet String Number)
; interpretation name is a string
;                number is a identification number

; (define-struct CD [artist title price])
; CD is (make-CD String String Number[0..])
; interpretation artist is a string
;                title is a string
;                price is a positive number

; (define-struct sweater [material size producer])
; Sweater is (make-sweater String Number[0..] String)
; interpretation material is a string
;                size is a positive number
;                producer is a string

;; Exercise 77

(define-struct point-time (hours minutes seconds))
; Point-Time is a structure:
;  (make-point-time Number[0..23] Number[0..59] Number[0..59])
; interpretation hours means a number between 0 and 23
;                minutes means a number between 0 and 59
;                seconds means a number between 0 and 59

;; Exercise 78

(define-struct word-3 (l1 l2 l3))
; Word-3 is a structure:
;  (make-word-3 String String String)
; interpretation l1 is a lower-case letter
;                l2 is a lower-case letter
;                l3 is a lower-case letter
; Each letter is represented by "a" through "z" plus #false

;; Exercise 79

; A Color is one of:
; - "white"
; - "yellow"
; - "orange"
; - "green"
; - "red"
; - "blue"
; - "black"
(define C1 "white")
(define C2 "yellow")
(define C3 "orange")
(define C4 "green")
(define C5 "red")
(define C6 "blue")
(define C7 "black")

; H is a Number between 0 and 100.
; interpretation represents a “happiness value”
(define H1 0)
(define H2 50)
(define H3 100)

(define-struct person-v2 [fstname lstname male?])
; A Person-v2 is a structure:
;   (make-person-v2 String String Boolean)
(define P1V2 (make-person-v2 "Joseph" "WGW" #true))

(define-struct dog [owner name age happiness])
; A Dog is a structure:
;   (make-dog Person-v2 String PositiveInteger H)
; interpretation owner means a Person-v2
;                name means a string
;                age means a positive number
;                happiness means a H
(define D1 (make-dog P1V2 "Totó" 2 H3))

; A Weapon is one of:
; - #false
; - Posn
; interpretation #false means the missile hasn't
; been fired yet; a Posn means it is in flight
(define W1 #false)
(define W2 (make-posn 20 20))



;; 5.8 - Designing with Structures

;; Exercise 80

; (define-struct movie [title director year])

; Movie -> String
; format movie information for a string
(define (format-movie m)
  (... (movie-title m) ... (movie-director m) ... (movie-year m) ...))


; (define-struct person [name hair eyes phone])

; Person -> String
; produces the information of a person
(define (do-person p)
  (... (person-name p) ... (person-hair p) ... (person-eyes p) ... (person-phone p) ...))


; (define-struct pet [name number])

; Pet -> String
; produces the identification of pet
(define (pet-id p)
  (... (pet-name p) ... (pet-number p) ...))


; (define-struct CD [artist title price])

; CD -> String
; produces the information of a CD
(define (do-price c)
  (... (CD-artist c) ... (CD-title c) ... (CD-price c) ...))


; (define-struct sweater [material size color])

; Sweater -> String
; produces the information of a Sweater
(define (do-sweater s)
  (... (sweater-material s) ... (sweater-size s) ... (sweater-color s) ...))

;; Exercise 81

; Point-Time -> Number
; produces the number of seconds that have passed since midnight
(check-expect (time->seconds (make-point-time 12 30 2)) 45002)

(define (time->seconds r)
  (+ (* (point-time-hours   r) 60 60)
     (* (point-time-minutes r) 60)
     (point-time-seconds    r)))

;; Exercise 82

; Word-3 Word-3 -> Word-3
; produces a word that indicates where the given ones agree and disagree
(check-expect (compare-word (make-word-3 "a" "b" "c")
                            (make-word-3 "a" "b" "d"))
              (make-word-3 "a" "b" #false))

(define (compare-word w1 w2)
  (make-word-3 (res (word-3-l1 w1) (word-3-l1 w2))
               (res (word-3-l2 w1) (word-3-l2 w2))
               (res (word-3-l3 w1) (word-3-l3 w2))))

; String String -> String/Boolean
; helper function to compare-word
(check-expect (res "a" "a")    "a")
(check-expect (res "a" "b")    #false)
(check-expect (res "a" #false) #false)
(check-expect (res #false "a") #false)

(define (res w1 w2)
  (cond [(and (string? w1)
              (string? w2)
              (string=? w1 w2)) w1]
        [else #false]))
