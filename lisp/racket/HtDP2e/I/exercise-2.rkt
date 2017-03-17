;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-2) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 2

(define prefix "hello")
(define suffix "world")

(define (glue prefix suffix)
  (string-append prefix "_" suffix))

(check-expect (glue prefix suffix) "hello_world")
