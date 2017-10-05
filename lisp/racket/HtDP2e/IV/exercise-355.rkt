;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-355) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 355


;; ====================
;; Data definitions:

(define-struct add [left right])
; An Add is a structure:
;   (make-add BSL-var-expr BSL-var-expr)
; interpretation (make-add l r) specifies an addition expression
;  l: is the left operand; and
;  r: is the right operand

(define-struct mul [left right])
; A Mul is a structure:
;   (make-mul BSL-var-expr BSL-var-expr)
; interpretation (make-mul l r) specifies a multiplication expression
;  l: is the left operand; and
;  r: is the right operand

; A BSL-var-expr is one of:
;  - Number
;  - Symbol
;  - (make-add BSL-var-expr BSL-var-expr)
;  - (make-mul BSL-var-expr BSL-var-expr)
; interpretation class of values and variables to which a representation of a BSL expression can evaluate

; An AL (short for association list) is [List-of Association]
; An Association is a list of two items:
;   (cons Symbol (cons Number '()))
(define AL1 (list (list 'a 2)))
(define AL2 (list (list 'c 1) (list 'b 3) (list 'a 2)))


;; ====================
;; Functions:

; BSL-var-expr AL -> Number
; determines its value; otherwise it signals an error
(check-expect (eval-var-lookup 1 AL1) 1)
(check-expect (eval-var-lookup (make-add 'a 1) AL1) 3)
(check-expect (eval-var-lookup (make-add (make-mul 'c 'b) 'a) AL2) 5)
(check-error  (eval-var-lookup (make-add 'b 1) AL1) "an error found")
(check-error  (eval-var-lookup (make-add (make-mul 'c 'b) (make-mul 'a 'd)) AL2) "an error found")

(define (eval-var-lookup e da)
  (local ((define (eval-var-lookup e)
            (cond [(number? e) e]
                  [(symbol? e)
                   (local ((define result (assq e da)))
                     (if (false? result)
                         (error "an error found")
                         (second result)))]
                  [(add? e)
                   (+ (eval-var-lookup (add-left e))
                      (eval-var-lookup (add-right e)))]
                  [(mul? e)
                   (* (eval-var-lookup (mul-left e))
                      (eval-var-lookup (mul-right e)))])))
    (eval-var-lookup e)))
