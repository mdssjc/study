;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-356) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 356


;; ====================
;; Data definitions:

(define-struct add [left right])
; An Add is a structure:
;   (make-add Number Number)
; interpretation (make-add l r) specifies an addition expression
;  l: is the left operand; and
;  r: is the right operand

(define-struct mul [left right])
; An Mul is a structure:
;   (make-mul Number Number)
; interpretation (make-mul l r) specifies an multiplication expression
;  l: is the left operand; and
;  r: is the right operand

(define-struct fun [name expr])
; An Fun is a structure:
;   (make-fun String BSL-fun-expr)
; interpretation (make-fun n e) specifies an function application
;  n: is the name of the function; and
;  e: is the an expression of the function

; A BSL-fun-expr is one of: 
;  - Number
;  - Symbol
;  - (make-fun BSL-fun-expr)
;  - (make-add BSL-fun-expr BSL-fun-expr)
;  - (make-mul BSL-fun-expr BSL-fun-expr)
(define FE1 (make-fun "f1" (k (make-add 1 1))))
(define FE2 (make-fun "f2" (make-mul 5 "f1")))
(define FE3 (make-fun "f3" 5))
(define FE4 (make-fun "f4" (make-mul "f3" "f1")))

; An AL (short for association list) is [List-of Association]
; An Association is a list of two items:
;   (cons Symbol (cons Number '()))
