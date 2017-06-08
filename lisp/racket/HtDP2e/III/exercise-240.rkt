;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-240) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 240


(define-struct layer [stuff])

; A LStr is one of:
; - String
; - (make-layer LStr)
(define LS1 "word")
(define LS2 (make-layer LS1))
(define LS3 (make-layer (make-layer LS2)))

; A LNum is one of:
; - Number
; - (make-layer LNum)
(define LN1 1)
(define LN2 (make-layer LN1))
(define LN3 (make-layer (make-layer LN2)))

; A [L ITEM] is one of:
; - ITEM
; - (make-layer ITEM)

; A [L String] is one of:
; - String
; - (make-layer String)
(define LIS1 "word")
(define LIS2 (make-layer LIS1))
(define LIS3 (make-layer (make-layer LIS2)))

; A [L Number] is one of:
; - Number
; - (make-layer Number)
(define LIN1 1)
(define LIN2 (make-layer LIN1))
(define LIN3 (make-layer (make-layer LIN2)))


; Tests
(check-expect LIS1 LS1)
(check-expect LIS2 LS2)
(check-expect LIS3 LS3)

(check-expect LIN1 LN1)
(check-expect LIN2 LN2)
(check-expect LIN3 LN3)
