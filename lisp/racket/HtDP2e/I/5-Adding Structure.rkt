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
(define-struct vel [deltax deltay])

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
