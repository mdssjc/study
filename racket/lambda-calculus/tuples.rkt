#lang racket/base

;;
;; Tuples (Church Pairs)
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")

(define pair (λ (a b) (λ (f) ((f a) b))))
(define head (λ (p) (p T)))
(define tail (λ (p) (p F)))

;; Output
(define p (pair "a" "b"))

(println (head p))
(println (tail p))
