;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-167) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 167

; Lop is one of:
; - '()
; - (cons Posn Lop)
; interpretation an instance of Lop represents a Posn list


; Lop -> Number
; consumes a list of Posns and produces the sum of all of its x-coordinates
(check-expect (sum '()) 0)
(check-expect (sum (cons (make-posn 11 20) (cons (make-posn 48 66) '()))) (+ 11 48))

(define (sum lop)
  (cond [(empty? lop) 0]
        [else (+ (posn-x (first lop))
                 (sum (rest lop)))]))
