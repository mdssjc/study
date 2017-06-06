;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-236) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 236


(define L1 (list 0))
(define L2 (list 1 2 3 4 5))


; Lon -> Lon
; add 1 to each item on l
(check-expect (add1* '()) '())
(check-expect (add1* L1) (list 1))
(check-expect (add1* L2) (list 2 3 4 5 6))

(define (add1* l)
  (cond [(empty? l) '()]
        [else (cons (add1 (first l))
                    (add1* (rest l)))]))

; Lon -> Lon
; adds 5 to each item on l
(check-expect (plus5 '()) '())
(check-expect (plus5 L1) (list 5))
(check-expect (plus5 L2) (list 6 7 8 9 10))

(define (plus5 l)
  (cond [(empty? l) '()]
        [else (cons (+ (first l) 5)
                    (plus5 (rest l)))]))

; Lon -> Lon
; subs 2 to each item on l
(check-expect (sub2 '()) '())
(check-expect (sub2 L1) (list -2))
(check-expect (sub2 L2) (list -1 0 1 2 3))

(define (sub2 l)
  (cond [(empty? l) '()]
        [else (cons (- (first l) 2)
                    (sub2 (rest l)))]))
