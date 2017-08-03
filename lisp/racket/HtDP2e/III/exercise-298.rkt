;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-298) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 298

(require 2htdp/image)
(require 2htdp/universe)


; An ImageStream is a function: 
;   [N -> Image]
; interpretation a stream s denotes a series of images

; ImageStream
(define (create-rocket-scene height)
  (place-image (circle 5 "solid" "blue") 50 height (empty-scene 60 60)))


; ImageStream Number -> Image
; consumes the representation of a stream of images, one per natural number
(define (my-animate s n)
  ((lambda (n)
     (big-bang n
               (on-tick add1)
               (to-draw s)))
   n))


; Test drive
(my-animate create-rocket-scene 0)
