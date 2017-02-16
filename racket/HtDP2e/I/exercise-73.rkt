;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-73) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 73

; Posn Number -> Posn
; produces a posn like p with n in the x field
(check-expect (posn-up-x (make-posn 2 3) 4) (make-posn 4 3))

(define (posn-up-x p n)
  (make-posn n (posn-y p)))


(define (x+ p)
  (posn-up-x p (+ (posn-x p) 3)))
(x+ (make-posn 2 2))
