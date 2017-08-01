;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-294) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 294


(define LST (list 0 2 4 6 8 10))


; X [List-of X] -> [Maybe N]
; determine the index of the first occurrence
; of x in l, #false otherwise
(define (index x l)
  (cond
    [(empty? l) #false]
    [else (if (equal? (first l) x)
              0
              (local ((define i (index x (rest l))))
                (if (boolean? i) i (+ i 1))))]))

; X [List-of X] -> [[Maybe N] -> Boolean]
; a specification for the index function
(define (is-index? x l)
  (lambda (l0)
    (equal? (foldr (lambda (i res)
                     (cond [(and (false? res)
                                 (equal? i x)) 0]
                           [(number? res) (add1 res)]
                           [else res])) #false l)
            l0)))

(check-satisfied (index     4 LST)
                 (is-index? 4 LST))
