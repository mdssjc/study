;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-225) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 225

(require 2htdp/image)
(require 2htdp/universe)


; Constants
(define AIRPLANE (overlay/xy (circle 10 "solid" "blue")
                             -15 -20
                             (overlay (ellipse 10 80 "solid" "blue")
                                      (rectangle 50 10 "solid" "blue"))))
(define TREE (overlay (above (circle 5 "solid" "forestgreen")
                             (beside (circle 5 "solid" "forestgreen")
                                     (circle 5 "solid" "forestgreen")))
                      (circle 14 "outline" "black")))
(define FOREST (beside TREE (above TREE TREE)))
(define FIRE (overlay (circle 4 75 "red")
                      (overlay (circle 8 75 "orange")
                               (circle 12 75 "yellow"))))
(define WATER (above (ellipse 8 10 "solid" "blue")
                     (ellipse 8 10 "solid" "blue")
                     (ellipse 8 10 "solid" "blue")
                     (ellipse 8 10 "solid" "blue")
                     (ellipse 8 10 "solid" "blue")))
(define WIDTH  640)
(define HEIGHT WIDTH)
(define CENTER-X (/ WIDTH 2))
(define CENTER-Y (/ HEIGHT 2))
(define FIRES 8)
(define WATER-LOAD 5)
(define TOCK-STEP 28) ; tock: 28 times by second
(define TIMEOUT (* 120 TOCK-STEP))
(define CTR-Y (- HEIGHT (/ (image-height AIRPLANE) 2)))
(define STEP-X 5)
(define MTS
  (place-image FOREST (* WIDTH 0.2) (* HEIGHT 0.2)
               (place-image FOREST (* WIDTH 0.2) (* HEIGHT 0.5)
                            (place-image FOREST (* WIDTH 0.2) (* HEIGHT 0.8)
                                         (place-image FOREST (* WIDTH 0.5) (* HEIGHT 0.2)
                                                      (place-image FOREST (* WIDTH 0.5) (* HEIGHT 0.5)
                                                                   (place-image FOREST (* WIDTH 0.5) (* HEIGHT 0.8)
                                                                                (place-image FOREST (* WIDTH 0.8) (* HEIGHT 0.2)
                                                                                             (place-image FOREST (* WIDTH 0.8) (* HEIGHT 0.5)
                                                                                                          (place-image FOREST (* WIDTH 0.8) (* HEIGHT 0.8)
                                                                                                                       (empty-scene WIDTH HEIGHT "mediumgoldenrod")))))))))))


; Variability
; A Fire is a Posn:
;   (make-posn Natural Natural)
; interpretation (make-posn x y) is the Fire location
; (using the top-down, left-to-right convention)
(define F1 (make-posn 10 20))
(define F2 (make-posn 50 50))

; A ListOfFire is one of:
;   '()
;   (cons Fire ListOfFire)
; interpretation represents all fires in the game
(define LOF1 '())
(define LOF2 (cons F1 '()))
(define LOF3 (cons F1 (cons F2 '())))

(define-struct water (enable? timer))
; A Water is a structure:
;   (make-water Boolean Integer)
; interpretation (make-water e? t) is the status of water control:
;  - e? is the enable of water; and
;  - t is the timer, WATER-LOAD to 0 for drop and 10 to 0 for recharge
(define W1 (make-water #true 0))
(define W2 (make-water #true 3))
(define W3 (make-water #true WATER-LOAD))
(define W4 (make-water #false 0))
(define W5 (make-water #false 5))
(define W6 (make-water #false 10))

(define-struct fire-fighting (fires water time ctr-x))
; A Fire-Fighting is a structure:
;   (make-fire-fighting ListOfFire Water Integer[0, TIMEOUT) Integer[0, WIDTH))
; interpretation (make-fire-fighting lof w t cx) is an instance of the game where:
;  - lof is the references to fires;
;  - w is a Water reference;
;  - t is the time counter, between 0 and TIMEOUT; and
;  - cx is the current x position, between 0 and WIDTH
(define FF (make-fire-fighting LOF1 W1 TIMEOUT CENTER-X))


; Environment
; Fire-Fighting -> World
; starts a world with (main FF)
(define (main ff)
  (big-bang (create-fires ff)
            (on-tick   tock)
            (on-draw   render)
            (on-key    control)
            (stop-when game-over? render-gamer-over)))

; Fire-Fighting Integer -> Fire-Fighting
; creates fires on the game
(check-random (create-fires FF)
              (make-fire-fighting
               (list (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE)))))
               W1 TIMEOUT CENTER-X))

(define (create-fires ff)
  (cond [(= (length (fire-fighting-fires ff)) FIRES) ff]
        [else (create-fires (make-fire-fighting
                             (append (fire-fighting-fires ff)
                                     (list (make-posn (random WIDTH)
                                                      (random (- HEIGHT (image-height AIRPLANE))))))
                             W1 TIMEOUT CENTER-X))]))

; Fire-Fighting -> Fire-Fighting
; updates the status of the game
(check-expect (tock FF) (make-fire-fighting LOF1 W1 (sub1 TIMEOUT) CENTER-X))
(check-expect (tock (make-fire-fighting LOF2 W1 TIMEOUT CENTER-X))
              (make-fire-fighting (list (make-posn 10 21)) W1 (sub1 TIMEOUT) CENTER-X))

(define (tock ff)
  (check-collision
   (make-fire-fighting
    (move-fires (fire-fighting-fires ff))
    (if (= (remainder (fire-fighting-time ff) TOCK-STEP) 0)
        (status-water (fire-fighting-water ff))
        (fire-fighting-water ff))
    (sub1 (fire-fighting-time ff))
    (fire-fighting-ctr-x ff))))

; Fire-Fighting -> Fire-Fighting
; checks the collision between fire and water
(check-expect (check-collision (make-fire-fighting LOF2 W1 TIMEOUT CENTER-X))
              (make-fire-fighting LOF2 W1 TIMEOUT CENTER-X))

(check-expect (check-collision (make-fire-fighting (list (make-posn 10 519)) W2 TIMEOUT 10))
              (make-fire-fighting (list (make-posn 10 519)) W2 TIMEOUT 10))
(check-expect (check-collision (make-fire-fighting (list (make-posn 10 520)) W2 TIMEOUT 10))
              (make-fire-fighting '() W2 TIMEOUT 10))
(check-expect (check-collision (make-fire-fighting (list (make-posn 10 520)) W2 TIMEOUT 20))
              (make-fire-fighting (list (make-posn 10 520)) W2 TIMEOUT 20))
(check-expect (check-collision (make-fire-fighting (list (make-posn 10 520)) W6 TIMEOUT 10))
              (make-fire-fighting (list (make-posn 10 520)) W6 TIMEOUT 10))

(check-expect (check-collision (make-fire-fighting (list (make-posn 10 570)) W2 TIMEOUT 10))
              (make-fire-fighting '() W2 TIMEOUT 10))
(check-expect (check-collision (make-fire-fighting (list (make-posn 10 570)) W2 TIMEOUT 20))
              (make-fire-fighting (list (make-posn 10 570)) W2 TIMEOUT 20))
(check-expect (check-collision (make-fire-fighting (list (make-posn 10 570)) W6 TIMEOUT 10))
              (make-fire-fighting (list (make-posn 10 570)) W6 TIMEOUT 10))
(check-expect (check-collision (make-fire-fighting (list (make-posn 10 571)) W2 TIMEOUT 10))
              (make-fire-fighting (list (make-posn 10 571)) W2 TIMEOUT 10))

(check-expect (check-collision (make-fire-fighting (list (make-posn 10 520) (make-posn 20 520)) W2 TIMEOUT 10))
              (make-fire-fighting (list (make-posn 20 520)) W2 TIMEOUT 10))
(check-expect (check-collision (make-fire-fighting (list (make-posn 10 570) (make-posn 20 570)) W2 TIMEOUT 10))
              (make-fire-fighting (list (make-posn 20 570)) W2 TIMEOUT 10))

(define (check-collision ff)
  (make-fire-fighting
   (cond [(and (water-enable? (fire-fighting-water ff))
               (> (water-timer (fire-fighting-water ff)) 0))
          (remove-in-x (fire-fighting-fires ff) (fire-fighting-ctr-x ff))]
         [else (fire-fighting-fires ff)])
   (fire-fighting-water ff)
   (fire-fighting-time ff)
   (fire-fighting-ctr-x ff)))

; ListOfFire Integer -> ListOfFire
; removes the fires at position:
;  - y: between 520 and 570; and
;  - x: same
(check-expect (remove-in-x '() 0) '())
(check-expect (remove-in-x (list (make-posn 10 520)) 10) '())
(check-expect (remove-in-x (list (make-posn 10 520)) 11) (list (make-posn 10 520)))
(check-expect (remove-in-x (list (make-posn 10 520) (make-posn 20 520)) 10) (list (make-posn 20 520)))
(check-expect (remove-in-x (list (make-posn 10 570)) 10) '())
(check-expect (remove-in-x (list (make-posn 10 570)) 11) (list (make-posn 10 570)))
(check-expect (remove-in-x (list (make-posn 10 570) (make-posn 20 570)) 10) (list (make-posn 20 570)))
(check-expect (remove-in-x (list (make-posn 10 519)) 10) (list (make-posn 10 519)))
(check-expect (remove-in-x (list (make-posn 10 571)) 10) (list (make-posn 10 571)))

(define (remove-in-x lof x)
  (cond [(empty? lof) '()]
        [(and (= (posn-x (first lof)) x)
              (<= 520 (posn-y (first lof)) 570))
         (remove-in-x (rest lof) x)]
        [else (cons (first lof)
                    (remove-in-x (rest lof) x))]))

; ListOfFire -> ListOfFire
; increments the height by 1 in list or reset when equal to HEIGHT
(check-expect (move-fires LOF1) LOF1)
(check-expect (move-fires LOF2) (list (make-posn 10 21)))
(check-expect (move-fires LOF3) (list (make-posn 10 21) (make-posn 50 51)))
(check-expect (move-fires (list (make-posn 10 HEIGHT)))
              (list (make-posn 10 0)))
(check-expect (move-fires (list (make-posn 10 HEIGHT) (make-posn 10 21)))
              (list (make-posn 10 0) (make-posn 10 22)))

(define (move-fires lof)
  (cond [(empty? lof) '()]
        [(= (posn-y (first lof)) HEIGHT)
         (cons (make-posn (posn-x (first lof)) 0)
               (move-fires (rest lof)))]
        [else (cons (make-posn (posn-x (first lof))
                               (add1 (posn-y (first lof))))
                    (move-fires (rest lof)))]))

; Water -> Water
; uptades the status water
(check-expect (status-water W1) (make-water #true 0))
(check-expect (status-water W2) (make-water #true 2))
(check-expect (status-water W3) (make-water #true (sub1 WATER-LOAD)))
(check-expect (status-water W4) W1)
(check-expect (status-water W5) (make-water #false 4))
(check-expect (status-water W6) (make-water #false 9))
(check-expect (status-water (make-water #true 1)) W6)

(define (status-water w)
  (cond [(and (water-enable? w)
              (= (water-timer w) 0)) w]
        [(and (water-enable? w)
              (= (water-timer w) 1)) (make-water #false 10)]
        [(and (not (water-enable? w))
              (= (water-timer w) 0)) (make-water #true 0)]
        [else (make-water (water-enable? w) (sub1 (water-timer w)))]))

; Fire-Fighting -> Image
; renders the given game state on top of MTS
(define (render ff)
  (place-image
   AIRPLANE
   (fire-fighting-ctr-x ff) CTR-Y
   (render-water ff
                 (render-fires (fire-fighting-fires ff)
                               (render-time (fire-fighting-time ff)
                                            (place-image (rectangle WIDTH 1 "solid" "blue")
                                                         CENTER-X 520
                                                         (place-image (rectangle WIDTH 1 "solid" "red")
                                                                      CENTER-X 570 MTS)))))))

; ListOfFire Image -> Image
; renders the fires on top of image
(define (render-fires lof i)
  (cond [(empty? lof) i]
        [else (place-image FIRE (posn-x (first lof)) (posn-y (first lof))
                           (render-fires (rest lof) i))]))

; Fire-Fighting Image -> Image
; renders the water on top of image
(define (render-water ff i)
  (cond [(and (water-enable? (fire-fighting-water ff))
              (> (water-timer (fire-fighting-water ff)) 0))
         (place-image WATER (fire-fighting-ctr-x ff) (- CTR-Y (image-height AIRPLANE)) i)]
        [(not (water-enable? (fire-fighting-water ff)))
         (place-image (text "X" 20 "red") (fire-fighting-ctr-x ff) (- CTR-Y (image-height AIRPLANE) -30) i)]
        [else i]))

; Integer Image -> Image
; renders the time on top of image
(define (render-time t i)
  (place-image (text (number->string (inexact->exact (floor (/ t TOCK-STEP)))) 20 "black") CENTER-X 20 i))

; Fire-Fighting KeyEvent -> Fire-Fighting
; handles the main events:
;  - pressing the left arrow ensures that the airplane moves left;
;  - pressing the right arrow ensures that the airplane moves right;
;  - pressing the shift ensures that the airplane moves left with precision;
;  - pressing the control ensures that the airplane moves right with precision; and
;  - pressing the space bar ensures that the airplane releases of water loads
(check-expect (control FF "left")
              (make-fire-fighting LOF1 W1 TIMEOUT (- CENTER-X STEP-X)))
(check-expect (control FF "right")
              (make-fire-fighting LOF1 W1 TIMEOUT (+ CENTER-X STEP-X)))
(check-expect (control FF "shift")
              (make-fire-fighting LOF1 W1 TIMEOUT (sub1 CENTER-X)))
(check-expect (control FF "control")
              (make-fire-fighting LOF1 W1 TIMEOUT (add1 CENTER-X)))
(check-expect (control FF " ")
              (make-fire-fighting LOF1 W3 TIMEOUT CENTER-X))
(check-expect (control (make-fire-fighting LOF1 W2 TIMEOUT CENTER-X) " ")
              (make-fire-fighting LOF1 W2 TIMEOUT CENTER-X))
(check-expect (control FF "a")
              (make-fire-fighting LOF1 W1 TIMEOUT CENTER-X))

(define (control ff ke)
  (make-fire-fighting
   (fire-fighting-fires ff)
   (cond  [(and (key=? ke " ")
                (water-enable? (fire-fighting-water ff))
                (= (water-timer (fire-fighting-water ff)) 0)) W3]
          [else (fire-fighting-water ff)])
   (fire-fighting-time ff)
   (+ (fire-fighting-ctr-x ff) (cond [(key=? ke "left") (- STEP-X)]
                                     [(key=? ke "right") STEP-X]
                                     [(key=? ke "shift") -1]
                                     [(key=? ke "control") 1]
                                     [else 0]))))

; Fire-Fighting -> Boolean
; returns true when the game stop;
; the game stops if extinguish all FIRES before the TIMEOUT
(check-expect (game-over? (make-fire-fighting LOF2 W1 TIMEOUT CENTER-X)) #false)
(check-expect (game-over? FF) #true)
(check-expect (game-over? (make-fire-fighting LOF1 W1 0 CENTER-X)) #true)

(define (game-over? ff)
  (or (= (length (fire-fighting-fires ff)) 0)
      (= (fire-fighting-time ff) 0)))

; Fire-Fighting -> Image
; renders the game over message on the last render
(define (render-gamer-over ff)
  (place-image (text (if (= (fire-fighting-time ff) 0)
                         "Game Over!"
                         "You Win!")
                     32 "black")
               CENTER-X CENTER-Y (render ff)))
