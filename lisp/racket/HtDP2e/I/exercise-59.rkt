;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-59) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 59

(require 2htdp/image)
(require 2htdp/universe)


; Constants
(define BULB-SIZE 8)
(define SPACE (rectangle  5  2 "solid"   "white"))
(define BOARD (rectangle 80 30 "outline" "black"))
(define RED-STATE (overlay (beside SPACE
                                   (circle BULB-SIZE "solid"   "red")
                                   SPACE
                                   (circle BULB-SIZE "outline" "yellow")
                                   SPACE
                                   (circle BULB-SIZE "outline" "green")
                                   SPACE)
                           BOARD))
(define GREEN-STATE (overlay (beside SPACE
                                     (circle BULB-SIZE "outline" "red")
                                     SPACE
                                     (circle BULB-SIZE "outline" "yellow")
                                     SPACE
                                     (circle BULB-SIZE "solid"   "green")
                                     SPACE)
                             BOARD))
(define YELLOW-STATE (overlay (beside SPACE
                                      (circle BULB-SIZE "outline" "red")
                                      SPACE
                                      (circle BULB-SIZE "solid"   "yellow")
                                      SPACE
                                      (circle BULB-SIZE "outline" "green")
                                      SPACE)
                              BOARD))


; A TrafficLight is one of the following Strings:
; – "red"
; – "green"
; – "yellow"
; interpretation the three strings represent the three 
; possible states that a traffic light may assume


; TrafficLight -> TrafficLight
; simulates a clock-based American traffic light
(define (traffic-light-simulation initial-state)
  (big-bang initial-state
            [to-draw tl-render]
            [on-tick tl-next 1]))


; TrafficLight -> TrafficLight
; yields the next state given current state cs
(check-expect (tl-next "red")    "green")
(check-expect (tl-next "green")  "yellow")
(check-expect (tl-next "yellow") "red")

(define (tl-next cs)
  (cond [(string=? cs "red")    "green"]
        [(string=? cs "green")  "yellow"]
        [(string=? cs "yellow") "red"]))
 
; TrafficLight -> Image
; renders the current state cs as an image
(check-expect (tl-render "red")    RED-STATE)
(check-expect (tl-render "green")  GREEN-STATE)
(check-expect (tl-render "yellow") YELLOW-STATE)

(define (tl-render current-state)
  (cond [(string=? current-state "red")    RED-STATE]
        [(string=? current-state "green")  GREEN-STATE]
        [(string=? current-state "yellow") YELLOW-STATE]))
