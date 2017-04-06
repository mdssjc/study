;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-187) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 187

(define-struct gp [name score])
; A GamePlayer is a structure: 
;    (make-gp String Number)
; interpretation (make-gp p s) represents player p who 
; scored a maximum of s points
(define GP1 (make-gp "MDS" 1234))
(define GP2 (make-gp "Joseph" 12))


; List-of-GamePlayer -> List-of-GamePlayer
; produces a sorted version of l
(check-expect (sort> '()) '())
(check-expect (sort> (list GP1 GP2 GP1)) (list GP1 GP1 GP2))

(define (sort> l)
  (cond [(empty? l) '()]
        [(cons? l) (insert (first l) (sort> (rest l)))]))
 
; GamePlayer List-of-GamePlayer -> List-of-GamePlayer
; inserts gp into the sorted list of GamePlayer l
(define (insert gp l)
  (cond [(empty? l) (cons gp '())]
        [else (if (gte gp (first l))
                  (cons gp l)
                  (cons (first l) (insert gp (rest l))))]))

; GamePlayer GamePlayer -> Boolean
; compares two GamePlayer gp by score (gp1 >= gp2)
(check-expect (gte GP1 GP2) #true)
(check-expect (gte GP1 GP1) #true)
(check-expect (gte GP2 GP1) #false)

(define (gte gp1 gp2)
  (>= (gp-score gp1)
      (gp-score gp2)))
