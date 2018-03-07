;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Intermezzo 1|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Intermezzo 1.rkt
;; Intermezzo 1: Beginning Student Language



;; BSL Vocabulary



;; BSL Grammar

;; Exercise 116

; x
; it's a variable

; (= y z)
; it's a primitive application

; (= (= y z) 0)
; it's a primitive application

;; Exercise 117

; (3 + 4)
; syntax error, the correct is (+ 3 4)

; number?
; syntax error, the correct is (number? x)

; (x)
; syntax error, the correct is x

;; Exercise 118

; (define (f x) x)
; def -> variable variable
;   variable (inner)

; (define (f x) y)
; def -> variable variable
;   variable (outer)

; (define (f x y) 3)
; def -> variable variable variable
;   value

;; Exercise 119

; (define (f "x") x)
; a value in place of the variable

; (define (f x y z) (x))
; a variable called as function

;; Exercise 120

; (x)
; illegal - variable

; (+ 1 (not x))
; illegal - sum of integer with boolean

; (+ 1 2 3)
; legal - expr -> (primitive value value value)



;; BSL Meaning

;; Exercise 121

; 1.
(+ (* (/ 12 8) 2/3)
   (- 20 (sqrt 4)))
(+ (* 3/2 2/3)
   (- 20 (sqrt 4)))
(+ 1 (- 20 (sqrt 4)))
(+ 1 (- 20 2))
(+ 1 18)
19

; 2.
(cond
  [(= 0 0) #false]
  [(> 0 1) (string=? "a" "a")]
  [else (= (/  1 0) 9)])
(cond
  [#true #false]
  [(> 0 1) (string=? "a" "a")]
  [else (= (/  1 0) 9)])
#false

; 3.
(cond
  [(= 2 0) #false]
  [(> 2 1) (string=? "a" "a")]
  [else (= (/  1 2) 9)])
(cond
  [#false #false]
  [(> 2 1) (string=? "a" "a")]
  [else (= (/  1 2) 9)])
(cond
 ((> 2 1)
  (string=? "a" "a"))
 (else (= (/ 1 2) 9)))
(cond
  [#true (string=? "a" "a")]
  [else (= (/  1 2) 9)])
(string=? "a" "a")
#true

;; Exercise 122

(define (f x y)
  (+ (* 3 x) (* y y)))

; 1.
(+ (f 1 2) (f 2 1))
(+ (+ (* 3 1) (* 2 2)) (f 2 1))
(+ (+ 3 (* 2 2)) (f 2 1))
(+ (+ 3 4) (f 2 1))
(+ 7 (f 2 1))
(+ 7 (+ (* 3 2) (* 1 1)))
(+ 7 (+ 6 (* 1 1)))
(+ 7 (+ 6 1))
(+ 7 7)
14

; 2.
(f 1 (* 2 3))
(f 1 6)
(+ (* 3 1) (* 6 6))
(+ 3 (* 6 6))
(+ 3 36)
39

; 3.
(f (f 1 (* 2 3)) 19)
(f (f 1 6) 19)
(f (+ (* 3 1) (* 6 6)) 19)
(f (+ 3 (* 6 6)) 19)
(f (+ 3 36) 19)
(f 39 19)
(+ (* 3 39) (* 19 19))
(+ 117 (* 19 19))
(+ 117 361)
478



;; Meaning and Computing



;; BSL Errors



;; Boolean Expressions

;; Exercise 123

(define x 5)
(define y 5)

(if (= x y) x y)
(cond [(= x y) x]
      [else y])
