;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname 2-Functions and Programs) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 2-Functions and Programs.rkt
;; I - Fixed-Size Data
;; 2 - Functions and Programs

(require 2htdp/image)


;; 2.1 - Functions

;; Exercise 11

(define (distance x y)
  (sqrt (+ (sqr x) (sqr y))))

(check-expect (distance 3 4)   5)
(check-expect (distance 12 5) 13)

;; Exercise 12

(define (cvolume length)
  (* length length length))

(define (csurface length)
  (* 6 (sqr length)))

(check-expect (cvolume  3) (* 3 3 3))
(check-expect (csurface 3) (* 6 3 3))

