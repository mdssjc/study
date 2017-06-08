;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-239) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 239


; A [List X Y] is a structure:
;   (cons X (cons Y '()))

; A [List Number Number] is a structure:
;   (cons Number (cons Number '()))
(define P1 (cons 1 (cons 2 '())))

; A [List Number 1String] is a structure:
;   (cons Number (cons 1String '()))
(define P2 (cons 1 (cons "a" '())))

; A [List String Boolean] is a structure:
;   (cons String (cons Boolean '()))
(define P3 (cons "hello" (cons #true '())))
(define P4 (cons "hello" (cons #false '())))
