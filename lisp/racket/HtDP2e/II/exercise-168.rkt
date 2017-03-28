;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-168) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 168

; Lop is one of:
; - '()
; - (cons Posn Lop)
; interpretation an instance of Lop represents a Posn list


; Lop -> Lop
; consumes and produces lists of Posns
; For each (make-posn x y) in the former, the latter contains (make-posn x (+ y 1))
(check-expect (translate '()) '())
(check-expect (translate (cons (make-posn 10 10) (cons (make-posn 20 20) '())))
              (cons (make-posn 10 11) (cons (make-posn 20 21) '())))

(define (translate lop)
  (cond [(empty? lop) '()]
        [else (cons (make-posn (posn-x (first lop)) (add1 (posn-y (first lop))))
              (translate (rest lop)))]))
