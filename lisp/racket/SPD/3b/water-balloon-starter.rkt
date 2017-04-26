;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname water-balloon-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Compound P9 - Water Balloons

;; water-balloon-starter.rkt

;; Domain Analysis
;; Commonality:
;; - WIDTH
;; - HEIGHT
;; - WATER-BALLOON
;; - POS-Y
;; - MTS
;;
;; Variability:
;; - pos-x
;; - rotate
;;
;; World:
;; - on-tick
;; - to-draw
;; - on-key


; PROBLEM:
; 
; In this problem, we will design an animation of throwing a water balloon.  
; When the program starts the water balloon should appear on the left side 
; of the screen, half-way up.  Since the balloon was thrown, it should 
; fly across the screen, rotating in a clockwise fashion. Pressing the 
; space key should cause the program to start over with the water balloon
; back at the left side of the screen. 
; 
; NOTE: Please include your domain analysis at the top in a comment box. 
; 
; Use the following images to assist you with your domain analysis:
; 
; 
; 1)
; 2).
; .
; 3)
; .
; 4)
; 
; .
;     
; 
; Here is an image of the water balloon:
; (define WATER-BALLOON.)
; 
; 
; 
; NOTE: The rotate function wants an angle in degrees as its first 
; argument. By that it means Number[0, 360). As time goes by your balloon 
; may end up spinning more than once, for example, you may get to a point 
; where it has spun 362 degrees, which rotate won't accept. 
; 
; The solution to that is to use the modulo function as follows:
; 
; (rotate (modulo ... 360) (text "hello" 30 "black"))
; 
; where ... should be replaced by the number of degrees to rotate.
; 
; NOTE: It is possible to design this program with simple atomic data, 
; but we would like you to use compound data.


(require 2htdp/image)
(require 2htdp/universe)

;; My world program: Compound P9 - Water Balloons

;; =================
;; Constants:
(define WIDTH  500)
(define HEIGHT 300)
(define WATER-BALLOON.)
(define POS-Y (/ HEIGHT 2))
(define MTS (empty-scene WIDTH HEIGHT))

;; =================
;; Data definitions:

(define-struct balloon (x y degree))
;; Balloon is (make-balloon Natural Natural Number[0, 360))
;; interp. a balloon at position x, y and degree

(define B1 (make-balloon 10 POS-Y 90))

#;
(define (fn-for-balloon b)
  (... (balloon-x b)        ; Natural
       (balloon-y b)        ; Natural
       (balloon-degree b))) ; Number[0, 360)

;; Template rules used:
;;  - compound: 3 fields

;; =================
;; Functions:

;; Balloon -> Balloon
;; start the world with (main (make-balloon 0 POS-Y 0))
;; 
(define (main b)
  (big-bang b                    ; Balloon
            (on-tick   next)     ; Balloon -> Balloon
            (to-draw   render)   ; Balloon -> Image
            (on-key    reset)))  ; Balloon KeyEvent -> Balloon

;; Balloon -> Balloon
;; increase ballon position x and degree by one; degree between 0-359
(check-expect (next (make-balloon 0  POS-Y 0))   (make-balloon 1  POS-Y 359))
(check-expect (next (make-balloon 10 POS-Y 359)) (make-balloon 11 POS-Y 358))

#;
(define (next b) B1) ; stub

;<template from Balloon>
(define (next b)
  (make-balloon
   (+ (balloon-x b) 1)
   (balloon-y b)
   (modulo (- (balloon-degree b) 1) 360)))

;; Balloon -> Image
;; place the WATER-BALLOON image on MTS at (balloon-x b) and POS-Y
;;                                      with rotate (balloon-degree b)
(check-expect (render B1) (place-image (rotate (balloon-degree B1) WATER-BALLOON)
                                       (balloon-x B1) POS-Y MTS))

;(define (render b) MTS) ; stub

;<template from Balloon>
(define (render b)
  (place-image (rotate (balloon-degree b) WATER-BALLOON)
               (balloon-x b)
               (balloon-y b)
               MTS))

;; Balloon KeyEvent -> Balloon
;; resets to the start position
(check-expect (reset B1 " ")    (make-balloon 0 POS-Y 0))
(check-expect (reset B1 "left") B1)

#;
(define (reset b ke) B1) ; stub

;<template from Balloon>
(define (reset b ke)
  (cond
    [(key=? ke " ") (make-balloon 0 (balloon-y b) 0)]
    [else b]))
