#lang racket/base

;;
;; Predicates (Church Predicates)
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")
(require "operators.rkt")
(provide (all-defined-out))

(define ZERO? (λ (n) ((n (λ (x) F)) T)))
