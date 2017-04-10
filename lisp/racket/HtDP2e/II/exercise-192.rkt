;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-192) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 192

(define triangle-p (list
                    (make-posn 20 10)
                    (make-posn 20 20)
                    (make-posn 30 20)))
(define square-p (list
                  (make-posn 10 10)
                  (make-posn 20 10)
                  (make-posn 20 20)
                  (make-posn 10 20)))


; A Polygon is one of:
; - (list Posn Posn Posn)
; - (cons Posn Polygon)


; Polygon -> Posn
; extracts the last item from p
(check-expect (last triangle-p) (make-posn 30 20))
(check-expect (last square-p)   (make-posn 10 20))

(define (last p)
  (cond [(empty? (rest (rest (rest p)))) (third p)]
        [else (last (rest p))]))
