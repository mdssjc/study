;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname average-tr) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; average.rkt
;; Accumulators P4 - Average Tail Recursive
;; Design a tail-recursive function that produces the average of
;; numbers in a list.


;; PROBLEM:
;;
;; Design a function called average that consumes (listof Number) and
;; produces the average of the numbers in the list.

;; (listof Number) -> Number
;; produces the average of the numbers in the list
(check-expect (average (list 2)) 2)
(check-expect (average (list 1 2 3)) 2)
(check-expect (average (list 4 8 2)) (/ (+ 4 8 2) 3))

;(define (average lon) 0) ; Stub

(define (average lon)
  (local ((define (average lon cnt sum)
            (cond [(empty? lon) (/ sum cnt)]
                  [else
                   (average (rest lon) (add1 cnt)
                            (+ (first lon) sum))])))
    (average lon 0 0)))
