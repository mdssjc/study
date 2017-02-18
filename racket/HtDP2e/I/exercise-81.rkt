;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-81) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 81

(define-struct point-time (hours minutes seconds))
; Point-Time is a structure:
;  (make-point-time Number[0..23] Number[0..59] Number[0..59])
; interpretation hours means a number between 0 and 23
;                minutes means a number between 0 and 59
;                seconds means a number between 0 and 59


; Point-Time -> Number
; produces the number of seconds that have passed since midnight
(check-expect (time->seconds (make-point-time 12 30 2)) 45002)

(define (time->seconds r)
  (+ (* (point-time-hours   r) 60 60)
     (* (point-time-minutes r) 60)
     (point-time-seconds    r)))
