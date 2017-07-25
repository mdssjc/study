;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname wide-only) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; wide-only.rkt
;; Abstraction P1 - Wide Only
;; Design a function to produce only wide images from a list of
;; images.

(require 2htdp/image)


;; PROBLEM:
;;
;; Use the built in version of filter to design a function called
;; wide-only that consumes a list of images and produces a list
;; containing only those images that are wider than they are tall.

(define I1 (rectangle 5 10 "solid" "red"))
(define I2 (rectangle 10 10 "solid" "green"))
(define I3 (rectangle 15 10 "solid" "blue"))
(define I4 (rectangle 20 10 "solid" "gray"))

(define LOI (list I1 I2 I3 I4))


;; (listof Image) -> (listof Image)
;; produces a list containing only those images that are wider than
;; they are tall
(check-expect (wide-only empty) empty)
(check-expect (wide-only LOI) (list I3 I4))
(check-expect (wide-only (list I1)) empty)
(check-expect (wide-only (list I3)) (list I3))

;(define (wide-only loi) empty) ; Stub

(define (wide-only loi)
  (local ((define (wide? i)
            (> (image-width i) (image-height i))))
    (filter wide? loi)))
