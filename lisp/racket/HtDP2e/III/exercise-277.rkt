;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-277) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 277

(require 2htdp/image)
(require 2htdp/universe)


; Constants:

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


; Data definitions:

; An UFO is a Posn:
;   (make-posn Natural Natural)
; interpretation (make-posn x y) is the UFO's location
; (using the top-down, left-to-right convention)
(define U1 (make-posn 10 20))

(define-struct tank [loc vel])
; A Tank is a structure:
;   (make-tank Number Number)
; interpretation (make-tank x dx) specifies the position:
; (x, HEIGHT) and the tank's speed: dx pixels/tick
(define T-0L (make-tank 0 -1))           ; Tank 0 Left
(define T-0R (make-tank 0 1))            ; Tank 0 Right
(define T-ML (make-tank (/ WIDTH 2) -1)) ; Tank Middle Left
(define T-MR (make-tank (/ WIDTH 2)  1)) ; Tank Middle Right
(define T-WL (make-tank WIDTH -1))       ; Tank Width Left
(define T-WR (make-tank WIDTH  1))       ; Tank Width Right

; A Missile is a Posn:
;   (make-posn Natural Natural)
; interpretation (make-posn x y) is the Missile's location
; (using the top-down, left-to-right convention)
(define M1 (make-posn 10 50))
(define M2 (make-posn 50 20))

; A [List-of Missile] is one of:
; empty
; (cons Missile [List-of Missile])
; interpretation represents the missiles launched
(define LOM1 empty)
(define LOM2 (list M1 M2))

(define-struct sigs [ufo tank missiles])
; A SIGS is a structure:
;   (make-sigs UFO Tank [List-of Missile])
; interpretation represents the complete state of a space invader game
(define S1 (make-sigs U1 T-MR LOM1))
(define S2 (make-sigs U1 T-MR LOM2))
(define S3 (make-sigs (make-posn 10 20)
                      (make-tank 28 -3)
                      (list (make-posn 32 (- HEIGHT TANK-HEIGHT 10)))))
(define S4 (make-sigs (make-posn 20 100)
                      (make-tank 100 3)
                      (list (make-posn 22 120))))
(define S5 (make-sigs (make-posn 10 (- HEIGHT CLOSE))
                      (make-tank 28 -3)
                      empty))


; Functions:

; SIGS -> World
; starts a world with (main S1)
(define (main s)
  (big-bang s
            (on-tick   si-move)
            (on-draw   si-render)
            (on-key    si-control)
            (stop-when si-game-over?)))

; SIGS -> SIGS
; updates the position of objects
(define (si-move s)
  (local (;; UFO Number -> UFO
          ;; updates the position of UFO
          (define (update-ufo u)
            (make-posn (random (+ (posn-x u) (image-width UFO)))
                       (add1 (posn-y u))))
          ;; Tank -> Tank
          ;; updates the position of Tank
          (define (update-tank t)
            (local ((define sum-loc-vel (+ (tank-loc t) (tank-vel t))))
              (make-tank (cond [(<   sum-loc-vel 0) 0]
                               [(>   sum-loc-vel WIDTH) WIDTH]
                               [else sum-loc-vel])
                         (tank-vel t))))
          ;; Missile -> Missile
          ;; updates the position of missile
          (define (update-missile m)
            (make-posn (posn-x m) (sub1 (posn-y m)))))
    (make-sigs (update-ufo         (sigs-ufo s))
               (update-tank        (sigs-tank s))
               (map update-missile (sigs-missiles s)))))

; SIGS -> Image
; renders the given game state on top of BACKGROUND
(check-expect (si-render S1) (place-image UFO (posn-x (sigs-ufo S1)) (posn-y (sigs-ufo S1))
                                          (place-image TANK (tank-loc (sigs-tank S1)) HEIGHT BACKGROUND)))
(check-expect (si-render S2) (place-image UFO (posn-x (sigs-ufo S2)) (posn-y (sigs-ufo S2))
                                          (place-image TANK (tank-loc (sigs-tank S2)) HEIGHT
                                                       (place-image MISSILE (posn-x (first (sigs-missiles S2))) (posn-y (first (sigs-missiles S2)))
                                                                    (place-image MISSILE (posn-x (second (sigs-missiles S2))) (posn-y (second (sigs-missiles S2))) BACKGROUND)))))

(define (si-render s)
  (local (;; UFO Image -> Image
          ;; adds u to the given image im
          (define (ufo-render u im)
            (place-image UFO (posn-x u) (posn-y u) im))
          ; Tank Image -> Image
          ; adds t to the given image im
          (define (tank-render t im)
            (place-image TANK (tank-loc t) HEIGHT im))
          ; Missile Image -> Image
          ; adds m to the given image im
          (define (missile-render m im)
            (place-image MISSILE (posn-x m) (posn-y m) im)))
    (ufo-render (sigs-ufo s)
                (tank-render (sigs-tank s)
                             (foldr missile-render BACKGROUND (sigs-missiles s))))))

; SIGS KeyEvent -> SIGS
; handles the main events:
; - pressing the left arrow ensures that the tank moves left;
; - pressing the right arrow ensures that the tank moves right; and
; - pressing the space bar fires a new missile.
(check-expect (si-control S1 "up") S1)
(check-expect (si-control S1 "left") (make-sigs (sigs-ufo S1)
                                                (make-tank (tank-loc (sigs-tank S1))
                                                           (* -1 (tank-vel (sigs-tank S1))))
                                                (sigs-missiles S1)))
(check-expect (si-control S1 "right") (make-sigs (sigs-ufo S1)
                                                 (make-tank (tank-loc (sigs-tank S1))
                                                            (tank-vel (sigs-tank S1)))
                                                 (sigs-missiles S1)))
(check-expect (si-control S1 " ") (make-sigs (sigs-ufo S1)
                                             (sigs-tank S1)
                                             (list (make-posn (tank-loc (sigs-tank S1))
                                                              (- HEIGHT TANK-HEIGHT)))))

(define (si-control s ke)
  (local ((define tank (sigs-tank s))
          (define tank-location (tank-loc tank))
          (define tank-velocity (tank-vel tank))
          ;; Number -> Tank
          ;; changes the speed direction of tank
          (define (tank-direction d)
            (make-tank tank-location (* d (abs tank-velocity))))
          ;; [List-of Missile] -> [List-of Missile]
          ;; fires a missile at the coordinate: x and (- HEIGHT TANK-HEIGHT)
          (define (missiles-fire x lom)
            (append lom (cons (make-posn x (- HEIGHT TANK-HEIGHT)) empty)))
          ;; Trampoline
          (define (si-control s ke)
            (make-sigs (sigs-ufo s)
                       (cond [(key=? ke "left")  (tank-direction -1)]
                             [(key=? ke "right") (tank-direction  1)]
                             [else
                              (sigs-tank s)])
                       (cond [(key=? ke " ")
                              (missiles-fire tank-location (sigs-missiles s))]
                             [else
                              (sigs-missiles s)]))))
    (si-control s ke)))

; SIGS -> Boolean
; returns true when the game stop;
; the game stops if the UFO lands or if the missile hits the UFO
(check-expect (si-game-over? S1) #false)
(check-expect (si-game-over? S2) #false)
(check-expect (si-game-over? S3) #false)
(check-expect (si-game-over? S4) #true)
(check-expect (si-game-over? S5) #true)

(define (si-game-over? s)
  (local (;; [List-of Missile] UFO -> Boolean
          ;; checks if any missiles hit the UFO
          (define (hit-missile? lom u)
            (cond [(empty? lom) #false]
                  [(and (<= (- (posn-x u) UFO-X)
                            (posn-x (first lom))
                            (+ (posn-x u) UFO-X))
                        (<= (- (posn-y u) UFO-Y)
                            (posn-y (first lom))
                            (+ (posn-y u) UFO-Y))) #true]
                  [else
                   (hit-missile? (rest lom) u)])))
    (cond [(>= (posn-y (sigs-ufo s))
               (- HEIGHT CLOSE)) #true]
          [else
           (hit-missile? (sigs-missiles s) (sigs-ufo s))])))
