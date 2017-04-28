;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-215) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 215

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define SIZE 10)
(define SEG  (circle (/ SIZE 2) "solid" "red"))
(define FOOD (circle (/ SIZE 2) "solid" "green"))
(define WIDTH  600)
(define HEIGHT 400)
(define BACKGROUND (empty-scene WIDTH HEIGHT))


; A Direction is one of:
; - "left"
; - "up"
; - "right"
; - "down"
; interpretation these strings represent the directions on the screen

(define-struct snake (left top direction))
; A Snake is a structure:
;   (make-snake Number Number Direction)
; interpretation (make-snake l t d) represents a position left l and top t;
; and the direction of movement d
(define S1 (make-snake 10 10 "left"))
(define S2 (make-snake 10 10 "up"))
(define S3 (make-snake 10 10 "right"))
(define S4 (make-snake 10 10 "down"))


; Environment
; WS -> WS
; starts a world with (worm-main (make-snake (/ WIDHT 2) (/ HEIGHT 2) "down"))
(define (worm-main s)
  (big-bang s
            (on-tick tock 1)
            (to-draw render)
            (on-key event)))

; Snake -> Snake
; updates the position of the snake with the current direction
(check-expect (tock S1) (make-snake (- (snake-left S1) SIZE) (snake-top S1) (snake-direction S1)))
(check-expect (tock S2) (make-snake (snake-left S2) (- (snake-top S2) SIZE) (snake-direction S2)))
(check-expect (tock S3) (make-snake (+ (snake-left S3) SIZE) (snake-top S3) (snake-direction S3)))
(check-expect (tock S4) (make-snake (snake-left S4) (+ (snake-top S4) SIZE) (snake-direction S4)))

(define (tock s)
  (make-snake
   (cond [(string=? (snake-direction s) "left")  (- (snake-left s) SIZE)]
         [(string=? (snake-direction s) "right") (+ (snake-left s) SIZE)]
         [else (snake-left s)])
   (cond [(string=? (snake-direction s) "up")   (- (snake-top s) SIZE)]
         [(string=? (snake-direction s) "down") (+ (snake-top s) SIZE)]
         [else (snake-top s)])
   (snake-direction s)))

; Snake -> Image
; renders the snake on the BACKGROUND
(define (render s)
  (place-image SEG (snake-left s) (snake-top s) BACKGROUND))

; Snake KeyEvent -> Snake
; updates the direction of snake with Direction
(check-expect (event S1 " ")     S1)
(check-expect (event S1 "left")  S1)
(check-expect (event S1 "up")    S2)
(check-expect (event S1 "right") S3)
(check-expect (event S1 "down")  S4)

(define (event s ke)
  (make-snake (snake-left s)
              (snake-top s)
              (cond [(or (key=? ke "left")
                         (key=? ke "up")
                         (key=? ke "right")
                         (key=? ke "down")) ke]
                    [else (snake-direction s)])))

(worm-main (make-snake (/ WIDTH 2) (/ HEIGHT 2) "down"))
