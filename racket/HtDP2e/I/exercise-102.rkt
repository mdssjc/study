;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-102) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 102

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define UFO      (overlay (rectangle 70 10 "solid" "green")
                          (circle 20 "solid" "green")))
(define UFO-X (/ (image-width  UFO) 2))
(define UFO-Y (/ (image-height UFO) 2))
(define TANK-HEIGHT 20)
(define TANK     (rectangle 50 TANK-HEIGHT "solid" "blue"))
(define MISSILE (triangle 10 "solid" "red"))
(define WIDTH  400)
(define HEIGHT 300)
(define CLOSE (/ HEIGHT 3))
(define BACKGROUND (empty-scene WIDTH HEIGHT))


; A UFO is a Posn. 
; interpretation (make-posn x y) is the UFO's location 
; (using the top-down, left-to-right convention)
 
(define-struct tank [loc vel])
; A Tank is a structure:
;   (make-tank Number Number). 
; interpretation (make-tank x dx) specifies the position:
; (x, HEIGHT) and the tank's speed: dx pixels/tick

; A MissileOrNot is one of:
; – #false
; – Posn
; interpretation#false means the missile is in the tank;
; Posn says the missile is at that location.

(define-struct sigs [ufo tank missile])
; A SIGS.v2 (short for SIGS version 2) is a structure:
;   (make-sigs UFO Tank MissileOrNot)
; interpretation represents the complete state of a
; space invader game
(define S1 (make-sigs (make-posn 10 20)
                      (make-tank 28 -3)
                      #false))
(define S2 (make-sigs (make-posn 10 20)
                      (make-tank 28 -3)
                      (make-posn 32 (- HEIGHT TANK-HEIGHT 10))))
(define S3 (make-sigs (make-posn 20 100)
                      (make-tank 100 3)
                      (make-posn 22 120)))
(define S4 (make-sigs (make-posn 10 (- HEIGHT CLOSE))
                      (make-tank 28 -3)
                      #false))


; SIGS.v2 -> SIGS.v2
; starts the world with (main S1)
(define (main s)
  (big-bang s
            (on-tick   si-move)
            (on-draw   si-render.v2)
            (on-key    si-control)
            (stop-when si-game-over?)))

; SIGS.v2 -> SIGS.v2
; updates the position of objects
(check-random (si-move S1) (make-sigs
                            (make-posn (random (+ (posn-x (sigs-ufo S1))
                                                  (image-width  UFO))) 21)
                            (make-tank 25 -3)
                            #false))
(check-random (si-move S2) (make-sigs
                            (make-posn (random (+ (posn-x (sigs-ufo S2))
                                                  (image-width  UFO))) 21)
                            (make-tank 25 -3)
                            (make-posn 32 (sub1 (- HEIGHT TANK-HEIGHT 10)))))

(define (si-move s)
  (si-move-proper s (random (+ (posn-x (sigs-ufo s))
                               (image-width  UFO)))))

; Number -> Number
; produces a number in the interval [0,n),
; possibly a different one each time it is called 
; (define (random n) ...)

; SIGS.v2 Number -> SIGS.v2 
; moves the space-invader objects predictably by delta
(define (si-move-proper s delta)
  (make-sigs (update-ufo (sigs-ufo s) delta)
             (update-tank (sigs-tank s))
             (update-missile (sigs-missile s))))

; UFO Number -> UFO
; updates the UFO by a value
(check-expect (update-ufo (make-posn 1 1) 2) (make-posn 2 2))
(check-expect (update-ufo (make-posn 0 1) 0) (make-posn 1 2))

(define (update-ufo u v)
  (make-posn (if (= v 0) 1 v) (add1 (posn-y u))))

; Tank -> Tank
; updates the Tank
(check-expect (update-tank (make-tank 0 -1))    (make-tank 0 -1))
(check-expect (update-tank (make-tank WIDTH 1)) (make-tank WIDTH 1))
(check-expect (update-tank (make-tank 5 -1))    (make-tank 4 -1))
(check-expect (update-tank (make-tank 5  1))    (make-tank 6 1))

(define (update-tank t)
  (make-tank (cond [(<   (+ (tank-loc t) (tank-vel t)) 0) 0]
                   [(>   (+ (tank-loc t) (tank-vel t)) WIDTH) WIDTH]
                   [else (+ (tank-loc t) (tank-vel t))])
             (tank-vel t)))

; Missile -> Missile
; updates the missile
(define (update-missile m)
  (cond [(boolean? m) m]
        [(posn? m) (make-posn (posn-x m) (sub1 (posn-y m)))]))

; SIGS.v2 -> Image 
; renders the given game state on top of BACKGROUND
(check-expect (si-render.v2 S1) (place-image UFO 10 20
                                             (place-image TANK 28 HEIGHT
                                                          BACKGROUND)))
(check-expect (si-render.v2 S2) (place-image UFO 10 20
                                             (place-image TANK 28 HEIGHT
                                                          (place-image MISSILE 32 (- HEIGHT TANK-HEIGHT 10)
                                                                       BACKGROUND))))

(define (si-render.v2 s)
  (tank-render
   (sigs-tank s)
   (ufo-render (sigs-ufo s)
               (missile-render.v2 (sigs-missile s)
                                  BACKGROUND))))

; Tank Image -> Image 
; adds t to the given image im
(define (tank-render t im)
  (place-image TANK (tank-loc t) HEIGHT im))
 
; UFO Image -> Image 
; adds u to the given image im
(define (ufo-render u im)
  (place-image UFO (posn-x u) (posn-y u) im))

; MissileOrNot Image -> Image 
; adds an image of missile m to scene s
(define (missile-render.v2 m s)
  (cond [(boolean? m) s]
        [(posn? m) (place-image MISSILE (posn-x m) (posn-y m) s)]))

; SIGS.v2 KeyEvent -> SIGS.v2
; handles the main events:
; - pressing the left arrow ensures that the tank moves left;
; - pressing the right arrow ensures that the tank moves right; and
; - pressing the space bar fires the missile if it hasn’t been launched yet.
(define (si-control s ke)
  (cond [(or (key=? ke "left")
             (key=? ke "right"))
         (make-sigs (sigs-ufo s)
                    (make-tank (tank-loc (sigs-tank s))
                               (tank-direction (if (string=? ke "left")
                                                   "l" "r")
                                               (tank-vel (sigs-tank s))))
                    (sigs-missile s))]
        [(key=? ke " ")
         (make-sigs (sigs-ufo s)
                    (sigs-tank s)
                    (make-posn (tank-loc (sigs-tank s))
                               (- HEIGHT TANK-HEIGHT)))]
        [else s]))

; String Number -> Number
; updates the speed direction, "l" to left and "r" to right
(check-expect (tank-direction "l"  10) -10)
(check-expect (tank-direction "l" -10) -10)
(check-expect (tank-direction "r"  10)  10)
(check-expect (tank-direction "r" -10)  10)

(define (tank-direction d v)
  (cond [(string=? d "l") (if (negative? v)
                              v
                              (* v -1))]
        [(string=? d "r") (if (negative? v)
                              (* v -1)
                              v)]))

; SIGS.v2 -> Boolean
; returns true when the game stop;
; the game stops if the UFO lands or if the missile hits the UFO
(check-expect (si-game-over? S1) #false)
(check-expect (si-game-over? S2) #false)
(check-expect (si-game-over? S3) #true)
(check-expect (si-game-over? S4) #true)

(define (si-game-over? s)
  (cond
    [(>= (posn-y (sigs-ufo s)) (- HEIGHT CLOSE)) #true]
    [(and (posn? (sigs-missile s))
          (<= (- (posn-x (sigs-ufo s)) UFO-X)
              (posn-x (sigs-missile s))
              (+ (posn-x (sigs-ufo s)) UFO-X))
          (<= (- (posn-y (sigs-ufo s)) UFO-Y)
              (posn-y (sigs-missile s))
              (+ (posn-y (sigs-ufo s)) UFO-Y))) #true]
    [else #false]))
