;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |4-Intervals, Enumerations, and Itemizations|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 4-Intervals, Enumerations, and Itemizations.rkt
;; I - Fixed-Size Data
;; 4 - Intervals, Enumerations, and Itemizations

(require 2htdp/image)
(require 2htdp/universe)


;; 4.1 - Programming with Conditionals



;; 4.2 - Computing Conditionally

;; Exercise 48

(define (reward s)
  (cond
    [(<= 0 s 10) "bronze"]
    [(and (< 10 s) (<= s 20)) "silver"]
    [else "gold"]))

(reward 18)

(cond
  [(<= 0 18 10) "bronze"]
  [(and (< 10 18) (<= 18 20)) "silver"]
  [else "gold"])

(cond
  [#false "bronze"]
  [(and (< 10 18) (<= 18 20)) "silver"]
  [else "gold"])

(cond
  [(and #true (<= 18 20)) "silver"]
  [else "gold"])

(cond
  [(and #true #true) "silver"]
  [else "gold"])

(cond
  [#true "silver"]
  [else "gold"])

"silver"

;; Exercise 49

; (- 200 (cond [(> y 200) 0] [else y]))

; y as 100
(- 200 (cond [(> 100 200) 0] [else 100]))

(- 200 (cond [#false 0] [else 100]))

(- 200 (cond [else 100]))

(- 200 100)

100

; y as 210
(- 200 (cond [(> 210 200) 0] [else 210]))

(- 200 (cond [#true 0] [else 210]))

(- 200 0)

200

; --

(define EX49_WIDTH  100)
(define EX49_HEIGHT 60)
(define EX49_MTSCN  (empty-scene EX49_WIDTH EX49_HEIGHT))
(define ROCKET (rectangle 10 20 "solid" "blue"))
(define ROCKET-CENTER-TO-TOP (- EX49_HEIGHT (/ (image-height ROCKET) 2)))

(define (create-rocket-scene.v5a h)
  (cond
    [(<= h ROCKET-CENTER-TO-TOP)
     (place-image ROCKET 50 h EX49_MTSCN)]
    [(> h ROCKET-CENTER-TO-TOP)
     (place-image ROCKET 50 ROCKET-CENTER-TO-TOP EX49_MTSCN)]))

(define (create-rocket-scene.v5b h)
  (place-image ROCKET
               50 (cond [(<= h ROCKET-CENTER-TO-TOP) h]
                        [(>  h ROCKET-CENTER-TO-TOP) ROCKET-CENTER-TO-TOP])
               EX49_MTSCN))



;; 4.3 - Enumerations

;; Exercise 50

;; Exercise 51

(define EX51_WIDTH  400)
(define EX51_HEIGHT 200)
(define EX51_MTS (empty-scene EX51_WIDTH EX51_HEIGHT))


; A TrafficLight is one of the following Strings:
; - "red"
; - "green"
; - "yellow"
; interpretation the three strings represent the three
; possible states that a traffic light may assume


; TrafficLight -> TrafficLight
; start the world with (main "red")
(define (main tl)
  (big-bang tl
            (on-tick traffic-light-next 3)
            (on-draw render)))

; TrafficLight -> TrafficLight
; yields the next state given current state s
(check-expect (traffic-light-next "red")    "green")
(check-expect (traffic-light-next "green")  "yellow")
(check-expect (traffic-light-next "yellow") "red")

(define (traffic-light-next s)
  (cond
    [(string=? "red"    s) "green"]
    [(string=? "green"  s) "yellow"]
    [(string=? "yellow" s) "red"]))

; TrafficLight -> Image
; produces the traffic light image with world state
(define (render tl)
  (place-image (circle (/ EX51_HEIGHT 3) "solid" tl)
               (/ EX51_WIDTH  2)
               (/ EX51_HEIGHT 2)
               EX51_MTS))



;; 4.4 - Intervals

;; Exercise 52

"1: 3 4 5"
"2: 4 5"
"3: 3 4"
"4: 4"



;; 4.5 - Itemizations

(define T45_HEIGHT 300) ; distances in pixels
(define T45_WIDTH  100)
(define T45_YDELTA 3)

(define T45_BACKG  (empty-scene T45_WIDTH T45_HEIGHT))
(define T45_ROCKET (rectangle 5 30 "solid" "red"))

(define T45_CENTER (/ (image-height T45_ROCKET) 2))


; An LRCD (for launching rocket countdown) is one of:
; - "resting"
; - a Number between -3 and -1
; - a NonnegativeNumber
; interpretation a grounded rocket, in countdown mode,
; a number denotes the number of pixels between the
; top of the canvas and the rocket (its height)

;; Exercise 53

; A LR (short for launching rocket) is one of:
; - "resting"
; - NonnegativeNumber
; interpretation "resting" represents a grounded rocket
; a number denotes the height of a rocket in flight
(define LR1 "resting")
(define LR2 T45_HEIGHT)
(define LR3 0)

; LR -> LR
; produces the next action in sequence of launching rocket
(check-expect (next LR1) T45_HEIGHT)
(check-expect (next LR2) (- T45_HEIGHT T45_YDELTA))
(check-expect (next LR3) 0)

(define (next lr)
  (cond [(string? lr) T45_HEIGHT]
        [(= lr T45_HEIGHT) (- lr T45_YDELTA)]
        [else 0]))

;; Exercise 54

(check-expect (show-ex54 "resting") "resting")
(check-expect (show-ex54 -2) -2)
(check-expect (show-ex54 10) 10)

(define (show-ex54 x)
  (cond
    [(string? x)  x]
    [(<= -3 x -1) x]
    [(>= x 0)     x]))

; (string=? "resting" x) Error when x is a number

;; Exercise 55

; LRCD -> Image
; produces a rocket at height h
(define (draw h)
  (place-image T45_ROCKET 10 (- h T45_CENTER) T45_BACKG))

;; Exercise 56

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
(check-expect (show "resting") (draw T45_HEIGHT))
(check-expect (show -2) (place-image (text "-2" 20 "red")
                                     10 (* 3/4 T45_WIDTH)
                                     (draw T45_HEIGHT)))
(check-expect (show T45_HEIGHT) (draw T45_HEIGHT))
(check-expect (show 53) (draw 53))

(define (show x)
  (cond
    [(string? x)  (draw T45_HEIGHT)]
    [(<= -3 x -1) (place-image (text (number->string x) 20 "red")
                               10 (* 3/4 T45_WIDTH)
                               (draw T45_HEIGHT))]
    [(>= x 0) (draw x)]))

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
(check-expect (fly -1) T45_HEIGHT)
(check-expect (fly 10) (- 10 T45_YDELTA))
(check-expect (fly 22) (- 22 T45_YDELTA))

(define (fly x)
  (cond
    [(string? x) x]
    [(<= -3 x -1) (if (= x -1) T45_HEIGHT (+ x 1))]
    [(>= x 0) (- x T45_YDELTA)]))

; LRCD -> Boolean
; produces true if the rocket is out of sight
(check-expect (end? "resting") #false)
(check-expect (end? -3) #false)
(check-expect (end? -2) #false)
(check-expect (end? -1) #false)
(check-expect (end? 33) #false)
(check-expect (end? 0)  #true)

(define (end? x)
  (cond
    [(string? x)  #false]
    [(<= -3 x -1) #false]
    [(> x 0)      #false]
    [else         #true]))

;; Exercise 57

; A LRCD (for launching rocket count down) is one of:
; - "resting"
; - a Number between -3 and -1
; - a NonnegativeNumber
; interpretation a grounded rocket, in count-down mode,
; a number denotes the height in pixels of rocket at canvas


; LRCD -> LRCD
; launches the program from some initial state (main3 "resting")
(define (main3 s)
  (big-bang s
            [on-tick   fly-ex57]
            [to-draw   show]
            [on-key    launch]
            [stop-when end?-ex57]))

; LRCD -> LRCD
; raises the rocket by YDELTA if it is moving already
(check-expect (fly-ex57 "resting") "resting")
(check-expect (fly-ex57 -3) -2)
(check-expect (fly-ex57 -2) -1)
(check-expect (fly-ex57 -1) 0)
(check-expect (fly-ex57 10) (+ 10 T45_YDELTA))
(check-expect (fly-ex57 22) (+ 22 T45_YDELTA))

(define (fly-ex57 x)
  (cond
    [(string? x) x]
    [(<= -3 x -1) (if (= x -1) 0 (+ x 1))]
    [(>= x 0) (+ x T45_YDELTA)]))

; LRCD -> Boolean
; produces true if the rocket is out of sight
(check-expect (end?-ex57 "resting") #false)
(check-expect (end?-ex57 -3) #false)
(check-expect (end?-ex57 -2) #false)
(check-expect (end?-ex57 -1) #false)
(check-expect (end?-ex57 33) #false)
(check-expect (end?-ex57 T45_HEIGHT) #true)

(define (end?-ex57 x)
  (cond
    [(string? x)      #false]
    [(<= -3 x -1)     #false]
    [(= x T45_HEIGHT) #true]
    [else             #false]))
