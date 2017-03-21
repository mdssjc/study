;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-151) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 151

; N -> Number
; computes (* n x) without using *
(check-expect (multiply 3 6) (* 3 6))
 
(define (multiply n x)
  (cond [(zero? n) 0]
        [else (add (multiply (sub1 n) x) x)]))

; N -> Number
; computes (+ n x) without using +
(check-expect (add 3 6) (+ 3 6))
 
(define (add n x)
  (cond [(zero? n) x]
        [else (add1 (add (sub1 n) x))]))
