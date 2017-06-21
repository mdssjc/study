;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-256) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 256


; A [NEList-of X] is one of:
; - (cons X '())
; - (cons X [NEList-of X])
; interpretation non-empty lists of X
(define NEL1 (list 5 2 4 7 1))
(define NEL2 (list (make-posn 2 4) (make-posn 3 1) (make-posn 1 5)))


; [X] (X -> Number) [NEList-of X] -> X
; finds the (first) item in lx that maximizes f
; if (argmax f (list x-1 ... x-n)) == x-i,
; then (>= (f x-i) (f x-1)), (>= (f x-i) (f x-2)), ...
(check-expect (argmax  add1 NEL1) 7)
(check-expect (argmax2 add1 NEL1) 7)
(check-expect (argmax  posn-x NEL2) (make-posn 3 1))
(check-expect (argmax2 posn-x NEL2) (make-posn 3 1))
(check-expect (argmax  posn-y NEL2) (make-posn 1 5))
(check-expect (argmax2 posn-y NEL2) (make-posn 1 5))

(define (argmax2 f lx)
  (cond [(empty? (rest lx)) (first lx)]
        [else
         (if (>= (f (first  lx))
                 (f (argmax2 f (rest lx))))
             (first lx)
             (argmax2 f (rest lx)))]))

; argmin: Finds the (first) element of the list that minimizes the output of the function.
