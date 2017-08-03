;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-299) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 299


; A Set is a function:
;   [X -> Boolean]
; interpretation: representation for finite and infinite sets 

; Set
(define two? (lambda (n) (or (equal? n 1) (equal? n 2))))

; X Set -> Set
; adds an element to a set
(check-expect ((add-element 1 even?) 1) #true)

(define (add-element x s)
  (lambda (x0)
    (or (s x0) (equal? x x0))))

; Set Set -> Set
; combines the elements of two sets
(check-expect ((union odd? even?) (random 1000)) #true)

(define (union s1 s2)
  (lambda (x)
    (or (s1 x) (s2 x))))

; X Set -> Set
; collects all elements common to two sets
(check-expect ((intersection odd? even?) (random 100)) #false)
(check-expect ((intersection odd?  two?) 3) #false)
(check-expect ((intersection even? two?) 2) #true)

(define (intersection s1 s2)
  (lambda (x)
    (and (s1 x) (s2 x))))
