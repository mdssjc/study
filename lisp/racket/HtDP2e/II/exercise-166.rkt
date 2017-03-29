;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-166) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 166

(define-struct work [employee number rate hours])
; A (piece of) Work is a structure:
;   (make-work String Number Number Number)
; interpretation (make-work n num r h) combines the name
; with the number num, pay rate r and the number of hours h

(define-struct pay-check (number name amount))
; A Pay-check is a structure:
;  (make-pay-check Number String Number)
; interpretation (make-pay-check num n a) contains
; the employee's number num, name n and an amount a

; A Low (short for list of works) is one of:
; - '()
; - (cons Work Low)
; interpretation an instance of Low represents the
; hours worked for a number of employees

; A Lop is one of:
; - '()
; - (cons Pay-check Lop)
; interpretation an instance of Lop represents the
; employee's name and an amount


; Low -> Lop
; consumes a list of work records and computes a list of pay checks
(check-expect
 (wage*.v4 (cons (make-work "Robby" 1 11.95 39) '()))
 (cons (make-pay-check 1 "Robby" (* 11.95 39)) '()))

(define (wage*.v4 an-low)
  (cond
    [(empty? an-low) '()]
    [(cons? an-low) (cons (make-pay-check (work-number (first an-low))
                                          (work-employee (first an-low))
                                          (wage.v2 (first an-low)))
                          (wage*.v4 (rest an-low)))]))

; Work -> Number
; computes the wage for the given work record w
(define (wage.v2 w)
  (* (work-rate w) (work-hours w)))
