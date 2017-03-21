;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-153) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 153

(require 2htdp/image)

; Constants
(define WIDTH  100)
(define HEIGHT 180)
(define DOT (circle 4 "solid" "red"))


; List-of-posn is one of:
; - '()
; - (cons Posn List-of-posn)
; interpretation a list of Posn


; N Image -> Image
; produces a column, a vertical arrangement, of n copies of img
(check-expect (col 5 (rectangle 10 10 "outline" "black")) (beside (rectangle 10 10 "outline" "black")
                                                                  (rectangle 10 10 "outline" "black")
                                                                  (rectangle 10 10 "outline" "black")
                                                                  (rectangle 10 10 "outline" "black")
                                                                  (rectangle 10 10 "outline" "black")))

(define (col n img)
  (cond [(zero? n) empty-image]
        [else (beside img (col (sub1 n) img))]))

; N Image -> Image
; produces a row, a horizontal arrangement, of n copies of img
(check-expect (row 5 (rectangle 10 10 "outline" "black")) (above (rectangle 10 10 "outline" "black")
                                                                 (rectangle 10 10 "outline" "black")
                                                                 (rectangle 10 10 "outline" "black")
                                                                 (rectangle 10 10 "outline" "black")
                                                                 (rectangle 10 10 "outline" "black")))

(define (row n img)
  (cond [(zero? n) empty-image]
        [else (above img (row (sub1 n) img))]))


(define HALL (place-image (col 10 (row 18 (rectangle 10 10 "outline" "black")))
                          (/ WIDTH 2) (/ HEIGHT 2)
                          (empty-scene WIDTH HEIGHT)))

; List-of-posn -> Image
; produces an image of the lecture hall with red dots added as specified by the Posns
(check-expect (add-balloons '()) HALL)
(check-expect (add-balloons (cons (make-posn 1 1) '())) (place-image DOT 10 10 HALL))
(check-expect (add-balloons (cons (make-posn 1 1) (cons (make-posn 5 5) '())))
              (place-image DOT 10 10 (place-image DOT 50 50 HALL)))

(define (add-balloons lop)
  (cond [(empty? lop) HALL]
        [else (place-image DOT
                           (* (posn-x(first lop)) 10)
                           (* (posn-y (first lop)) 10)
                           (add-balloons (rest lop)))]))
