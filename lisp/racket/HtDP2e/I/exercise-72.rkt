;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-72) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 72

(define-struct phone [area number])
; A Phone is a structure:
;   (make-phone Number[1..999] Number[1..9999])
; interpretation area means first three digits of phone, between 1 and 999
;                number means last four number of phone, between 1 and 9999

(define-struct phone# [area switch num])
; A Phone# is a structure:
;   (make-phone# Number[1..999] Number[1..999] Number[1..9999])
; interpretation area means first three digits of phone, between 1 and 999
;                switch means next three code of phone, between 1 and 999
;                number means last four number of phone, between 1 and 9999
