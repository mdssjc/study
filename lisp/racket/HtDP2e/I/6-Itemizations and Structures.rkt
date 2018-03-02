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
;; Exercise 95

;; The examples represent three states, being the movement of the Tank with its
;; aim, the firing of the missile and the collision with the UFO.

;; Exercise 96

;; Paper sketch of the three examples:
;; - aim: render the UFO and Tank;
;; - fired 1: render the UFO, Tank and Missile; and
;; - fired 2: render the Tank and collision between the UFO and the Missile.

;; Exercise 97
;; Exercise 98
;; Exercise 99
;; Exercise 100


;; =================
;; Constants:

(define UFO (overlay (rectangle 70 10 "solid" "green")
                     (circle 20 "solid" "green")))
(define UFO-X (/ (image-width  UFO) 2))
(define UFO-Y (/ (image-height UFO) 2))
(define TANK-HEIGHT 20)
(define TANK    (rectangle 50 TANK-HEIGHT "solid" "blue"))
(define MISSILE (triangle 10 "solid" "red"))
(define WIDTH  400)
(define HEIGHT 300)
(define CLOSE (/ HEIGHT 3))
(define BACKGROUND (empty-scene WIDTH HEIGHT))


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

(define-struct aim   [ufo tank])
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
(define S4 (make-aim   (make-posn 10 (- HEIGHT CLOSE))
                       (make-tank 28 -3)))


;; =================
;; Functions:

; SIGS -> World
; starts a world with (main S1)
(define (main s)
  (big-bang s
            (on-tick   si-move)
            (on-draw   si-render)
            (on-key    si-control)
            (stop-when si-game-over?)))

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

; SIGS -> Boolean
; returns true when the game stop;
; the game stops if the UFO lands or if the missile hits the UFO
(check-expect (si-game-over? S1) #false)
(check-expect (si-game-over? S2) #false)
(check-expect (si-game-over? S3) #true)
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
; renders the final state of the game
(define (si-render-final s)
  (si-render s))

; SIGS -> SIGS
; updates the position of objects
(check-random (si-move S1)
              (make-aim
               (make-posn (random (posn-x (aim-ufo S1))) 11)
               (make-tank 25 -3)))
(check-random (si-move S3)
              (make-fired
               (make-posn (random (posn-x (fired-ufo S3))) 101)
               (make-tank 103 3)
               (make-posn 22  102)))

(define (si-move s)
  (si-move-proper s (random (cond [(aim?   s) (posn-x (aim-ufo   s))]
                                  [(fired? s) (posn-x (fired-ufo s))]))))

; Number -> Number
; produces a number in the interval [0,n),
; possibly a different one each time it is called
; (define (random n) ...)

; SIGS Number -> SIGS
; moves the space-invader objects predictably by delta
(define (si-move-proper s delta)
  (cond [(aim?   s) (make-aim   (update-ufo  (aim-ufo s) delta)
                                (update-tank (aim-tank s)))]
        [(fired? s) (make-fired (update-ufo  (fired-ufo s) delta)
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
(check-expect (update-missile (make-posn 1 1)) (make-posn 1 0))

(define (update-missile m)
  (make-posn (posn-x m) (sub1 (posn-y m))))

; SIGS KeyEvent -> SIGS
; handles the main events:
; - pressing the left arrow ensures that the tank moves left;
; - pressing the right arrow ensures that the tank moves right; and
; - pressing the space bar fires the missile if it hasn’t been launched yet.
(check-expect (si-control S1 "left")
              (make-aim (aim-ufo S1)
                        (create-tank (aim-tank S1) "left")))
(check-expect (si-control S1 "right")
              (make-aim (aim-ufo S1)
                        (create-tank (aim-tank S1) "right")))
(check-expect (si-control S1 " ")
              (make-fired (aim-ufo S1)
                          (aim-tank S1)
                          (make-posn (tank-loc (aim-tank S1))
                                     (- HEIGHT TANK-HEIGHT))))
(check-expect (si-control S1 "a") S1)
(check-expect (si-control S2 "left")
              (make-fired (fired-ufo S2)
                          (create-tank (fired-tank S2) "left")
                          (fired-missile S2)))
(check-expect (si-control S2 "right")
              (make-fired (fired-ufo S2)
                          (create-tank (fired-tank S2) "right")
                          (fired-missile S2)))
(check-expect (si-control S2 " ")
              (make-fired (fired-ufo  S2)
                          (fired-tank S2)
                          (make-posn (tank-loc (fired-tank S2))
                                     (- HEIGHT TANK-HEIGHT))))
(check-expect (si-control S2 "a") S2)

(define (si-control s ke)
  (cond [(or (key=? ke "left")
             (key=? ke "right"))
         (cond [(aim? s)
                (make-aim (aim-ufo s)
                          (create-tank (aim-tank s) ke))]
               [(fired? s)
                (make-fired (fired-ufo s)
                            (create-tank (fired-tank s) ke)
                            (fired-missile s))])]
        [(key=? ke " ")
         (cond [(aim? s)
                (make-fired (aim-ufo  s)
                            (aim-tank s)
                            (make-posn (tank-loc (aim-tank s))
                                       (- HEIGHT TANK-HEIGHT)))]
               [(fired? s)
                (make-fired (fired-ufo  s)
                            (fired-tank s)
                            (make-posn (tank-loc (fired-tank s))
                                       (- HEIGHT TANK-HEIGHT)))])]
        [else s]))

; Tank -> Tank
; produces a tank from t with the speed direction dir
(check-expect (create-tank (make-tank 100 3)  "left")  (make-tank 100 -3))
(check-expect (create-tank (make-tank 100 -3) "left")  (make-tank 100 -3))
(check-expect (create-tank (make-tank 100 3)  "right") (make-tank 100 3))
(check-expect (create-tank (make-tank 100 -3) "right") (make-tank 100 3))

(define (create-tank t dir)
  (make-tank (tank-loc t)
             (* (tank-vel t)
                (cond [(string=? dir "left")
                       (if (negative? (tank-vel t)) 1 -1)]
                      [(string=? dir "right")
                       (if (negative? (tank-vel t)) -1 1)]))))


;; Exercise 101
;; Exercise 102


;; =================
;; Data definitions:

; A MissileOrNot is one of:
; - #false
; - Posn
; interpretation#false means the missile is in the tank;
; Posn says the missile is at that location

(define-struct sigs [ufo tank missile])
; A SIGS.v2 (short for SIGS version 2) is a structure:
;   (make-sigs UFO Tank MissileOrNot)
; interpretation represents the complete state of a
; space invader game
(define S5 (make-sigs (make-posn 20 10)
                      (make-tank 28 -3)
                      #false))
(define S6 (make-sigs (make-posn 20 10)
                      (make-tank 28 -3)
                      (make-posn 32 (- HEIGHT TANK-HEIGHT 10))))
(define S7 (make-sigs (make-posn 20 100)
                      (make-tank 100 3)
                      (make-posn 22 103)))
(define S8 (make-sigs (make-posn 10 (- HEIGHT CLOSE))
                      (make-tank 28 -3)
                      #false))


;; =================
;; Functions:

; SIGS.v2 -> World
; starts a world with (main S1)
(define (main.v2 s)
  (big-bang s
            (on-tick   si-move.v2)
            (on-draw   si-render.v2)
            (on-key    si-control.v2)
            (stop-when si-game-over?.v2)))

; SIGS.v2 -> SIGS.v2
; updates the position of objects
(check-random (si-move.v2 S5)
              (make-sigs
               (make-posn (random (+ (posn-x (sigs-ufo S5)) (image-width UFO))) 11)
               (make-tank 25 -3)
               #false))
(check-random (si-move.v2 S6)
              (make-sigs
               (make-posn (random (+ (posn-x (sigs-ufo S6)) (image-width UFO))) 11)
               (make-tank 25 -3)
               (make-posn 32 (sub1 (- HEIGHT TANK-HEIGHT 10)))))

(define (si-move.v2 s)
  (si-move-proper.v2 s (random (+ (posn-x (sigs-ufo s))
                               (image-width  UFO)))))

; SIGS.v2 Number -> SIGS.v2
; moves the space-invader objects predictably by delta
(define (si-move-proper.v2 s delta)
  (make-sigs (update-ufo  (sigs-ufo  s) delta)
             (update-tank (sigs-tank s))
             (update-missile.v2 (sigs-missile s))))

; Missile -> Missile
; updates the missile
(define (update-missile.v2 m)
  (cond [(boolean? m) m]
        [(posn?    m) (make-posn (posn-x m) (sub1 (posn-y m)))]))

; SIGS.v2 -> Image
; renders the given game state on top of BACKGROUND
(check-expect (si-render.v2 S5)
              (place-image UFO 20 10
                           (place-image TANK 28 HEIGHT
                                        BACKGROUND)))
(check-expect (si-render.v2 S6)
              (place-image UFO 20 10
                           (place-image TANK 28 HEIGHT
                                        (place-image MISSILE 32 (- HEIGHT TANK-HEIGHT 10)
                                                     BACKGROUND))))

(define (si-render.v2 s)
  (tank-render
   (sigs-tank s)
   (ufo-render (sigs-ufo s)
               (missile-render.v2 (sigs-missile s)
                                  BACKGROUND))))

; MissileOrNot Image -> Image
; adds an image of missile m to scene s
(define (missile-render.v2 m s)
  (cond [(boolean? m) s]
        [(posn?    m) (place-image MISSILE (posn-x m) (posn-y m) s)]))

; SIGS.v2 KeyEvent -> SIGS.v2
; handles the main events:
; - pressing the left arrow ensures that the tank moves left;
; - pressing the right arrow ensures that the tank moves right; and
; - pressing the space bar fires the missile if it hasn’t been launched yet.
(check-expect (si-control.v2 S5 "left")
              (make-sigs (sigs-ufo S5)
                         (create-tank (sigs-tank S5) "left")
                         (sigs-missile S5)))
(check-expect (si-control.v2 S5 "right")
              (make-sigs (sigs-ufo S5)
                         (create-tank (sigs-tank S5) "right")
                         (sigs-missile S5)))
(check-expect (si-control.v2 S5 " ")
              (make-sigs (sigs-ufo S5)
                         (sigs-tank S5)
                         (make-posn (tank-loc (sigs-tank S5))
                                    (- HEIGHT TANK-HEIGHT))))
(check-expect (si-control.v2 S5 "a") S5)
(check-expect (si-control.v2 S6 "left")
              (make-sigs (sigs-ufo S6)
                         (create-tank (sigs-tank S6) "left")
                         (sigs-missile S6)))
(check-expect (si-control.v2 S6 "right")
              (make-sigs (sigs-ufo S6)
                         (create-tank (sigs-tank S6) "right")
                         (sigs-missile S6)))
(check-expect (si-control.v2 S6 " ")
              (make-sigs (sigs-ufo  S6)
                         (sigs-tank S6)
                         (make-posn (tank-loc (sigs-tank S6))
                                    (- HEIGHT TANK-HEIGHT))))
(check-expect (si-control.v2 S6 "a") S6)

(define (si-control.v2 s ke)
  (cond [(or (key=? ke "left")
             (key=? ke "right"))
         (make-sigs (sigs-ufo s)
                    (create-tank (sigs-tank s) ke)
                    (sigs-missile s))]
        [(key=? ke " ")
         (make-sigs (sigs-ufo s)
                    (sigs-tank s)
                    (make-posn (tank-loc (sigs-tank s))
                               (- HEIGHT TANK-HEIGHT)))]
        [else s]))

; SIGS.v2 -> Boolean
; returns true when the game stop;
; the game stops if the UFO lands or if the missile hits the UFO
(check-expect (si-game-over?.v2 S5) #false)
(check-expect (si-game-over?.v2 S6) #false)
(check-expect (si-game-over?.v2 S7) #true)
(check-expect (si-game-over?.v2 S8) #true)

(define (si-game-over?.v2 s)
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


;; Exercise 103

(define-struct spider (legs space))
; Spider is a structure:
; interpretation (make-spider Number Number)
;  legs means the total of legs remaining
;  space means the amount of space to transport
(define SP1 (make-spider 4 10))
(define SP2 (make-spider 8 20))

(define-struct elephant (space))
; Elephante is a structure:
; interpretation (make-elephant Number)
;  space means the amount of space to transport
(define E1 (make-elephant 10))
(define E2 (make-elephant 20))

(define-struct boa-constrictor (length girth))
; Boa-constrictor is a structure:
; interpretation (make-boa-constrictor Number(0..N] Number(0..N])
;  length means its horizontal size, between 0 and N
;  girth means its vertical size, between 0 and N
(define B1 (make-boa-constrictor 5 2))
(define B2 (make-boa-constrictor 5 4))

(define-struct armadillo (claws space))
; Armadillo is a structure:
; interpretation (make-armadillo Number[0..100] Number)
;  claws means the percentage of durability
;  space means the amount of space to transport
(define A1 (make-armadillo 100 10))
(define A2 (make-armadillo 100 20))

(define-struct zoo (spider elephant boa-constrictor armadillo))
; A Zoo is a structure:
; interpretation (make-spider Spider Elephant Boa-constrictor Armadillo)
;  represents four kinds of zoo animals
(define Z1 (make-zoo SP1 E1 B1 A1))
(define Z2 (make-zoo SP2 E2 B2 A2))

#;
(define (fn-for-zoo z)
  (... (zoo-spider z)
       (zoo-elephant z)
       (zoo-boa-constrictor z)
       (zoo-armadillo z)))

; Zoo Number -> Boolean
; determines whether the cage is large enough for the animal
(check-expect (fits? Z1 50) #true)
(check-expect (fits? Z2 50) #false)

(define (fits? z v)
  (<= (+ (spider-space   (zoo-spider z))
         (elephant-space (zoo-elephant z))
         (* (boa-constrictor-length (zoo-boa-constrictor z))
            (boa-constrictor-girth  (zoo-boa-constrictor z)))
         (armadillo-space (zoo-armadillo z)))
      v))


;; Exercise 104

; Vehicle is one of:
; - "automobile"
; - "van"
; - "bus"
; - "SUV"
; - "truck"
; interpretation a vehicle of fleet

(define-struct fleet (vehicle passenger license fuel))
; Fleet is a structure:
; interpretation (make-fleet Vehicle Number Number Number)
;  vehicle means a vehicle type
;  passenger means the total number that it can carry
;  license means the value of plate number
;  fuel means the current value in miles per gallon
(define (fn-to-fleet f)
  (... (fleet-vehicle f)
       (fleet-passenger f)
       (fleet-license f)
       (fleet-fuel f)))


;; Exercise 105

; A Coordinate is one of:
; - a NegativeNumber
; interpretation on the y axis, distance from top
; - a PositiveNumber
; interpretation on the x axis, distance from left
; - a Posn
; interpretation an ordinary Cartesian point
(define C1 -10)
(define C2 -20)
(define C3  10)
(define C4  20)
(define C5 (make-posn 10 10))
(define C6 (make-posn  0 50))
