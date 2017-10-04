;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-353) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 353


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

; A BSL-expr is one of:
;  - Number
;  - (make-add BSL-expr BSL-expr)
;  - (make-mul BSL-expr BSL-expr)

(define E1 (make-add 10 -10))
(define E2 (make-add (make-mul 20 3) 33))
(define E3 (make-add (make-mul 3.14 (make-mul 2 3)) (make-mul 3.14 (make-mul -1 -9))))


;; ====================
;; Functions:

; BSL-var-expr -> Boolean
; determines whether a BSL-var-expr is also a BSL-expr
(check-expect (numeric? 1) #true)
(check-expect (numeric? 'a) #false)
(check-expect (numeric? E1) #true)
(check-expect (numeric? E2) #true)
(check-expect (numeric? E3) #true)

(define (numeric? ex)
  (cond [(number? ex) #true]
        [(symbol? ex) #false]
        [(add? ex)
         (and (numeric? (add-left ex))
              (numeric? (add-right ex)))]
        [(mul? ex)
         (and (numeric? (mul-left ex))
              (numeric? (mul-right ex)))]))
