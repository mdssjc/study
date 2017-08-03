;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-250) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 250


; Number -> [List-of Number]
; tabulates sin between n 
; and 0 (incl.) in a list
(define (tab-sin n)
  (cond
    [(= n 0) (list (sin 0))]
    [else
     (cons
      (sin n)
      (tab-sin (sub1 n)))]))

; Number -> [List-of Number]
; tabulates sqrt between n 
; and 0 (incl.) in a list
(define (tab-sqrt n)
  (cond
    [(= n 0) (list (sqrt 0))]
    [else
     (cons
      (sqrt n)
      (tab-sqrt (sub1 n)))]))

; [Number -> Number] Number -> [List-of Number]
; creates a list by applying each number in the range (n..0) for the function f
(check-expect (tabulate sqr 0) (list (sqr 0)))
(check-expect (tabulate sqr 2) (list (sqr 2) (sqr 1) (sqr 0)))
(check-expect (tabulate tan 0) (list (tan 0)))
(check-within (tabulate tan 2) (list (tan 2) (tan 1) (tan 0)) 0.1)

(define (tabulate f n)
  (cond [(= n 0) (list (f 0))]
        [else (cons (f n)
                    (tabulate f (sub1 n)))]))
