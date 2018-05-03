;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname |17-Nameless Functions|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 17-Nameless Functions.rkt
;; III - Abstraction
;; 17  - Nameless Functions

(require 2htdp/image)


(define-struct ir [name price])
; An IR is a structure:
;   (make-ir String Number)
; An Inventory is one of:
; - '()
; - (cons IR Inventory)


; [List-of IR] Number -> Boolean
#;
(define (find l th)
  (local (; IR -> Boolean
          (define (acceptable? ir)
            (<= (ir-price ir) th)))
    (filter acceptable? l)))
(define (find l th)
  (filter (lambda (ir) (<= (ir-price ir) th)) l))



;; 17.1 - Functions from lambda

;; Exercise 279

(lambda (x y) (x y y))
((lambda (x y) (x y y)) + 1)

;(lambda () 10)

(lambda (x) x)
((lambda (x) x) 2)

(lambda (x y) x)
((lambda (x y) x) 2 1)

;(lambda x 10)

;; Exercise 280

(check-expect ((lambda (x y) (+ x (* x y)))
               1 2)
              3)

(check-expect ((lambda (x y)
                 (+ x
                    (local ((define z (* y y)))
                      (+ (* 3 z) (/ 1 x)))))
               1 2)
              14)

(check-expect ((lambda (x y)
                 (+ x
                    ((lambda (z)
                       (+ (* 3 z) (/ 1 z)))
                     (* y y))))
               1 2)
              53/4)

;; Exercise 281

; consumes a number and decides whether it is less than 10
(define lambda1 (lambda (n) (< n 10)))

(check-expect (lambda1 5)  #true)
(check-expect (lambda1 20) #false)

; multiplies two given numbers and turns the result into a string
(define lambda2 (lambda (x y) (number->string (* x y))))

(check-expect (lambda2 2 5) "10")

; consumes a natural number and produces 0 if it is even and 1 if odd
(define lambda3 (lambda (n) (if (odd? n) 1 0)))

(check-expect (lambda3 2) 0)
(check-expect (lambda3 3) 1)

; consumes two inventory records and compares them by price
(define lambda4 (lambda (c ir1 ir2)
                  (if (c (ir-price ir1) (ir-price ir2))
                      (ir-price ir1)
                      (ir-price ir2))))

(check-expect (lambda4 > (make-ir "TV" 123) (make-ir "Radio" 23)) 123)
(check-expect (lambda4 < (make-ir "TV" 123) (make-ir "Radio" 23)) 23)

; adds a red dot at a given Posn to a given Image
(define MTS (rectangle 10 10 "outline" "black"))

(define lambda5 (lambda (p) (place-image (circle 2 "solid" "red") (posn-x p) (posn-y p) MTS)))

(check-expect (lambda5 (make-posn 5 5))
              (place-image (circle 2 "solid" "red") 5 5 MTS))



;; 17.2 - Computing with lambda

;; Exercise 282

(define (f-plain x)
  (* 10 x))

(define f-lambda
  (lambda (x)
    (* 10 x)))

; Number -> Boolean
(define (compare x)
  (= (f-plain x) (f-lambda x)))

(compare (random 100000))

;; Exercise 283

(define th 20)


(map (lambda (x) (* 10 x))
     '(1 2 3))

(foldl (lambda (name rst)
         (string-append name ", " rst))
       "etc."
       '("Matthew" "Robby"))

(filter (lambda (ir) (<= (ir-price ir) th))
        (list (make-ir "bear" 10)
              (make-ir "doll" 33)))

;; Exercise 284

((lambda (x) x) (lambda (x) x))
(((lambda (x) x)
  (lambda (x) x))
 10)

((lambda (x) (x x)) (lambda (x) x))
(((lambda (x) (x x))
  (lambda (x) x))
 10)

; Indirect self-reference
#;
((lambda (x) (x x))
 (lambda (x) (x x)))
