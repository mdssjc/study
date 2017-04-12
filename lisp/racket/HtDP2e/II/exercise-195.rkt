;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-195) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 195

(define DICTIONARY-AS-LIST (list "alfa" "eco" "bravo" "erlang" "charlie" "zulu"))

; A Letter is one of the following 1Strings: 
; - "a"
; - ... 
; - "z"
; or, equivalently, a member? of this list: 
(define LETTERS (explode "abcdefghijklmnopqrstuvwxyz"))


; Letter Dictionary -> Number
; counts how many words in the given Dictionary d start with the given Letter l
(check-expect (starts-with# "e" '()) 0)
(check-expect (starts-with# "e" DICTIONARY-AS-LIST) 2)
(check-expect (starts-with# "z" DICTIONARY-AS-LIST) 1)

(define (starts-with# l d)
  (cond [(empty? d) 0]
        [else (+ (if (string=? (substring (first d) 0 1) l) 1 0)
                 (starts-with# l (rest d)))]))
