;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-108) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 108

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define SIZE 10)
(define RED   (circle SIZE "solid" "red"))
(define GREEN (circle SIZE "solid" "green"))

(define COUNT-RED   40)
(define COUNT-GREEN 20)

(define WIDTH  40)
(define HEIGHT WIDTH)
(define CENTER (/ WIDTH 2))
(define BACKGROUND (rectangle WIDTH HEIGHT "solid" "black"))


(define-struct traffic-light (state count-down))
; Traffic-Light is a structure:
; interpretation (make-traffic-light s c)
;  - s means the current state: standing or walking
;  - c means the count-down
(define TL1 (make-traffic-light "standing" COUNT-RED))
(define TL2 (make-traffic-light "standing" 20))
(define TL3 (make-traffic-light "standing"  0))
(define TL4 (make-traffic-light "walking" COUNT-GREEN))
(define TL5 (make-traffic-light "walking" 10))
(define TL6 (make-traffic-light "walking"  9))
(define TL7 (make-traffic-light "walking"  0))


; Traffic-Light -> World
; starts the world with (main TL1)
(define (main tl)
  (big-bang tl
            (on-tick tock 1)
            (on-draw render)
            (on-key  reset)))

; Traffic-Light -> Traffic-Light
; updates the states and count-down values
(check-expect (tock TL1) (make-traffic-light "standing" (sub1 COUNT-RED)))
(check-expect (tock TL2) (make-traffic-light "standing" 19))
(check-expect (tock TL3) (make-traffic-light "walking" COUNT-GREEN))
(check-expect (tock TL4) (make-traffic-light "walking" (sub1 COUNT-GREEN)))
(check-expect (tock TL5) (make-traffic-light "walking" 9))
(check-expect (tock TL6) (make-traffic-light "walking" 8))
(check-expect (tock TL7) (make-traffic-light "standing" COUNT-RED))

(define (tock tl)
  (cond [(string=? (traffic-light-state tl) "standing")
         (if (> (traffic-light-count-down tl) 0)
             (make-traffic-light "standing" (sub1 (traffic-light-count-down tl)))
             (make-traffic-light "walking" COUNT-GREEN))]
        [(string=? (traffic-light-state tl) "walking")
         (if (> (traffic-light-count-down tl) 0)
             (make-traffic-light "walking" (sub1 (traffic-light-count-down tl)))
             (make-traffic-light "standing" COUNT-RED))]))

; Traffic-Light -> Image
; renders the image of Traffic Light into the BACKGROUND scene
(check-expect (render TL1) (place-image RED CENTER CENTER BACKGROUND))
(check-expect (render TL4) (place-image GREEN CENTER CENTER BACKGROUND))
(check-expect (render TL5) (overlay/align "middle" "middle"
                                          (text "10" SIZE "red")
                                          GREEN BACKGROUND))
(check-expect (render TL6) (overlay/align "middle" "middle"
                                          (text "9" SIZE "darkgreen")
                                          GREEN BACKGROUND))
(check-expect (render TL7) (place-image GREEN CENTER CENTER BACKGROUND))

(define (render tl)
  (cond [(string=? (traffic-light-state tl) "standing")
         (place-image RED CENTER CENTER BACKGROUND)]
        [(string=? (traffic-light-state tl) "walking")
         (if (< 0 (traffic-light-count-down tl) 11)
             (overlay/align "middle" "middle"
                            (text (number->string (traffic-light-count-down tl)) SIZE
                                  (if (even? (traffic-light-count-down tl))
                                      "red"
                                      "darkgreen"))
                                  GREEN BACKGROUND)
             (place-image GREEN CENTER CENTER BACKGROUND))]))

; Traffic-Light KeyEvent -> Traffic-Light
; resets the default state
(check-expect (reset TL2 " ")    TL1)
(check-expect (reset TL2 "left") TL2)

(define (reset tl ke)
  (if (key=? ke " ") TL1 tl))
