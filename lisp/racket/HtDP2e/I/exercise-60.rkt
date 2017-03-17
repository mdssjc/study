;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-60) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 60

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


; A N-TrafficLight is one of:
; – 0 interpretation the traffic light shows red
; – 1 interpretation the traffic light shows green
; – 2 interpretation the traffic light shows yellow


; TrafficLight -> TrafficLight
; simulates a clock-based American traffic light
(define (traffic-light-simulation initial-state)
  (big-bang initial-state
            [to-draw tl-render-numeric]
            [on-tick tl-next-numeric 1]))


; N-TrafficLight -> N-TrafficLight
; yields the next state given current state cs
(check-expect (tl-next-numeric 0) 1)
(check-expect (tl-next-numeric 1) 2)
(check-expect (tl-next-numeric 2) 0)

(define (tl-next-numeric cs) (modulo (+ cs 1) 3))
 
; TrafficLight -> Image
; renders the current state cs as an image
(check-expect (tl-render-numeric 0) RED-STATE)
(check-expect (tl-render-numeric 1) GREEN-STATE)
(check-expect (tl-render-numeric 2) YELLOW-STATE)

(define (tl-render-numeric current-state)
  (cond [(= current-state 0) RED-STATE]
        [(= current-state 1) GREEN-STATE]
        [(= current-state 2) YELLOW-STATE]))
