;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-359) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 359


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

(define-struct fun-def [name parameter body])
; A Fun-Def (BSL-fun-def) is a structure:
;   (make-fun-def Symbol Symbol BSL-fun-expr)
; interpretation (make-fun-def n p b) specifies an function definition
;  n: is the name of the function
;  p: is the parameter of the function; and
;  b: is the body expression of the function
(define f (make-fun-def 'f 'x (make-add 3 'x)))
(define g (make-fun-def 'g 'y (make-fun-app 'f (make-mul 2 'y))))
(define h (make-fun-def 'h 'v (make-add (make-fun-app 'f 'v) (make-fun-app 'g 'v))))

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

; A BSL-fun-def* is a [List-of BSL-fun-def]:
; interpretation represent a definitions area that consists of a number of one-argument function definitions
(define da-fgh (list f g h))


;; ====================
;; Functions:

; BSL-fun-expr BSL-fun-def* -> Number
; produces the result
(check-expect (eval-function* (make-fun-app 'f 2) da-fgh) 5)
(check-expect (eval-function* (make-fun-app 'g 6) da-fgh) 15)
(check-expect (eval-function* (make-fun-app 'h (make-add 1 1)) da-fgh) 12)
(check-error  (eval-function* (make-fun-app 'h (make-fun-app 'square 2)) da-fgh) "an error found")

(define (eval-function* ex da)
  (cond [(number? ex) ex]
        [(symbol? ex) (error "an error found")]
        [(add? ex)
         (+ (eval-function* (add-left ex) da)
            (eval-function* (add-right ex) da))]
        [(mul? ex)
         (* (eval-function* (mul-left ex) da)
            (eval-function* (mul-right ex) da))]
        [(fun-app? ex)
         (local ((define def (lookup-def da (fun-app-name ex)))
                 (define b (fun-def-body def))
                 (define x (fun-def-parameter def))
                 (define v (eval-function* (fun-app-expr ex) da)))
           (eval-function* (subst b x v) da))]))

; BSL-fun-def* Symbol -> BSL-fun-def
; retrieves the definition of f in da
; signals an error if there is none
(check-error (lookup-def da-fgh 'a) "an error found")
(check-expect (lookup-def da-fgh 'g) g)

(define (lookup-def da f)
  (cond [(empty? da) (error "an error found")]
        [else
         (if (symbol=? (fun-def-name (first da)) f)
             (first da)
             (lookup-def (rest da) f))]))

; BSL-fun-expr Symbol Number -> BSL-fun-expr
; produces a BSL-fun-expr like ex with all occurrences of x replaced by v
(check-expect (subst 1 'a 2) 1)
(check-expect (subst 'a 'a 2) 2)
(check-expect (subst 'b 'a 2) 'b)
(check-expect (subst (make-add 'a 'b) 'a 2) (make-add 2 'b))
(check-expect (subst (make-add 'a 'a) 'a 2) (make-add 2 2))
(check-expect (subst (make-mul 'a 'b) 'a 3) (make-mul 3 'b))
(check-expect (subst (make-mul 'a 'a) 'a 3) (make-mul 3 3))
(check-expect (subst (make-mul 'a (make-add 'b 'a)) 'a 3) (make-mul 3 (make-add 'b 3)))
(check-expect (subst (make-fun-app 'fa (make-add 5 'a)) 'a 3) (make-fun-app 'fa (make-add 5 3)))

(define (subst ex x v)
  (cond [(number? ex) ex]
        [(symbol? ex)
         (if (symbol=? ex x) v ex)]
        [(add? ex)
         (make-add (subst (add-left ex) x v)
                   (subst (add-right ex) x v))]
        [(mul? ex)
         (make-mul (subst (mul-left ex) x v)
                   (subst (mul-right ex) x v))]
        [(fun-app? ex)
         (make-fun-app (fun-app-name ex)
                       (subst (fun-app-expr ex) x v))]))
