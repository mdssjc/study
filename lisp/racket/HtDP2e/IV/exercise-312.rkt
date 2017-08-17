;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-312) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 312


;; ====================
;; Data definitions:

(define-struct no-parent [])
(define-struct child [father mother name date eyes])
; An FT (short for family tree) is one of: 
; - (make-no-parent)
; - (make-child FT FT String N String)

(define NP (make-no-parent))
; An FT is one of: 
; - NP
; - (make-child FT FT String N String)

; Oldest Generation:
(define Carl (make-child NP NP "Carl" 1926 "green"))
(define Bettina (make-child NP NP "Bettina" 1926 "green"))
 
; Middle Generation:
(define Adam (make-child Carl Bettina "Adam" 1950 "hazel"))
(define Dave (make-child Carl Bettina "Dave" 1955 "black"))
(define Eva (make-child Carl Bettina "Eva" 1965 "blue"))
(define Fred (make-child NP NP "Fred" 1966 "pink"))
 
; Youngest Generation: 
(define Gustav (make-child Fred Eva "Gustav" 1988 "brown"))


;; ====================
;; Functions:

; FT -> [List-of String]
; produces a list of all eye colors in the tree
(check-expect (eye-colors NP) empty)
(check-expect (eye-colors Carl) (list "green"))
(check-expect (eye-colors Gustav) (list "brown" "pink" "blue" "green" "green"))

(define (eye-colors ft)
  (cond [(no-parent? ft) empty]
        [else
         (cons (child-eyes ft)
               (append (eye-colors (child-father ft))
                       (eye-colors (child-mother ft))))]))
