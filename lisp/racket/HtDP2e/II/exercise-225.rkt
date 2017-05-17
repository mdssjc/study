;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-225) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 225

(require 2htdp/image)

;Design a fire-fighting game.
;
;The game is set in the western states where fires rage through vast forests.
;It simulates an airborne fire-fighting effort.
;Specifically, the player acts as the pilot of an airplane that drops loads
;of water on fires on the ground. The player controls the plane’s horizontal
;movements and the release of water loads.
;
;Your game software starts fires at random places on the ground.
;You may wish to limit the number of fires, making them a function of how many
;fires are currently burning or other factors. The purpose of the game is to
;extinguish all fires in a limited amount of time. Hint Use an iterative design
;approach as illustrated in this chapter to create this game.

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
(define FIRES 5)
(define WATER-LOAD 5)
(define TIMEOUT 60)
(define CTR-Y (- HEIGHT (/ (image-height AIRPLANE) 2)))
(define MTS (empty-scene WIDTH HEIGHT "mediumgoldenrod"))


; Variability
;  - fires
;  - time
;  - pos-x

; Environment
;  - on-tick
;  - on-render
;  - on-key: left, right (horizontal movements) and space (water)
;  - stop-when: timeout
