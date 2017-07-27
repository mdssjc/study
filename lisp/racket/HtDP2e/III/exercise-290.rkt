;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-290) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 290

(require 2htdp/image)


(equal? (append (list 1 2 3) (list 4 5 6 7 8))
        (list 1 2 3 4 5 6 7 8))

; [List-of Number] [List-of Number] -> [List-of Number]
; concatenates the items of two lists
(check-expect (append-from-fold (list 1 2 3) (list 4 5 6 7 8)) (list 1 2 3 4 5 6 7 8))

(define (append-from-fold lon1 lon2)
  (foldr (lambda (i lst)
           (cons i lst))
         lon2 lon1))

; [List-of Number] -> Number
; computes the sum of a list of numbers
(check-expect (sum empty) 0)
(check-expect (sum (list 1)) 1)
(check-expect (sum (list 1 2 3)) 6)

(define (sum lon)
  (foldr + 0 lon))

; [List-of Number] -> Number
; computes the product of a list of numbers
(check-expect (product empty) 1)
(check-expect (product (list 1)) 1)
(check-expect (product (list 1 2 3)) 6)

(define (product lon)
  (foldr * 1 lon))

; [List-of Image] -> Image
; composes a list of Images horizontally
(check-expect (compose-images empty) empty-image)
(check-expect (compose-images (list (circle 5 "solid" "blue"))) (circle 5 "solid" "blue"))
(check-expect (compose-images (list (circle 5 "solid" "blue") (square 10 "solid" "red")))
              (beside (circle 5 "solid" "blue") (square 10 "solid" "red")))

(define (compose-images loi)
  (foldr beside empty-image loi))
