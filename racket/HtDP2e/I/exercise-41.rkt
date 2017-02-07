;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-41) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 41

(require 2htdp/image)
(require 2htdp/universe)

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

(define WIDTH (* (image-width CAR) 10))
(define HEIGHT (image-height CAR))

(define TREE
  (underlay/xy (circle 10 "solid" "green")
               9 15
               (rectangle 2 20 "solid" "brown")))

(define Y-CAR (/ HEIGHT 2))
(define X-TREE (- WIDTH (/ (image-width CAR) 2)))

(define BACKGROUND (overlay/align
                    "right" "bottom"
                    TREE
                    (rectangle WIDTH HEIGHT "solid" "white")))

; WorldState -> WorldState
; launches the program from some initial state 
(define (main ws)
  (big-bang ws
            [on-tick tock]
            [to-draw render]
            [stop-when stop?]))

; WorldState -> WorldState 
; moves the car by 3 pixels for every clock  tick
; examples: 
;   given: 20, expect 23
;   given: 78, expect 81
(check-expect (tock 20) 23)
(check-expect (tock 78) 81)

(define (tock ws)
  (+ ws 3))

; WorldState -> Image
; places the car into the BACKGROUND scene,
; according to the given world state
(check-expect (render 50)  (place-image CAR  50 Y-CAR BACKGROUND))
(check-expect (render 100) (place-image CAR 100 Y-CAR BACKGROUND))
(check-expect (render 150) (place-image CAR 150 Y-CAR BACKGROUND))
(check-expect (render 200) (place-image CAR 200 Y-CAR BACKGROUND))

(define (render ws)
  (place-image CAR ws Y-CAR BACKGROUND))

; WorldState -> Boolean
; checks if the car has collided with the tree
(check-expect (stop? 20)     (>= 20 X-TREE))
(check-expect (stop? X-TREE) (>= X-TREE X-TREE))

(define (stop? ws)
  (>= ws X-TREE))

(main 0)