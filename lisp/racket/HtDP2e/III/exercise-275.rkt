;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-275) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 275


(define DICTIONARY-AS-LIST (list "alfa" "eco" "bravo" "erlang" "charlie" "zulu"))


; A Letter is one of the following 1Strings:
; - "a"
; - ...
; - "z"
; or, equivalently, a member? of this list:

; A LoL is one of:
; '()
; (cons Letter LoL)
; interpretation the list of Letters is a collection of Letter
(define LETTERS (explode "abcdefghijklmnopqrstuvwxyz"))

; A Letter-Count is one of:
; '()
; '(list Letter Number)
; interpretation the Letter-Count is a piece of data that combines letter and count

; A LoD is one of:
; - '()
; - (cons String LoD)
; interpretation the list of Dictionary is a collection of Dictionary


; Dictionary -> Letter-Count
; produces the Letter-Count for the letter that is occurs most often
; as the first one in the given Dictionary
(check-expect (most-frequent empty) empty)
(check-expect (most-frequent DICTIONARY-AS-LIST) (list "e" 2))

(define (most-frequent d)
  (local ((define (count-by-letter w)
            (list (string-ith (first w) 0) (length w)))
          (define (most it last)
            (cond [(empty? last) it]
                  [else
                   (if (> (second it) (second last)) it last)])))
    (foldr most empty (map count-by-letter (words-by-first-letter d)))))

; Dictionary -> LoD
; produces a list of Dictionarys, one per Letter
(check-expect (words-by-first-letter empty) empty)
(check-expect (words-by-first-letter DICTIONARY-AS-LIST) (list (list "alfa")
                                                               (list "bravo")
                                                               (list "charlie")
                                                               (list "eco" "erlang")
                                                               (list "zulu")))

(define (words-by-first-letter d)
  (local ((define (merge-by-words l)
            (cond [(empty? l) empty]
                  [else
                   (local ((define (start-with? s)
                             (string=? (first l) (string-ith s 0)))
                           (define words (filter start-with? d)))
                     (if (empty? words)
                         (merge-by-words (rest l))
                         (cons words (merge-by-words (rest l)))))])))
    (merge-by-words LETTERS)))
