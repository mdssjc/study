;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname htdf-with-non-primitive-data) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)

;; Icon is Image
;; interp. the image of an icon
(define RUNNING-STICKMAN-ICON .)
(define STEP-ICON .)

#;
(define (fn-for-icon i)
  (... i))

;; Template rules used:
;;  - atomic non-distinct: Image

;; Icon -> Boolean
;; produce true if the given icon is more than 30 pixels high
(check-expect (too-tall? STEP-ICON) false)
(check-expect (too-tall? RUNNING-STICKMAN-ICON) true)

;(define (too-tall? i) false)   ;stub

(define (too-tall? i)
  (> (image-height i) 30))
