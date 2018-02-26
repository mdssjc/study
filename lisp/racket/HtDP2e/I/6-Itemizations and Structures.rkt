;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |6-Itemizations and Structures|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 6-Itemizations and Structures.rkt
;; I - Fixed-Size Data
;; 6 Itemizations and Structures

(require 2htdp/image)
(require 2htdp/universe)


;; 6.1 - Designing with Itemizations, Again

;; Exercise 94

;; =================
;; Constants:

(define UFO (overlay (rectangle 70 10 "solid" "green")
                     (circle 20 "solid" "green")))
(define TANK-HEIGHT 20)
(define TANK    (rectangle 50 TANK-HEIGHT "solid" "blue"))
(define MISSILE (triangle 10 "solid" "red"))
(define WIDTH  400)
(define HEIGHT 300)
(define CLOSE (/ HEIGHT 3))
(define BACKGROUND (empty-scene WIDTH HEIGHT))

;; Exercise 95

;; =================
;; Data definitions:

; A UFO is a Posn.
; interpretation (make-posn x y) is the UFO's location
; (using the top-down, left-to-right convention)

(define-struct tank [loc vel])
; A Tank is a structure:
;   (make-tank Number Number).
; interpretation (make-tank x dx) specifies the position:
; (x, HEIGHT) and the tank's speed: dx pixels/tick

; A Missile is a Posn.
; interpretation (make-posn x y) is the missile's place

(define-struct aim [ufo tank])
(define-struct fired [ufo tank missile])
; A SIGS is one of:
; - (make-aim UFO Tank)
; - (make-fired UFO Tank Missile)
; interpretation represents the complete state of a
; space invader game
(define S1 (make-aim   (make-posn 20 10) (make-tank 28 -3)))
(define S2 (make-fired (make-posn 20 10)
                       (make-tank 28 -3)
                       (make-posn 28 (- HEIGHT TANK-HEIGHT))))
(define S3 (make-fired (make-posn 20 100)
                       (make-tank 100 3)
                       (make-posn 22 103)))

;; The examples represent three states, being the movement of the Tank with its
;; aim, the firing of the missile and the collision with the UFO.

;; Exercise 96

;; Paper sketch of the three examples:
;; - aim: render the UFO and Tank;
;; - fired 1: render the UFO, Tank and Missile; and
;; - fired 2: render the Tank and collision between the UFO and the Missile.

;; Exercise 97

;; =================
;; Functions:

; SIGS -> Image
; renders the given game state on top of BACKGROUND
(define (si-render s)
  (cond
    [(aim? s)
     (tank-render (aim-tank s)
                  (ufo-render (aim-ufo s) BACKGROUND))]
    [(fired? s)
     (tank-render
      (fired-tank s)
      (ufo-render (fired-ufo s)
                  (missile-render (fired-missile s)
                                  BACKGROUND)))]))

; Tank Image -> Image
; adds t to the given image im
(define (tank-render t im)
  (place-image TANK (tank-loc t) HEIGHT im))

; UFO Image -> Image
; adds u to the given image im
(define (ufo-render u im)
  (place-image UFO (posn-x u) (posn-y u) im))

; Missile Image -> Image
; adds m to the given image im
(define (missile-render m im)
  (place-image MISSILE (posn-x m) (posn-y m) im))

; Tests
(define T1 (tank-render
            (fired-tank S2)
            (ufo-render (fired-ufo S2)
                        (missile-render (fired-missile S2)
                                        BACKGROUND))))
(define T2 (ufo-render
            (fired-ufo S2)
            (tank-render (fired-tank S2)
                         (missile-render (fired-missile S2)
                                         BACKGROUND))))
(check-expect T1 T2)
