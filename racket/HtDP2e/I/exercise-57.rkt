;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-57) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 57

(require 2htdp/image)
(require 2htdp/universe)

(define HEIGHT 300)
(define WIDTH  100)
(define YDELTA 3)
 
(define BACKG  (empty-scene WIDTH HEIGHT))
(define ROCKET (rectangle 5 30 "solid" "red"))
 
(define CENTER (/ (image-height ROCKET) 2))

; A LRCD (for launching rocket count down) is one of:
; – "resting"
; – a Number between -3 and -1
; – a NonnegativeNumber 
; interpretation a grounded rocket, in count-down mode,
; a number denotes the height in pixels of rocket at canvas

; LRCD -> LRCD
; launches the program from some initial state (main2 "resting")
(define (main2 s)
  (big-bang s
            [on-tick   fly]
            [to-draw   show]
            [on-key    launch]
            [stop-when end?]))

; LRCD -> Image
; renders the state as a resting or flying rocket
(check-expect (show "resting") (draw HEIGHT))
(check-expect (show -2) (place-image (text "-2" 20 "red")
                                     10 (* 3/4 WIDTH)
                                     (draw HEIGHT)))
(check-expect (show HEIGHT) (draw HEIGHT))
(check-expect (show 53) (draw 53))

(define (show x)
  (cond
    [(string? x) (draw HEIGHT)]
    [(<= -3 x -1) (place-image (text (number->string x) 20 "red")
                               10 (* 3/4 WIDTH)
                               (draw HEIGHT))]
    [(>= x 0) (draw x)]))

; LRCD -> Image
; produces a rocket at height h
(define (draw h)
  (place-image ROCKET 10 (- (- HEIGHT h) CENTER) BACKG))

; LRCD KeyEvent -> LRCD
; starts the count-down when space bar is pressed, 
; if the rocket is still resting
(check-expect (launch "resting" " ") -3)
(check-expect (launch "resting" "a") "resting")
(check-expect (launch -3 " ") -3)
(check-expect (launch -1 " ") -1)
(check-expect (launch 33 " ") 33)
(check-expect (launch 33 "a") 33)

(define (launch x ke)
  (cond
    [(string? x) (if (string=? " " ke) -3 x)]
    [(<= -3 x -1) x]
    [(>= x 0) x]))

; LRCD -> LRCD
; raises the rocket by YDELTA if it is moving already 
(check-expect (fly "resting") "resting")
(check-expect (fly -3) -2)
(check-expect (fly -2) -1)
(check-expect (fly -1) 0)
(check-expect (fly 10) (+ 10 YDELTA))
(check-expect (fly 22) (+ 22 YDELTA))

(define (fly x)
  (cond
    [(string? x) x]
    [(<= -3 x -1) (if (= x -1) 0 (+ x 1))]
    [(>= x 0) (+ x YDELTA)]))

; LRCD -> Boolean
; produces true if the rocket is out of sight
(check-expect (end? "resting") #false)
(check-expect (end? -3) #false)
(check-expect (end? -2) #false)
(check-expect (end? -1) #false)
(check-expect (end? 33) #false)
(check-expect (end? HEIGHT) #true)

(define (end? x)
  (cond
    [(string? x)  #false]
    [(<= -3 x -1) #false]
    [(= x HEIGHT) #true]
    [else         #false]))
