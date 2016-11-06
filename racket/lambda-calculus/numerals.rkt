#lang racket/base

;;
;; Numerals (Church Numerals)
;;
;;  0 = λf.λx.x
;;  1 = λf.λx.fx
;;  2 = λf.λx.f(fx)
;;  3 = λf.λx.f(f(fx))
;;  ...
;;  n = λf.λxfⁿx
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")
(provide (all-defined-out))

(define :0 (lambda (f) I))
(define :1 (lambda (f) (lambda (x) (f ((:0 f) x)))))
(define :2 (lambda (f) (lambda (x) (f ((:1 f) x)))))
(define :3 (lambda (f) (lambda (x) (f ((:2 f) x)))))
(define :4 (lambda (f) (lambda (x) (f ((:3 f) x)))))
(define :5 (lambda (f) (lambda (x) (f ((:4 f) x)))))
(define :6 (lambda (f) (lambda (x) (f ((:5 f) x)))))
(define :7 (lambda (f) (lambda (x) (f ((:6 f) x)))))
(define :8 (lambda (f) (lambda (x) (f ((:7 f) x)))))
(define :9 (lambda (f) (lambda (x) (f ((:8 f) x)))))
