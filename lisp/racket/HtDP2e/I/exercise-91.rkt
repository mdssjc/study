;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-91) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 91

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define WIDTH  400)
(define HEIGHT 400)

(define CAT (circle 6 "solid" "brown"))
(define SPEED 3)
(define OFFSET      (/ (image-width CAT) 2))
(define Y-CAT       (/ HEIGHT 2))

(define GAUGE-WIDTH  (/ WIDTH 3))
(define GAUGE-HEIGHT (/ HEIGHT 40))
(define MIN    0)
(define MAX  100)
(define DEC -0.1)
(define INC-DOWN 1/5)
(define INC-UP   1/3)

(define BACKGROUND (empty-scene WIDTH HEIGHT))


(define-struct vcat (x h d))
; A VCat is a structure:
;   (make-vcat Number Number Number)
; interpretation (make-vcat x h) describes a virtual cat
;   where x means x-coordinate
;   and   h means your happiness
;   and   d means your direction, 0 left and 1 right
(define VC1 (make-vcat 10 100 1))
(define VC2 (make-vcat WIDTH 100 1))
(define VC3 (make-vcat 0 MIN 1))
(define VC4 (make-vcat 0 0.1 1))
(define VC5 (make-vcat 0 0.3 1))
(define VC6 (make-vcat 0 10  1))
(define VC7 (make-vcat 0 (sub1 MAX) 1))
(define VC8 (make-vcat 0  100 0))
(define VC9 (make-vcat 10 100 0))


; VCat -> World
; starts a world with (happy-cat (make-vcat 0 100 0))
(define (happy-cat vcat)
  (big-bang vcat
            [on-tick   tock]
            [to-draw   render]
            [on-key    increase]
            [stop-when sad?]))

; VCat -> VCat
; moves the virtual cat by SPEED pixels and
; decreases the happiness by DEC for every clock tick,
; turn the virtual cat around when it reaches either end of the scene
(check-expect (tock VC1) (make-vcat (+ (vcat-x VC1) SPEED) (+ (vcat-h VC1) DEC) 1))
(check-expect (tock VC2) (make-vcat (- (vcat-x VC2) SPEED) (+ (vcat-h VC2) DEC) 0))
(check-expect (tock VC3) (make-vcat (+ (vcat-x VC3) SPEED) MIN 1))
(check-expect (tock VC4) (make-vcat (+ (vcat-x VC4) SPEED) MIN 1))
(check-expect (tock VC5) (make-vcat (+ (vcat-x VC5) SPEED) (+ (vcat-h VC5) DEC) 1))
(check-expect (tock VC8) (make-vcat (+ (vcat-x VC8) SPEED) (+ (vcat-h VC8) DEC) 1))
(check-expect (tock VC9) (make-vcat (- (vcat-x VC9) SPEED) (+ (vcat-h VC9) DEC) 0))

(define (tock vc)
  (make-vcat
   (cond [(>= (vcat-x vc) WIDTH) (- (vcat-x vc) SPEED)]
         [(<= (vcat-x vc)     0) (+ (vcat-x vc) SPEED)]
         [else (if (= (vcat-d vc) 1)
                   (+ (vcat-x vc) SPEED)
                   (- (vcat-x vc) SPEED))])
   (if (<= (+ (vcat-h vc) DEC) MIN)
       MIN
       (+ (vcat-h vc) DEC))
   (cond [(>= (vcat-x vc) WIDTH) 0]
         [(<= (vcat-x vc)     0) 1]
         [else (vcat-d vc)])))

; VCat -> Image
; places the virtual cat into the BACKGROUND scene
(define (render vc)
  (place-image CAT (vcat-x vc) Y-CAT
               (overlay/align "middle" "top"
                              (rectangle (* (vcat-h vc) GAUGE-WIDTH .01)
                                         GAUGE-HEIGHT
                                         "solid" "red")
                              BACKGROUND)))

; VCat KeyEvent -> VCat
; produces a increase in happiness for:
; up is 1/3 and down is 1/5
(check-expect (increase VC6 "up")   (make-vcat (vcat-x VC6) (calculate (vcat-h VC6) INC-UP) (vcat-d VC6)))
(check-expect (increase VC6 "left") VC6)
(check-expect (increase VC6 "down") (make-vcat (vcat-x VC6) (calculate (vcat-h VC6) INC-DOWN) (vcat-d VC6)))
(check-expect (increase VC7 "up")   (make-vcat (vcat-x VC7) MAX (vcat-d VC7)))
(check-expect (increase VC7 "down") (make-vcat (vcat-x VC7) MAX (vcat-d VC7)))
(check-expect (increase VC3 "up")   (make-vcat (vcat-x VC3) 1 (vcat-d VC3)))
(check-expect (increase VC3 "down") (make-vcat (vcat-x VC3) 1 (vcat-d VC3)))

(define (increase vc ke)
  (make-vcat (vcat-x vc)
             (cond [(key=? ke "up")   (calculate (vcat-h vc) INC-UP)]
                   [(key=? ke "down") (calculate (vcat-h vc) INC-DOWN)]
                   [else (vcat-h vc)])
             (vcat-d vc)))

; Number -> Number
; help function for increase x by n, limited by MAX
(define (calculate x n)
  (cond [(= x MIN) 1]
        [(> (+ x (* x n)) MAX) MAX]
        [else (+ x (* x n))]))

; VCat -> Boolean
; stops when the virtual cat is sad
(check-expect (sad? VC3) #true)
(check-expect (sad? VC1) #false)

(define (sad? vc)
  (= (vcat-h vc) MIN))
