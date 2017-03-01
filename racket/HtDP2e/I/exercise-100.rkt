;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-100) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 100

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
 
; A Missile is a Posn. 
; interpretation (make-posn x y) is the missile's place

(define-struct aim [ufo tank])
(define-struct fired [ufo tank missile])
; A SIGS is one of: 
; - (make-aim UFO Tank)
; - (make-fired UFO Tank Missile)
; interpretation represents the complete state of a 
; space invader game
(define S1 (make-aim
            (make-posn 10 20)
            (make-tank 28 -3)))
(define S2 (make-fired
            (make-posn 20 100)
            (make-tank 100 3)
            (make-posn 22 120)))
(define S3 (make-fired
            (make-posn 10 20)
            (make-tank 28 -3)
            (make-posn 32 (- HEIGHT TANK-HEIGHT 10))))
(define S4 (make-aim
            (make-posn 10 (- HEIGHT CLOSE))
            (make-tank 28 -3)))


; SIGS -> SIGS
; starts the world with (main S1)
(define (main s)
  (big-bang s
            (on-tick   si-move)
            (on-draw   si-render)
            (on-key    si-control)
            (stop-when si-game-over?)))

; SIGS -> SIGS
; updates the position of objects
(check-random (si-move S1) (make-aim
                            (make-posn (random (+ (posn-x (aim-ufo S1))
                                                  (image-width  UFO))) 21)
                            (make-tank 25 -3)))
(check-random (si-move S2) (make-fired
                            (make-posn (random (+ (posn-x (fired-ufo S2))
                                                  (image-width  UFO))) 101)
                            (make-tank 103 3)
                            (make-posn 22 119)))

(define (si-move s)
  (si-move-proper s (random (cond [(aim?   s) (+ (posn-x (aim-ufo s))
                                                 (image-width  UFO))]
                                  [(fired? s) (+ (posn-x (fired-ufo s))
                                                 (image-width  UFO))]))))

; Number -> Number
; produces a number in the interval [0,n),
; possibly a different one each time it is called 
; (define (random n) ...)

; SIGS Number -> SIGS 
; moves the space-invader objects predictably by delta
(define (si-move-proper s delta)
  (cond [(aim?   s) (make-aim (update-ufo (aim-ufo s) delta)
                              (update-tank (aim-tank s)))]
        [(fired? s) (make-fired (update-ufo (fired-ufo s) delta)
                                (update-tank (fired-tank s))
                                (update-missile (fired-missile s)))]))

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
  (make-posn (posn-x m) (sub1 (posn-y m))))

; SIGS -> Image
; renders the given game state on top of BACKGROUND
(define (si-render s)
  (cond
    [(aim? s) (tank-render (aim-tank s)
                           (ufo-render (aim-ufo s) BACKGROUND))]
    [(fired? s) (tank-render
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

; SIGS KeyEvent -> SIGS
; handles the main events:
; - pressing the left arrow ensures that the tank moves left;
; - pressing the right arrow ensures that the tank moves right; and
; - pressing the space bar fires the missile if it hasn’t been launched yet.
(define (si-control s ke)
  (cond [(or (key=? ke "left")
             (key=? ke "right"))
         (cond [(aim?   s) (make-aim (aim-ufo s)
                                     (make-tank (tank-loc (aim-tank s))
                                                (tank-direction (if (string=? ke "left")
                                                                    "l" "r")
                                                                (tank-vel (aim-tank s)))))]
               [(fired? s) (make-fired (fired-ufo s)
                                       (make-tank (tank-loc (fired-tank s))
                                                  (tank-direction (if (string=? ke "left")
                                                                      "l" "r")
                                                                  (tank-vel (fired-tank s))))
                                       (fired-missile s))])]
        [(key=? ke " ")
         (cond [(aim? s) (make-fired (aim-ufo s)
                                     (aim-tank s)
                                     (make-posn (tank-loc (aim-tank s))
                                                (- HEIGHT TANK-HEIGHT)))]
               [(fired? s) (make-fired (fired-ufo s)
                                       (fired-tank s)
                                       (make-posn (tank-loc (fired-tank s))
                                                  (- HEIGHT TANK-HEIGHT)))])]
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

; SIGS -> Boolean
; returns true when the game stop;
; the game stops if the UFO lands or if the missile hits the UFO
(check-expect (si-game-over? S1) #false)
(check-expect (si-game-over? S2) #true)
(check-expect (si-game-over? S3) #false)
(check-expect (si-game-over? S4) #true)

(define (si-game-over? s)
  (cond
    [(aim? s)
     (cond
       [(>= (posn-y (aim-ufo s)) (- HEIGHT CLOSE)) #true]
       [else #false])]
    [(fired? s)
     (cond
       [(>= (posn-y (fired-ufo s)) (- HEIGHT CLOSE)) #true]
       [(and (<= (- (posn-x (fired-ufo s)) UFO-X)
                 (posn-x (fired-missile s))
                 (+ (posn-x (fired-ufo s)) UFO-X))
             (<= (- (posn-y (fired-ufo s)) UFO-Y)
                 (posn-y (fired-missile s))
                 (+ (posn-y (fired-ufo s)) UFO-Y))) #true]
       [else #false])]
    [else #false]))

; SIGS -> Image
(define (si-render-final s)
  (si-render s))
