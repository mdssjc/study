#lang racket/base

;; Combinators
(define S (λ (x) (λ (y) (λ (z) ((x z) (y z))))))
(define K (λ (x) (λ (y) x)))
(define I (λ (x) x))

;; Output
(define multi (λ (x) (λ (y) (* x y))))
(define double (λ (x) (* x x)))

(((S multi) double) 5)
((K "A") "B")
(I 1)
