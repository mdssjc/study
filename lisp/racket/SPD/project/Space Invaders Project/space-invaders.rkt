;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname space-invaders-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;; space-invaders.rkt

(require 2htdp/universe)
(require 2htdp/image)


;; Space Invaders

;; =================
;; Constants:

(define WIDTH  300)
(define HEIGHT 500)

(define INVADER-X-SPEED 1.5)  ;speeds (not velocities) in pixels per tick
(define INVADER-Y-SPEED 1.5)
(define TANK-SPEED 2)
(define MISSILE-SPEED 10)

(define HIT-RANGE 10)

(define INVADE-RATE 100)

(define BACKGROUND (empty-scene WIDTH HEIGHT))

(define INVADER
  (overlay/xy (ellipse 10 15 "outline" "blue")              ;cockpit cover
              -5 6
              (ellipse 20 10 "solid"   "blue")))            ;saucer

(define TANK
  (overlay/xy (overlay (ellipse 28 8 "solid" "black")       ;tread center
                       (ellipse 30 10 "solid" "green"))     ;tread outline
              5 -14
              (above (rectangle 5 10 "solid" "black")       ;gun
                     (rectangle 20 10 "solid" "black"))))   ;main body

(define TANK-HEIGHT/2 (/ (image-height TANK) 2))

(define MISSILE (ellipse 5 15 "solid" "red"))
(define MISSILE-STARTING-Y-POSITION (+ TANK-HEIGHT/2 20))


;; =================
;; Data definitions:

(define-struct game (invaders missiles tank))
;; Game is (make-game  (listof Invader) (listof Missile) Tank)
;; interp. the current state of a space invaders game
;;         with the current invaders, missiles and tank position
;; Game constants defined below Missile data definition

#;
(define (fn-for-game s)
  (... (fn-for-loinvader (game-invaders s))
       (fn-for-lom (game-missiles s))
       (fn-for-tank (game-tank s))))

(define-struct tank (x dir))
;; Tank is (make-tank Number Integer[-1, 1])
;; interp. the tank location is x, HEIGHT - TANK-HEIGHT in screen coordinates
;;         the tank moves TANK-SPEED pixels per clock tick left if dir -1, right if dir 1
(define T0 (make-tank (/ WIDTH 2) 1))   ;center going right
(define T1 (make-tank 50 1))            ;going right
(define T2 (make-tank 50 -1))           ;going left

#;
(define (fn-for-tank t)
  (... (tank-x t)
       (tank-dir t)))

(define-struct invader (x y dx))
;; Invader is (make-invader Number Number Number)
;; interp. the invader is at (x, y) in screen coordinates
;;         the invader along x by dx pixels per clock tick
(define I1 (make-invader 150 100 12))           ;not landed, moving right
(define I2 (make-invader 150 HEIGHT -10))       ;exactly landed, moving left
(define I3 (make-invader 150 (+ HEIGHT 10) 10)) ;> landed, moving right

#;
(define (fn-for-invader invader)
  (... (invader-x invader)
       (invader-y invader)
       (invader-dx invader)))

(define-struct missile (x y))
;; Missile is (make-missile Number Number)
;; interp. the missile's location is x y in screen coordinates
(define M1 (make-missile 150 300))                               ;not hit U1
(define M2 (make-missile (invader-x I1) (+ (invader-y I1) 10)))  ;exactly hit U1
(define M3 (make-missile (invader-x I1) (+ (invader-y I1)  5)))  ;> hit U1

#;
(define (fn-for-missile m)
  (... (missile-x m)
       (missile-y m)))

(define G0 (make-game empty empty T0))
(define G1 (make-game empty empty T1))
(define G2 (make-game (list I1) (list M1) T1))
(define G3 (make-game (list I1 I2) (list M1 M2) T1))


;; =================
;; Functions:

;; Game -> Game
;; start the world with ...
;;
(define (main g)
  (big-bang g                        ; Game
            (on-tick   tock)         ; Game -> Game
            (to-draw   render)       ; Game -> Image
            (stop-when game-over?)   ; Game -> Boolean
            (on-key    controller))) ; Game KeyEvent -> Game

;; Game -> Game
;; produce the next ...
;; !!!
(define (tock g) ...)

;; Game -> Image
;; render ...
;; !!!
(define (render g) ...)

;; Game -> Boolean
;; produce true when the game is over
(check-expect (game-over? G0) false)
(check-expect (game-over? G1) false)
(check-expect (game-over? G2) false)
(check-expect (game-over? G3) false)
(check-expect (game-over? (make-game (list I1 I2 I3) (list M1 M2) T1)) true)

;(define (game-over? g) false) ; Stub

(define (game-over? s)
  (cond [(empty? (game-invaders s)) false]
        [else
         (any>landed? (game-invaders s))]))

;; ListofInvader -> Boolean
;; produce true when any invader is greater than landed
(check-expect (any>landed? empty) false)
(check-expect (any>landed? (list I1 I2)) false)
(check-expect (any>landed? (list I3 I1 I2)) true)
(check-expect (any>landed? (list I1 I3 I2)) true)
(check-expect (any>landed? (list I1 I2 I3)) true)

;(define (any>landed? invaders) false) ; Stub

(define (any>landed? invaders)
  (cond [(empty? invaders) false]
        [else
         (or (>landed? (first invaders))
             (any>landed? (rest invaders)))]))

;; Invader -> Boolean
;; produce true when the invader-y is greater then HEIGHT
(check-expect (>landed? I1) false)
(check-expect (>landed? I2) false)
(check-expect (>landed? I3) true)

;(define (>landed? invader) false) ; Stub

(define (>landed? invader)
  (> (invader-y invader) HEIGHT))

;; Game KeyEvent -> Game
;; handle the keyboard events:
;;  - left and right arrows: change the tank direction
;;  - space bar: launch missiles
(check-expect (controller G0 "a") G0)
(check-expect (controller (make-game empty empty T2) "left")
              (make-game empty empty T2))
(check-expect (controller (make-game empty empty T1) "left")
              (make-game empty empty T2))
(check-expect (controller (make-game empty empty T1) "right")
              (make-game empty empty T1))
(check-expect (controller (make-game empty empty T2) "right")
              (make-game empty empty T1))
(check-expect (controller G0 " ")
              (make-game empty (list (make-missile (/ WIDTH 2) MISSILE-STARTING-Y-POSITION)) (game-tank G0)))
(check-expect (controller G2 " ")
              (make-game (list I1) (list M1 (make-missile 50 MISSILE-STARTING-Y-POSITION)) (game-tank G2)))
(check-expect (controller G3 " ")
              (make-game (list I1 I2) (list M1 M2 (make-missile 50 MISSILE-STARTING-Y-POSITION)) (game-tank G3)))

;(define (controller g ke) ...) ; Stub

(define (controller g ke)
  (cond [(key=? ke "left") (make-game
                            (game-invaders g)
                            (game-missiles g)
                            (change-tank-left (game-tank g)))]
        [(key=? ke "right") (make-game
                             (game-invaders g)
                             (game-missiles g)
                             (change-tank-right (game-tank g)))]
        [(key=? ke " ") (make-game
                         (game-invaders g)
                         (launch-missile (game-missiles g) (tank-x (game-tank g)))
                         (game-tank g))]
        [else g]))

;; Tank -> Tank
;; change the tank direction for left (-1)
(check-expect (change-tank-left T0) (make-tank (/ WIDTH 2) -1))
(check-expect (change-tank-left T1) T2)
(check-expect (change-tank-left T2) T2)

;(define (change-tank-left t) t) ; Stub

(define (change-tank-left t)
  (make-tank (tank-x t) -1))

;; Tank -> Tank
;; change the tank direction for right (1)
(check-expect (change-tank-right T0) T0)
(check-expect (change-tank-right T1) T1)
(check-expect (change-tank-right T2) T1)

;(define (change-tank-right t) t) ; Stub

(define (change-tank-right t)
  (make-tank (tank-x t) 1))

;; ListofMissile Number -> ListofMissile
;; insert a new missile in List of Missile
(check-expect (launch-missile empty 30)        (list (make-missile 30 MISSILE-STARTING-Y-POSITION)))
(check-expect (launch-missile (list M1) 30)    (list M1 (make-missile 30 MISSILE-STARTING-Y-POSITION)))
(check-expect (launch-missile (list M1 M2) 30) (list M1 M2 (make-missile 30 MISSILE-STARTING-Y-POSITION)))

;(define (launch-missile lom x) lom) ; Stub

(define (launch-missile lom x)
  (cond [(empty? lom) (list (make-missile x MISSILE-STARTING-Y-POSITION))]
        [else
         (cons (first lom) (launch-missile (rest lom) x))]))
