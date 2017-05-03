;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname area-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; area-starter.rkt

; 
; PROBLEM:
; 
; DESIGN a function called area that consumes the length of one side 
; of a square and produces the area of the square.
; 
; Remember, when we say DESIGN, we mean follow the recipe.
; 
; Leave behind commented out versions of the stub and template.
; 


;; Number -> Number
;; Given length of one side of square, produce the area of the square
(check-expect (area 3) 9)
(check-expect (area 3.2) (* 3.2 3.2))

;(define (area s) 0) ; Stub

;(define (area s)    ; Template
;  (... s))

(define (area s)
  (* s s))
