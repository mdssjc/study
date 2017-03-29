;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-171) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 171

; A Los is one of:
; - '()
; - (cons String Los)
; interpretation a list of Strings, each is a String

; A LLS is one of: 
; - '()
; - (cons Los LLS)
; interpretation a list of lines, each is a list of Strings
