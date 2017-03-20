;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-146) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 146

; A CTemperature is a Number greater than -273.

; A NEList-of-temperatures is one of: 
; - (cons CTemperature '())
; - (cons CTemperature NEList-of-temperatures)
; interpretation non-empty lists of Celsius temperatures
;
; NEList-of-temperatures is a subset of List-of-temperatures so
; the sum and how-manu functions work.


; NEList-of-temperatures -> Number
; computes the average temperature
(check-expect (average (cons 1 (cons 2 (cons 3 '())))) 2)

(define (average ne-l)
  (/ (sum ne-l)
     (how-many ne-l)))

; List-of-temperatures -> Number 
; adds up the temperatures on the given list
(define (sum alot)
  (cond [(empty? alot) 0]
        [else (+ (first alot) (sum (rest alot)))]))
 
; NEList-of-temperatures -> Number 
; counts the temperatures on the given list
(define (how-many alot)
  (cond [(empty? (rest alot)) 1]
        [else (+ (how-many (rest alot)) 1)]))
