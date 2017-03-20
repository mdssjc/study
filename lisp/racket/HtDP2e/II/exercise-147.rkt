;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-147) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 147

; A NEList-of-Booleans is one of: 
; - (cons Boolean '())
; - (cons Boolean NEList-of-Booleans)
; interpretation non-empty lists of Boolean values
(define NELOB1 (cons #true '()))
(define NELOB2 (cons #false '()))
(define NELOB3 (cons #true (cons #false '())))


; NEList-of-Booleans -> Boolean
; determines whether all of them are true
(check-expect (all-true NELOB1) #true)
(check-expect (all-true NELOB2) #false)
(check-expect (all-true NELOB3) #false)

(define (all-true l)
  (cond [(empty? (rest l)) (first l)]
        [else (and (first l) (all-true (rest l)))]))

; NEList-of-Booleans -> Boolean
; determines whether at least one item on the list is true
(check-expect (one-true NELOB1) #true)
(check-expect (one-true NELOB2) #false)
(check-expect (one-true NELOB3) #true)

(define (one-true l)
  (cond [(empty? (rest l)) (first l)]
        [else (or (first l) (one-true (rest l)))]))
