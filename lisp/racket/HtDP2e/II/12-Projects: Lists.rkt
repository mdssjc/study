;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname |12-Projects: Lists|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 12-Projects: Lists.rkt
;; II - Arbitrarily Large Data
;; 12 - Projects: Lists

(require 2htdp/image)
(require 2htdp/universe)
(require 2htdp/batch-io)
(require 2htdp/itunes)


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
        [else
         (maximum-count.v1 (rest lolc)
                           (cond [(or (empty? max)
                                      (> (second (first lolc)) (second max)))
                                  (first lolc)]
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
        [else (insert (first l)
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
        [else
         (cond [(>= (second x)
                    (second (first l)))
                (cons x l)]
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
        [else
         (cond [(empty? (words-by (first lol) d))
                (words-by* (rest lol) d)]
               [else (cons (words-by (first lol) d)
                           (words-by* (rest lol) d))])]))

; Letter Dictionary -> Dictionary
; produces a dictionary with all the words in the dictionary d with the letter l
(check-expect (words-by ""  DICTIONARY-EMPTY)   '())
(check-expect (words-by "e" DICTIONARY-EMPTY)   '())
(check-expect (words-by ""  DICTIONARY-AS-LIST) '())
(check-expect (words-by "d" DICTIONARY-AS-LIST) '())
(check-expect (words-by "e" DICTIONARY-AS-LIST)  (list "eco" "erlang"))

(define (words-by l d)
  (cond [(or (string=? l "")
             (empty? d))
         '()]
        [else
         (cond [(string=? (string-ith (first d) 0) l)
                (cons (first d)
                      (words-by l (rest d)))]
               [else (words-by l (rest d))])]))

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
        [else
         (maximum-count.v3 (rest lolc)
                           (cond [(or (empty? max)
                                      (> (length (first lolc)) (second max)))
                                  (list (string-ith (first (first lolc)) 0)
                                        (length (first lolc)))]
                                 [else max]))]))



;; 12.2 - Real-World Data: iTunes

;; Exercise 199
;; Exercise 200
;; Exercise 201
;; Exercise 202
;; Exercise 203
;; Exercise 204


;; =================
;; Constants:

; modify the following to use your chosen name
(define ITUNES-LOCATION "itunes.xml")

; LTracks
; (define itunes-tracks (read-itunes-as-tracks ITUNES-LOCATION))


;; =================
;; Data definitions:

; Date
(define DATE1 (create-date 1 2 3 4 5 6))
(define DATE2 (create-date 1 2 3 4 5 5))
(define DATE3 (create-date 6 5 4 3 2 1))
(define DATE4 (create-date 1 2 3 "four" 5 6))

; Track
(define TRACK1 (create-track "title A" "two" "three" 4 5 DATE1 7 DATE1))
(define TRACK2 (create-track "title B" "two" "three" 4 5 DATE3 7 DATE3))
(define TRACK3 (create-track "title C" "two" "new-three" 4 5 DATE3 7 DATE3))
(define TRACK4 (create-track "title D" "two" "new-three" 4 5 DATE3 7 DATE3))
(define TRACK5 (create-track "title A" "two" "three" 4 5 "a date" 7 "another date"))

; LTrack
(define LTRACK1 '())
(define LTRACK2 (list TRACK1))
(define LTRACK3 (list TRACK1 TRACK2))
(define LTRACK4 (list TRACK1 TRACK2 TRACK1))
(define LTRACK5 (list TRACK4 TRACK2 TRACK3 TRACK1))

; A List-of-strings is one of:
; - '()
; - (cons String List-of-strings)
; interpretation a list of String values

; A LoLT is one of:
; - '()
; - (cons LTracks LoLT)
; interpretation a collection of LTracks


;; =================
;; Functions:

; LTracks -> Number
; produces the total amount of play time
(check-expect (total-time LTRACK1) 0)
(check-expect (total-time LTRACK2) (+ 4 (/ 5 60) (/ 6 60 60)))
(check-expect (total-time LTRACK3) (+ 4 (/ 5 60) (/ 6 60 60)
                                      3 (/ 2 60) (/ 1 60 60)))

(define (total-time lt)
  (cond [(empty? lt) 0]
        [else
         (+ (date-hour (track-played (first lt)))
            (/ (date-minute (track-played (first lt))) 60)
            (/ (date-second (track-played (first lt))) 60 60)
            (total-time (rest lt)))]))

; LTracks -> List-of-strings
; produces the list of album titles
(check-expect (select-all-album-titles LTRACK1) '())
(check-expect (select-all-album-titles LTRACK2) (list "title A"))
(check-expect (select-all-album-titles LTRACK3) (list "title A" "title B"))
(check-expect (select-all-album-titles LTRACK4) (list "title A" "title B" "title A"))

(define (select-all-album-titles lt)
  (cond [(empty? lt) '()]
        [else (cons (track-name (first lt))
                    (select-all-album-titles (rest lt)))]))

; List-of-strings -> String
; constructs one that contains every String from the given list exactly once
(check-expect (create-set (select-all-album-titles LTRACK1)) "")
(check-expect (create-set (select-all-album-titles LTRACK2)) "title A")
(check-expect (create-set (select-all-album-titles LTRACK3)) "title A title B")
(check-expect (create-set (select-all-album-titles LTRACK4)) "title A title B")

(define (create-set los)
  (cond [(empty? los) ""]
        [(empty? (rest los)) (first los)]
        [else (string-append (first los) " "
                             (create-set (remove-all (first los) (rest los))))]))

; LTracks -> List-of-strings
; produces a list of unique album titles
(check-expect (select-album-titles/unique LTRACK1) '())
(check-expect (select-album-titles/unique LTRACK2) (list "title A"))
(check-expect (select-album-titles/unique LTRACK3) (list "title A" "title B"))
(check-expect (select-album-titles/unique LTRACK4) (list "title A" "title B"))

(define (select-album-titles/unique lt)
  (cond [(empty? lt) '()]
        [else (cons (track-name (first lt))
                    (select-album-titles/unique (remove-all (first lt) (rest lt))))]))

; String String LTracks -> LTracks
; extracts from the latter the list of tracks that belong to the given album
(check-expect (select-album "title A"  "three" LTRACK1) '())
(check-expect (select-album "title A"  "three" LTRACK3) (list TRACK1))
(check-expect (select-album "title B"  "three" LTRACK3) (list TRACK2))
(check-expect (select-album "title A"  "three" LTRACK4) (list TRACK1 TRACK1))
(check-expect (select-album "title B"  "three" LTRACK4) (list TRACK2))
(check-expect (select-album "title AB" "three" LTRACK2) '())

(define (select-album t a lt)
  (cond [(empty? lt) '()]
        [(and (string=? (track-name  (first lt)) t)
              (string=? (track-album (first lt)) a))
         (cons (first lt)
               (select-album t a (rest lt)))]
        [else (select-album t a (rest lt))]))

; String String Date LTracks -> LTracks
; extracts from the latter the list of tracks that belong
; to the given album and have been played after the given date
(check-expect (select-album-date "title A"  "three" DATE1 LTRACK1) '())
(check-expect (select-album-date "title A"  "three" DATE3 LTRACK3) (list TRACK1))
(check-expect (select-album-date "title A"  "three" DATE1 LTRACK3) '())
(check-expect (select-album-date "title A"  "three" DATE3 LTRACK4) (list TRACK1 TRACK1))
(check-expect (select-album-date "title A"  "three" DATE1 LTRACK4) '())
(check-expect (select-album-date "title AB" "three" DATE3 LTRACK3) '())

(define (select-album-date t a d lt)
  (cond [(empty? lt) '()]
        [(and (string=? (track-name  (first lt)) t)
              (string=? (track-album (first lt)) a)
              (date>? (track-played (first lt)) d))
         (cons (first lt)
               (select-album-date t a d (rest lt)))]
        [else (select-album-date t a d (rest lt))]))

; Date Date -> Boolean
; determines whether the first occurs before the second
(check-expect (date>? DATE1 DATE3) #true)
(check-expect (date>? DATE1 DATE1) #false)

(define (date>? d1 d2)
  (or
   (> (date-year   d1) (date-year   d2))
   (> (date-month  d1) (date-month  d2))
   (> (date-day    d1) (date-day    d2))
   (> (date-hour   d1) (date-hour   d2))
   (> (date-minute d1) (date-minute d2))
   (> (date-second d1) (date-second d2))))

; LTracks -> LoLT
; produce a list of LTracks, one per album
(check-expect (select-albums LTRACK1) '())
(check-expect (select-albums LTRACK2) (list (list TRACK1)))
(check-expect (select-albums LTRACK3) (list (list TRACK1 TRACK2)))
(check-expect (select-albums LTRACK4) (list (list TRACK1 TRACK2)))
(check-expect (select-albums LTRACK5) (list (list TRACK4 TRACK3)
                                            (list TRACK2 TRACK1)))

(define (select-albums lt)
  (cond [(empty? lt) '()]
        [else (cons (extract-album (track-album (first lt)) lt)
                    (select-albums (delete-album (track-album (first lt)) (rest lt))))]))

; String LTracks -> LTracks
; extracts the tracks belonging to the given album from the list of tracks
(check-expect (extract-album "three"     LTRACK1) '())
(check-expect (extract-album "three"     LTRACK3) (list TRACK1 TRACK2))
(check-expect (extract-album "new-three" LTRACK3) '())
(check-expect (extract-album "three"     LTRACK4) (list TRACK1 TRACK2))
(check-expect (extract-album "three"     LTRACK5) (list TRACK2 TRACK1))
(check-expect (extract-album "new-three" LTRACK5) (list TRACK4 TRACK3))

(define (extract-album a lt)
  (cond [(empty? lt) '()]
        [(string=? (track-album (first lt)) a)
         (cons (first lt)
               (extract-album a (remove (first lt) (rest lt))))]
        [else (extract-album a (rest lt))]))

; String LTracks -> LTracks
; removes the tracks belonging to the given album from the list of tracks
(check-expect (delete-album "three"     LTRACK1) '())
(check-expect (delete-album "three"     LTRACK3) '())
(check-expect (delete-album "new-three" LTRACK3) (list TRACK1 TRACK2))
(check-expect (delete-album "three"     LTRACK4) '())
(check-expect (delete-album "three"     LTRACK5) (list TRACK4 TRACK3))
(check-expect (delete-album "new-three" LTRACK5) (list TRACK2 TRACK1))

(define (delete-album a lt)
  (cond [(empty? lt) '()]
        [(string=? (track-album (first lt)) a)
         (delete-album a (remove (first lt) (rest lt)))]
        [else (cons (first lt) (delete-album a (rest lt)))]))
