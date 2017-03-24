;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-159) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 159

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define WIDTH  100)
(define HEIGHT 180)
(define DOT (circle 4 "solid" "red"))


(define-struct pair [balloon# lob])
; A Pair is a structure (make-pair N List-of-posns)

; A List-of-posns is one of: 
; - '()
; - (cons Posn List-of-posns)
; interpretation (make-pair n lob) means n balloons 
; must yet be thrown and added to lob


; Pair -> World
; starts the world with (riot 10)
(define (riot n)
  (big-bang (make-pair n '())
            [on-tick tock 1]
            [on-draw add-balloons]))

; Pair -> Pair
; drops a new ballon in List-of-posns at a rate of one per second
(check-expect (tock (make-pair 0 '())) (make-pair 0 '()))
(check-random (tock (make-pair 1 '()))
              (make-pair 0 (cons (make-posn (random 11) (random 11)) '())))
(check-random (tock (make-pair 2 (cons (make-posn 6 8) '())))
              (make-pair 1 (cons (make-posn (random 11) (random 11))
                                 (cons (make-posn 6 8) '()))))

(define (tock p)
  (if (= (pair-balloon# p) 0)
      p
      (make-pair (sub1 (pair-balloon# p))
                 (cons (make-posn (random 11) (random 11)) (pair-lob p)))))

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

; Pair -> Image
; produces an image of the lecture hall with red dots added as specified by the Posns
(check-expect (add-balloons (make-pair 0 '())) HALL)
(check-expect (add-balloons (make-pair 0 (cons (make-posn 0 0) '()))) (place-image DOT  0  0 HALL))
(check-expect (add-balloons (make-pair 0 (cons (make-posn 1 1) '()))) (place-image DOT 10 10 HALL))
(check-expect (add-balloons (make-pair 0 (cons (make-posn 1 1) (cons (make-posn 5 5) '()))))
              (place-image DOT 10 10 (place-image DOT 50 50 HALL)))

(define (add-balloons p)
  (cond [(empty? (pair-lob p)) HALL]
        [else (place-image DOT
                           (* (posn-x (first (pair-lob p))) 10)
                           (* (posn-y (first (pair-lob p))) 10)
                           (add-balloons (make-pair (pair-balloon# p) (rest (pair-lob p)))))]))
