#lang racket/base

;;
;; Booleans (Church Booleans)
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")
(provide (all-defined-out))

(define TRUE  T)
(define FALSE F)

(define NOT  (λ (p)     ((p FALSE) TRUE))) ; Normal Order
(define NOT2 (lambda (p a b) ((p a) b)))        ; Application Order
(define AND  (λ (a b)   ((a b) FALSE)))
(define OR   (λ (a b)   ((a TRUE) b)))
(define XOR  (lambda (a b)   ((a (NOT b)) b)))
(define IF   (lambda (p a b) ((p a) b)))
