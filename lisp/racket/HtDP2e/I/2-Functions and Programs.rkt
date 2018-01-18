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
