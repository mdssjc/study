;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-330) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 330


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