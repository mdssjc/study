#lang racket/base

;;
;; Examples
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")
(require "numerals.rkt")
(require "operators.rkt")
(require "tuples.rkt")

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

;; Tuples
(define p (PAIR "a" "b"))
(HEAD p)
(TAIL p)
