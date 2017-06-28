;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-266) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 266


(define result (local ((define (f x) (+ x 3))
                       (define (g x) (* x 4)))
                 (if (odd? (f (g 1)))
                     f
                     g)))
(result 2)
