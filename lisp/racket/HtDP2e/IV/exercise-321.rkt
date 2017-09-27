;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-321) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 321


;; ====================
;; Data definitions:

; A S-expr is one of:
; - X
; - [List-of S-expr]


;; ====================
;; Functions:

; S-expr Symbol -> N
; counts all occurrences of sy in sexp
(check-expect (count 'world 'hello) 0)
(check-expect (count '(world hello) 'hello) 1)
(check-expect (count '(((world) hello) hello) 'hello) 2)

(define (count sexp sy)
  (cond [(symbol? sexp) (if (symbol=? sexp sy) 1 0)]
        [else
         (foldr (lambda (at res) (+ (count at sy) res)) 0 sexp)]))
