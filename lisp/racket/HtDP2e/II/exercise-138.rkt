;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-138) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 138

; A List-of-amounts is one of:
; - '()
; - (cons PositiveNumber List-of-amounts)
(define LOA1 '())
(define LOA2 (cons 1 '()))
(define LOA3 (cons 1 (cons 2 '())))


; List-of-amounts -> Number
; computes the sum of the amounts
(check-expect (sum LOA1) 0)
(check-expect (sum LOA2) 1)
(check-expect (sum LOA3) 3)

(define (sum loa)
  (cond [(empty? loa) 0]
        [else (+ (first loa) (sum (rest loa)))]))


(sum LOA3)
(sum (cons 1 (cons 2 '())))
(cond [(empty? (cons 1 (cons 2 '()))) 0]
      [else (+ (first (cons 1 (cons 2 '()))) (sum (rest (cons 1 (cons 2 '())))))])
(cond [#false 0]
      [else (+ (first (cons 1 (cons 2 '()))) (sum (rest (cons 1 (cons 2 '())))))])
(cond [else (+ (first (cons 1 (cons 2 '()))) (sum (rest (cons 1 (cons 2 '())))))])
(+ (first (cons 1 (cons 2 '()))) (sum (rest (cons 1 (cons 2 '())))))
(+ 1 (sum (rest (cons 1 (cons 2 '())))))
(+ 1 (sum (cons 2 '())))
(+ 1 (cond [(empty? (cons 2 '())) 0]
           [else (+ (first (cons 2 '())) (sum (rest (cons 2 '()))))]))
(+ 1 (cond [#false 0]
           [else (+ (first (cons 2 '())) (sum (rest (cons 2 '()))))]))
(+ 1 (cond [else (+ (first (cons 2 '())) (sum (rest (cons 2 '()))))]))
(+ 1 (+ (first (cons 2 '())) (sum (rest (cons 2 '())))))
(+ 1 (+ 2 (sum (rest (cons 2 '())))))
(+ 1 (+ 2 (sum '())))
(+ 1 (+ 2 (cond [(empty? '()) 0]
                [else (+ (first '()) (sum (rest '())))])))
(+ 1 (+ 2 (cond [#true 0]
                [else (+ (first '()) (sum (rest '())))])))
(+ 1 (+ 2 0))
(+ 1 2)
3
