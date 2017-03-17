#lang racket/base

;;
;; Lists (Church Lists)
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")
(provide (all-defined-out))

(define CONS (lambda (h t) (lambda (f) ((f h) t))))
(define NIL  (lambda (x) T))
(define NULL (λ (l) (l (lambda (h) (λ (t) F)))))
(define CAR  (λ (l) (l T)))
(define CDR  (λ (l) (l F)))
