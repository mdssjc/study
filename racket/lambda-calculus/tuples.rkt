#lang racket/base

;;
;; Tuples (Church Tuples)
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")
(provide (all-defined-out))

(define PAIR (λ (a b) (λ (f) ((f a) b))))
(define HEAD (λ (p) (p T)))
(define TAIL (λ (p) (p F)))
