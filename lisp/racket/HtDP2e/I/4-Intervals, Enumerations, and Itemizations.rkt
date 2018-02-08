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
