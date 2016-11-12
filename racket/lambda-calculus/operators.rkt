#lang racket/base

;;
;; Operators (Church Operators)
;;
;; author: Marcelo dos Santos
;;
(require "numerals.rkt")
(require "combinators.rkt")
(provide (all-defined-out))

(define SUCC (λ (n)   (λ (f) (λ (x) (f ((n f) x))))))
(define PLUS (λ (m n) (m (SUCC n))))
(define MULT (λ (m n) ((m (n SUCC)) :0)))
(define POW  (λ (b e) (e b)))
(define PRED (λ (n)   (λ (f) (λ (x) (((n (λ (g) (λ (h) (h (g f))))) (λ (u) x)) I)))))
