;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-93) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 93

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define WIDTH  400)
(define HEIGHT 400)

(define CHAM (circle 6 "solid" "red"))
(define SPEED 3)
(define OFFSET  (/ (image-width CHAM) 2))
(define LIMIT-X (+ WIDTH OFFSET))
(define Y-CHAM  (/ HEIGHT 2))

(define GAUGE-WIDTH  (/ WIDTH 3))
(define GAUGE-HEIGHT (/ HEIGHT 40))
(define MIN    0)
(define MAX  100)
(define DEC -0.1)
(define INC-DOWN 1/5)
(define INC-UP   1/3)

(define BACKGROUND
  (beside (empty-scene (/ WIDTH 3) HEIGHT "green")
          (empty-scene (/ WIDTH 3) HEIGHT "white")
          (empty-scene (/ WIDTH 3) HEIGHT "red")))


(define-struct vcham (x h c))
; A VCham is a structure:
;   (make-vcham Number Number String)
; interpretation (make-vcham x h c) describes a virtual cham
;   where x means x-coordinate
;   and   h means your happiness
;   and   c means your color
(define VC1 (make-vcham 0 100 "red"))
(define VC2 (make-vcham LIMIT-X 100 "red"))
(define VC3 (make-vcham 0 MIN "red"))
(define VC4 (make-vcham 0 0.1 "red"))
(define VC5 (make-vcham 0 0.3 "red"))
(define VC6 (make-vcham 0 10 "red"))
(define VC7 (make-vcham 0 (sub1 MAX) "red"))
(define VC8 (make-vcham 0 10 "green"))
(define VC9 (make-vcham 0 10 "blue"))


; VCham -> World
; starts a world with (cham (make-vcham 0 100 "red"))
(define (cham vcham)
  (big-bang vcham
            [on-tick   tock]
            [to-draw   render]
            [on-key    interact]
            [stop-when sad?]))

; VCham -> VCham
; moves the virtual cham by SPEED pixels and
; decreases the happiness by DEC for every clock tick,
; reset when the virtual cham disappears on the right
(check-expect (tock VC1) (make-vcham (+ (vcham-x VC1) SPEED) (+ (vcham-h VC1) DEC) "red"))
(check-expect (tock VC2) (make-vcham 0 (+ (vcham-h VC2) DEC) "red"))
(check-expect (tock VC3) (make-vcham (+ (vcham-x VC3) SPEED) MIN "red"))
(check-expect (tock VC4) (make-vcham (+ (vcham-x VC4) SPEED) MIN "red"))
(check-expect (tock VC5) (make-vcham (+ (vcham-x VC5) SPEED) (+ (vcham-h VC5) DEC) "red"))

(define (tock vc)
  (make-vcham
   (if (>= (+ (vcham-x vc) SPEED)
           LIMIT-X)
       0
       (+ (vcham-x vc) SPEED))
   (if (<= (+ (vcham-h vc) DEC) MIN)
       MIN
       (+ (vcham-h vc) DEC))
   (vcham-c vc)))

; VCham -> Image
; places the virtual cham into the BACKGROUND scene
(define (render vc)
  (place-image (circle 6 "solid" (vcham-c vc)) (vcham-x vc) Y-CHAM
               (overlay/align "middle" "top"
                              (rectangle (* (vcham-h vc) GAUGE-WIDTH .01)
                                         GAUGE-HEIGHT
                                         "solid" "red")
                              BACKGROUND)))

; VCham KeyEvent -> VCham
; interacts with the cham:
;  happiness: up is 1/3 and down is 1/5
;  color: r is "red", g is "green" and b is "blue"
(check-expect (interact VC6 "up")   (make-vcham (vcham-x VC6) (calculate (vcham-h VC6) INC-UP) "red"))
(check-expect (interact VC6 "left") VC6)
(check-expect (interact VC6 "down") (make-vcham (vcham-x VC6) (calculate (vcham-h VC6) INC-DOWN) "red"))
(check-expect (interact VC7 "up")   (make-vcham (vcham-x VC7) MAX "red"))
(check-expect (interact VC7 "down") (make-vcham (vcham-x VC7) MAX "red"))
(check-expect (interact VC3 "up")   (make-vcham (vcham-x VC3) 1 "red"))
(check-expect (interact VC3 "down") (make-vcham (vcham-x VC3) 1 "red"))
(check-expect (interact VC9 "r") VC6)
(check-expect (interact VC6 "g") VC8)
(check-expect (interact VC8 "b") VC9)

(define (interact vc ke)
  (make-vcham (vcham-x vc)
              (cond [(key=? ke "up")   (calculate (vcham-h vc) INC-UP)]
                    [(key=? ke "down") (calculate (vcham-h vc) INC-DOWN)]
                    [else (vcham-h vc)])
              (cond [(key=? ke "r") "red"]
                    [(key=? ke "g") "green"]
                    [(key=? ke "b") "blue"]
                    [else (vcham-c vc)])))

; Number -> Number
; help function for increase x by n, limited by MAX
(define (calculate x n)
  (cond [(= x MIN) 1]
        [(> (+ x (* x n)) MAX) MAX]
        [else (+ x (* x n))]))

; VCham -> Boolean
; stops when the virtual cham is sad
(check-expect (sad? VC3) #true)
(check-expect (sad? VC1) #false)

(define (sad? vc)
  (= (vcham-h vc) MIN))
