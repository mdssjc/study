;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-253) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 253


; [Number -> Boolean]
(zero? 0)

; [Boolean String -> Boolean]
(eq? #true "world")

; [Number Number Number -> Number]
(+ 1 2 3)

; [Number -> [List-of Number]]
(list 1)

; [[List-of Number] -> Boolean]
(number? (list 1 2 3))
