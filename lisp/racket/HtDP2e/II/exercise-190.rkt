;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-190) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 190

; List-of-1Strings -> List-of-1Strings
; produces the list of all prefixes
(check-expect (prefixes '()) '())
(check-expect (prefixes (list "a" "b" "c")) (list "a" "b" "c" "d"))

(define (prefixes lo1s)
  (cond [(empty? lo1s) '()]
        [else
         (append lo1s (list (int->string (add1 (string->int (first (reverse lo1s)))))))]))

; List-of-1Strings -> List-of-1Strings
; produces the list of all suffixes
(check-expect (suffixes '()) '())
(check-expect (suffixes (list "b" "c" "d")) (list "a" "b" "c" "d"))

(define (suffixes lo1s)
  (cond [(empty? lo1s) '()]
        [else
         (cons (int->string (sub1 (string->int (first lo1s)))) lo1s)]))
