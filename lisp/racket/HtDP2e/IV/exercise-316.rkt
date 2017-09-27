;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-316) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 316


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


;; ====================
;; Functions:

; Atom -> Boolean
; predicates if it's an atom
(check-expect (atom? #true) #false)
(check-expect (atom? 1) #true)
(check-expect (atom? "abc") #true)
(check-expect (atom? 'sb) #true)

(define (atom? a)
  (or (number? a) (string? a) (symbol? a)))
