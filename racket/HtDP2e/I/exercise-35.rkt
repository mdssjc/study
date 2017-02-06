;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-35) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 35

;; String -> String
;; extracts the last character from a non-empty string
(check-expect (string-last "Hello") "o")
(check-expect (string-last "apple") "e")

(define (string-last s)
  (substring s (- (string-length s) 1)))
