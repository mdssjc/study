;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-245) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 245


; Number Number Number -> Number
; test function #1
(define (fun1 a b c)
  (/ (/ a c) (/ b c)))

; Number Number Number -> Number
; test function #2
(define (fun2 a b c)
  (/ (* a c) (* b c)))

; Function Function -> Boolean
; determines whether the two produce the same results for 1.2, 3, and -5.775
(check-expect (function=at-1.2-3-and-5.775? fun1 fun2) #true)
(check-expect (function=at-1.2-3-and-5.775? fun1 +)    #false)
(check-expect (function=at-1.2-3-and-5.775? + fun2)    #false)

(define (function=at-1.2-3-and-5.775? f1 f2)
  (= (f1 1.2 3 -5.775)
     (f2 1.2 3 -5.775)))
