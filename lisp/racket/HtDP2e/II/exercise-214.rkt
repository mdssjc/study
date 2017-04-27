;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-214) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 214

; A Word is one of:
; - '() or
; - (cons 1String Word)
; interpretation a String as a list of 1Strings (letters)

; A List-of-words is one of:
; - '() or
; - (cons Word List-of-words)
; interpretation a collection of Word values

; A Dictionary is a List-of-strings.
(define DICTIONARY-AS-LIST (list "hello" "world" "cat" "act" "rat" "art" "tar"))


; String -> Boolean
(define (all-words-from-rat? w) (and (member? "rat" w)
                                     (member? "art" w)
                                     (member? "tar" w)))


; String -> List-of-strings
; find all words that the letters of some given word spell
(check-member-of (alternative-words "cat")
                 (list "act" "cat")
                 (list "cat" "act"))
 
(check-satisfied (alternative-words "rat")
                 all-words-from-rat?)
 
(define (alternative-words s)
  (in-dictionary (words->strings (arrangements (string->word s)))))

; String -> Word
; convert s to the chosen word representation
(check-expect (string->word "") '())
(check-expect (string->word "hello") (list "h" "e" "l" "l" "o"))

(define (string->word s)
  (explode s))

; Word -> List-of-words
; creates all rearrangements of the letters in w
(check-expect (arrangements '()) (list '()))
(check-expect (arrangements (list "d" "e")) (list (list "d" "e")
                                                  (list "e" "d")))

(define (arrangements w)
  (cond
    [(empty? w) (list '())]
    [else (insert-everywhere/in-all-words (first w)
                                          (arrangements (rest w)))]))

; 1String List-of-words -> List-of-words
; result is a list of words like its second argument,
; but with the first argument inserted at the beginning,
; between all letters, and at the end of all words of the given list
(check-expect (insert-everywhere/in-all-words "d" '()) '())
(check-expect (insert-everywhere/in-all-words "d" (list (list "e")))
              (list (list "d" "e")
                    (list "e" "d")))
(check-expect (insert-everywhere/in-all-words "d" (list (list "e" "r")
                                                        (list "r" "e")))
              (list (list "d" "e" "r")
                    (list "e" "d" "r")
                    (list "e" "r" "d")
                    (list "d" "r" "e")
                    (list "r" "d" "e")
                    (list "r" "e" "d")))

(define (insert-everywhere/in-all-words 1s low)
  (cond [(empty? low) '()]
        [else (append (insert-everywhere/in-word 1s '() (first low))
                      (insert-everywhere/in-all-words 1s (rest low)))]))

; 1String Word Word -> List-of-words
; arrangements the words (prefix sp and suffix ss) with 1String 1s
(check-expect (insert-everywhere/in-word "d" '() '()) (list (list "d")))
(check-expect (insert-everywhere/in-word "d" '() (list "e" "r"))
              (list (list "d" "e" "r")
                    (list "e" "d" "r")
                    (list "e" "r" "d")))

(define (insert-everywhere/in-word 1s sp ss)
  (cond [(empty? ss) (cons (append sp (cons 1s '()) ss) '())]
        [else (cons (append sp (cons 1s '()) ss)
                    (insert-everywhere/in-word 1s
                                               (append sp (cons (first ss) '()))
                                               (rest ss)))]))

; List-of-words -> List-of-strings
; turn all Words in low into Strings
(check-expect (words->strings '()) '())
(check-expect (words->strings (list (explode "hello")
                                    (explode "world"))) (list "hello" "world"))

(define (words->strings low)
  (cond [(empty? low) '()]
        [else (cons (word->string (first low))
                    (words->strings (rest low)))]))

; Word -> String
; convert w to a string
(check-expect (word->string '()) "")
(check-expect (word->string (list "h" "e" "l" "l" "o")) "hello")

(define (word->string w)
  (implode w))
 
; List-of-strings -> List-of-strings
; pick out all those Strings that occur in the dictionary
(check-expect (in-dictionary (list "hello" "world")) (list "hello" "world"))
(check-expect (in-dictionary (list "a" "car")) '())

(define (in-dictionary los)
  (cond [(empty? los) '()]
        [(member? (first los) DICTIONARY-AS-LIST)
         (cons (first los) (in-dictionary (rest los)))]
        [else (in-dictionary (rest los))]))
