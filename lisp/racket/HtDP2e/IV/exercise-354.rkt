;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-354) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 354


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

; BSL-var-expr AL -> BSL-var-expr
; determines its value; otherwise it signals an error
(check-expect (eval-variable* 1 AL1) 1)
(check-expect (eval-variable* (make-add 'a 1) AL1) (make-add 2 1))
(check-expect (eval-variable* (make-add (make-mul 'c 'b) 'a) AL2) (make-add (make-mul 1 3) 2))
(check-error (eval-variable* (make-add 'b 1) AL1) "an error found")
(check-error (eval-variable* (make-add (make-mul 'c 'b) (make-mul 'a 'd)) AL2) "an error found")

(define (eval-variable* ex da)
  (local ((define (eval-variable* ex da)
            (cond [(empty? da) ex]
                  [else
                   (eval-variable* (subst ex (first (first da)) (second (first da)))
                                   (rest da))]))
          (define result (eval-variable* ex da)))
    (if (numeric? result)
        result
        (error "an error found"))))

; BSL-var-expr -> True or Error
; determines its value if numeric? yields true for the input; otherwise it signals an error
(check-expect (eval-variable 1) #true)
(check-error (eval-variable 'a) "an error found")
(check-expect (eval-variable (make-add 1 2)) #true)
(check-error (eval-variable (make-add 1 'a)) "an error found")
(check-expect (eval-variable (make-add (make-mul 1 2) 3)) #true)
(check-error (eval-variable (make-add (make-mul 1 2) 'a)) "an error found")

(define (eval-variable ex)
  (if (numeric? ex)
      #true
      (error "an error found")))

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

; BSL-var-expr Symbol Number -> BSL-var-expr
; produces a BSL-var-expr like ex with all occurrences of x replaced by v
(check-expect (subst 1 'a 2) 1)
(check-expect (subst 'a 'a 2) 2)
(check-expect (subst 'b 'a 2) 'b)
(check-expect (subst (make-add 'a 'b) 'a 2) (make-add 2 'b))
(check-expect (subst (make-add 'a 'a) 'a 2) (make-add 2 2))
(check-expect (subst (make-mul 'a 'b) 'a 3) (make-mul 3 'b))
(check-expect (subst (make-mul 'a 'a) 'a 3) (make-mul 3 3))
(check-expect (subst (make-mul 'a (make-add 'b 'a)) 'a 3) (make-mul 3 (make-add 'b 3)))

(define (subst ex x v)
  (cond [(number? ex) ex]
        [(symbol? ex)
         (if (symbol=? ex x) v ex)]
        [(add? ex)
         (make-add (subst (add-left ex) x v)
                   (subst (add-right ex) x v))]
        [(mul? ex)
         (make-mul (subst (mul-left ex) x v)
                   (subst (mul-right ex) x v))]))
