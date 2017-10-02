;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-351) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 351


;; =================
;; Constants:

(define WRONG "Invalid datatype")


;; ====================
;; Data definitions:

; A S-expr is one of:
; - Atom
; - SL

; A SL is one of:
; - '()
; - (cons S-expr SL)

; An Atom is one of:
; - Number
; - String
; - Symbol

(define-struct add [left right])
; An Add is a structure:
;   (make-add BSL-expr BSL-expr)
; interpretation (make-add l r) specifies an addition expression
;  l: is the left operand; and
;  r: is the right operand

(define-struct mul [left right])
; A Mul is a structure:
;   (make-mul BSL-expr BSL-expr)
; interpretation (make-mul l r) specifies a multiplication expression
;  l: is the left operand; and
;  r: is the right operand

; A BSL-expr is one of:
;  - Number
;  - (make-add BSL-expr BSL-expr)
;  - (make-mul BSL-expr BSL-expr)
; interpretation class of values to which a representation of a BSL expression can evaluate

(define E1 (make-add 10 -10))
(define E2 (make-add (make-mul 20 3) 33))
(define E3 (make-add (make-mul 3.14 (make-mul 2 3)) (make-mul 3.14 (make-mul -1 -9))))
; (+ -1 2)
; (+ (* -2 -3) 33)
; (* (+ 1 (* 2 3)) 3.14)


;; ====================
;; Functions:

; S-expr -> Number
; produces its value; otherwise, it signals an error
(check-error (interpreter-expr "1") "Invalid datatype")
(check-expect (interpreter-expr 1) 1)
(check-expect (interpreter-expr '(+ 1 1)) 2)
(check-expect (interpreter-expr '(* 2 3)) 6)

(define (interpreter-expr s)
  ((compose eval-expression parse) s))

; BSL-expr -> Number
; computes its value
(check-expect (eval-expression 3) 3)
(check-expect (eval-expression E1) 0)
(check-expect (eval-expression E2) 93)
(check-expect (eval-expression E3) 47.1)

(define (eval-expression exp)
  (cond [(number? exp) exp]
        [(add? exp)
         (+ (eval-expression (add-left exp))
            (eval-expression (add-right exp)))]
        [(mul? exp)
         (* (eval-expression (mul-left exp))
            (eval-expression (mul-right exp)))]))

; S-expr -> BSL-expr
; produces a BSL-expr
(check-expect (parse 1) 1)
(check-error (parse "1") "Invalid datatype")
(check-expect (parse '1) 1)
(check-error (parse 'a) "Invalid datatype")
(check-error (parse (list 1 1)) "Invalid datatype")
(check-error (parse (list 1 1 1 1)) "Invalid datatype")
(check-expect (parse '(+ 1 1)) (make-add 1 1))
(check-expect (parse '(* 2 3)) (make-mul 2 3))
(check-error (parse '(/ 1 1)) "Invalid datatype")

(define (parse s)
  (local ((define (atom? a)
            (or (number? a) (string? a) (symbol? a)))
          (define (parse-atom s)
            (cond [(number? s) s]
                  [(string? s) (error WRONG)]
                  [(symbol? s) (error WRONG)]))
          (define (parse-sl s)
            (cond [(and (= (length s) 3)
                        (symbol? (first s)))
                   (cond [(symbol=? (first s) '+)
                          (make-add (parse (second s)) (parse (third s)))]
                         [(symbol=? (first s) '*)
                          (make-mul (parse (second s)) (parse (third s)))]
                         [else (error WRONG)])]
                  [else (error WRONG)])))
    (cond [(atom? s) (parse-atom s)]
          [else (parse-sl s)])))
