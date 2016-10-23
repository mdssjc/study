#lang racket/base

;;
;; Boolean
;;
;; author: Marcelo dos Santos
;;
(define T (lambda (a b) a))
(define F (lambda (a b) b))

(define NOT (λ (x) (x F T)))
(define AND (λ (b1 b2) (b1 b2 F)))
(define OR  (λ (b1 b2) (b1 T b2)))

;; Output
(println (T 1 0))
(println (F 1 0))

(println "NOT")
(println (NOT T))
(println (NOT F))

(println "AND")
(println (AND F F))
(println (AND F T))
(println (AND T F))
(println (AND T T))

(println "OR")
(println (OR F F))
(println (OR F T))
(println (OR T F))
(println (OR T T))
