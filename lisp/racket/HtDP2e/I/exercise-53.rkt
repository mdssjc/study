;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-53) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 53

(define HEIGHT 300) ; distances in pixels
(define YDELTA 3)

; A LR (short for launching rocket) is one of:
; – "resting"
; – NonnegativeNumber
; interpretation "resting" represents a grounded rocket
; a number denotes the height of a rocket in flight
(define LR1 "resting")
(define LR2 HEIGHT)
(define LR3 0)

; LR -> LR
; produces the next action in sequence of launching rocket
(check-expect (next LR1) HEIGHT)
(check-expect (next LR2) (- HEIGHT YDELTA))
(check-expect (next LR3) 0)

(define (next lr)
  (cond [(string? lr) HEIGHT]
        [(= lr HEIGHT) (- lr YDELTA)]
        [else 0]))
