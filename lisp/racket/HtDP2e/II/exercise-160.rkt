;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-160) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 160

; Number Son.L -> Son.L
; adds a number x to some given set s
(check-expect (set+.L 1 (cons 1 (cons 1 '()))) (cons 1 (cons 1 '())))
(check-expect (set+.L 2 (cons 1 (cons 1 '()))) (cons 2 (cons 1 (cons 1 '()))))
  
(define (set+.L x s)
  (if (member? x s)
      s
      (cons x s)))
	
; Number Son.R -> Son.R
; adds a number x to some given set s
(define s1.R (cons 1 '()))
(check-expect (set+.R 1 (cons 1 '())) (cons 1 (cons 1 '())))
(check-expect (set+.R 1 (cons 1 (cons 1 '()))) (cons 1 (cons 1 (cons 1 '()))))

(define (set+.R x s)
  (cons x s))
