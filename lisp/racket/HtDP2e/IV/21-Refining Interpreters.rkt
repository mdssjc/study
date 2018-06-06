;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname |21-Refining Interpreters|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 21-Refining Interpreters.rkt
;; IV - Intertwined Data
;; 21 - Refining Interpreters



;; 21.1 - Interpreting Expressions

;; Exercise 345


;; =================
;; Data definitions:

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

(define EXPR1 (make-add 10 -10))
(define EXPR2 (make-add (make-mul 20 3) 33))
(define EXPR3 (make-add (make-mul 3.14 (make-mul 2 3)) (make-mul 3.14 (make-mul -1 -9))))
; (+ -1 2)
; (+ (* -2 -3) 33)
; (* (+ 1 (* 2 3)) 3.14)


;; =================
;; Functions:

; BSL-expr -> Number
; computes its value
(check-expect (calculator 3) 3)
(check-expect (calculator (make-add 1 1)) 2)
(check-expect (calculator (make-mul 3 10)) 30)
(check-expect (calculator (make-add (make-mul 1 1) 10)) 11)

(define (calculator expr)
  (cond [(number? expr) expr]
        [(add? expr)
         (+ (calculator (add-left  expr))
            (calculator (add-right expr)))]
        [(mul? expr)
         (* (calculator (mul-left  expr))
            (calculator (mul-right expr)))]))

;; Exercise 346


;; =================
;; Data definitions:

(define-struct div [left right])
; A Div is a structure:
;   (make-div BSL-expr BSL-expr)
; interpretation (make-div l r) specifies a division expression
;  l: is the left operand; and
;  r: is the right operand

; A BSL-expr is one of:
;  - Number
;  - (make-add BSL-expr BSL-expr)
;  - (make-mul BSL-expr BSL-expr)
;  - (make-div BSL-expr BSL-expr)
; interpretation class of values to which a representation of a BSL expression can evaluate

(define EXPR4 (make-div (make-mul 4 2) 8))
; (/ (* 4 2) 8)

;; Exercise 347


;; =================
;; Functions:

; BSL-expr -> Number
; computes its value
(check-expect (eval-expression 3) 3)
(check-expect (eval-expression EXPR1) 0)
(check-expect (eval-expression EXPR2) 93)
(check-expect (eval-expression EXPR3) 47.1)
(check-expect (eval-expression EXPR4) 1)

(define (eval-expression expr)
  (cond [(number? expr) expr]
        [(add? expr)
         (+ (eval-expression (add-left  expr))
            (eval-expression (add-right expr)))]
        [(mul? expr)
         (* (eval-expression (mul-left  expr))
            (eval-expression (mul-right expr)))]
        [(div? expr)
         (/ (eval-expression (div-left  expr))
            (eval-expression (div-right expr)))]))

;; Exercise 348


;; =================
;; Data definitions:

(define-struct and2 [left right])
; An And is a structure:
;   (make-and BSL-boolean-expr BSL-boolean-expr)
; interpretation (make-and2 l r) specifies an AND operation
;  l: is the left operand; and
;  r: is the right operand

(define-struct or2 [left right])
; An Or is a structure:
;   (make-or BSL-boolean-expr BSL-boolean-expr)
; interpretation (make-or2 l r) specifies an OR operation
;  l: is the left operand; and
;  r: is the right operand

(define-struct not2 [operand])
; A Not is a structure:
;   (make-not BSL-boolean-expr)
; interpretation (make-not2 o) specifies a NOT operation
;  o: is an operand

; A BSL-boolean-expr is one of:
;  - #false
;  - #true
;  - (make-and2 BSL-boolean-expr BSL-boolean-expr)
;  - (make-or2  BSL-boolean-expr BSL-boolean-expr)
;  - (make-not2 BSL-boolean-expr)
; interpretation class of values to which a representation of a BSL boolean expression can evaluate


;; =================
;; Functions:

; BSL-boolean-expr -> Boolean
; computes its value
(check-expect (eval-bool-expression #false) #false)
(check-expect (eval-bool-expression #true) #true)
(check-expect (eval-bool-expression (make-and2 #true    #true))  #true)
(check-expect (eval-bool-expression (make-and2 #true    #false)) #false)
(check-expect (eval-bool-expression (make-or2  #true    #false)) #true)
(check-expect (eval-bool-expression (make-or2  #false   #false)) #false)
(check-expect (eval-bool-expression (make-not2 #false)) #true)
(check-expect (eval-bool-expression (make-not2 #true))  #false)
(check-expect (eval-bool-expression (make-not2 (make-and2 #true (make-or2 #false #true)))) #false)

(define (eval-bool-expression expr)
  (cond [(boolean? expr) expr]
        [(and2? expr)
         (and (eval-bool-expression (and2-left  expr))
              (eval-bool-expression (and2-right expr)))]
        [(or2? expr)
         (or (eval-bool-expression (or2-left  expr))
             (eval-bool-expression (or2-right expr)))]
        [(not2? expr)
         (not (eval-bool-expression (not2-operand expr)))]))

;; Exercise 349


;; =================
;; Constants:

(define WRONG "Invalid datatype")


;; =================
;; Data definitions:

; An S-expr is one of:
; - Atom
; - SL

; An SL is one of:
; - '()
; - (cons S-expr SL)

; An Atom is one of:
; - Number
; - String
; - Symbol


;; =================
;; Functions:

; S-expr -> BSL-expr
; computes its value
(check-expect (parse 1) 1)
(check-error  (parse "1") "Invalid datatype")
(check-expect (parse '1) 1)
(check-error  (parse 'a) "Invalid datatype")
(check-error  (parse '(1 1)) "Invalid datatype")
(check-error  (parse '(1 1 1 1)) "Invalid datatype")
(check-expect (parse '(+ 1 1)) (make-add 1 1))
(check-expect (parse '(* 2 3)) (make-mul 2 3))
(check-expect (parse '(/ 1 1)) (make-div 1 1))

(define (parse s)
  (cond [(atom? s) (parse-atom s)]
        [else
         (parse-sl s)]))

; Atom -> Boolean
; predicates if it's an atom
(check-expect (atom? #true) #false)
(check-expect (atom? 1)     #true)
(check-expect (atom? "abc") #true)
(check-expect (atom? 'sb)   #true)

(define (atom? a)
  (or (number? a)
      (string? a)
      (symbol? a)))

; SL -> BSL-expr
(define (parse-sl s)
  (local ((define L (length s)))
    (cond [(< L 3) (error WRONG)]
          [(and (= L 3)
                (symbol? (first s)))
           (cond [(symbol=? (first s) '+)
                  (make-add (parse (second s))
                            (parse (third  s)))]
                 [(symbol=? (first s) '*)
                  (make-mul (parse (second s))
                            (parse (third  s)))]
                 [(symbol=? (first s) '/)
                  (make-div (parse (second s))
                            (parse (third  s)))]
                 [else
                  (error WRONG)])]
          [else
           (error WRONG)])))

; Atom -> BSL-expr
(define (parse-atom s)
  (cond [(number? s) s]
        [(string? s) (error WRONG)]
        [(symbol? s) (error WRONG)]))

;; Exercise 350

; What is unusual about the definition of this program with respect to the design recipe?
;
; Note One unusual aspect is that parse uses length on the list argument.
; Real parsers avoid length because it slows the functions down.

;; Exercise 351


;; =================
;; Functions:

; S-expr -> Number
; produces its value; otherwise, it signals an error
(check-error  (interpreter-expr "1") "Invalid datatype")
(check-expect (interpreter-expr 1) 1)
(check-expect (interpreter-expr '(+ 1 1)) 2)
(check-expect (interpreter-expr '(* 2 3)) 6)
(check-expect (interpreter-expr '(/ 8 2)) 4)

(define (interpreter-expr s)
  ((compose eval-expression parse) s))
