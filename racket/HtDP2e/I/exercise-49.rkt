;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-49) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
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
(require 2htdp/image)

(define WIDTH  100)
(define HEIGHT  60)
(define MTSCN  (empty-scene WIDTH HEIGHT))
(define ROCKET (rectangle 10 20 "solid" "blue"))
(define ROCKET-CENTER-TO-TOP
  (- HEIGHT (/ (image-height ROCKET) 2)))

(define (create-rocket-scene.v5a h)
  (cond
    [(<= h ROCKET-CENTER-TO-TOP)
     (place-image ROCKET 50 h MTSCN)]
    [(> h ROCKET-CENTER-TO-TOP)
     (place-image ROCKET 50 ROCKET-CENTER-TO-TOP MTSCN)]))

(define (create-rocket-scene.v5b h)
  (place-image ROCKET 50 (cond [(<= h ROCKET-CENTER-TO-TOP) h]
                               [(> h  ROCKET-CENTER-TO-TOP) ROCKET-CENTER-TO-TOP])
               MTSCN))
