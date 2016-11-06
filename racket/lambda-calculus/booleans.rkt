#lang racket/base

;;
;; Booleans (Church Booleans)
;;
;; author: Marcelo dos Santos
;;
(require "combinators.rkt")

(define TRUE  T)
(define FALSE F)

(define NOT  (λ (p)     ((p FALSE) TRUE))) ; Normal Order
(define NOT2 (lambda (p a b) ((p a) b)))        ; Application Order
(define AND  (λ (a b)   ((a b) FALSE)))
(define OR   (λ (a b)   ((a TRUE) b)))
(define XOR  (lambda (a b)   ((a (NOT b)) b)))
(define IF   (lambda (p a b) ((p a) b)))

;; Output
(println "BOOLEANS")
(println TRUE)
(println FALSE)

(println "NOT")
(println (NOT  TRUE))
(println (NOT  FALSE))
(println (NOT2 TRUE  "1" "0"))
(println (NOT2 FALSE "1" "0"))

(println "AND")
(println (AND FALSE FALSE))
(println (AND FALSE TRUE))
(println (AND TRUE FALSE))
(println (AND TRUE TRUE))

(println "OR")
(println (OR FALSE FALSE))
(println (OR FALSE TRUE))
(println (OR TRUE FALSE))
(println (OR TRUE TRUE))

(println "XOR")
(println (XOR FALSE FALSE))
(println (XOR FALSE TRUE))
(println (XOR TRUE FALSE))
(println (XOR TRUE TRUE))

(println "IF")
(println (IF TRUE  "1" "2"))
(println (IF FALSE "1" "2"))
