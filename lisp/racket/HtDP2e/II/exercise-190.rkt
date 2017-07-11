;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-190) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 190

; List-of-1Strings -> List-of-List-of-1Strings
; produces the list of all prefixes
(check-expect (prefixes '()) '())
(check-expect (prefixes (list "a")) (list (list "a")))
(check-expect (prefixes (list "a" "b")) (list (list "a" "b") (list "a")))
(check-expect (prefixes (list "a" "b" "c")) (list (list "a" "b" "c") (list "a" "b") (list "a")))

(define (prefixes lo1s)
  (cond [(empty? lo1s) '()]
        [else
         (cons lo1s
               (prefixes (reverse (rest (reverse lo1s)))))]))

; List-of-1Strings -> List-of-List-of-1Strings
; produces the list of all suffixes
(check-expect (suffixes '()) '())
(check-expect (suffixes (list "a")) (list (list "a")))
(check-expect (suffixes (list "a" "b")) (list (list "a" "b") (list "b")))
(check-expect (suffixes (list "a" "b" "c")) (list (list "a" "b" "c") (list "b" "c") (list "c")))

(define (suffixes lo1s)
  (cond [(empty? lo1s) '()]
        [else
         (cons lo1s
               (suffixes (rest lo1s)))]))
