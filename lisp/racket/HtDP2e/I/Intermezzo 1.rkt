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
