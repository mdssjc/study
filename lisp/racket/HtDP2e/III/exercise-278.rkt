;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-278) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 278

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

(define-struct snake (left top direction tails food))
; A Snake is a structure:
;   (make-snake Number Number Direction Tails Posn)
; interpretation (make-snake l t d t f) represents a position left l and top t;
; the direction of movement d, the tails t and the food f position
(define S0 (make-snake (/ WIDTH 2) (/ HEIGHT 2) "down" '() (make-posn 100 10)))
(define S1 (make-snake 10 10 "left"  '() null))
(define S2 (make-snake 10 10 "up"    '() null))
(define S3 (make-snake 10 10 "right" '() null))
(define S4 (make-snake 10 10 "down"  '() null))
(define S5 (make-snake 10 10 "down" (cons (make-tail 0 0)
                                          (cons (make-tail 10 0) '()))
                       (make-posn 10 50)))
(define S6 (make-snake 10 10 "up" (cons (make-tail 10 10)
                                        (cons (make-tail 20 10)
                                              (cons (make-tail 20 20)
                                                    (cons (make-tail 10 20) '())))) null))
(define S7 (make-snake 10 10 "down" (cons (make-tail 0 0)
                                          (cons (make-tail 10 0) '()))
                       (make-posn 10 20)))
(define S8 (make-snake 10 10 "down" '() (make-posn 10 20)))


; Environment
; WS -> WS
; starts a world with (worm-main S0)
(define (worm-main s)
  (big-bang s
            (on-tick tock 1)
            (to-draw render)
            (on-key event)
            (stop-when hit-border? game-over)))

; Snake -> Snake
; updates the position of the snake with the current direction
(check-expect (tock S5) (make-snake (future-left S5)
                                    (future-top S5)
                                    (snake-direction S5)
                                    (cons (make-tail 10 0)
                                          (cons (make-tail 10 10) '()))
                                    (snake-food S5)))
(check-random (tock S7) (make-snake (future-left S7)
                                    (future-top S7)
                                    (snake-direction S7)
                                    (cons (make-tail 0 0)
                                          (cons (make-tail 10 0)
                                                (cons (make-tail 10 10) '())))
                                    (food-create (make-posn (future-left S7) (future-top S7)))))
(check-random (tock S8) (make-snake (future-left S8)
                                    (future-top S8)
                                    (snake-direction S8)
                                    (cons (make-tail 10 10) '())
                                    (food-create (make-posn (future-left S8) (future-top S8)))))
(check-expect (tock S0) (make-snake (future-left S0)
                                    (future-top S0)
                                    (snake-direction S0)
                                    '()
                                    (snake-food S0)))

(define (tock s)
  (make-snake
   (future-left s)
   (future-top s)
   (snake-direction s)
   (cond [(eat? (future-left s) (future-top s) (snake-food s))
          (append (snake-tails s)
                  (list (make-tail (snake-left s)
                                   (snake-top s))))]
         [(empty? (snake-tails s)) '()]
         [else (append (rest (snake-tails s))
                       (list (make-tail (snake-left s)
                                        (snake-top s))))])
   (cond [(eat? (future-left s) (future-top s) (snake-food s))
          (food-create (make-posn (future-left s)
                                  (future-top s)))]
         [else (snake-food s)])))

; Snake -> Number
; calculates the future value for the left position
(check-expect (future-left S1) (- (snake-left S1) SIZE))
(check-expect (future-left S2) (snake-left S2))
(check-expect (future-left S3) (+ (snake-left S3) SIZE))
(check-expect (future-left S4) (snake-left S4))

(define (future-left s)
  (cond [(string=? (snake-direction s) "left")  (- (snake-left s) SIZE)]
        [(string=? (snake-direction s) "right") (+ (snake-left s) SIZE)]
        [else (snake-left s)]))

; Snake -> Number
; calculates the future value for the top position
(check-expect (future-top S1) (snake-top S1))
(check-expect (future-top S2) (- (snake-top S2) SIZE))
(check-expect (future-top S3) (snake-top S3))
(check-expect (future-top S4) (+ (snake-top S4) SIZE))

(define (future-top s)
  (cond [(string=? (snake-direction s) "up")   (- (snake-top s) SIZE)]
        [(string=? (snake-direction s) "down") (+ (snake-top s) SIZE)]
        [else (snake-top s)]))

; Number Number Posn -> Boolean
; checks if the distance from the left and top position is near the food position in SIZE
(check-expect (eat? 0 0 (make-posn 0 0))   #true)
(check-expect (eat? 0 0 (make-posn 0 10))  #true)
(check-expect (eat? 0 0 (make-posn 0 -10)) #true)
(check-expect (eat? 0 0 (make-posn 10 0))  #true)
(check-expect (eat? 0 0 (make-posn -10 0)) #true)
(check-expect (eat? 0 0 (make-posn 10 10)) #false)

(define (eat? l t p)
  (<= (sqrt (+ (sqr (- (posn-x p) l))
               (sqr (- (posn-y p) t))))
      SIZE))

; Snake -> Image
; renders the snake on the BACKGROUND
(define (render s)
  (place-image FOOD
               (+ (posn-x (snake-food s)) (/ SIZE 2))
               (+ (posn-y (snake-food s)) (/ SIZE 2))
               (place-image SEG
                            (+ (snake-left s) (/ SIZE 2))
                            (+ (snake-top s)  (/ SIZE 2))
                            (render-tails (snake-tails s)))))

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
(check-expect (event S7 "up")    S7)

(define (event s ke)
  (make-snake (snake-left s)
              (snake-top s)
              (cond [(and (not (empty? (snake-tails s)))
                          (or (and (key=? ke "left")  (string=? (snake-direction s) "right"))
                              (and (key=? ke "right") (string=? (snake-direction s) "left"))
                              (and (key=? ke "up")    (string=? (snake-direction s) "down"))
                              (and (key=? ke "down")  (string=? (snake-direction s) "up"))))
                     (snake-direction s)]
                    [(or (key=? ke "left")
                         (key=? ke "up")
                         (key=? ke "right")
                         (key=? ke "down")) ke]
                    [else (snake-direction s)])
              (snake-tails s)
              (snake-food s)))

; Snake -> Boolean
; stops if the snake has run into the walls of the world
(check-expect (hit-border? (make-snake 0 10 "left" '() null)) #true)
(check-expect (hit-border? (make-snake 0 10 "up" '() null)) #false)
(check-expect (hit-border? (make-snake 0 10 "right" '() null)) #false)
(check-expect (hit-border? (make-snake 0 10 "down" '() null)) #false)
(check-expect (hit-border? (make-snake 10 0 "up" '() null)) #true)
(check-expect (hit-border? (make-snake 10 0 "right" '() null)) #false)
(check-expect (hit-border? (make-snake 10 0 "down" '() null)) #false)
(check-expect (hit-border? (make-snake 10 0 "left" '() null)) #false)
(check-expect (hit-border? (make-snake (- WIDTH SIZE) 10 "right" '() null)) #true)
(check-expect (hit-border? (make-snake (- WIDTH SIZE) 10 "down" '() null)) #false)
(check-expect (hit-border? (make-snake (- WIDTH SIZE) 10 "left" '() null)) #false)
(check-expect (hit-border? (make-snake (- WIDTH SIZE) 10 "up" '() null)) #false)
(check-expect (hit-border? (make-snake 10 (- HEIGHT SIZE) "down" '() null)) #true)
(check-expect (hit-border? (make-snake 10 (- HEIGHT SIZE) "left" '() null)) #false)
(check-expect (hit-border? (make-snake 10 (- HEIGHT SIZE) "up" '() null)) #false)
(check-expect (hit-border? (make-snake 10 (- HEIGHT SIZE) "right" '() null)) #false)
(check-expect (hit-border? S1) #false)
(check-expect (hit-border? S6) #true)

(define (hit-border? s)
  (local ((define (hit-border? s)
            (or (dir? left 0 "left")
                (dir? top  0 "up")
                (dir? left (- WIDTH  SIZE) "right")
                (dir? top  (- HEIGHT SIZE) "down")
                (member? (make-tail left top) (snake-tails s))))

          (define left  (snake-left s))
          (define top   (snake-top s))
          
          (define (dir? p r d)
            (and (= p r)
                 (string=? (snake-direction s) d))))
    (hit-border? s)))

; Snake -> Image
; renders the game over message on the last render
(define (game-over s)
  (place-image (text "worm hit border" 12 "black") 50 (- HEIGHT 10) (render s)))

; Posn -> Posn 
; creates a food randomly between WIDTH and HEIGHT
(check-satisfied (food-create (make-posn 1 1)) not-equal-1-1?)
 
(define (food-create p)
  (local ((define (food-create p)
            (food-check-create p (make-posn (random WIDTH)
                                            (random HEIGHT))))

          (define (food-check-create p candidate)
            (if (equal? p candidate)
                (food-create p)
                candidate)))
    (food-create p)))
 
; Posn -> Boolean
; use for testing only 
(define (not-equal-1-1? p)
  (not (and (= (posn-x p) 1) (= (posn-y p) 1))))

(worm-main S0)
