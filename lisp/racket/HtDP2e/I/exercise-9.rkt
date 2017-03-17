;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-9) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 9
(require 2htdp/image)

(define in "hello")

(define (convert x)
  (cond [(string? x) (string-length x)]
        [(image? x) (* (image-width x) (image-height x))]
        [(number? x) (if (> x 0)
                         (- x 1)
                         x)]
        [(boolean? x) (if x 10 20)]))

(convert in)
(convert (rectangle 10 10 "solid" "black"))
(convert 10)
(convert 0)
(convert -1)
(convert #true)
(convert #false)
