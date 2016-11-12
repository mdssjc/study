;; #lang racket/base
#lang lazy

;;
;; Examples
;;
;; author: Marcelo dos Santos
;;
(require "numerals.rkt")
(require "operators.rkt")
(require "predicates.rkt")
(require "tuples.rkt")
(require "combinators.rkt")

;; Helper
(define (eval f) ((f (λ (n) (+ n 1))) 0))

;; Numbers
(println "Numbers:")
(eval :0)
(eval :1)
(eval :2)
(eval :3)
(eval :4)
(eval :5)
(eval :6)
(eval :7)
(eval :8)
(eval :9)

;; Operators
(println "Operators:")
(eval (SUCC :0))
(eval (PLUS :1 :2))
(eval (MULT :3 :2))
(eval (POW  :2 :5))
(eval (PRED :4))
(eval (SUB :6 :2))

;; Predicates
(println "Predicates:")
(ZERO? :0)
(ZERO? :1)
(LEQ?  :2 :3)
(LEQ?  :7 :2)
(EQ?   :2 :2)
(EQ?   :2 :1)

;; Tuples
(println "Tuples:")
(define p (PAIR "a" "b"))
(HEAD p)
(TAIL p)

;; Combinators
(println "Combinators:")
(define multi (λ (x) (λ (y) (* x y))))
(define div (λ (x) (λ (y) (/ x y))))
(define (double x) (* x x))
(define (succ x) (+ x 1))
(define factorial (Y (λ (fact) (λ (n) (if (zero? n) 1 (* n (fact (- n 1))))))))

(((S multi) double) 5)
((K "A") "B")
(I 1)
(((B double) succ) 1)
(((C div) 4) 2)
((T 1) 0)
((F 1) 0)
((W multi) 5)

;; (!! (map factorial '(1 2 4 8)))
