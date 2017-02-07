;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-39) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 39

(require 2htdp/image)

(define WHEEL-RADIUS 5)
(define WHEEL-DISTANCE (* WHEEL-RADIUS 2))

(define WHEEL
  (circle WHEEL-RADIUS "solid" "black"))
(define SPACE
  (rectangle WHEEL-DISTANCE 0 "solid" "white"))
(define BOTH-WHEELS
  (beside WHEEL SPACE WHEEL))

(define BODY-A
  (rectangle (* WHEEL-RADIUS 8) (* WHEEL-RADIUS 3) "solid" "red"))
(define BODY-B
  (rectangle (* WHEEL-RADIUS 5) (* WHEEL-RADIUS 5) "solid" "red"))
(define CHASSIS (overlay/align "middle" "bottom" BODY-A BODY-B))

(define CAR (overlay/offset BOTH-WHEELS
                            0 (* (/ (image-height CHASSIS) 2) -1)
                            CHASSIS))
