;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-292) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 292


; [X X -> Boolean] [NEList-of X] -> Boolean 
; determine whether l is sorted according to cmp
(check-expect (sorted? < '(1 2 3)) #true)
(check-expect (sorted? < '(2 1 3)) #false)
 
(define (sorted? cmp l)
  (cond [(empty? (rest l)) #true]
        [else
         (and (cmp (first l) (second l))
              (sorted? cmp (rest l)))]))

; [X X -> Boolean] -> [[List-of X] -> Boolean]
; is the given list l0 sorted according to cmp
(check-expect ((sorted <) '(1 2 3)) #true)
(check-expect ((sorted <) '(2 1 3)) #false)

(define (sorted cmp)
  (lambda (l0)
    (if (empty? l0)
        #true
        (sorted? cmp l0 ))))
