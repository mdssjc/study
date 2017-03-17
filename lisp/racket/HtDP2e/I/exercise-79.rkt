;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-79) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 79

; A Color is one of: 
; — "white"
; — "yellow"
; — "orange"
; — "green"
; — "red"
; — "blue"
; — "black"
(define C1 "white")
(define C2 "yellow")
(define C3 "orange")
(define C4 "green")
(define C5 "red")
(define C6 "blue")
(define C7 "black")

; H is a Number between 0 and 100.
; interpretation represents a “happiness value”
(define H1 0)
(define H2 50)
(define H3 100)

(define-struct person [fstname lstname male?])
; A Person is a structure:
;   (make-person String String Boolean)
(define P1 (make-person "Joseph" "WGW" #true))

(define-struct dog [owner name age happiness])
; A Dog is a structure:
;   (make-dog Person String PositiveInteger H)
; interpretation owner means a Person
;                name means a string
;                age means a positive number
;                happiness means a H
(define D1 (make-dog P1 "Totó" 2 H3))

; A Weapon is one of: 
; — #false
; — Posn
; interpretation #false means the missile hasn't 
; been fired yet; a Posn means it is in flight
(define W1 #false)
(define W2 (make-posn 20 20))
