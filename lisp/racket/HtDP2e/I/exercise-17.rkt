;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-17) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 17

(require 2htdp/image)

(define rh (rectangle 10 20 "solid" "black"))
(define rw (rectangle 20 10 "solid" "black"))
(define rs (rectangle 20 20 "solid" "black"))

(define (image-classify img)
  (cond [(> (image-height img) (image-width img))  "tall"]
        [(> (image-width img)  (image-height img)) "wide"]
        [else "square"]))

(check-expect (image-classify rh) "tall")
(check-expect (image-classify rw) "wide")
(check-expect (image-classify rs) "square")
