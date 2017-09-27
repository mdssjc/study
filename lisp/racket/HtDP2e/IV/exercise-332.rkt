;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-332) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 332


;; ====================
;; Data definitions:

(define-struct dir (name lofd))
; A Dir.v2 is a structure:
;   (make-dir String LOFD)
 
; A LOFD (short for list of files and directories) is one of:
; - '()
; - (cons File.v2 LOFD)
; - (cons Dir.v2 LOFD)
 
; A File.v2 is a String.
(define D-CODE (make-dir "Code" (list "hang" "draw")))
(define D-DOCS (make-dir "Docs" (list "read!")))
(define D-LIBS (make-dir "Libs" (list D-CODE D-DOCS)))
(define D-TEXT (make-dir "Text" (list "part1" "part2" "part3")))
(define D-TS (make-dir "TS" (list D-TEXT "read!" D-LIBS)))
