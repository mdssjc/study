;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-362) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 362


;; =================
;; Constants:

(define WRONG "Invalid datatype")


;; ====================
;; Data definitions:

; A S-expr is one of:
; - Atom
; - SL

; A SL is one of:
; - '()
; - (cons S-expr SL)

; An Atom is one of:
; - Number
; - String
; - Symbol

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

; S-expr SL -> Number
; produces the result of expression 
(define sl '((close-to-pi 3.14)
             (def area-of-circle r (* close-to-pi (* r r)))
             (def volume-of-10-cylinder r (* 10 (app area-of-circle r)))))

(check-expect (interpreter 'close-to-pi sl) 3.14)
(check-expect (interpreter '(app area-of-circle 5) sl) 78.5)
(check-expect (interpreter '(app volume-of-10-cylinder 5) sl) 785)

(define (interpreter s-expr sl)
  (eval-all (parse s-expr) (map parse sl)))

; BSL-fun-expr BSL-da-all -> Number
; produces the same value that DrRacket
(check-expect (eval-all 'close-to-pi da-list) 3.14)
(check-error (eval-all 'close-to-pi2 da-list) "an error found")
(check-expect (eval-all (make-fun-app 'area-of-circle 5) da-list) 78.5)
(check-expect (eval-all (make-fun-app 'volume-of-10-cylinder 5) da-list) 785)
(check-error (eval-all (make-fun-app 'area-of-circle2 5) da-list) "an error found")

(define (eval-all ex da)
  (cond [(number? ex) ex]
        [(symbol? ex) (lookup-con-def da ex)]
        [(add? ex)
         (+ (eval-all (add-left ex) da)
            (eval-all (add-right ex) da))]
        [(mul? ex)
         (* (eval-all (mul-left ex) da)
            (eval-all (mul-right ex) da))]
        [(fun-app? ex)
         (local ((define def (lookup-fun-def da (fun-app-name ex)))
                 (define b (fun-def-body def))
                 (define x (fun-def-parameter def))
                 (define v (eval-all (fun-app-expr ex) da)))
           (eval-all (subst b x v) da))]))

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

; S-expr -> BSL-fun-expr or Fun-Def
; produces a BSL-fun-expr or Fun-Def
(check-expect (parse 1) 1)
(check-error (parse "1") "Invalid datatype")
(check-expect (parse '1) 1)
(check-expect (parse 'a) 'a)
(check-error (parse (list 1 1)) "Invalid datatype")
(check-error (parse (list 1 1 1 1)) "Invalid datatype")
(check-expect (parse '(+ 1 1)) (make-add 1 1))
(check-expect (parse '(* 2 3)) (make-mul 2 3))
(check-error (parse '(/ 1 1)) "Invalid datatype")
(check-expect (parse '(const 123)) '(const 123))
(check-expect (parse '(app x 3.12)) (make-fun-app 'x 3.12))
(check-expect (parse '(app f (+ 1 x))) (make-fun-app 'f (make-add 1 'x)))
(check-expect (parse '(def f x (+ 1 x))) (make-fun-def 'f 'x (make-add 1 'x)))

(define (parse s)
  (local ((define (atom? a)
            (or (number? a) (string? a) (symbol? a)))
          (define (parse-atom s)
            (cond [(number? s) s]
                  [(string? s) (error WRONG)]
                  [(symbol? s) s]))
          (define (parse-sl s)
            (cond [(and (= (length s) 2)
                        (symbol? (first s)))
                   (list (first s) (parse (second s)))]
                  [(and (= (length s) 3)
                        (symbol? (first s)))
                   (cond [(symbol=? (first s) '+)
                          (make-add (parse (second s)) (parse (third s)))]
                         [(symbol=? (first s) '*)
                          (make-mul (parse (second s)) (parse (third s)))]
                         [(symbol=? (first s) 'app)
                          (make-fun-app (second s) (parse (third s)))]
                         [else (error WRONG)])]
                  [(and (= (length s) 4)
                        (symbol? (first s)))
                   (cond [(symbol=? (first s) 'def)
                          (make-fun-def (second s) (third s) (parse (fourth s)))]
                         [else (error WRONG)])]
                  [else (error WRONG)])))
    (cond [(atom? s) (parse-atom s)]
          [else
           (parse-sl s)])))
