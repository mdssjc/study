#lang racket/base

;; Combinators
(define S (λ (x) (λ (y) (λ (z) ((x z) (y z))))))           ; Substitution
(define K (λ (x) (λ (y) x)))                               ; Cancellator
(define I (λ (x) x))                                       ; Identificator
(define B (λ (x) (λ (y) (λ (z) ((x y) z)))))               ; Compositor
(define C (λ (x) (λ (y) (λ (z) x z y))))                   ; Permutator
(define T (λ (x) (λ (y) x)))
(define F (λ (x) (λ (y) y)))
(define ω (λ (x) x x))
(define Ω (λ () ω ω))
(define Y (λ (x) (λ (y) (λ (z) (λ (u) (x (y z) (y u))))))) ; Distribution
(define Θ (λ (x) (λ (y) (λ (z) (λ (u) (x (y u) (z u))))))) ; Distribution

;; Output
(define multi (λ (x) (λ (y) (* x y))))
(define double (λ (x) (* x x)))

(((S multi) double) 5)
((K "A") "B")
(I 1)
(((B multi) 5) 2)

((T 1) 0)
((F 1) 0)
