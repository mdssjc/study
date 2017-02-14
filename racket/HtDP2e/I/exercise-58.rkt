;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-58) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 58

; Constants
(define LOW-PRICE    1000)
(define LUXURY-PRICE 10000)

; A Price falls into one of three intervals: 
; — 0 through LOW-PRICE
; — LOW-PRICE through LUXURY-PRICE
; — LUXURY-PRICE and above.
; interpretation the price of an item
(define P1 0)
(define P2 (/ LOW-PRICE 2))
(define P3 LOW-PRICE)
(define P4 (/ LUXURY-PRICE 2))
(define P5 LUXURY-PRICE)
(define P6 (* LUXURY-PRICE 1.2))

; Price -> Number
; computes the amount of tax charged for p
(check-expect (sales-tax P1) 0)
(check-expect (sales-tax P2) 0)
(check-expect (sales-tax P3) (* 0.05 P3))
(check-expect (sales-tax P4) (* 0.05 P4))
(check-expect (sales-tax P5) (* 0.08 P5))
(check-expect (sales-tax P6) (* 0.08 P6))

(define (sales-tax p)
  (cond
    [(and (<= 0 p)
          (< p LOW-PRICE)) 0]
    [(and (<= LOW-PRICE p)
          (< p LUXURY-PRICE)) (* 0.05 p)]
    [(>= p LUXURY-PRICE) (* 0.08 p)]))
