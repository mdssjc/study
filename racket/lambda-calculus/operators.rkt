#lang racket/base

;;
;; Operators (Church Operators)
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")
(provide (all-defined-out))

(define SUCC (λ (n)   (λ (f) (λ (x) (f ((n f) x))))))
(define PLUS (λ (m n) (m (SUCC n))))
