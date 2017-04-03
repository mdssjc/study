;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-175) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 175

(require 2htdp/batch-io)

; A Los is one of:
; - '()
; - (cons String Los)
; interpretation a list of Strings, each is a String
(define line0 '())
(define line1 (cons "the" (cons "car" '())))

; A LLS is one of: 
; - '()
; - (cons Los LLS)
; interpretation a list of lines, each is a list of Strings
(define lls0 '())
(define lls1 (cons line1 (cons line0 (cons line1 '()))))


; String -> String
; consumes the name of a file and produces a value that consists of three numbers
(define (wc filename)
  (count (read-words/line filename)))

; LLS -> String
; counts the number of 1Strings, words, and lines
(check-expect (count lls0) "0 0 0")
(check-expect (count lls1) "12 4 3")

(define (count lls)
  (string-append (number->string (count-1Strings lls)) " "
                 (number->string (count-words lls)) " "
                 (number->string (count-lines lls))))

; LLS -> Number
; counts the number of 1Strings
(check-expect (count-1Strings lls0) 0)
(check-expect (count-1Strings lls1) 12)

(define (count-1Strings lls)
  (cond [(empty? lls) 0]
        [else (+ (count-1Strings* (first lls))
                 (count-1Strings (rest lls)))]))

(define (count-1Strings* los)
  (cond [(empty? los) 0]
        [else (+ (string-length (first los))
                 (count-1Strings* (rest los)))]))

; LLS -> String
; counts the number of words
(check-expect (count-words lls0) 0)
(check-expect (count-words lls1) 4)

(define (count-words lls)
  (cond [(empty? lls) 0]
        [else (+ (length (first lls))
                 (count-words (rest lls)))]))

; LLS -> String
; counts the number of lines
(check-expect (count-lines lls0) 0)
(check-expect (count-lines lls1) 3)

(define (count-lines lls)
  (length lls))


; Test drive
(wc "ttt.txt")
