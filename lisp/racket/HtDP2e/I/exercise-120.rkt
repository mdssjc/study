;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-120) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 120

; (x)
; illegal - variable

; (+ 1 (not x))
; illegal - sum of integer with boolean

; (+ 1 2 3)
; legal - expr -> (primitive value value value)
