;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-291) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 291


; [X Y] (X -> Y) [List-of X] -> [List-of Y]
; maps fn for each item in the list
(check-expect (map2 (lambda (n) (* n 2)) empty) empty)
(check-expect (map2 (lambda (n) (* n 2)) (list 1)) (list 2))
(check-expect (map2 (lambda (n) (* n 2)) (list 1 2 3)) (list 2 4 6))

(define (map2 fn lox)
  (foldr (lambda (x lst)
           (cons (fn x) lst))
         empty lox))
