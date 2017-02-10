;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-47) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 47

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define INC-DOWN-KEY 1/5)
(define INC-UP-KEY   1/3)
(define DEC  -0.1)
(define MAXIMUM 100)
(define MINIMUM   0)
(define WIDTH  400)
(define HEIGHT 200)
(define BACKGROUND (rectangle WIDTH HEIGHT "solid" "black"))

; WorldState -> WorldState
; launches the program from some initial state (gauge-prog 100)
(define (gauge-prog ws)
  (big-bang ws
            [on-tick tock]
            [to-draw render]
            [on-key  increase]))

; WorldState -> WorldState 
; decreases by DEC for every clock tick
(check-expect (tock 0)   MINIMUM)
(check-expect (tock 0.1) MINIMUM)
(check-expect (tock 0.3) (+ 0.3 DEC))

(define (tock ws)
  (cond [(<=  (+ ws DEC) MINIMUM) MINIMUM]
        [else (+ ws DEC)]))

; WorldState -> Image
; places the gauge into the scene, according to the given world state
(define (render ws)
  (place-image/align (rectangle (/ (* ws WIDTH) 100) HEIGHT "solid" "red")
                     0 (/ HEIGHT 2) "left" "center"
                     BACKGROUND))

; WorldState KeyEvent -> WorldState
; produces a increase for: up is 1/3 and down is 1/5
(check-expect (increase 10 "up")   (+ 10 (* 10 1/3)))
(check-expect (increase 10 "left") 10)
(check-expect (increase 10 "down") (+ 10 (* 10 1/5)))
(check-expect (increase 99 "up")   100)
(check-expect (increase MINIMUM "up") 1)

(define (increase ws ke)
  (cond [(and (or (key=? ke "up")
                  (key=? ke "down"))
              (= ws MINIMUM)) 1]
        [(key=? ke "up")   (if (> (+ ws (* ws 1/3))
                                  MAXIMUM)
                               MAXIMUM
                               (+ ws (* ws 1/3)))]
        [(key=? ke "down") (if (> (+ ws (* ws 1/5))
                                  MAXIMUM)
                               MAXIMUM
                               (+ ws (* ws 1/5)))]
        [else ws]))
