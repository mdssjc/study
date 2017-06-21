;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-259) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 259


; A Word is one of:
; - '() or
; - (cons 1String Word)
; interpretation a String as a list of 1Strings (letters)

; A [List-of Word] is one of:
; - '() or
; - (cons Word [List-of Word])
; interpretation a collection of Word values

; A Dictionary is a [List-of String]
(define DICTIONARY-AS-LIST (list "hello" "world" "cat" "act" "rat" "art" "tar"))


; String -> Boolean
(define (all-words-from-rat? w) (and (member? "rat" w)
                                     (member? "art" w)
                                     (member? "tar" w)))


; String -> [List-of String]
; find all words that the letters of some given word spell
(check-member-of (alternative-words "cat") (list "act" "cat") (list "cat" "act"))
(check-satisfied (alternative-words "rat") all-words-from-rat?)

(define (alternative-words s)
  (local ((define in-dictionary? (lambda (x) (member? x DICTIONARY-AS-LIST)))
          ; 1String Word Word -> [List-of Word]
          ; arrangements the words (prefix sp and suffix ss) with 1String 1s
          (define (insert/word 1s sp ss)
            (cond [(empty? ss) (cons (append sp (cons 1s '()) ss) '())]
                  [else
                   (cons (append sp (cons 1s '()) ss)
                         (insert/word 1s
                                      (append sp (cons (first ss) '()))
                                      (rest ss)))]))
          ; 1String [List-of Word] -> [List-of Word]
          ; result is a list of words like its second argument,
          ; but with the first argument inserted at the beginning,
          ; between all letters, and at the end of all words of the given list
          (define (insert/all-words 1s low)
            (cond [(empty? low) empty]
                  [else
                   (append (insert/word 1s empty (first low))
                           (insert/all-words 1s (rest low)))]))
          ; Word -> [List-of Word]
          ; creates all rearrangements of the letters in w
          (define (arrangements w)
            (cond [(empty? w) (list empty)]
                  [else
                   (insert/all-words (first w)
                                     (arrangements (rest w)))])))
    (filter in-dictionary? (map implode (arrangements (explode s))))))
