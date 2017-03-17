;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-44) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 44

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

(define WIDTH  (* (image-width CAR) 10))
(define HEIGHT (*(image-height CAR) 2))

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
(define AS1 10)

; AnimationState -> AnimationState
; launches the program from some initial state 
(define (main as)
  (big-bang as
            [on-tick tock]
            [to-draw render]
            [stop-when stop?]
            [on-mouse hyper]))

; AnimationState -> AnimationState 
; moves the car by 3 pixels for every clock tick
(check-expect (tock 20) 23)
(check-expect (tock 78) 81)

(define (tock as)
  (+ as 3))

; AnimationState -> Image
; places the car into the BACKGROUND scene,
; according to the given world state
(check-expect (render 50)  (place-image CAR (+  50 (image-width CAR)) (jump  50) BACKGROUND))
(check-expect (render 100) (place-image CAR (+ 100 (image-width CAR)) (jump 100) BACKGROUND))
(check-expect (render 150) (place-image CAR (+ 150 (image-width CAR)) (jump 150) BACKGROUND))
(check-expect (render 200) (place-image CAR (+ 200 (image-width CAR)) (jump 200) BACKGROUND))

(define (render as)
  (place-image CAR (+ as (image-width CAR)) (jump as) BACKGROUND))

;; AnimationState -> Number
;; produce the Y position of the car given an AnimationState
(define (jump as)
  (+ (/ HEIGHT 2) (* 10 (sin as))))

; AnimationState -> Boolean
; checks if the car has collided with the tree
(check-expect (stop? 20)     (>= 20 X-TREE))
(check-expect (stop? X-TREE) (>= X-TREE X-TREE))

(define (stop? as)
  (>= (+ as (image-width CAR)) X-TREE))

; AnimationState Number Number String -> AnimationState
; places the car at the x-coordinate 
; if the given me is "button-down"
(check-expect (hyper 21 10 20 "enter") 21)
(check-expect (hyper 42 10 20 "button-down") (- 10 (image-width CAR)))
(check-expect (hyper 42 10 20 "move") 42)

(define (hyper x-position-of-car x-mouse y-mouse me)
  (cond
    [(string=? "button-down" me) (- x-mouse (image-width CAR))]
    [else x-position-of-car]))

(main 0)
