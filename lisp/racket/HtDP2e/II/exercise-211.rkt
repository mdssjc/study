;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-211) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 211

; List-of-strings -> List-of-strings
; pick out all those Strings that occur in the dictionary
(check-expect (in-dictionary (list "hello" "world")) (list "hello" "world"))
(check-expect (in-dictionary (list "a" "car")) '())

(define (in-dictionary los)
  (cond [(empty? los) '()]
        [(member? (first los) (list "hello" "world" "egg"))
         (cons (first los) (in-dictionary (rest los)))]
        [else (in-dictionary (rest los))]))
