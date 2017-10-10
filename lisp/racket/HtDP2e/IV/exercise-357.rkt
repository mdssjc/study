;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-357) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 357


;; ====================
;; Data definitions:

(define-struct add [left right])
; An Add is a structure:
;   (make-add BSL-fun-expr BSL-fun-expr)
; interpretation (make-add l r) specifies an addition expression
;  l: is the left operand; and
;  r: is the right operand

(define-struct mul [left right])
; A Mul is a structure:
;   (make-mul BSL-fun-expr BSL-fun-expr)
; interpretation (make-mul l r) specifies a multiplication expression
;  l: is the left operand; and
;  r: is the right operand

(define-struct fun-app [name expr])
; A Fun-App is a structure:
;   (make-fun-app Symbol BSL-fun-expr)
; interpretation (make-fun-app n e) specifies an function application
;  n: is the name of the function; and
;  e: is the an expression of the function

; A BSL-var-expr is one of:
;  - Number
;  - Symbol
;  - (make-add BSL-var-expr BSL-var-expr)
;  - (make-mul BSL-var-expr BSL-var-expr)

; A BSL-fun-expr is one of:
;  - Number
;  - Symbol
;  - (make-add BSL-fun-expr BSL-fun-expr)
;  - (make-mul BSL-fun-expr BSL-fun-expr)
;  - (make-fun-app Symbol BSL-fun-expr)
; interpretation class of values, variables and function application to which a representation of a BSL expression can evaluate
(define k (make-fun-app 'k (make-add 1 1)))
(define EX1 (make-mul 5 k))
(define i (make-fun-app 'i 5))
(define EX2 (make-mul i k))

; An AL (short for association list) is [List-of Association]
; An Association is a list of two items:
;   (cons Symbol (cons Number '()))


;; ====================
;; Functions:

; BSL-fun-expr Symbol Symbol BSL-fun-expr -> Number
; determines the value of ex
(check-error (eval-definition1 (make-add (make-fun-app 'f 'x) 'a) 'f 'x (make-add 1 1)) "an error found")
(check-error (eval-definition1 (make-add (make-fun-app 'f 'x) 'a) 'g 'x (make-add 1 1)) "an error found")
(check-expect (eval-definition1 (make-add (make-fun-app 'f 1) 1) 'f 'x (make-add 'x 1)) 3)
(check-expect (eval-definition1 (make-add (make-fun-app 'f 2) 1) 'f 'x (make-mul 'x 3)) 7)

(define (eval-definition1 ex f x b)
  (cond [(number? ex) ex]
        [(symbol? ex) (error "an error found")]
        [(add? ex)
         (+ (eval-definition1 (add-left ex) f x b)
            (eval-definition1 (add-right ex) f x b))]
        [(mul? ex)
         (* (eval-definition1 (mul-left ex) f x b)
            (eval-definition1 (mul-right ex) f x b))]
        [(fun-app? ex)
         (if (symbol=? (fun-app-name ex) f)
             (local ((define value (eval-definition1 (fun-app-expr ex) f x b))
                     (define plugd (subst b x value)))
               (eval-definition1 plugd f x b))
             (error "an error found"))]))

; BSL-var-expr Symbol Number -> BSL-var-expr
; produces a BSL-var-expr like ex with all occurrences of x replaced by v
(check-expect (subst 1 'a 2) 1)
(check-expect (subst 'a 'a 2) 2)
(check-expect (subst 'b 'a 2) 'b)
(check-expect (subst (make-add 'a 'b) 'a 2) (make-add 2 'b))
(check-expect (subst (make-add 'a 'a) 'a 2) (make-add 2 2))
(check-expect (subst (make-mul 'a 'b) 'a 3) (make-mul 3 'b))
(check-expect (subst (make-mul 'a 'a) 'a 3) (make-mul 3 3))
(check-expect (subst (make-mul 'a (make-add 'b 'c)) 'b 3) (make-mul 'a (make-add 3 'c)))

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
