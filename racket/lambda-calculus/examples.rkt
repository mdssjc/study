#lang racket/base

;;
;; Examples
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")
(require "numerals.rkt")
(require "operators.rkt")

;; Numbers
(println "Numbers:")
(number :0)
(number :1)
(number :2)
(number :3)
(number :4)
(number :5)
(number :6)
(number :7)
(number :8)
(number :9)

;; Operators
(println "Operators:")
(eval (SUCC :0))
(eval (PLUS :1 :2))
