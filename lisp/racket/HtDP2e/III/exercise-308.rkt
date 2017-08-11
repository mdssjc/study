;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-308) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 308

(require 2htdp/abstraction)


(define-struct phone [area switch four])
; A Phone is a structure:
;   (make-phone Three Three Four)
; A Three is a Number between 100 and 999
; A Four is a Number between 1000 and 9999
(define P1 (make-phone 713 123 4567))
(define P2 (make-phone 281 123 4567))
(define P3 (make-phone 123 123 4567))


; [Listof Phone] -> [Listof Phone]
; replaces all occurrence of area code 713 with 281
(check-expect (replace empty) empty)
(check-expect (replace (list P1 P3)) (list P2 P3))

(define (replace lop)
  (map (lambda (p)
         (match p
           [(phone 713 s f) (make-phone 281 s f)]
           [_ p]))
       lop))
