;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-5) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 5
(require 2htdp/image)

;; Automobile
(define tire (circle 12 "solid" "black"))
(define tires (underlay/offset tire 40 0 tire))
(define bodywork (overlay/offset
                  (rectangle 10 10 "solid" "white")
                  34 10
                  (rectangle 80 40 "solid" "blue")))

(define automobile (overlay/offset
                    bodywork
                    0 20
                    tires))

;; Boat
(define sail (overlay/offset
              (rhombus 60 40 "outline" "red")
              0 40
              (rectangle 4 60 "solid" "black")))

(define boat (overlay/offset
              sail
              0 68
              (rectangle 120 10 "solid" "brown")))

;; Tree
(define leaf (circle 10 "solid" "green"))
(define trunk (rectangle 10 20 "solid" "brown"))
(define sheets (overlay/offset leaf 0 5 (overlay/offset leaf 10 0 leaf)))

(define tree (overlay/offset sheets 0 15 trunk))

;; Print
automobile
boat
tree
