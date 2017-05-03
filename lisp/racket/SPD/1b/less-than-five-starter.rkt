;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname less-than-five-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; less-than-five-starter.rkt

; 
; PROBLEM:
; 
; DESIGN function that consumes a string and determines whether its length is
; less than 5.  Follow the HtDF recipe and leave behind commented out versions 
; of the stub and template.
; 


;; String -> Boolean
;; Evalutes a predicate for length less than 5 (true).
(check-expect (less5? "hi") true)
(check-expect (less5? "string") false)
(check-expect (less5? "hello") false)

;(define (less5? s) false) ; Stub

;(define (less5? s)        ; Template
;  (... s))

(define (less5? s)
  (< (string-length s) 5))
