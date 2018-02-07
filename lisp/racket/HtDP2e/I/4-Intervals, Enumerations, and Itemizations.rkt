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

(define WIDTH  100)
(define HEIGHT 60)
(define MTSCN  (empty-scene WIDTH HEIGHT))
(define ROCKET (rectangle 10 20 "solid" "blue"))
(define ROCKET-CENTER-TO-TOP (- HEIGHT (/ (image-height ROCKET) 2)))

(define (create-rocket-scene.v5a h)
  (cond
    [(<= h ROCKET-CENTER-TO-TOP)
     (place-image ROCKET 50 h MTSCN)]
    [(> h ROCKET-CENTER-TO-TOP)
     (place-image ROCKET 50 ROCKET-CENTER-TO-TOP MTSCN)]))

(define (create-rocket-scene.v5b h)
  (place-image ROCKET
               50 (cond [(<= h ROCKET-CENTER-TO-TOP) h]
                        [(>  h ROCKET-CENTER-TO-TOP) ROCKET-CENTER-TO-TOP])
               MTSCN))
