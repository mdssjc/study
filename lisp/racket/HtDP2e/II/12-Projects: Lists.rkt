;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname |12-Projects: Lists|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 12-Projects: Lists.rkt
;; II - Arbitrarily Large Data
;; 12 - Projects: Lists

(require 2htdp/image)
(require 2htdp/universe)
(require 2htdp/batch-io)


;; 12.1 - Real-World Data: Dictionaries

;; Exercise 195
;; Exercise 196
;; Exercise 197
;; Exercise 198


;; =================
;; Constants:

; On OS X: /usr/share/dict/words
; On LINUX: /usr/share/dict/words or /var/lib/dict/words
; On WINDOWS: borrow the word file from your Linux friend
(define LOCATION "/usr/share/dict/words")


;; =================
;; Data definitions:

; A Letter is one of the following 1Strings:
; - "a"
; - ...
; - "z"
; or, equivalently, a member? of this list:
(define LETTERS (explode "abcdefghijklmnopqrstuvwxyz"))

; A Dictionary is a List-of-strings.
(define AS-LIST (read-lines LOCATION))
(define DICTIONARY-EMPTY  '())
(define DICTIONARY-AS-LIST (list "alfa" "eco" "bravo" "erlang" "charlie" "zulu"))

; A LoL is one of:
; '()
; (cons Letter LoL)
; interpretation the list of Letters is a collection of Letter

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


;; =================
;; Functions:

; Dictionary Letter -> Number
; counts how many words in the given Dictionary d start wn Letter l
(check-expect (starts-with# DICTIONARY-EMPTY   "e") 0)
(check-expect (starts-with# DICTIONARY-AS-LIST "e") 2)
(check-expect (starts-with# DICTIONARY-AS-LIST "z") 1)

(define (starts-with# d l)
  (cond [(empty? d) 0]
        [else (+ (if (string=? (string-ith (first d) 0) l) 1 0)
                 (starts-with# (rest d) l))]))


(starts-with# AS-LIST "e")              ; 4006
(starts-with# AS-LIST "z")              ; 190

; Dictionary -> LoLC
; counts how often each letter is used as the first one of a word in the given dictionary
(check-expect (count-by-letter DICTIONARY-EMPTY)  '())
(check-expect (count-by-letter DICTIONARY-AS-LIST) (list
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
  (cond [(empty? d) '()]
        (else (count-by-letters LETTERS d))))

; LoL Dictionary -> LoLC
; reports how often the given letters occur as first ones in the dictionary
(check-expect (count-by-letters LETTERS DICTIONARY-EMPTY) (list
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
(check-expect (count-by-letters LETTERS DICTIONARY-AS-LIST) (list
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
        [else (cons (list (first lol) (starts-with# d (first lol)))
                    (count-by-letters (rest lol) d))]))

; Dictionary -> Letter-Count
; produces the Letter-Count for the letter that is occurs most often
; as the first one in the given Dictionary
(check-expect (most-frequent DICTIONARY-EMPTY)  '())
(check-expect (most-frequent DICTIONARY-AS-LIST) (list "e" 2))

(define (most-frequent d)
  (maximum-count.v1 (count-by-letter d) '()))

; LoLC Letter-Count -> Letter-Count
; picks the pair with the maximum count
(check-expect (maximum-count.v1 (count-by-letter DICTIONARY-EMPTY)   '()) '())
(check-expect (maximum-count.v1 (count-by-letter DICTIONARY-AS-LIST) '())  (list "e" 2))
(check-expect (maximum-count.v2 (count-by-letter DICTIONARY-EMPTY)   '()) '())
(check-expect (maximum-count.v2 (count-by-letter DICTIONARY-AS-LIST) '())  (list "e" 2))

(define (maximum-count.v1 lolc max)
  (cond [(empty? lolc) max]
        [(empty? max) (maximum-count.v1 (rest lolc)
                                        (first lolc))]
        [else (maximum-count.v1 (rest lolc)
                                (cond [(> (second (first lolc)) (second max)) (first lolc)]
                                      [else max]))]))

(define (maximum-count.v2 lolc max)
  (cond [(empty? lolc) max]
        [else (first (sort lolc))]))

; LoLC -> LoLC
; produces a sorted version of l
(check-expect (sort '()) '())
(check-expect (sort (list (list "a" 0) (list "b" 2) (list "c" 1)))
              (list (list "b" 2) (list "c" 1) (list "a" 0)))

(define (sort l)
  (cond [(empty? l) '()]
        [(cons? l)   (insert (first l)
                             (sort (rest l)))]))

; Letter-Count LoLC -> LoLC
; inserts x into the sorted list l
(check-expect (insert (list "a" 0) '())
              (list (list "a" 0)))
(check-expect (insert (list "a" 0) (list (list "b" 2)))
              (list (list "b" 2) (list "a" 0)))
(check-expect (insert (list "b" 2) (list (list "a" 0)))
              (list (list "b" 2) (list "a" 0)))
(check-expect (insert (list "c" 1) (list (list "b" 2) (list "a" 0)))
              (list (list "b" 2) (list "c" 1) (list "a" 0)))

(define (insert x l)
  (cond [(empty? l) (cons x '())]
        [else (cond [(>= (second x) (second (first l))) (cons x l)]
                    [else (cons (first l)
                                (insert x (rest l)))])]))

; Dictionary -> LoD
; produces a list of Dictionarys, one per Letter
(check-expect (words-by-first-letter DICTIONARY-EMPTY)  '())
(check-expect (words-by-first-letter DICTIONARY-AS-LIST) (list (list "alfa")
                                                               (list "bravo")
                                                               (list "charlie")
                                                               (list "eco" "erlang")
                                                               (list "zulu")))

(define (words-by-first-letter d)
  (words-by* LETTERS d))

; LoL Dictionary -> LoD
; produces a list of Dictionarys with all the words in the dictionary d for each letter lol
(check-expect (words-by* '()     DICTIONARY-AS-LIST) '())
(check-expect (words-by* '()     DICTIONARY-EMPTY)   '())
(check-expect (words-by* LETTERS DICTIONARY-EMPTY)   '())
(check-expect (words-by* LETTERS DICTIONARY-AS-LIST)  (list (list "alfa")
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
(check-expect (words-by ""  DICTIONARY-EMPTY)   '())
(check-expect (words-by "e" DICTIONARY-EMPTY)   '())
(check-expect (words-by ""  DICTIONARY-AS-LIST) '())
(check-expect (words-by "d" DICTIONARY-AS-LIST) '())
(check-expect (words-by "e" DICTIONARY-AS-LIST)  (list "eco" "erlang"))

(define (words-by l d)
  (cond [(string=? l "") '()]
        [(empty? d) '()]
        [else (if (string=? (substring (first d) 0 1) l)
                  (cons (first d) (words-by l (rest d)))
                  (words-by l (rest d)))]))

; Dictionary -> Letter-Count
; produces the Letter-Count for the letter that is occurs most often
; as the first one in the given Dictionary
(check-expect (most-frequent.v2 DICTIONARY-EMPTY)  '())
(check-expect (most-frequent.v2 DICTIONARY-AS-LIST) (list "e" 2))
(check-expect (most-frequent    DICTIONARY-AS-LIST)
              (most-frequent.v2 DICTIONARY-AS-LIST))

(define (most-frequent.v2 d)
  (maximum-count.v3 (words-by-first-letter d) '()))

; LoD Letter-Count -> Letter-Count
; picks the pair with the maximum count
(check-expect (maximum-count.v3 (words-by-first-letter DICTIONARY-EMPTY)   '()) '())
(check-expect (maximum-count.v3 (words-by-first-letter DICTIONARY-AS-LIST) '())  (list "e" 2))

(define (maximum-count.v3 lolc max)
  (cond [(empty? lolc) max]
        [(empty? max) (maximum-count.v3 (rest lolc)
                                        (list (substring (first (first lolc)) 0 1)
                                                          (length (first lolc))))]
        [else (maximum-count.v3 (rest lolc)
                                (if (> (length (first lolc)) (second max))
                                    (list (substring (first (first lolc)) 0 1)
                                          (length (first lolc)))
                                    max))]))
