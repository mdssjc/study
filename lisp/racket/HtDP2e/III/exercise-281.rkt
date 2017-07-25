;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-281) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 281

(require 2htdp/image)


; consumes a number and decides whether it is less than 10
((lambda (n)
   (< n 10))
 20)

; multiplies two given numbers and turns the result into a string
((lambda (x y)
   (number->string (* x y)))
 2 5)

; consumes two inventory records and compares them by price
(define-struct ir [name price])
; An IR is a structure:
;   (make-IR String Number)
; An Inventory is one of: 
; - '()
; - (cons IR Inventory)
((lambda (c ir1 ir2)
   (if (c (ir-price ir1) (ir-price ir2))
       (ir-price ir1)
       (ir-price ir2)))
 > (make-ir "TV" 123) (make-ir "Radio" 23))

; consumes a natural number and produces 0 if it is even and 1 if odd
((lambda (n)
   (if (odd? n) 1 0))
 3)

; adds a red dot at a given Posn to a given Image
(define MTS (rectangle 10 10 "outline" "black"))

((lambda (p)
   (place-image (circle 2 "solid" "red") (posn-x p) (posn-y p) MTS))
 (make-posn 5 5))
