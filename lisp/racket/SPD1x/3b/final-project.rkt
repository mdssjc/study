;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname final-project) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; final-project.rkt

;; Problem: A star in which follows the mouse pointer and
;; changes color when you click.

;; Domain Analysis
;; Commonality:
;;  - STAR-SIZE
;;  - STAR-OUTLINE
;;  - STAR-DEFAULT-COLOR
;;  - WIDTH
;;  - HEIGHT
;;  - MTS
;;
;; Variability:
;;  - pos-x
;;  - pos-y
;;  - color
;;
;; World:
;;  - to-draw
;;  - on-mouse
;;

(require 2htdp/image)
(require 2htdp/universe)

;; My world program to final project: The Star

;; =================
;; Constants:
(define STAR-SIZE 20)
(define STAR-OUTLINE "solid")
(define STAR-DEFAULT-COLOR "gray")
(define WIDTH  400)
(define HEIGHT 200)
(define MTS (empty-scene WIDTH HEIGHT))

;; =================
;; Data definitions:
(define-struct the-star (x y color))
;; TheStar is (make-the-star Number Number String)
;; interp. a star at position x, y with color
;;         color is one of: "black" "red" "green" "blue"
(define S1 (make-the-star 10 20 "red"))
(define S2 (make-the-star 50 10 "blue"))

#;
(define (fn-for-the-star ts)
  (... (the-star-x ts)       ; Number
       (the-star-y ts)       ; Number
       (the-star-color ts))) ; String

;; Template rules used:
;;  - compound: 3 fields

;; =================
;; Functions:

;; TheStar -> TheStar
;; start the world with (main (make-the-star 0 0 STAR-DEFAULT-COLOR))
;; 
(define (main ts)
  (big-bang ts                  ; TheStar
            (to-draw  render)   ; TheStar -> Image
            (on-mouse action))) ; TheStar Integer Integer MouseEvent -> TheStar

;; TheStar -> Image
;; place the START image on MTS at position (the-star-x ts) (the-star-y ts)
(check-expect (render S1) (place-image
                           (star STAR-SIZE STAR-OUTLINE (the-star-color S1))
                           (the-star-x S1) (the-star-y S1) MTS))

#;
(define (render ts) MTS) ; stub

;<Template from TheStar>

(define (render ts)
  (place-image
   (star STAR-SIZE STAR-OUTLINE (the-star-color ts))
   (the-star-x ts) (the-star-y ts) MTS))

;; TheStar Integer Integer MouseEvent -> TheStar
;; event handler to move and change the color of TheStar
(check-expect (action S1 20 30 "move")        (make-the-star 20 30 (the-star-color S1)))
(check-expect (action S1 20 30 "button-down") (make-the-star 20 30 "green"))
(check-expect (action S2 20 30 "button-down") (make-the-star 20 30 "black"))

#;
(define (action ts x y me) S1) ; stub

;<Template from TheStar>

(define (action ts x y me)
  (cond
    [(mouse=? me "move")        (make-the-star x y (the-star-color ts))]
    [(mouse=? me "button-down") (make-the-star x y (next-color ts))]
    [else ts]))

;; TheStar -> String
;; next color in cycle: "black" -> "red" -> "green" -> "blue"
(check-expect (next-color (make-the-star 0 0 STAR-DEFAULT-COLOR)) "black")
(check-expect (next-color (make-the-star 0 0 "black")) "red")
(check-expect (next-color (make-the-star 0 0 "red"))   "green")
(check-expect (next-color (make-the-star 0 0 "green")) "blue")
(check-expect (next-color (make-the-star 0 0 "blue"))  "black")

#;
(define (next-color ts) "black") ; stub

;<Template from TheStar>

(define (next-color ts) 
  (cond [(string=? (the-star-color ts) STAR-DEFAULT-COLOR) "black"]
        [(string=? (the-star-color ts) "black") "red"]
        [(string=? (the-star-color ts) "red")   "green"]
        [(string=? (the-star-color ts) "green") "blue"]
        [(string=? (the-star-color ts) "blue")  "black"]))
