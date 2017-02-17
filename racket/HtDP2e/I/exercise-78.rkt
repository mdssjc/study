;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-78) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 78

(define-struct word-3 (l1 l2 l3))
; Word-3 is a structure:
;  (make-word-3 String String String)
; interpretation l1 is a lower-case letter
;                l2 is a lower-case letter
;                l3 is a lower-case letter
; Each letter is represented by "a" through "z" plus #false
