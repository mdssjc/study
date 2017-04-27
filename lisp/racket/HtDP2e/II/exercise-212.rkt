;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-212) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 212

; A Word is one of:
; - '() or
; - (cons 1String Word)
; interpretation a String as a list of 1Strings (letters)

; A List-of-words is one of:
; - '() or
; - (cons Word List-of-words)
; interpretation a collection of Word values


; Word -> List-of-words
; creates all rearrangements of the letters in w
(check-expect (arrangements '()) '())
(check-expect (arrangements (list "d" "e")) (list (list "d" "e")
                                                  (list "e" "d")))

(define (arrangements w) '())
