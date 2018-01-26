;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |3-How to Design Programs|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 3-How to Design Programs.rkt
;; I - Fixed-Size Data
;; 3 - How to Design Programs

(require 2htdp/image)
(require 2htdp/batch-io)


;; Exercise 33

"The Year 2000 problem is also known as the Y2K problem, the Millennium bug, the Y2K bug, or Y2K."



;; 3.1 - Designing Functions



;; 3.2 - Finger Exercises: Functions

;; Exercise 34

;; String -> String
;; extracts the first character from a non-empty string
(check-expect (string-first "Hello") "H")
(check-expect (string-first "apple") "a")

(define (string-first s)
  (substring s 0 1))

;; Exercise 35

;; String -> String
;; extracts the last character from a non-empty string
(check-expect (string-last "Hello") "o")
(check-expect (string-last "apple") "e")

(define (string-last s)
  (substring s (sub1 (string-length s))))

;; Exercise 36

;; Image -> Number
;; counts the number of pixels in a given image
(check-expect (image-area (square 100 "solid" "black")) (* 100 100))

(define (image-area i)
  (* (image-width i) (image-height i)))

;; Exercise 37

;; String -> String
;; produces a string like the given one with the first character removed
(check-expect (string-rest "Hello") "ello")
(check-expect (string-rest "apple") "pple")

(define (string-rest s)
  (substring s 1))

;; Exercise 38

;; String -> String
;; produces a string like the given one with the last character removed
(check-expect (string-remove-last "Hello") "Hell")
(check-expect (string-remove-last "apple") "appl")

(define (string-remove-last s)
  (substring s 0 (sub1 (string-length s))))



;; 3.3 - Domain Knowledge



;; 3.4 - From Functions to Programs



;; 3.5 - On Testing
