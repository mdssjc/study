;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname image-list) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; image-list.rkt
;; Self-Reference P6 - Image List

(require 2htdp/image)


;; =================
;; Data definitions:

;; PROBLEM A:
;;
;; Design a data definition to represent a list of images. Call it ListOfImage.

;; ListOfImage is one of:
;;  - empty
;;  - (cons Image ListOfImage)
;; interp. a list of images
(define LOI1 empty)
(define LOI2 (cons (square 5 "solid" "black") empty))
(define LOI3 (cons (square 5 "solid" "black") (cons (square 4 "solid" "red") empty)))

#;
(define (fn-for-loi loi)
  (cond [(empty? loi) (...)]
        [else (... (first loi)
                   (fn-for-loi (rest loi)))]))

;; Template rules used:
;;  - one of: 2 cases
;;  - atomic distinct: empty
;;  - compound: (cons Image ListOfImage)
;;  - self-reference: (rest loi) is ListOfImage


;; =================
;; Functions:

;; PROBLEM B:
;;
;; Design a function that consumes a list of images and produces a number
;; that is the sum of the areas of each image. For area, just use the image's
;; width times its height.

;; ListOfImage -> Number
;; produces a number that is the sum of the areas of each image
(check-expect (sum-areas LOI1) 0)
(check-expect (sum-areas LOI2) (* 5 5))
(check-expect (sum-areas LOI3) (+ (* 5 5) (* 4 4)))

;(define (sum-areas loi) 0) ; stub

(define (sum-areas loi)
  (cond [(empty? loi) 0]
        [else (+ (* (image-width (first loi))
                    (image-height (first loi)))
                 (sum-areas (rest loi)))]))
