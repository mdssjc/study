;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-142) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 142

(require 2htdp/image)

; Constants
(define I1 (rectangle 10 10 "solid" "black")) ; 10x10
(define I2 (rectangle 20 20 "solid" "black")) ; 20x20
(define I3 (rectangle 30 30 "solid" "black")) ; 30x30

; A List-of-images is one of: 
; - '()
; - (cons Image List-of-images)
(define LOI1 '())
(define LOI2 (cons I1 '()))
(define LOI3 (cons I1 (cons I2 '())))
(define LOI4 (cons I1 (cons I2 (cons I3 '()))))

; ImageOrFalse is one of:
; - Image
; - #false


; List-of-images -> ImageOrFalse
; produces the first image on loi that is not an n by n square;
; if it cannot find such an image, it produces false
(check-expect (ill-sized? LOI1 20) #false)
(check-expect (ill-sized? LOI2 20) #false)
(check-expect (ill-sized? LOI3 20) I2)
(check-expect (ill-sized? LOI4 30) I3)

(define (ill-sized? loi n)
  (cond [(empty? loi) #false]
        [(= (image-width (first loi)) n) (first loi)]
        [else (ill-sized? (rest loi) n)]))
