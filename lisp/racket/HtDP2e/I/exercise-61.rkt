;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-61) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 61

; A S-TrafficLight is one of:
; – RED
; – GREEN
; – YELLOW
;(define RED    0)
;(define GREEN  1)
;(define YELLOW 2)
(define RED    "red")
(define GREEN  "green")
(define YELLOW "yellow")


; S-TrafficLight -> S-TrafficLight
; yields the next state given current state cs
(check-expect (tl-next- ... RED) YELLOW)
(check-expect (tl-next- ... YELLOW) GREEN)

;(define (tl-next-numeric cs)
;  (modulo (+ cs 1) 3))

(define (tl-next-symbolic cs)
  (cond
    [(equal? cs RED) GREEN]
    [(equal? cs GREEN) YELLOW]
    [(equal? cs YELLOW) RED]))
