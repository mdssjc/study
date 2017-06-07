;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname decreasing-image) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; decreasing-image.rkt
;; Naturals P2 - Decreasing Image

(require 2htdp/image)


;; PROBLEM:
;;
;; Design a function called decreasing-image that consumes a Natural n
;; and produces an image of all the numbers from n to 0 side by side.
;;
;; So (decreasing-image 3) should produce [Image 3210]

;; Natural -> Image
;; produces an image of all the numbers from n to 0 side by side
(check-expect (decreasing-image 3) (text "3210" 14 "black"))

;(define (decreasing-image n) empty-image) ; Stub

(define (decreasing-image n)
  (cond [(zero? n) (text "0" 14 "black")]
        [else (beside (text (number->string n) 14 "black")
                      (decreasing-image (sub1 n)))]))
