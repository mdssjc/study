;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-251) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 251


; [List-of Number] -> Number
; computes the sum of 
; the numbers on l
(define (sum l)
  (cond
    [(empty? l) 0]
    [else
     (+ (first l)
        (sum (rest l)))]))

; [List-of Number] -> Number
; computes the product of 
; the numbers on l
(define (product l)
  (cond
    [(empty? l) 1]
    [else
     (* (first l)
        (product (rest l)))]))

; [Number -> Number] [List-of Number] Number -> Number
; summarizes the list l with the function f and identity i
(check-expect (fold1 + '() 0) 0)
(check-expect (fold1 + (list 1 2 3) 0) 6)
(check-expect (fold1 * '() 1) 1)
(check-expect (fold1 * (list 1 2 3) 1) 6)

(define (fold1 f l i)
  (cond [(empty? l) i]
        [else (f (first l)
                 (fold1 f (rest l) i))]))
