;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-213) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 213

; A Word is one of:
; - '() or
; - (cons 1String Word)
; interpretation a String as a list of 1Strings (letters)

; A List-of-words is one of:
; - '() or
; - (cons Word List-of-words)
; interpretation a collection of Word values


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
