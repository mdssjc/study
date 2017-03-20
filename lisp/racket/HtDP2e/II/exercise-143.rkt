;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-143) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 143

; A CTemperature is a Number greater than -273.

; A List-of-temperatures is one of:
; - '()
; - (cons CTemperature List-of-temperatures)


; List-of-temperatures -> Number
; computes the average temperature
(check-expect (average (cons 1 (cons 2 (cons 3 '())))) 2)
(check-error  (average '()) "Invalid input (empty list)")

(define (average alot)
  (cond [(checked-average alot) (/ (sum alot) (how-many alot))]))

; List-of-temperatures -> Boolean
; checks if the list is valid for the average
(define (checked-average alot)
  (if (empty? alot)
      (error "Invalid input (empty list)")
      #true))

; List-of-temperatures -> Number 
; adds up the temperatures on the given list
(define (sum alot)
  (cond [(empty? alot) 0]
        [else (+ (first alot) (sum (rest alot)))]))
 
; List-of-temperatures -> Number 
; counts the temperatures on the given list
(define (how-many alot)
  (cond [(empty? alot) 0]
        [else (+ (how-many (rest alot)) 1)]))
