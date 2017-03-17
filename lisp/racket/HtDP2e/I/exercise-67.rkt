;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-67) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 67

(define SPEED 3)
(define-struct balld [location direction])
(make-balld 10 "up")

(make-balld 5 "left")
(make-balld 2 "right")
(make-balld 8 "down")
