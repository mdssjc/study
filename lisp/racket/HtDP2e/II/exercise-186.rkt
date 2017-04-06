;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-186) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 186

; List-of-numbers -> Boolean
; produces true if the numbers are sorted in descending order
(check-expect (sorted>? (cons 1 (cons 2 '()))) #false)
(check-expect (sorted>? (cons 3 (cons 2 '()))) #true)
(check-expect (sorted>? (cons 0 (cons 3 (cons 2 '())))) #false)
(check-expect (sorted>? '()) #true)

(define (sorted>? l)
  (cond [(empty? l) #true]
        [(empty? (rest l)) #true]
        [else (and (>= (first l)
                       (first (rest l)))
                   (sorted>? (rest l)))]))

; List-of-numbers -> List-of-numbers
; produces a sorted version of l
(check-satisfied (sort> '()) sorted>?)
(check-satisfied (sort> (list 3 2 1)) sorted>?)
(check-satisfied (sort> (list 1 2 3)) sorted>?)
(check-satisfied (sort> (list 12 20 -5)) sorted>?)

(define (sort> l)
  (cond [(empty? l) '()]
        [(cons? l) (insert (first l) (sort> (rest l)))]))
 
; Number List-of-numbers -> List-of-numbers
; inserts n into the sorted list of numbers l
(define (insert n l)
  (cond [(empty? l) (cons n '())]
        [else (if (>= n (first l))
                  (cons n l)
                  (cons (first l) (insert n (rest l))))]))

; List-of-numbers -> List-of-numbers
; produces a sorted version of l
(check-satisfied (sort>/bad (list 3 2 1)) sorted>?)
(check-satisfied (sort>/bad '()) empty?)

(define (sort>/bad l)
  '(9 8 7 6 5 4 3 2 1 0))
