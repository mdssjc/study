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
(define DICTIONARY-AS-LIST (list "alfa" "eco" "bravo" "erlang" "charlie" "zulu"))


;; =================
;; Functions:

;; Exercise 195

; Dictionary Letter -> Number
; counts how many words in the given Dictionary d start with the given Letter l
(check-expect (starts-with# '() "e") 0)
(check-expect (starts-with# DICTIONARY-AS-LIST "e") 2)
(check-expect (starts-with# DICTIONARY-AS-LIST "z") 1)

(define (starts-with# d l)
  (cond [(empty? d) 0]
        [else (+ (if (string=? (string-ith (first d) 0) l) 1 0)
                 (starts-with# (rest d) l))]))


(starts-with# AS-LIST "e")              ; 4006
(starts-with# AS-LIST "z")              ; 190
