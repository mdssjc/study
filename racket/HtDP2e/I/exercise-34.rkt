;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-34) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 34

;; String -> String
;; extracts the first character from a non-empty string
(check-expect (string-first "Hello") "H")
(check-expect (string-first "apple") "a")

(define (string-first s)
  (substring s 0 1))
