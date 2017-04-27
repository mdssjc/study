;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-210) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 210

; A Word is one of:
; - '() or
; - (cons 1String Word)
; interpretation a String as a list of 1Strings (letters)


; List-of-words -> List-of-strings
; turn all Words in low into Strings
(check-expect (words->strings '()) '())
(check-expect (words->strings (list (explode "hello")
                                    (explode "world"))) (list "hello" "world"))

(define (words->strings low)
  (cond [(empty? low) '()]
        [else (cons (word->string (first low))
                    (words->strings (rest low)))]))

; Word -> String
; convert w to a string
(check-expect (word->string '()) "")
(check-expect (word->string (list "h" "e" "l" "l" "o")) "hello")

(define (word->string w)
  (implode w))
