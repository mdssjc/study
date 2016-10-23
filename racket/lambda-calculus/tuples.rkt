#lang racket/base

;;
;; Tuples
;;
;; author: Marcelo dos Santos
;;
(define T (lambda (a b) a))
(define F (lambda (a b) b))

(define pair (λ (a b) (λ (f) (f a b))))
(define head (λ (p) (p T)))
(define tail (λ (p) (p F)))

;; Output
(define p (pair "a" "b"))
(println (head p))
(println (tail p))
