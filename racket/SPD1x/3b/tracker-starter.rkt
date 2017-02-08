;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname tracker-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)
(require 2htdp/universe)

;; tracker-starter.rkt

; 
; PROBLEM:
; 
; Design a world program that displays the current (x, y) position
; of the mouse at that current position. So as the mouse moves the 
; numbers in the (x, y) display changes and its position changes. 
; 


;; Domain Analysis
;; Commonality:
;;  - TEXT-COLOR
;;  - TEXT-SIZE
;;  - WIDTH
;;  - HEIGHT
;;  - MTS
;; Variability:
;;  - x-value
;;  - y-value
;; World:
;;  - on-tick
;;  - on-draw
;;  - on-mouse

;; My world program: Compound P6

;; =================
;; Constants:
(define TEXT-COLOR "black")
(define TEXT-SIZE 12)
(define WIDTH  400)
(define HEIGHT 200)
(define MTS (empty-scene WIDTH HEIGHT))

;; =================
;; Data definitions:

(define-struct label (x y))
;; Label is (make-label Number Number)
;; interp. a pair (x,y) of coordinates
(define L1 (make-label 10 10))
(define L2 (make-label 50 80))

#;
(define (fn-for-label l)
  (... (label-x l)   ; Number
       (label-y l))) ; Number

;; Template rules used:
;;  - compound: 2 fields

;; =================
;; Functions:

;; Label -> Label
;; start the world with (main (make-label 0 0))
;; 
(define (main l)
  (big-bang l                    ; Label
            (to-draw   render)   ; Label -> Image
            (on-mouse  update))) ; Label Integer Integer MouseEvent -> Label

;; Label -> Image
;; render the mouse position with label
(check-expect (render L1) (place-image
                           (text (string-append
                                  "("
                                  (number->string (label-x L1))
                                  ","
                                  (number->string (label-x L1))
                                  ")")
                                 TEXT-SIZE TEXT-COLOR)
                           (label-x L1) (label-y L1)
                           MTS))

#;
(define (render l) L1) ; stub

;<template from Label>

(define (render l)
  (place-image
   (text (string-append "(" (number->string (label-x l)) "," (number->string (label-x l)) ")")
         TEXT-SIZE TEXT-COLOR)
   (label-x l) (label-y l) MTS))

;; Label Integer Integer MouseEvent -> Label
;; updates the pair of the mouse position on the screen
(check-expect (update L1 30 30 "move")        (make-label 30 30))
(check-expect (update L1 30 30 "button-down") (make-label 30 30))

#;
(define (update l x y me) L1) ; stub

;<template from Label>

(define (update l x y me)
  (make-label x y))
