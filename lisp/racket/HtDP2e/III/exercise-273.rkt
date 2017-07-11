;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-273) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 273


; [List-of Number] -> [List-of Number]
; doubles each number in the list
(check-expect (doubles empty) empty)
(check-expect (doubles (list 1)) (list 2))
(check-expect (doubles (list 1 2 3)) (list 2 4 6))

(define (doubles lon)
  (local ((define (double n lst)
            (cons (* n 2) lst)))
    (foldr double empty lon)))
