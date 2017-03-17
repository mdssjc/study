;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname growing-grass-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)
(require 2htdp/universe)

;; growing-grass-starter.rkt

; 
; PROBLEM:
; 
; Design a world program as follows:
; 
; The world starts off with a piece of grass waiting to grow. As time passes, 
; the grass grows upwards. Pressing any key cuts the current strand of 
; grass to 0, allowing a new piece to grow to the right of it.
; 
; Starting display:
; 
; .
; 
; After a few seconds:
; 
; .
; 
; After a few more seconds:
; 
; .
; 
; Immediately after pressing any key:
; 
; .
; 
; A few more seconds after pressing any key:
; 
; .
; 
; NOTE 1: Remember to follow the HtDW recipe! Be sure to do a proper domain 
; analysis before starting to work on the code file.
; 


;; Domain Analysis
;; Commonality:
;; - background color
;; - grass color
;; - grass width
;; - growth rate
;; - shift
;; - width
;; - height
;; - pos y
;; - mts
;; Variability:
;; - grass size
;; - pos x
;; World:
;; - on-tick
;; - on-draw
;; - on-key

;; My world program: Compound P5

;; =================
;; Constants:
(define BACKGROUND-COLOR "sky blue")
(define GRASS-COLOR "green")
(define GRASS-WIDTH 5)
(define GROWTH-RATE 1)
(define SHIFT (+ GRASS-WIDTH 2))
(define WIDTH  400)
(define HEIGHT 200)
(define POS-Y HEIGHT)
(define MTS (rectangle WIDTH HEIGHT "solid" BACKGROUND-COLOR))

;; =================
;; Data definitions:

(define-struct grass (pos size))
;; Grass is (make-grass Number Number)
;; interp. a grass at position (pos) and growth (size)
(define G1 (make-grass 0 0))
(define G2 (make-grass 5 10))

#;
(define (fn-for-grass g)
  (... (grass-pos g)    ; Number
       (grass-size g))) ; Number

;; Template rules used:
;;  - compound: 2 fields

;; =================
;; Functions:

;; Grass -> Grass
;; start the world with (main (make-grass 0 0))
;; 
(define (main g)
  (big-bang g                            ; Grass
            (on-tick growth GROWTH-RATE) ; Grass -> Grass
            (to-draw render)             ; Grass -> Image
            (on-key  cut)))              ; Grass KeyEvent -> Grass

;; Grass -> Grass
;; produce the next cycle of growth
(check-expect (growth G1) (make-grass (grass-pos G1)
                                      (+ (grass-size G1) GRASS-WIDTH)))

#;
(define (growth g) G1) ; stub

;<template from Grass>

(define (growth g)
  (make-grass (grass-pos g)
              (+ (grass-size g) GRASS-WIDTH)))

;; Grass -> Image
;; render the Grass in scene with your position and size
(check-expect (render G2) (place-image
                           (rectangle GRASS-WIDTH (grass-size G2) "solid" GRASS-COLOR)
                           (grass-pos G2) POS-Y MTS))

#;
(define (render g) MTS) ; stub

;<template from Grass>

(define (render g)
  (place-image
   (rectangle GRASS-WIDTH (grass-size g) "solid" GRASS-COLOR)
   (grass-pos g) POS-Y MTS))

;; Grass KeyEvent -> Grass
;; Cut the grass and plant the next grass
(check-expect (cut G1 " ")    (make-grass (+ (grass-pos G1) SHIFT) 0))
(check-expect (cut G2 "left") (make-grass (+ (grass-pos G2) SHIFT) 0))

#;
(define (cut g ke) G1) ; stub

;<template from Grass>

(define (cut g ke)
  (make-grass (+ (grass-pos g) SHIFT) 0))
