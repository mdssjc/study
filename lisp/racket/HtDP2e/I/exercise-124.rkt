;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-124) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 124

(define PRICE 5)
(define SALES-TAX (* 0.08 PRICE))
(* 0.08 5)
0.4
(define TOTAL (+ PRICE SALES-TAX))
(+ 5 0.4)
5.4

; ---

; fahrenheit->celsius is used here before its definition
;(define COLD-F 32)
;(define COLD-C (fahrenheit->celsius COLD-F))
;(define (fahrenheit->celsius f)
;  (* 5/9 (- f 32)))

; ---

(define LEFT -100)
(define RIGHT 100)
(define (f x) (+ (* 5 (expt x 2)) 10))

(define f@LEFT (f LEFT))
(f -100)
(+ (* 5 (expt -100 2)) 10)
(+ (* 5 10000) 10)
(+ 50000 10)
50010

(define f@RIGHT (f RIGHT))
(f 100)
(+ (* 5 (expt 100 2)) 10)
(+ 50000 10)
50010
