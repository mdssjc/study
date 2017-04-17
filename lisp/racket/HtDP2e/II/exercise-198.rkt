;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-198) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 198

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

; A LoLC is one of:
; '()
; (cons Letter-Count LoLC)
; interpretation the list of Letter-Counts is a collection of Letter-Count

; A LoD is one of:
; - '()
; - (cons String LoD)
; interpretation the list of Dictionary is a collection of Dictionary


; Dictionary -> LoD
; produces a list of Dictionarys, one per Letter
(check-expect (words-by-first-letter '()) '())
(check-expect (words-by-first-letter DICTIONARY-AS-LIST) (list (list "alfa")
                                                               (list "bravo")
                                                               (list "charlie")
                                                               (list "eco" "erlang")
                                                               (list "zulu")))

(define (words-by-first-letter d)
  (words-by* LETTERS d))

; LoL Dictionary -> LoD
; produces a list of Dictionarys with all the words in the dictionary d for each letter lol
(check-expect (words-by* '() DICTIONARY-AS-LIST) '())
(check-expect (words-by* '() '()) '())
(check-expect (words-by* LETTERS '()) '())
(check-expect (words-by* LETTERS DICTIONARY-AS-LIST) (list (list "alfa")
                                                           (list "bravo")
                                                           (list "charlie")
                                                           (list "eco" "erlang")
                                                           (list "zulu")))

(define (words-by* lol d)
  (cond [(empty? lol) '()]
        [else (if (empty? (words-by (first lol) d))
                  (words-by* (rest lol) d)
                  (cons (words-by (first lol) d)
                        (words-by* (rest lol) d)))]))

; Letter Dictionary -> Dictionary
; produces a dictionary with all the words in the dictionary d with the letter l
(check-expect (words-by "" '()) '())
(check-expect (words-by "e" '()) '())
(check-expect (words-by "" DICTIONARY-AS-LIST) '())
(check-expect (words-by "d" DICTIONARY-AS-LIST) '())
(check-expect (words-by "e" DICTIONARY-AS-LIST) (list "eco" "erlang"))

(define (words-by l d)
  (cond [(string=? l "") '()]
        [(empty? d) '()]
        [else (if (string=? (substring (first d) 0 1) l)
                  (cons (first d) (words-by l (rest d)))
                  (words-by l (rest d)))]))

; ---

(check-expect (most-frequent DICTIONARY-AS-LIST) (most-frequent.v2 DICTIONARY-AS-LIST))

; Dictionary -> Letter-Count
; produces the Letter-Count for the letter that is occurs most often
; as the first one in the given Dictionary
(check-expect (most-frequent.v2 '()) '())
(check-expect (most-frequent.v2 DICTIONARY-AS-LIST) (list "e" 2))

(define (most-frequent.v2 d)
  (maximum-count.v2 (words-by-first-letter d) '()))

; LoD Letter-Count -> Letter-Count
; picks the pair with the maximum count
(check-expect (maximum-count.v2 (words-by-first-letter '()) '()) '())
(check-expect (maximum-count.v2 (words-by-first-letter DICTIONARY-AS-LIST) '()) (list "e" 2))

(define (maximum-count.v2 lolc max)
  (cond [(empty? lolc) max]
        [(empty? max) (maximum-count.v2 (rest lolc)
                                        (list (substring (first (first lolc)) 0 1)
                                                          (length (first lolc))))]
        [else (maximum-count.v2 (rest lolc)
                                (if (> (length (first lolc)) (second max))
                                    (list (substring (first (first lolc)) 0 1)
                                          (length (first lolc)))
                                    max))]))

; Dictionary -> Letter-Count
; produces the Letter-Count for the letter that is occurs most often
; as the first one in the given Dictionary
(check-expect (most-frequent '()) '())
(check-expect (most-frequent DICTIONARY-AS-LIST) (list "e" 2))

(define (most-frequent d)
  (maximum-count (count-by-letter d) '()))

; LoLC Letter-Count -> Letter-Count
; picks the pair with the maximum count
(check-expect (maximum-count (count-by-letter '()) '()) '())
(check-expect (maximum-count (count-by-letter DICTIONARY-AS-LIST) '()) (list "e" 2))

(define (maximum-count lolc max)
  (cond [(empty? lolc) max]
        [(empty? max) (maximum-count (rest lolc) (first lolc))]
        [else  (maximum-count (rest lolc)
                              (if (> (second (first lolc)) (second max))
                                  (first lolc)
                                  max))]))

; Dictionary -> LoLC
; counts how often each letter is used as the first one of a word in the given dictionary
(check-expect (count-by-letter '()) '())
(check-expect (count-by-letter DICTIONARY-AS-LIST)
              (list
               (list "a" 1)
               (list "b" 1)
               (list "c" 1)
               (list "d" 0)
               (list "e" 2)
               (list "f" 0)
               (list "g" 0)
               (list "h" 0)
               (list "i" 0)
               (list "j" 0)
               (list "k" 0)
               (list "l" 0)
               (list "m" 0)
               (list "n" 0)
               (list "o" 0)
               (list "p" 0)
               (list "q" 0)
               (list "r" 0)
               (list "s" 0)
               (list "t" 0)
               (list "u" 0)
               (list "v" 0)
               (list "w" 0)
               (list "x" 0)
               (list "y" 0)
               (list "z" 1)))

(define (count-by-letter d)
  (if (empty? d)
      '()
      (count-by-letters LETTERS d)))

; LoL Dictionary -> LoLC
; reports how often the given letters occur as first ones in the dictionary
(check-expect (count-by-letters LETTERS '())
              (list
               (list "a" 0)
               (list "b" 0)
               (list "c" 0)
               (list "d" 0)
               (list "e" 0)
               (list "f" 0)
               (list "g" 0)
               (list "h" 0)
               (list "i" 0)
               (list "j" 0)
               (list "k" 0)
               (list "l" 0)
               (list "m" 0)
               (list "n" 0)
               (list "o" 0)
               (list "p" 0)
               (list "q" 0)
               (list "r" 0)
               (list "s" 0)
               (list "t" 0)
               (list "u" 0)
               (list "v" 0)
               (list "w" 0)
               (list "x" 0)
               (list "y" 0)
               (list "z" 0)))
(check-expect (count-by-letters LETTERS DICTIONARY-AS-LIST)
              (list
               (list "a" 1)
               (list "b" 1)
               (list "c" 1)
               (list "d" 0)
               (list "e" 2)
               (list "f" 0)
               (list "g" 0)
               (list "h" 0)
               (list "i" 0)
               (list "j" 0)
               (list "k" 0)
               (list "l" 0)
               (list "m" 0)
               (list "n" 0)
               (list "o" 0)
               (list "p" 0)
               (list "q" 0)
               (list "r" 0)
               (list "s" 0)
               (list "t" 0)
               (list "u" 0)
               (list "v" 0)
               (list "w" 0)
               (list "x" 0)
               (list "y" 0)
               (list "z" 1)))

(define (count-by-letters lol d)
  (cond [(empty? lol) '()]
        [else (cons (list (first lol) (starts-with# (first lol) d))
                    (count-by-letters (rest lol) d))]))

; Letter Dictionary -> Number
; counts how many words in the given Dictionary d start with the given Letter l
(check-expect (starts-with# "e" '()) 0)
(check-expect (starts-with# "e" DICTIONARY-AS-LIST) 2)
(check-expect (starts-with# "z" DICTIONARY-AS-LIST) 1)

(define (starts-with# l d)
  (cond [(empty? d) 0]
        [else (+ (if (string=? (substring (first d) 0 1) l) 1 0)
                 (starts-with# l (rest d)))]))
