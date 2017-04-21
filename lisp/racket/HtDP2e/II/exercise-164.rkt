;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-164) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 164

(define RATE 0.920)

; List-of-numbers -> List-of-numbers
; converts a list of US$ amounts into a list of € amounts
(check-expect (convert-euro* '()) '())
(check-within (convert-euro* (cons 1 '())) (cons 0.92 '()) 0.1)
(check-within (convert-euro* (cons 1 (cons 3.5 '()))) (cons 0.92 (cons 3.22 '())) 0.1)

(define (convert-euro* d)
  (cond [(empty? d) '()]
        [else (cons (convert-euro (first d))
              (convert-euro* (rest d)))]))

; Number -> Number
; converts the US$ in € with the current exchange rate
(check-within (convert-euro 1)   0.92 0.1)
(check-within (convert-euro 3.5) 3.22 0.1)

(define (convert-euro d)
  (* d RATE))
