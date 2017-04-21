;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-205) (read-case-sensitive #t) (teachpacks ((lib "itunes.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "itunes.rkt" "teachpack" "2htdp")) #f)))
;; Exercise 205

(require 2htdp/itunes)

; An LLists is one of:
; - '()
; - (cons LAssoc LLists)

; An LAssoc is one of: 
; - '()
; - (cons Association LAssoc)
;
; An Association is a list of two items: 
;   (cons String (cons BSDN '()))

; A BSDN is one of: 
; - Boolean
; - Number
; - String
; - Date

(define A1 (list "Assoc A" true))
(define A2 (list "Assoc B" 5))
(define A3 (list "Assoc C" "123ABC"))
(define A4 (list "Assoc D" (create-date 1 2 3 4 5 6)))

(define LA1 (list A1 A2 A3 A4))
(define LA2 (list A4 A3 A2 A1))
(define LA3 '())

(define LL1 (list LA1 LA2))
(define LL2 (list LA1 LA3 LA2))
(define LL3 '())
