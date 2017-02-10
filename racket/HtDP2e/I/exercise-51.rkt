;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-51) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 51

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define WIDTH  400)
(define HEIGHT 200)
(define MTS (empty-scene WIDTH HEIGHT))

; TrafficLight -> TrafficLight
; start the world with (main "red")
;
(define (main tl)
  (big-bang tl
            (on-tick traffic-light-next 3)
            (on-draw render)))

; TrafficLight -> TrafficLight
; yields the next state given current state s
(check-expect (traffic-light-next "red")    "green")
(check-expect (traffic-light-next "green")  "yellow")
(check-expect (traffic-light-next "yellow") "red")

(define (traffic-light-next s)
  (cond
    [(string=? "red"    s) "green"]
    [(string=? "green"  s) "yellow"]
    [(string=? "yellow" s) "red"]))

; TrafficLight -> Image
; produces the traffic light image with world state
(define (render tl)
  (place-image (circle (/ HEIGHT 3) "solid" tl)
               (/ WIDTH  2)
               (/ HEIGHT 2)
               MTS))

(main "red")
