;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-36) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 36

(require 2htdp/image)

;; Image -> Number
;; counts the number of pixels in a given image
(check-expect (image-area (square 100 "solid" "black")) (* 100 100))

(define (image-area i)
  (* (image-width i) (image-height i)))
