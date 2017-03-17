;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname traffic-light-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)
(require 2htdp/universe)

;; traffic-light-starter.rkt

; 
; PROBLEM:
; 
; Design an animation of a traffic light. 
; 
; Your program should show a traffic light that is red, then green, 
; then yellow, then red etc. For this program, your changing world 
; state data definition should be an enumeration.
; 
; Here is what your program might look like if the initial world 
; state was the red traffic light:
; .
; Next:
; .
; Next:
; .
; Next is red, and so on.
; 
; To make your lights change at a reasonable speed, you can use the 
; rate option to on-tick. If you say, for example, (on-tick next-color 1) 
; then big-bang will wait 1 second between calls to next-color.
; 
; Remember to follow the HtDW recipe! Be sure to do a proper domain 
; analysis before starting to work on the code file.
; 
; Note: If you want to design a slightly simpler version of the program,
; you can modify it to display a single circle that changes color, rather
; than three stacked circles. 
; 


;; HtDW P2 - Traffic Light

;; =================
;; Constants:
(define RED-STATE    .)
(define YELLOW-STATE .)
(define GREEN-STATE  .)
(define WIDTH  200)
(define HEIGHT 200)
(define POS-X (/ WIDTH  2))
(define POS-Y (/ HEIGHT 2))
(define MTS (empty-scene WIDTH HEIGHT))

;; =================
;; Data definitions:

;; TrafficLight is one of:
;;  - "red"
;;  - "yellow"
;;  - "green"
;; interp. states of a traffic light

;; <examples are redundant for enumerations>

#;
(define (fn-to-traffic-light tl)
  (cond [(string=? "red"    tl) (...)]
        [(string=? "yellow" tl) (...)]
        [(string=? "green"  tl) (...)]))

;; Template rules used:
;;  - one of: 3 cases
;;  - atomic distinct: "red"
;;  - atomic distinct: "yellow"
;;  - atomic distinct: "green"

;; =================
;; Functions:

;; TrafficLight -> TrafficLight
;; start the world with (main "red")
;; 
(define (main tl)
  (big-bang tl                    ; TrafficLight
            (on-tick   next 3)    ; TrafficLight -> TrafficLight
            (to-draw   render)))  ; TrafficLight -> Image

;; TrafficLight -> TrafficLight
;; produce the next state of traffic light
(check-expect (next "red")    "green")
(check-expect (next "green")  "yellow")
(check-expect (next "yellow") "red")

;(define (next tl) "red") ; Stub

;<template from TrafficLight>

(define (next tl)
  (cond [(string=? "red"    tl) "green"]
        [(string=? "yellow" tl) "red"]
        [(string=? "green"  tl) "yellow"]))

;; TrafficLight -> Image
;; render the traffic light image at appropriate place on MTS 
(check-expect (render "red")    (place-image RED-STATE POS-X POS-Y MTS))
(check-expect (render "yellow") (place-image YELLOW-STATE POS-X POS-Y MTS))
(check-expect (render "green")  (place-image GREEN-STATE POS-X POS-Y MTS))

;(define (render tl) MTS) ; Stub

;<template from TrafficLight>

(define (render tl)
  (cond [(string=? "red"    tl) (place-image RED-STATE POS-X POS-Y MTS)]
        [(string=? "yellow" tl) (place-image YELLOW-STATE POS-X POS-Y MTS)]
        [(string=? "green"  tl) (place-image GREEN-STATE POS-X POS-Y MTS)]))
