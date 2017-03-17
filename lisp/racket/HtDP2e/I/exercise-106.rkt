;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-106) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 106

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define WIDTH  400)
(define HEIGHT 400)

(define CAT (circle 6 "solid" "brown"))
(define OFFSET-CAT (/ (image-width CAT) 2))

(define CHAM (circle 6 "solid" "red"))
(define OFFSET-CHAM  (/ (image-width CHAM) 2))

(define Y-VA (/ HEIGHT 2))
(define SPEED 3)

(define GAUGE-WIDTH  (/ WIDTH 3))
(define GAUGE-HEIGHT (/ HEIGHT 40))
(define MIN    0)
(define MAX  100)
(define DEC -0.1)
(define INC-DOWN 1/5)
(define INC-UP   1/3)

(define BACKGROUND (empty-scene WIDTH HEIGHT))


(define-struct vcat (x h))
; A VCat is a structure:
;   (make-vcat Number Number)
; interpretation (make-vcat x h) describes a virtual cat
; where x means x-coordinate
; and   h means your happiness

(define-struct vcham (x h c))
; A VCham is a structure:
;   (make-vcham Number Number String)
; interpretation (make-vcham x h c) describes a virtual cham
;   where x means x-coordinate
;   and   h means your happiness
;   and   c means your color

; A VAnimal is either
; - a VCat
; - a VCham


; VAnimal -> World
; starts a world with (cat-cham (make-vcat 0 100)) or (cat-cham (make-vcham 0 100 "red"))
(define (cat-cham va)
  (big-bang va
            [on-tick tock]
            [to-draw render]
            [on-key  interact]))

; VAnimal -> VAnimal
; moves the virtual animal by SPEED pixels and
; decreases the happiness by DEC for every clock tick,
; reset when the virtual animal disappears on the right
(define (tock va)
  (cond [(vcat?  va) (make-vcat
                      (do-x-coordinate va OFFSET-CAT)
                      (do-happiness va))]
        [(vcham? va) (make-vcham
                      (do-x-coordinate va OFFSET-CHAM)
                      (do-happiness va)
                      (vcham-c va))]))

; VAnimal Number -> Number
; updates the x-coordinate
(define (do-x-coordinate x offset)
  (if (>= (+ (va-x-coordinate x) SPEED)
          (+ WIDTH offset))
      0
      (+ (va-x-coordinate x) SPEED)))

; VAnimal Number -> Number
; updates the happiness
(define (do-happiness h)
  (if (<= (+ (va-happiness h) DEC) MIN)
      MIN
      (+ (va-happiness h) DEC)))

; VAnimal -> Image
; places the virtual animal into the BACKGROUND scene
(define (render va)
  (place-image (cond [(vcat?  va) CAT]
                     [(vcham? va) (circle 6 "solid" (vcham-c va))])
               (va-x-coordinate va) Y-VA
               (overlay/align "middle" "top"
                              (rectangle (* (va-happiness va) GAUGE-WIDTH .01)
                                         GAUGE-HEIGHT
                                         "solid" "red")
                              BACKGROUND)))

; VAnimal KeyEvent -> VAnimal
; interacts with the virtual animal:
;  happiness: up is 1/3 and down is 1/5
;  color: r is "red", g is "green" and b is "blue"
(define (interact va ke)
  (cond [(vcat? va) (make-vcat (vcat-x va)
                               (cond [(key=? ke "up")   (calculate (vcat-h va) INC-UP)]
                                     [(key=? ke "down") (calculate (vcat-h va) INC-DOWN)]
                                     [else (vcat-h va)]))]
        [(vcham? va) (make-vcham (vcham-x va)
                                 (cond [(key=? ke "up")   (calculate (vcham-h va) INC-UP)]
                                       [(key=? ke "down") (calculate (vcham-h va) INC-DOWN)]
                                       [else (vcham-h va)])
                                 (cond [(key=? ke "r") "red"]
                                       [(key=? ke "g") "green"]
                                       [(key=? ke "b") "blue"]
                                       [else (vcham-c va)]))]))

; Number -> Number
; help function for increase x by n, limited by MAX
(define (calculate x n)
  (cond [(= x MIN) 1]
        [(> (+ x (* x n)) MAX) MAX]
        [else (+ x (* x n))]))

; VAnimal -> Number
; returns the x-coordinate
(define (va-x-coordinate va)
  (cond [(vcat?  va) (vcat-x  va)]
        [(vcham? va) (vcham-x va)]))

; VAnimal -> Number
; returns the happiness
(define (va-happiness va)
  (cond [(vcat?  va) (vcat-h  va)]
        [(vcham? va) (vcham-h va)]))
