;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-218) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 218

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define SIZE 10)
(define SEG  (circle (/ SIZE 2) "solid" "red"))
(define FOOD (circle (/ SIZE 2) "solid" "green"))
(define WIDTH  600)
(define HEIGHT 400)
(define BACKGROUND (empty-scene WIDTH HEIGHT))


; Variability
; A Direction is one of:
; - "left"
; - "up"
; - "right"
; - "down"
; interpretation these strings represent the directions on the screen

(define-struct tail (left top))
; A Tail is a structure:
;   (make-tail Number Number)
; interpretation (make-tail l t) represents a position left l and top t

; A Tails is one of:
; '()
; '(cons Tail Tails)
; interpretation represents the tail of the snake

(define-struct snake (left top direction tails))
; A Snake is a structure:
;   (make-snake Number Number Direction Tails)
; interpretation (make-snake l t d t) represents a position left l and top t;
; the direction of movement d and the tails t
(define S1 (make-snake 10 10 "left"  '()))
(define S2 (make-snake 10 10 "up"    '()))
(define S3 (make-snake 10 10 "right" '()))
(define S4 (make-snake 10 10 "down"  '()))
(define S5 (make-snake 10 10 "down" (cons (make-tail 0 0)
                                          (cons (make-tail 10 0) '()))))
(define S6 (make-snake 0 0 "down" (cons (make-tail 0 0)
                                        (cons (make-tail 10 0)
                                              (cons (make-tail 10 10)
                                                    (cons (make-tail 0 10) '()))))))


; Environment
; WS -> WS
; starts a world with (worm-main (make-snake (/ WIDHT 2) (/ HEIGHT 2) "down" '())
(define (worm-main s)
  (big-bang s
            (on-tick tock 1)
            (to-draw render)
            (on-key event)
            (stop-when hit-border? game-over)))

; Snake -> Snake
; updates the position of the snake with the current direction
(check-expect (tock S1) (make-snake (- (snake-left S1) SIZE) (snake-top S1) (snake-direction S1) (snake-tails S1)))
(check-expect (tock S2) (make-snake (snake-left S2) (- (snake-top S2) SIZE) (snake-direction S2) (snake-tails S2)))
(check-expect (tock S3) (make-snake (+ (snake-left S3) SIZE) (snake-top S3) (snake-direction S3) (snake-tails S3)))
(check-expect (tock S4) (make-snake (snake-left S4) (+ (snake-top S4) SIZE) (snake-direction S4) (snake-tails S4)))
(check-expect (tock S5) (make-snake (snake-left S5) (+ (snake-top S5) SIZE)
                                    (snake-direction S5)
                                    (cons (make-tail 10 0)
                                          (cons (make-tail 10 10) '()))))

(define (tock s)
  (make-snake
   (cond [(string=? (snake-direction s) "left")  (- (snake-left s) SIZE)]
         [(string=? (snake-direction s) "right") (+ (snake-left s) SIZE)]
         [else (snake-left s)])
   (cond [(string=? (snake-direction s) "up")   (- (snake-top s) SIZE)]
         [(string=? (snake-direction s) "down") (+ (snake-top s) SIZE)]
         [else (snake-top s)])
   (snake-direction s)
   (cond [(empty? (snake-tails s)) '()]
         [else (rest (reverse (cons (make-tail (snake-left s) (snake-top s))
                                    (reverse (snake-tails s)))))])))

; Snake -> Image
; renders the snake on the BACKGROUND
(define (render s)
  (place-image SEG
               (+ (snake-left s) (/ SIZE 2))
               (+ (snake-top s)  (/ SIZE 2))
               (render-tails (snake-tails s))))

; Tails -> Image
; renders the tails on the BACKGROUND
(define (render-tails t)
  (cond [(empty? t) BACKGROUND]
        [else (place-image SEG
                           (+ (tail-left (first t)) (/ SIZE 2))
                           (+ (tail-top (first t)) (/ SIZE 2))
                           (render-tails (rest t)))]))

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
                    [else (snake-direction s)])
              (snake-tails s)))

; Snake -> Boolean
; stops if the snake has run into the walls of the world
(check-expect (hit-border? (make-snake 0 10 "left" '())) #true)
(check-expect (hit-border? (make-snake 0 10 "up" '())) #false)
(check-expect (hit-border? (make-snake 0 10 "right" '())) #false)
(check-expect (hit-border? (make-snake 0 10 "down" '())) #false)
(check-expect (hit-border? (make-snake 10 0 "up" '())) #true)
(check-expect (hit-border? (make-snake 10 0 "right" '())) #false)
(check-expect (hit-border? (make-snake 10 0 "down" '())) #false)
(check-expect (hit-border? (make-snake 10 0 "left" '())) #false)
(check-expect (hit-border? (make-snake (- WIDTH SIZE) 10 "right" '())) #true)
(check-expect (hit-border? (make-snake (- WIDTH SIZE) 10 "down" '())) #false)
(check-expect (hit-border? (make-snake (- WIDTH SIZE) 10 "left" '())) #false)
(check-expect (hit-border? (make-snake (- WIDTH SIZE) 10 "up" '())) #false)
(check-expect (hit-border? (make-snake 10 (- HEIGHT SIZE) "down" '())) #true)
(check-expect (hit-border? (make-snake 10 (- HEIGHT SIZE) "left" '())) #false)
(check-expect (hit-border? (make-snake 10 (- HEIGHT SIZE) "up" '())) #false)
(check-expect (hit-border? (make-snake 10 (- HEIGHT SIZE) "right" '())) #false)
(check-expect (hit-border? S1) #false)
(check-expect (hit-border? S6) #true)

(define (hit-border? s)
  (or (and (= (snake-left s) 0) (string=? (snake-direction s) "left"))
      (and (= (snake-top s)  0) (string=? (snake-direction s) "up"))
      (and (= (snake-left s) (- WIDTH SIZE))  (string=? (snake-direction s) "right"))
      (and (= (snake-top s)  (- HEIGHT SIZE)) (string=? (snake-direction s) "down"))
      (member? (make-tail (snake-left s) (snake-top s)) (snake-tails s))))

; Snake -> Image
; renders the game over message on the last render
(define (game-over s)
  (place-image (text "worm hit border" 12 "black") 50 (- HEIGHT 10) (render s)))

(worm-main S5)
