;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-225) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 225

(require 2htdp/image)
(require 2htdp/universe)


; Design a fire-fighting game.
;
; The game is set in the western states where fires rage through vast forests.
; It simulates an airborne fire-fighting effort.
; Specifically, the player acts as the pilot of an airplane that drops loads
; of water on fires on the ground. The player controls the plane’s horizontal
; movements and the release of water loads.
;
; Your game software starts fires at random places on the ground.
; You may wish to limit the number of fires, making them a function of how many
; fires are currently burning or other factors. The purpose of the game is to
; extinguish all fires in a limited amount of time. Hint Use an iterative design
; approach as illustrated in this chapter to create this game.

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
(define WATER (above (ellipse 2 4 "solid" "blue")
                     (ellipse 2 4 "solid" "blue")
                     (ellipse 2 4 "solid" "blue")
                     (ellipse 2 4 "solid" "blue")
                     (ellipse 2 4 "solid" "blue")))
(define WIDTH  640)
(define HEIGHT WIDTH)
(define CENTER-X (/ WIDTH 2))
(define FIRES 5)
(define WATER-LOAD 5)
(define TIMEOUT 60)
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

; A ListOfFires is one of:
;   '()
;   (cons Fire ListOfFires)
; interpretation represents all fires in the game
(define LOF1 '())
(define LOF2 (cons F1 '()))
(define LOF3 (cons F1 (cons F2 '())))

(define-struct fire-fighting (fires water time ctr-x))
; A Fire-Fighting is a structure:
;   (make-fire-fighting ListOfFires Integer[0, WATER-LOAD] Integer[0, TIMEOUT) Integer[0, WIDTH))
; interpretation (make-fire-fighting lof w t cx) is an instance of the game where:
;  - lof is the references to fires;
;  - w is a counter for the water charge, in total of WATER-LOAD;
;  - t is the time counter, between 0 and TIMEOUT; and
;  - cx is the current x position, between 0 and WIDTH
(define FF (make-fire-fighting LOF1 0 TIMEOUT CENTER-X))


; Environment
; Fire-Fighting -> World
; starts a world with (main FF)
(define (main ff)
  (big-bang (create-fires ff)
            (on-tick   tock)
            (on-draw   render)
            (on-key    control)
            (stop-when game-over?)))

; Fire-Fighting Integer -> Fire-Fighting
; creates fires on the game
(check-random (create-fires FF)
              (make-fire-fighting
               (list (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE))))
                     (make-posn (random WIDTH) (random (- HEIGHT (image-height AIRPLANE)))))
               0 TIMEOUT CENTER-X))

(define (create-fires ff)
  (cond [(= (length (fire-fighting-fires ff)) FIRES) ff]
        [else (create-fires (make-fire-fighting
                             (append (fire-fighting-fires ff)
                                     (list (make-posn (random WIDTH)
                                                      (random (- HEIGHT (image-height AIRPLANE))))))
                             0 TIMEOUT CENTER-X))]))

; Fire-Fighting -> Fire-Fighting
; updates the status of the game
(check-expect (tock FF) (make-fire-fighting LOF1 0 (sub1 TIMEOUT) CENTER-X))
(check-expect (tock (make-fire-fighting LOF2 0 TIMEOUT CENTER-X))
              (make-fire-fighting (list (make-posn 10 21)) 0 (sub1 TIMEOUT) CENTER-X))

(define (tock ff)
  (make-fire-fighting (move-fires (fire-fighting-fires ff))
                      (fire-fighting-water ff)
                      (sub1 (fire-fighting-time ff))
                      (fire-fighting-ctr-x ff)))

; ListOfFires -> ListOfFires
; increments the height by 1 in list
(check-expect (move-fires LOF1) LOF1)
(check-expect (move-fires LOF2) (list (make-posn 10 21)))
(check-expect (move-fires LOF3) (list (make-posn 10 21) (make-posn 50 51)))

(define (move-fires lof)
  (cond [(empty? lof) '()]
        [else (cons (make-posn (posn-x (first lof)) (add1 (posn-y (first lof))))
                    (move-fires (rest lof)))]))

; Fire-Fighting -> Image
; renders the given game state on top of MTS
(define (render ff)
  (place-image
   AIRPLANE
   (fire-fighting-ctr-x ff) CTR-Y
   (render-fires (fire-fighting-fires ff) MTS)))

; ListOfFires Image -> Image
; renders the fires on top of image
(define (render-fires lof i)
  (cond [(empty? lof) i]
        [else (place-image FIRE (posn-x (first lof)) (posn-y (first lof))
                           (render-fires (rest lof) i))]))

; Fire-Fighting KeyEvent -> Fire-Fighting
; handles the main events:
;  - pressing the left arrow ensures that the airplane moves left;
;  - pressing the right arrow ensures that the airplane moves right; and
;  - pressing the space bar ensures that the airplane releases of water loads
(check-expect (control FF "left") (make-fire-fighting LOF1 0 TIMEOUT (- CENTER-X STEP-X)))
(check-expect (control FF "right") (make-fire-fighting LOF1 0 TIMEOUT (+ CENTER-X STEP-X)))
(check-expect (control FF " ") (make-fire-fighting LOF1 5 TIMEOUT CENTER-X))
(check-expect (control (make-fire-fighting LOF1 3 TIMEOUT CENTER-X) " ")
              (make-fire-fighting LOF1 3 TIMEOUT CENTER-X))
(check-expect (control FF "a") (make-fire-fighting LOF1 0 TIMEOUT CENTER-X))

(define (control ff ke)
  (cond [(key=? ke "left")
         (make-fire-fighting (fire-fighting-fires ff)
                             (fire-fighting-water ff)
                             (fire-fighting-time ff)
                             (- (fire-fighting-ctr-x ff) STEP-X))]
        [(key=? ke "right")
         (make-fire-fighting (fire-fighting-fires ff)
                             (fire-fighting-water ff)
                             (fire-fighting-time ff)
                             (+ (fire-fighting-ctr-x ff) STEP-X))]
        [(key=? ke " ")
         (make-fire-fighting (fire-fighting-fires ff)
                             (if (= (fire-fighting-water ff) 0)
                                 WATER-LOAD
                                 (fire-fighting-water ff))
                             (fire-fighting-time ff)
                             (fire-fighting-ctr-x ff))]
        [else ff]))

; Fire-Fighting -> Boolean
; returns true when the game stop;
; the game stops if extinguish all FIRES before the TIMEOUT
(define (game-over? ff) #false)
