;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-331) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 331


;; ====================
;; Data definitions:

; A Dir.v1 (short for directory) is one of:
; - '()
; - (cons File.v1 Dir.v1)
; - (cons Dir.v1 Dir.v1)
 
; A File.v1 is a String.
(define D-CODE (list "hang" "draw"))
(define D-DOCS (list "read!"))
(define D-LIBS (list D-CODE D-DOCS))
(define D-TEXT (list "part1" "part2" "part3"))
(define D-TS (list D-TEXT "read!" D-LIBS))


;; ====================
;; Functions:

; Dir.v1 -> Natural
; determines how many files a given Dir.v1 contains
(check-expect (how-many empty) 0)
(check-expect (how-many D-CODE) 2)
(check-expect (how-many D-LIBS) 3)
(check-expect (how-many D-TS) 7)

(define (how-many d)
  (cond [(empty? d) 0]
        [(string? (first d))
         (+ 1 (how-many (rest d)))]
        [else
         (+ (how-many (first d))
            (how-many (rest d)))]))
