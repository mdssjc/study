;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-43) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 42

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

; An AnimationState is a Number.
; interpretation the number of clock ticks 
; since the animation started


; AnimationState -> AnimationState
; launches the program from some initial state 
(define (main as)
  (big-bang as
            [on-tick tock]
            [to-draw render]))

; AnimationState -> AnimationState 
; moves the car by 3 pixels for every clock tick
(check-expect (tock 20) 20.1)
(check-expect (tock 78) 78.1)

(define (tock as)
  (+ as 0.1))

; AnimationState -> Image
; places the car into the BACKGROUND scene,
; according to the given world state
(check-expect (render 50)  (place-image CAR (+ (* (sin  50) (/ WIDTH 2)) (/ WIDTH 2)) Y-CAR BACKGROUND))
(check-expect (render 100) (place-image CAR (+ (* (sin 100) (/ WIDTH 2)) (/ WIDTH 2)) Y-CAR BACKGROUND))
(check-expect (render 150) (place-image CAR (+ (* (sin 150) (/ WIDTH 2)) (/ WIDTH 2)) Y-CAR BACKGROUND))
(check-expect (render 200) (place-image CAR (+ (* (sin 200) (/ WIDTH 2)) (/ WIDTH 2)) Y-CAR BACKGROUND))

(define (render as)
  (place-image CAR
               (+ (* (sin as) (/ WIDTH 2)) (/ WIDTH 2))
               Y-CAR BACKGROUND))

(main 0)
