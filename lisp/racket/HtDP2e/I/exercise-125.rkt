;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-125) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 125

(define-struct oops [])
; it's legal

(define-struct child [parents dob date])
; it's legal

; (define-struct (child person) [dob date])
; it's illegal, incorrect syntax
