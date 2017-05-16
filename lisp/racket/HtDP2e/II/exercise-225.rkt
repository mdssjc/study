;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-225) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 225

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
;  - airplane (image)
;  - tree (image)
;  - florest (image)
;  - fire (image)
;  - water (image)
;  - limit of fires
;  - limit of time
;  - pos-y (airplane)
;  - width
;  - height
;  - mts

; Variability
;  - fires
;  - time
;  - pos-x

; Environment
;  - on-tick
;  - on-render
;  - on-key: left, right (horizontal movements) and space (water)
;  - stop-when: timeout
