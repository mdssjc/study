;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-11) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 11

(define (distance x y)
  (sqrt (+ (sqr x) (sqr y))))

(check-expect (distance 3 4) 5)
(check-expect (distance 12 5) 13)
