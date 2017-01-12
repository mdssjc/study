;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname quiz) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)

;; quiz.rkt

; PROBLEM:
; 
; Design a function that consumes two images and produces true if the first is larger than the second.


;; Image Image -> Boolean
;; Produce a boolean (true) if the first image is larger than the second image.
(check-expect (larger? (rectangle 10 10 "solid" "red")
                       (rectangle 10 10 "solid" "green")) false)
(check-expect (larger? (rectangle 10 40 "solid" "red")
                       (rectangle 10 20 "solid" "green")) true)
(check-expect (larger? (rectangle 40 10 "solid" "red")
                       (rectangle 20 10 "solid" "green")) true)
(check-expect (larger? (rectangle 10 20 "solid" "red")
                       (rectangle 10 40 "solid" "green")) false)
(check-expect (larger? (rectangle 20 10 "solid" "red")
                       (rectangle 40 10 "solid" "green")) false)
(check-expect (larger? (rectangle 10 40 "solid" "red")
                       (rectangle 20 30 "solid" "green")) false)
(check-expect (larger? (rectangle 40 10 "solid" "red")
                       (rectangle 30 20 "solid" "green")) false)
(check-expect (larger? (rectangle 20 30 "solid" "red")
                       (rectangle 10 40 "solid" "green")) true)
(check-expect (larger? (rectangle 30 20 "solid" "red")
                       (rectangle 40 10 "solid" "green")) true)

;(define (larger? img1 img2) false) ; Stub

;(define (larger? img1 img2)        ; Template
;  (... img1 img2))

(define (larger? img1 img2)
  (> (* (image-width img1) (image-height img1))
     (* (image-width img2) (image-height img2))))
