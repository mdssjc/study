;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-169) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 169

; Lop is one of:
; - '()
; - (cons Posn Lop)
; interpretation an instance of Lop represents a Posn list


; Lop -> Lop
; consumes and produces lists of Posns
; result contains all those Posns whose x-coordinates
; are between 0 and 100 and whose y-coordinates are between 0 and 200
(check-expect (legal '()) '())
(check-expect (legal (cons (make-posn -1 100)  '())) '())
(check-expect (legal (cons (make-posn 0 100)   '())) (cons (make-posn 0 100) '()))
(check-expect (legal (cons (make-posn 50 100)  '())) (cons (make-posn 50 100) '()))
(check-expect (legal (cons (make-posn 100 100) '())) (cons (make-posn 100 100) '()))
(check-expect (legal (cons (make-posn 101 100) '())) '())
(check-expect (legal (cons (make-posn 50 -1)   '())) '())
(check-expect (legal (cons (make-posn 50 0)    '())) (cons (make-posn 50 0) '()))
(check-expect (legal (cons (make-posn 50 100)  '())) (cons (make-posn 50 100) '()))
(check-expect (legal (cons (make-posn 50 200)  '())) (cons (make-posn 50 200) '()))
(check-expect (legal (cons (make-posn 50 201)  '())) '())
(check-expect (legal (cons (make-posn -1 100)
                           (cons (make-posn 50 100)
                                 (cons (make-posn 50 -1)
                                       (cons (make-posn 50 100) '())))))
              (cons (make-posn 50 100) (cons (make-posn 50 100) '())))

(define (legal lop)
  (cond [(empty? lop) '()]
        [(< (posn-x (first lop)) 0)   (legal (rest lop))]
        [(> (posn-x (first lop)) 100) (legal (rest lop))]
        [(< (posn-y (first lop)) 0)   (legal (rest lop))]
        [(> (posn-y (first lop)) 200) (legal (rest lop))]
        [else (cons (first lop)
                    (legal (rest lop)))]))
