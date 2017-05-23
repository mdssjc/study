;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname tall-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; tall.rkt
;; HtDF L4

(require 2htdp/image)


;; PROBLEM:
;;
;; DESIGN a function that consumes an image and determines whether the
;; image is tall.
;;
;; Remember, when we say DESIGN, we mean follow the recipe.
;;
;; Leave behind commented out versions of the stub and template.

;; Image -> Boolean
;; Produce true if the image is tall (height is greater than width)
(check-expect (tall? (rectangle 2 3 "solid" "red")) true)
(check-expect (tall? (rectangle 3 2 "solid" "red")) false)
(check-expect (tall? (rectangle 3 3 "solid" "red")) false)

;(define (tall? img) false) ; Stub

;(define (tall? img)        ; Template
;  (... img))

;(define (tall? img)
; (> (image-height img) (image-width img))
;      true
;      false))

(define (tall? img)
  (> (image-height img) (image-width img)))
