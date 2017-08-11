;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-309) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 309

(require 2htdp/abstraction)


; [List-of [List-of String]] -> [List-of Number]
; determines the number of words on each line
(check-expect (words-on-line empty) 0)
(check-expect (words-on-line (list (list "hello" "hello"))) 2)

(define (words-on-line lls)
  (match lls
    ['() 0]
    [(cons line rest) (+ (length line)
                         (words-on-line rest))]))
