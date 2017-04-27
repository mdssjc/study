;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-209) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 209

; A Word is one of:
; - '() or
; - (cons 1String Word)
; interpretation a String as a list of 1Strings (letters)


; String -> Word
; convert s to the chosen word representation
(check-expect (string->word "") '())
(check-expect (string->word "hello") (list "h" "e" "l" "l" "o"))

(define (string->word s)
  (explode s))
 
; Word -> String
; convert w to a string
(check-expect (word->string '()) "")
(check-expect (word->string (list "h" "e" "l" "l" "o")) "hello")

(define (word->string w)
  (implode w))
