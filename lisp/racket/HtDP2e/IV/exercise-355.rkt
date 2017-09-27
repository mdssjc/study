;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-355) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 355


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

; An AL (short for association list) is [List-of Association]
; An Association is a list of two items:
;   (cons Symbol (cons Number '()))
(define AL1 (list (list 'a 2)))
(define AL2 (list (list 'c 1) (list 'b 3) (list 'a 2)))


;; ====================
;; Functions:

; BSL-var-expr AL -> Number
(check-error (eval-var-lookup 1 AL1) "an error found")
(check-expect (eval-var-lookup 'a AL1) 2)
(check-error (eval-var-lookup 'b AL1) "an error found")
(check-expect (eval-var-lookup 'a AL1) 2)
(check-error (eval-var-lookup (make-add 1 2) AL1) "an error found")
(check-expect (eval-var-lookup (make-add 1 'b) AL2) 3)
(check-error (eval-var-lookup (make-add (make-mul 1 2) 3) AL2) "an error found")
(check-expect (eval-var-lookup (make-add (make-mul 1 2) 'a) AL2) 2)

(define (eval-var-lookup e da)
  (local ((define (eval-var-lookup e da)
            (cond [(number? e) empty]
                  [(symbol? e) (cons e empty)]
                  [(add? e)
                   (append (eval-var-lookup (add-left e) da)
                           (eval-var-lookup (add-right e) da))]
                  [(mul? e)
                   (append (eval-var-lookup (mul-left e) da)
                           (eval-var-lookup (mul-right e) da))]))
          (define result (foldr (lambda (element acc)
                                  (local ((define value (assq element da)))
                                    (if (false? value)
                                        acc
                                        value))) #false (eval-var-lookup e da))))
    (if (false? result)
        (error "an error found")
        (second result))))
