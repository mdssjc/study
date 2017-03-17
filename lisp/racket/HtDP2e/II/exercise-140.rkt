;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-140) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 140

; A List-of-booleans is one of: 
; - '()
; - (cons Boolean List-of-booleans)
(define LOB1 '())
(define LOB2 (cons #true '()))
(define LOB3 (cons #false '()))
(define LOB4 (cons #true (cons #false '())))


; List-of-booleans -> Boolean
; determines whether all of them are true
(check-expect (all-true LOB1) #true)
(check-expect (all-true LOB2) #true)
(check-expect (all-true LOB3) #false)
(check-expect (all-true LOB4) #false)

(define (all-true lob)
  (cond [(empty? lob) #true]
        [else (and (first lob) (all-true (rest lob)))]))

; List-of-booleans -> Boolean
; determines whether at least one item on the list is true
(check-expect (one-true LOB1) #true)
(check-expect (one-true LOB2) #true)
(check-expect (one-true LOB3) #true)
(check-expect (all-true LOB4) #false)

(define (one-true lob)
  (cond [(empty? lob) #true]
        [else (or (first lob) (one-true (rest lob)))]))
