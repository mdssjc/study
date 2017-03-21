;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-152) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 152

(require 2htdp/image)

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
