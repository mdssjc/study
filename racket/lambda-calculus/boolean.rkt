#lang racket/base

;;
;; Boolean
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")

(define TRUE  T)
(define FALSE F)

(define NOT (λ (p)   ((p FALSE) TRUE)))
(define AND (λ (a b) ((a b) FALSE)))
(define OR  (λ (a b) ((a TRUE) b)))
(define XOR (lambda (a b) ((a ((b FALSE) TRUE)) b)))

;; Output
(println TRUE)
(println FALSE)

(println "NOT")
(println (NOT TRUE))
(println (NOT FALSE))

(println "AND")
(println (AND FALSE FALSE))
(println (AND FALSE TRUE))
(println (AND TRUE FALSE))
(println (AND TRUE TRUE))

(println "OR")
(println (OR FALSE FALSE))
(println (OR FALSE TRUE))
(println (OR TRUE FALSE))
(println (OR TRUE TRUE))

(println "XOR")
(println (XOR FALSE FALSE))
(println (XOR FALSE TRUE))
(println (XOR TRUE FALSE))
(println (XOR TRUE TRUE))
