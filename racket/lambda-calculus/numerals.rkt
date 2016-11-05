#lang racket/base

;;
;; Numerals
;;
;; author: Marcelo dos Santos
;;
(define N0 (lambda (f x) x))
;; (define N1 (lambda (f x) (f x)))
(define N1 (lambda (f x) (f (N0 f x))))
;; (define N2 (lambda (f x) (f (f x))))
(define N2 (lambda (f x) (f (N1 f x))))
;; (define N3 (lambda (f x) (f (f (f x)))))
(define N3 (lambda (f x) (f (N2 f x))))

;; Output
(define (inc x) (+ x 1))                ; TODO: refatorar
(N0 inc 0)
(N1 inc 0)
(N2 inc 0)
(N3 inc 0)
