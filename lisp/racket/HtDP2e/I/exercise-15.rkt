;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-15) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 15

(define sunny  #false)
(define friday #true)

(define (==> b1 b2)
  (or (not b1) b2))

(check-expect (==> #false #false) #true)
(check-expect (==> #false #true)  #true)
(check-expect (==> #true  #false) #false)
(check-expect (==> #true  #true)  #true)
(check-expect (==> sunny friday)  #true)
