;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-249) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 249


(define (f x) x)
(cons f '())                         ; (list function:f)
(f f)                                ; function:f
(cons f (cons 10 (cons (f 10) '()))) ; (list function:f 10 10)
