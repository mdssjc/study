;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname 2-Functions and Programs) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 2-Functions and Programs.rkt
;; I - Fixed-Size Data
;; 2 - Functions and Programs

(require 2htdp/image)


;; 2.1 - Functions

;; Exercise 11

(define (distance x y)
  (sqrt (+ (sqr x) (sqr y))))

(check-expect (distance 3 4)   5)
(check-expect (distance 12 5) 13)

;; Exercise 12

(define (cvolume length)
  (* length length length))

(define (csurface length)
  (* 6 (sqr length)))

(check-expect (cvolume  3) (* 3 3 3))
(check-expect (csurface 3) (* 6 3 3))

;; Exercise 13

(define (string-first s)
  (substring s 0 1))

(check-expect (string-first "abc") "a")

;; Exercise 14

(define (string-last s)
  (substring s (- (string-length s) 1)))

(check-expect (string-last "abc") "c")

;; Exercise 15

(define sunny  #false)
(define friday #true)

(define (==> b1 b2)
  (or (not b1) b2))

(check-expect (==> #false #false) #true)
(check-expect (==> #false #true)  #true)
(check-expect (==> #true  #false) #false)
(check-expect (==> #true  #true)  #true)
(check-expect (==> sunny friday)  #true)

;; Exercise 16

(define r (rectangle 10 10 "solid" "black"))

(define (image-area img)
  (* (image-width img) (image-height img)))

(check-expect (image-area r) 100)

;; Exercise 17

(define rh (rectangle 10 20 "solid" "black"))
(define rw (rectangle 20 10 "solid" "black"))
(define rs (rectangle 20 20 "solid" "black"))

(define (image-classify img)
  (cond [(> (image-height img) (image-width  img)) "tall"]
        [(> (image-width  img) (image-height img)) "wide"]
        [else "square"]))

(check-expect (image-classify rh) "tall")
(check-expect (image-classify rw) "wide")
(check-expect (image-classify rs) "square")

;; Exercise 18

(define prefix "hello")
(define suffix "world")

(define (string-join s1 s2)
  (string-append s1 "_" s2))

(check-expect (string-join prefix suffix) "hello_world")

;; Exercise 19

(define str "helloworld")
(define i 5)

(define (string-insert str i)
  (string-append
   (substring str 0 i)
   "_"
   (substring str i)))

(check-expect (string-insert str i) "hello_world")

;; Exercise 20

(define (string-delete str i)
  (string-append
   (substring str 0 i)
   (substring str (add1 i))))

(check-expect (string-delete str i) "helloorld")



;; 2.2 - Computing

;; Exercise 21

(define (ff a)
  (* 10 a))

(check-expect (ff (ff 1))       100)
(check-expect (+ (ff 1) (ff 1))  20)

;; Exercise 22

(define (distance-to-origin x y)
  (sqrt (+ (sqr x) (sqr y))))

(check-expect (distance-to-origin 3 4) (sqrt (+ (* 3 3) (* 4 4))))

;; Exercise 23

(check-expect (string-first "hello world") "h")

;; Exercise 24

(check-expect (==> #true #false) #false)

;; Exercise 25

(check-expect (image-classify rh) "tall")
(check-expect (image-classify rw) "wide")
(check-expect (image-classify rs) "square")

;; Exercise 26

(check-expect (string-insert "helloworld" 6) "helloorld")



;; 2.3 - Composing Functions

;; Exercise 27

(define PEOPLE          120)
(define TICKET-PRICE    5.0)
(define AVERAGE-CHANGES 15)
(define PERCENT         0.1)
(define FIXED-COST      180)
(define VARIABLE-COST   0.04)

(define (attendees ticket-price)
  (- PEOPLE (* (- ticket-price TICKET-PRICE) (/ AVERAGE-CHANGES PERCENT))))

(define (revenue ticket-price)
  (* ticket-price (attendees ticket-price)))

(define (cost ticket-price)
  (+ FIXED-COST (* VARIABLE-COST (attendees ticket-price))))

(define (profit ticket-price)
  (- (revenue ticket-price)
     (cost ticket-price)))

;; Exercise 28

(profit 1)
(profit 2)
(profit 3) ; <--
(profit 4)
(profit 5)

;; Exercise 29

(define FIXED-COST-2    0)
(define VARIABLE-COST-2 1.5)

(define (cost-v2 ticket-price)
  (+ FIXED-COST-2 (* VARIABLE-COST-2 (attendees ticket-price))))

(define (profit-v2 ticket-price)
  (- (revenue ticket-price)
     (cost-v2 ticket-price)))

(profit-v2 3)
(profit-v2 4) ; <--
(profit-v2 5)
