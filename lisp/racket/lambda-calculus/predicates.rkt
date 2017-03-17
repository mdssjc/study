#lang racket/base

;;
;; Predicates (Church Predicates)
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")
(require "booleans.rkt")
(require "operators.rkt")
(provide (all-defined-out))

(define ZERO? (λ (n) ((n (λ (x) F)) T)))
(define LEQ?  (λ (m n) (ZERO? (SUB m n))))
(define EQ?   (λ (m n) (AND (LEQ? m n) (LEQ? n m))))
