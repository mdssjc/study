;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-18) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 18

(define prefix "hello")
(define suffix "world")

(define (string-join s1 s2)
  (string-append s1 "_" s2))

(check-expect (string-join prefix suffix) "hello_world")
