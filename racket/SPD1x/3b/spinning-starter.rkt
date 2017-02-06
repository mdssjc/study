;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname spinning-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)
(require 2htdp/universe)

;; spinning-starter.rkt

; 
; PROBLEM:
; 
; Design a world program as follows:
; 
; The world starts off with a small square at the center of the screen. As time 
; passes, the square stays fixed at the center, but increases in size and rotates 
; at a constant speed.Pressing the spacebar resets the world so that the square 
; is small and unrotated.
; 
; Starting display:
; .
; After a few seconds:
; .
; After a few more seconds:
; .
; Immediately after pressing the spacebar:
; .
; NOTE 1: Remember to follow the HtDW recipe! Be sure to do a proper domain 
; analysis before starting to work on the code file.
; 
; NOTE 2: The rotate function requires an angle in degrees as its first 
; argument. By that it means Number[0, 360). As time goes by the box may end up 
; spinning more than once, for example, you may get to a point where it has spun 
; 362 degrees, which rotate won't accept. One solution to that is to use the 
; remainder function as follows:
; 
; (rotate (remainder ... 360) (text "hello" 30 "black"))
; 
; where ... can be an expression that produces any positive number of degrees 
; and remainder will produce a number in [0, 360).
; 
; Remember that you can lookup the documentation of rotate if you need to know 
; more about it.
; 
; NOTE 3: There is a way to do this without using compound data. But you should 
; design the compound data based solution.
; 


;; Domain Analysis
;; Commonality:
;; - WIDTH
;; - HEIGHT
;; - POS-X
;; - POS-Y
;; - SPEED
;; - MTS
;; Variability:
;; - ROTATION
;; - SIZE
;; World:
;; - on-tick
;; - on-draw
;; - on-key

;; My world program: Compound P2

;; =================
;; Constants:
(define WIDTH  400)
(define HEIGHT 200)
(define POS-X (/ WIDTH 2))
(define POS-Y (/ HEIGHT 2))
(define SPEED 4)
(define MTS (empty-scene WIDTH HEIGHT))

;; =================
;; Data definitions:

(define-struct box (rotation size))
;; Box is (make-box Number Number)
;; interp. a box with rotation (between 0 and 359) and size
(define B1 (make-box 45  50))
(define B2 (make-box 359 50))

#;
(define (fn-for-box b)
  (... (box-rotation b) ; Number
       (box-size b)))   ; Number

;; Template rules used:
;;  - compound: 2 fields

;; =================
;; Functions:

;; Box -> Box
;; start the world with (main (make-box 0 0))
;; 
(define (main b)
  (big-bang b                  ; Box
            (on-tick tock)     ; Box -> Box
            (to-draw render)   ; Box -> Image
            (on-key  reset)))  ; Box KeyEvent -> Box

;; Box -> Box
;; produce an increment in Box for rotation and size
(check-expect (tock B1) (make-box (+ (box-rotation B1) SPEED)
                                  (+ (box-size B1) SPEED)))
(check-expect (tock B2) (make-box (remainder (+ (box-rotation B2) SPEED) 360)
                                  (+ (box-size B2) SPEED)))

#;
(define (tock b) B1) ; stub

;<template from Box>
(define (tock b)
  (make-box (remainder (+ (box-rotation b) SPEED) 360)
            (+ (box-size b) SPEED)))   

;; Box -> Image
;; render the Box like a square shape in scene
(check-expect (render B1) (place-image
                           (rotate (box-rotation B1) (square (box-size B1) "solid" "red"))
                           POS-X POS-Y
                           MTS))
(check-expect (render B2) (place-image
                           (rotate (box-rotation B2) (square (box-size B2) "solid" "red"))
                           POS-X POS-Y
                           MTS))

#;
(define (render b) MTS) ; stub

;<template from Box>
(define (render b)
  (place-image
   (rotate (box-rotation b) (square (box-size b) "solid" "red"))
   POS-X POS-Y
   MTS))

;; Box KeyEvent -> Box
;; reset the box attributes when space key is pressed
(check-expect (reset B1 " ")    (make-box 0 0))
(check-expect (reset B1 "left") (make-box (box-rotation B1) (box-size B1)))

#;
(define (reset ke b) B1) ; stub

;<template from Box>
(define (reset b ke)
  (cond [(key=? ke " ") (make-box 0 0)]
        [else b]))
