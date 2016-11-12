#lang racket/base

;;
;; Combinators
;;
;; author: Marcelo dos Santos
;;
(provide (all-defined-out))

;; S -> Substitution/Slider: λx[λy[λz[xz(yz)]]]
(define S (λ (x) (λ (y) (λ (z) ((x z) (y z))))))

;; K -> Killer/Cancellator: λx[λy[x]]
;; K = λx.λy.x
(define K (λ (x) (λ (y) x)))

;; I -> Identity/Identificator: λx[x]
;; id = λx.x
(define I (λ (x) x))

;; B -> Compositor: λx[λy[λz[x(yz)]]]
(define B (λ (x) (λ (y) (λ (z) (x (y z))))))

;; C -> Permutator: λx[λy[λz[xzy]]]
(define C (λ (x) (λ (y) (λ (z) ((x z) y)))))

;; T -> True: λx[λy[x]]
(define T (λ (x) (λ (y) x)))

;; F -> False: λx[λy[y]]
(define F (λ (x) (λ (y) y)))

;; W -> Duplicator: λx[λy[xyy]]
(define W (λ (x) (λ (y) ((x y) y))))

;; ω -> λx[xx]
(define ω (λ (x) (x x)))

;; Ω -> ωω
(define Ω (λ () (ω (ω))))

;; Y -> Distribution: λf[(λx[f(xx)])(λx[f(xx)])]
(define Y (λ (f) ((λ (x) (f (x x)))
                  (λ (x) (f (x x))))))

;; Θ -> Distribution: (λx[λf[f(xxf)]])(λx[λf[f(xxf)]])
(define Θ (λ (x) (λ (y) (λ (z) (λ (u) (x (y u) (z u)))))))
