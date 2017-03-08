;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-111) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 111

(define-struct vec [x y])
; A vec is
;   (make-vec PositiveNumber PositiveNumber)
; interpretation represents a velocity vector

; Any -> Vec
; creates a vec structure
; if x and y are positive numbers
(define (checked-make-vec x y)
  (cond [(and (> x 0)
              (> y 0)) (make-vec x y)]
        [else (error "make-vec: positive numbers expected")]))

(checked-make-vec 0 0)
