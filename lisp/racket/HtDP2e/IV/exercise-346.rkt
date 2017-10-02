;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-346) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 346


;; ====================
;; Data definitions:

(define-struct add [left right])
; An Add is a structure:
;   (make-add BSL-expr BSL-expr)
; interpretation (make-add l r) specifies an addition expression
;  l: is the left operand; and
;  r: is the right operand

(define-struct mul [left right])
; A Mul is a structure:
;   (make-mul BSL-expr BSL-expr)
; interpretation (make-mul l r) specifies a multiplication expression
;  l: is the left operand; and
;  r: is the right operand

; A BSL-expr is one of:
;  - Number
;  - (make-add BSL-expr BSL-expr)
;  - (make-mul BSL-expr BSL-expr)
; interpretation class of values to which a representation of a BSL expression can evaluate

(define E1 (make-add 10 -10))
(define E2 (make-add (make-mul 20 3) 33))
(define E3 (make-add (make-mul 3.14 (make-mul 2 3)) (make-mul 3.14 (make-mul -1 -9))))
; (+ -1 2)
; (+ (* -2 -3) 33)
; (* (+ 1 (* 2 3)) 3.14)
