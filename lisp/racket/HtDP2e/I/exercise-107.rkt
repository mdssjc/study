;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-107) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 107

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

(define-struct zoo (cat cham focus))
; A Zoo is a structure:
; interpretation (make-zoo VCat VCham String)
;  cat means a VCat type
;  cham means a VCham type
;  focus means the selected animal, "k" for the Cat and "l" for the Cham
(define Z1 (make-zoo (make-vcat 50 100)
                     (make-vcham 10 100 "red")
                     "k"))


; Zoo -> World
; starts a world with (cham-and-cat Z1)
(define (cham-and-cat z)
  (big-bang z
            [on-tick tock]
            [to-draw render]
            [on-key  interact]))

; Zoo -> Zoo
; moves the virtual animals by SPEED pixels and
; decreases the happiness by DEC for every clock tick,
; reset when the virtual animals disappears on the right
(define (tock z)
  (make-zoo (make-vcat
             (do-x-coordinate (zoo-cat z) OFFSET-CAT)
             (do-happiness (zoo-cat z)))
            (make-vcham
             (do-x-coordinate (zoo-cham z) OFFSET-CHAM)
             (do-happiness (zoo-cham z))
             (vcham-c (zoo-cham z)))
            (zoo-focus z)))

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

; Zoo -> Image
; places the virtual animals into the BACKGROUND scene
(define (render z)
  (place-image CAT (va-x-coordinate (zoo-cat z)) Y-VA 
               (place-image (circle 6 "solid" (vcham-c (zoo-cham z))) (va-x-coordinate (zoo-cham z)) Y-VA 
                            (overlay/align "left" "top"
                                           (rectangle (* (va-happiness (zoo-cat z)) GAUGE-WIDTH .01)
                                                      GAUGE-HEIGHT
                                                      "solid" "red")
                                           (overlay/align "right" "top"
                                                          (rectangle (* (va-happiness (zoo-cham z)) GAUGE-WIDTH .01)
                                                                     GAUGE-HEIGHT
                                                                     "solid" "red")
                                                          BACKGROUND)))))

; Zoo KeyEvent -> Zoo
; interacts with virtual animals:
;  happiness: up is 1/3 and down is 1/5
;  color: r is "red", g is "green" and b is "blue"
;  focus: k is "Cat" and l is "Cham"
(define (interact z ke)
  (cond
    [(key=? ke "k") (make-zoo (zoo-cat z) (zoo-cham z) "k")]
    [(key=? ke "l") (make-zoo (zoo-cat z) (zoo-cham z) "l")]
    [(string=? (zoo-focus z) "k")
     (make-zoo
      (make-vcat (vcat-x (zoo-cat z))
                 (cond [(key=? ke "up")   (calculate (vcat-h (zoo-cat z)) INC-UP)]
                       [(key=? ke "down") (calculate (vcat-h (zoo-cat z)) INC-DOWN)]
                       [else (vcat-h (zoo-cat z))]))
      (zoo-cham z)
      (zoo-focus z))]
    [(string=? (zoo-focus z) "l")
     (make-zoo
      (zoo-cat z)
      (make-vcham (vcham-x (zoo-cham z))
                  (cond [(key=? ke "up")   (calculate (vcham-h (zoo-cham z)) INC-UP)]
                        [(key=? ke "down") (calculate (vcham-h (zoo-cham z)) INC-DOWN)]
                        [else (vcham-h (zoo-cham z))])
                  (cond [(key=? ke "r") "red"]
                        [(key=? ke "g") "green"]
                        [(key=? ke "b") "blue"]
                        [else (vcham-c (zoo-cham z))]))
      (zoo-focus z))]))

; Number -> Number
; help function for increase x by n, limited by MAX
(define (calculate x n)
  (cond [(= x MIN) 1]
        [(> (+ x (* x n)) MAX) MAX]
        [else (+ x (* x n))]))

; Zoo -> Number
; returns the x-coordinate
(define (va-x-coordinate va)
  (cond [(vcat?  va) (vcat-x  va)]
        [(vcham? va) (vcham-x va)]))

; Zoo -> Number
; returns the happiness
(define (va-happiness va)
  (cond [(vcat?  va) (vcat-h  va)]
        [(vcham? va) (vcham-h va)]))
