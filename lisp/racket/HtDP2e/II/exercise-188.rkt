;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-188) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 188

(define-struct email [from date message])
; A Email Message is a structure:
;   (make-email String Number String)
; interpretation (make-email f d m) represents text m
; sent by f, d seconds after the beginning of time
(define E1 (make-email "MDS" 12 "Hello man!"))
(define E2 (make-email "Joseph" 30 "Hi bro!"))

; List-of-Email -> List-of-Email
; produces a sorted version of l
(check-expect (sort1> '()) '())
(check-expect (sort1> (list E1 E2 E1)) (list E2 E1 E1))

(define (sort1> l)
  (cond [(empty? l) '()]
        [(cons? l) (insert1 (first l) (sort1> (rest l)))]))

; List-of-Email -> List-of-Email
; produces a sorted version of l
(check-expect (sort2> '()) '())
(check-expect (sort2> (list E1 E2 E1)) (list E1 E1 E2))

(define (sort2> l)
  (cond [(empty? l) '()]
        [(cons? l) (insert2 (first l) (sort2> (rest l)))]))
 
; Email List-of-Email -> List-of-Email
; inserts e into the sorted list of Email l
(define (insert1 e l)
  (cond [(empty? l) (cons e '())]
        [else (if (compare-by-date e (first l))
                  (cons e l)
                  (cons (first l) (insert1 e (rest l))))]))

; Email List-of-Email -> List-of-Email
; inserts e into the sorted list of Email l
(define (insert2 e l)
  (cond [(empty? l) (cons e '())]
        [else (if (compare-by-message e (first l))
                  (cons e l)
                  (cons (first l) (insert2 e (rest l))))]))

; Email Email -> Boolean
; compares two Email e by date (e1 >= e2)
(check-expect (compare-by-date E1 E2) #false)
(check-expect (compare-by-date E1 E1) #true)
(check-expect (compare-by-date E2 E1) #true)

(define (compare-by-date e1 e2)
  (>= (email-date e1)
      (email-date e2)))

; Email Email -> Boolean
; compares two Email e by message (e < e2)
(check-expect (compare-by-message E1 E2) #true)
(check-expect (compare-by-message E1 E1) #false)
(check-expect (compare-by-message E2 E1) #false)

(define (compare-by-message e1 e2)
  (string<? (email-message e1)
            (email-message e2)))
