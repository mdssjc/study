;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-262) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 262


; Natural -> [List-of [List-of Natural]]
; creates diagonal squares of 0s and 1s
(check-expect (identityM 0) empty)
(check-expect (identityM 1) (list (list 1)))
(check-expect (identityM 3) (list (list 1 0 0) (list 0 1 0) (list 0 0 1)))

(define (identityM n)
  (local ((define (numbers n s)
            (cond [(zero? n) empty]
                  [else
                   (cons (if (= n s) 1 0) (numbers (sub1 n) s))]))
          (define (rows i)
            (cond [(zero? i) empty]
                  [else
                   (cons (numbers n i) (rows (sub1 i)))])))
    (rows n)))
