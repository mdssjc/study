;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-353) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 353


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

; A BSL-var-expr is one of: 
;  - Number
;  - Symbol 
;  - (make-add BSL-var-expr BSL-var-expr)
;  - (make-mul BSL-var-expr BSL-var-expr)


;; ====================
;; Functions:

; BSL-var-expr -> Boolean
; determines whether a BSL-var-expr is also a BSL-expr
(check-expect (numeric? 1) #true)
(check-expect (numeric? 'a) #false)
(check-expect (numeric? (make-add 1 2)) #true)
(check-expect (numeric? (make-add 1 'a)) #false)
(check-expect (numeric? (make-add (make-mul 1 2) 3)) #true)
(check-expect (numeric? (make-add (make-mul 1 2) 'a)) #false)

(define (numeric? ex)
  (cond [(number? ex) #true]
        [(symbol? ex) #false]
        [(add? ex)
         (and (numeric? (add-left ex))
              (numeric? (add-right ex)))]
        [(mul? ex)
         (and (numeric? (mul-left ex))
              (numeric? (mul-right ex)))]))
