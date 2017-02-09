;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname rolling-lambda-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)
(require 2htdp/universe)

;; rolling-lambda-starter.rkt

; 
; PROBLEM:
; 
; Design a world program as follows:
; 
; The world starts off with a lambda on the left hand side of the screen. As 
; time passes, the lambda will roll towards the right hand side of the screen. 
; Clicking the mouse changes the direction the lambda is rolling (ie from 
; left -> right to right -> left). If the lambda hits the side of the window 
; it should also change direction.
; 
; Starting display (rolling to the right):
; 
; .
; 
; After a few seconds (rolling to the right):
;       .
; After a few more seconds (rolling to the right):
;                .
; A few seconds after clicking the mouse (rolling to the left):
; 
;      .
; 
; NOTE 1: Remember to follow the HtDW recipe! Be sure to do a proper domain 
; analysis before starting to work on the code file.
; 
; NOTE 2: DO THIS PROBLEM IN STAGES.
; 
; FIRST
; 
; Just make the lambda slide back and forth across the screen without rolling.
;       
; SECOND
;   
; Make the lambda spin as it slides, but don't worry about making the spinning
; be just exactly right to make it look like its rolling. Just have it 
; spinning and sliding back and forth across the screen.
; 
; FINALLY
; 
; Work out the math you need to in order to make the lambda look like it is
; actually rolling.  Remember that the circumference of a circle is 2*pi*radius,
; so that for each degree of rotation the circle needs to move:
; 
;    2*pi*radius
;    -----------
;        360
; 
; Also note that the rotate function requires an angle in degrees as its 
; first argument. [By that it means Number[0, 360). As time goes by the lambda
; may end up spinning more than once, for example, you may get to a point 
; where it has spun 362 degrees, which rotate won't accept. One solution to 
; that is to  use the modulo function as follows:
; 
; (rotate (modulo ... 360) LAMBDA)
; 
; where ... can be an expression that produces any positive number of degrees 
; and remainder will produce a number in [0, 360).
; 
; Remember that you can lookup the documentation of modulo if you need to know 
; more about it.
; 


;; Domain Analysis
;; Commonality:
;;  - WIDTH
;;  - HEIGHT
;;  - Y-POS
;;  - LAMBDA
;;  - MOVE-LAMBDA
;;  - MTS
;; Variability:
;;  - x-pos [0..WIDTH]
;;  - roll
;;  - direction
;; World:
;;  - on-tick
;;  - on-draw
;;  - on-mouse

;; My world program: Compound P7

;; =================
;; Constants:
(define WIDTH  400)
(define HEIGHT 200)
(define Y-POS (/ HEIGHT 2))
(define LAMBDA .)
(define MOVE-LAMBDA (inexact->exact (/ (* 2 pi (/ (image-width LAMBDA) 2)) 360)))
(define MTS (empty-scene WIDTH HEIGHT))

;; =================
;; Data definitions:

(define-struct shape (x-pos roll direction))
;; Shape is (make-shape (Number Number[0,360) String))
;; interp. a shape information for position, rotation and direction
(define S1 (make-shape 10    359 "right"))
(define S2 (make-shape WIDTH 359 "right"))
(define S3 (make-shape 30      0 "left"))
(define S4 (make-shape 0       0 "left"))

#;
(define (fn-for-shape s)
  (... (shape-x-pos s)       ; Number
       (shape-roll s)        ; Number[0,360)
       (shape-direction s))) ; String

;; Template rules used:
;;  - compound: 3 fields

;; =================
;; Functions:

;; Shape -> Shape
;; start the world with (main (make-shape 0 0 "right"))
;; 
(define (main s)
  (big-bang s                    ; Shape
            (on-tick   tock)     ; Shape -> Shape
            (to-draw   render)   ; Shape -> Image
            (on-mouse  change))) ; Shape Integer Integer MouseEvent -> Shape

;; Shape -> Shape
;; produce the next shape information
(check-expect (tock S1) (make-shape (+ (shape-x-pos S1) MOVE-LAMBDA)
                                    0
                                    "right"))
(check-expect (tock S2) (make-shape (- (shape-x-pos S2) MOVE-LAMBDA)
                                    0
                                    "left"))
(check-expect (tock S3) (make-shape (- (shape-x-pos S3) MOVE-LAMBDA)
                                    1
                                    "left"))
(check-expect (tock S4) (make-shape (+ (shape-x-pos S4) MOVE-LAMBDA)
                                    1
                                    "right"))

#;
(define (tock s) S1) ; stub

;<template from Shape>
(define (tock s)
  (make-shape
   (cond [(and (next? s)
               (string=? (shape-direction s) "right"))
          (+ (shape-x-pos s) MOVE-LAMBDA)]
         [(and (next? s)
               (string=? (shape-direction s) "left"))
          (- (shape-x-pos s) MOVE-LAMBDA)]
         [(string=? (shape-direction s) "right") (- (shape-x-pos s) MOVE-LAMBDA)]
         [(string=? (shape-direction s) "left")  (+ (shape-x-pos s) MOVE-LAMBDA)])
   (modulo (+ (shape-roll s) 1) 360)
   (cond [(next? s) (shape-direction s)] 
         [else (if (string=? (shape-direction s) "right")
                   "left"
                   "right")])))

;; Shape -> Boolean
;; produce true if the next increment is valid, otherwise false
(check-expect (next? S1) (if (string=? (shape-direction S1) "right")
                             (<= (+ (shape-x-pos S1) MOVE-LAMBDA) WIDTH)
                             (>= (- (shape-x-pos S1) MOVE-LAMBDA) 0)))

#;
(define (next? s) #false) ; stub

;<template from Shape>
(define (next? s)
  (if (string=? (shape-direction s) "right")
      (<= (+ (shape-x-pos s) MOVE-LAMBDA) WIDTH)
      (>= (- (shape-x-pos s) MOVE-LAMBDA) 0)))

;; Shape -> Image
;; render the Lambda image in scene with the shape informations
(check-expect (render S2) (place-image (rotate (shape-roll S2) LAMBDA)
                                       (shape-x-pos S2) Y-POS
                                       MTS))

#;
(define (render s) MTS) ; stub

;<template from Shape>
(define (render s)
  (place-image (rotate (shape-roll s) LAMBDA)
               (shape-x-pos s) Y-POS
               MTS))

;; Shape Integer Integer MouseEvent -> Shape
;; produce an inverted direction with mouse button down
(check-expect (change S1 0 0 "button-down") (make-shape (shape-x-pos S1)
                                                        (shape-roll S1)
                                                        "left"))
(check-expect (change S1 0 0 "move")        (make-shape (shape-x-pos S1)
                                                        (shape-roll S1)
                                                        "right"))
(check-expect (change S3 0 0 "button-down") (make-shape (shape-x-pos S3)
                                                        (shape-roll S3)
                                                        "right"))
(check-expect (change S3 0 0 "move")        (make-shape (shape-x-pos S3)
                                                        (shape-roll S3)
                                                        "left"))

#;
(define (change s x y me) S1) ; stub

;<template from Shape>
(define (change s x y me)
  (cond [(mouse=? me "button-down") (make-shape (shape-x-pos s)
                                                (shape-roll s)
                                                (if (string=? (shape-direction s) "right")
                                                    "left"
                                                    "right"))]
        [else s]))
