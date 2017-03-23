;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-158) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 158

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define HEIGHT 80) ; distances in terms of pixels
(define WIDTH 100)
(define XSHOTS (/ WIDTH 2))

; graphical constants 
(define BACKGROUND (empty-scene WIDTH HEIGHT))
(define SHOT (triangle 3 "solid" "red"))


; A Shot is a Number.
; interpretation represents the shot's y-coordinate

; A List-of-shots is one of:
; - '()
; - (cons Shot List-of-shots)
; interpretation the collection of shots fired


; A ShotWorld is List-of-numbers.
; interpretation each number on such a list
;   represents the y-coordinate of a shot
(define (main w0)
  (big-bang w0
            [on-tick tock]
            [on-key keyh]
            [to-draw to-image]))

; ShotWorld -> ShotWorld
; moves each shot up by one pixel, until the shot disappears from the canvas
(check-expect (tock (cons 9 '())) (cons 8 '()))
(check-expect (tock (cons 5 (cons 0 (cons 9 '())))) (cons 4 (cons 8 '())))

(define (tock w)
  (cond [(empty? w) '()]
        [(= (first w) 0) (tock (rest w))]
        [else (cons (sub1 (first w)) (tock (rest w)))]))

; ShotWorld KeyEvent -> ShotWorld
; adds a shot to the world if the space bar was hit
(check-expect (keyh (cons 9 '()) "left") (cons 9 '()))
(check-expect (keyh (cons 9 '()) " ") (cons HEIGHT (cons 9 '())))

(define (keyh w ke)
  (if (key=? ke " ") (cons HEIGHT w) w))

; ShotWorld -> Image 
; adds each shot y on w at (XSHOTS,y} to BACKGROUND
(check-expect (to-image (cons 9 '())) (place-image SHOT XSHOTS 9 BACKGROUND))

(define (to-image w)
  (cond [(empty? w) BACKGROUND]
        [else (place-image SHOT XSHOTS (first w) (to-image (rest w)))]))
