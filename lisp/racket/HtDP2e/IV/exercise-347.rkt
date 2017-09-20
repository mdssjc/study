;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-347) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 347


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

; A BSL-Exp is one of:
;  - Number
;  - (make-add BSL-Exp BSL-Exp)
;  - (make-mul BSL-Exp BSL-Exp)
; interpretation class of values to which a representation of a BSL expression can evaluate

(define E1 (make-add 10 -10))
(define E2 (make-add (make-mul 20 3) 33))
(define E3 (make-add (make-mul 3.14 (make-mul 2 3)) (make-mul 3.14 (make-mul -1 -9))))
; (+ -1 2)
; (+ (* -2 -3) 33)
; (* (+ 1 (* 2 3)) 3.14)


;; ====================
;; Functions:

; BSL-Exp -> Number
; computes its value
(check-expect (eval-expression 3) 3)
(check-expect (eval-expression (make-add 1 1)) 2)
(check-expect (eval-expression (make-mul 3 10)) 30)
(check-expect (eval-expression (make-add (make-mul 1 1) 10)) 11)

(define (eval-expression exp)
  (cond [(number? exp) exp]
        [(add? exp)
         (+ (eval-expression (add-left exp))
            (eval-expression (add-right exp)))]
        [(mul? exp)
         (* (eval-expression (mul-left exp))
            (eval-expression (mul-right exp)))]))
