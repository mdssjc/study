;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-360) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 360


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
; A Fun-Def is a structure:
;   (make-fun-def Symbol Symbol BSL-fun-expr)
; interpretation (make-fun-def n p b) specifies an function definition
;  n: is the name of the function
;  p: is the parameter of the function; and
;  b: is the body expression of the function

; A BSL-fun-expr is one of:
;  - Number
;  - Symbol
;  - (make-add BSL-fun-expr BSL-fun-expr)
;  - (make-mul BSL-fun-expr BSL-fun-expr)
;  - (make-fun-app Symbol BSL-fun-expr)
; interpretation class of values, variables and function application to which a representation of a BSL expression can evaluate

; An Association is a list of two items:
;   (cons Symbol (cons Number '()))

; A BSL-da is one of:
; - Association
; - Fun-Def
; interpretation data definition for the representation of DrRacket’s definition area
; A BSL-da-all is a [List-of BSL-da]:
; interpretation a sequence that freely mixes constant definitions and one-argument function definitions
(define close-to-pi '(close-to-pi 3.14))
(define area-of-circle (make-fun-def 'area-of-circle 'r (make-mul 'close-to-pi (make-mul 'r 'r))))
(define volume-of-10-cylinder (make-fun-def 'volume-of-10-cylinder 'r (make-mul 10 (make-fun-app 'area-of-circle 'r))))

(define da-list (list close-to-pi area-of-circle volume-of-10-cylinder))


;; ====================
;; Functions:

; BSL-da-all Symbol -> Number
; produces the representation of a constant definition whose name is x
(check-expect (lookup-con-def da-list 'close-to-pi) 3.14)
(check-error (lookup-con-def da-list 'closed-to-pi) "an error found")

(define (lookup-con-def da x)
  (cond [(empty? da) (error "an error found")]
        [else
         (if (and (list? (first da))
                  (symbol=? (first (first da)) x))
             (second (first da))
             (lookup-con-def (rest da) x))]))

; BSL-da-all Symbol -> Fun-Def
; produces the representation of a function definition whose name is f
(check-error (lookup-fun-def da-list 'close-to-pi) "an error found")
(check-expect (lookup-fun-def da-list 'area-of-circle) area-of-circle)
(check-expect (lookup-fun-def da-list 'volume-of-10-cylinder) volume-of-10-cylinder)

(define (lookup-fun-def da f)
  (cond [(empty? da) (error "an error found")]
        [else
         (if (and (fun-def? (first da))
                  (symbol=? (fun-def-name (first da)) f))
             (first da)
             (lookup-fun-def (rest da) f))]))
