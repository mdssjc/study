;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-267) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 267


(define D1 (list 1.00 5.00 12.34))
(define F1 (list 0 10 20 30 40 50))
(define P1 (list (make-posn 1 2) (make-posn 5 3) (make-posn 9 6)))


; [List-of Number] -> [List-of Number]
; converts a list of US$ amounts into a list of € amounts
; based on an exchange rate of €1.22 per US$
(check-expect (convert-euro empty) empty)
(check-expect (convert-euro D1) (list (* 1.00 1.22) (* 5.00 1.22) (* 12.34 1.22)))

(define (convert-euro lon)
  (local ((define (exchange-rate n)
            (* n 1.22)))
    (map exchange-rate lon)))

; [List-of Number] -> [List-of Number]
; converts a list of Fahrenheit measurements to a list of Celsius measurements
(check-expect (convertFC empty) empty)
(check-within (convertFC F1) (list -17.78 -12.22 -6.67 -1.11 4.44 10) 0.01)

(define (convertFC lon)
  (local ((define (fahrenheit->celsius f)
            (/ (- f 32) 1.8)))
    (map fahrenheit->celsius lon)))

; [List-of Posn] -> [List-of [List-of Number]]
; translates a list of Posns into a list of list of pairs of numbers
(check-expect (translate empty) empty)
(check-expect (translate P1) (list (list 1 2) (list 5 3) (list 9 6)))

(define (translate lop)
  (local ((define (posn->list p)
            (list (posn-x p) (posn-y p))))
    (map posn->list lop)))
