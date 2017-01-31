;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-12) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 12

(define cube 3)

(define (cvolume s)
  (* s (sqr s)))

(define (csurface s)
  (* 6 (sqr s)))

(check-expect (cvolume cube)  (* 3 3 3))
(check-expect (csurface cube) (* 6 3 3))
