;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-54) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 54

(check-expect (show "resting") "resting")
(check-expect (show -2) -2)
(check-expect (show 10) 10)

(define (show x)
  (cond
    [(string? x) x]
    [(<= -3 x -1) x]
    [(>= x 0) x]))

; (string=? "resting" x) Error when x is a number
