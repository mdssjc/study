;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-62) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 62

(require 2htdp/image)
(require 2htdp/universe)


; A DoorState is one of:
; – LOCKED
; – CLOSED
; – OPEN
(define LOCKED "locked")
(define CLOSED "closed")
(define OPEN   "open")


; DoorState -> DoorState
; simulates a door with an automatic door closer
(define (door-simulation initial-state)
  (big-bang initial-state
            [on-tick door-closer 3]
            [on-key  door-actions]
            [to-draw door-render]))


; DoorState -> DoorState
; closes an open door over the period of one tick
(check-expect (door-closer LOCKED) LOCKED)
(check-expect (door-closer CLOSED) CLOSED)
(check-expect (door-closer   OPEN) CLOSED)

(define (door-closer state-of-door)
  (cond
    [(string=? LOCKED state-of-door) LOCKED]
    [(string=? CLOSED state-of-door) CLOSED]
    [(string=? OPEN   state-of-door) CLOSED]))

; DoorState KeyEvent -> DoorState
; turn key event k into an action on state s
(check-expect (door-actions LOCKED "u") CLOSED)
(check-expect (door-actions CLOSED "u") CLOSED)
(check-expect (door-actions   OPEN "u") OPEN)
(check-expect (door-actions LOCKED "l") LOCKED)
(check-expect (door-actions CLOSED "l") LOCKED)
(check-expect (door-actions   OPEN "l") OPEN)
(check-expect (door-actions LOCKED " ") LOCKED)
(check-expect (door-actions CLOSED " ") OPEN)
(check-expect (door-actions   OPEN " ") OPEN)
(check-expect (door-actions LOCKED "a") LOCKED)
(check-expect (door-actions   OPEN "a") OPEN)
(check-expect (door-actions CLOSED "a") CLOSED)

(define (door-actions s k)
  (cond
    [(and (string=? LOCKED s) (string=? "u" k))
     CLOSED]
    [(and (string=? CLOSED s) (string=? "l" k))
     LOCKED]
    [(and (string=? CLOSED s) (string=? " " k))
     OPEN]
    [else s]))

; DoorState -> Image
; translates the state s into a large text image
(check-expect (door-render CLOSED) (text CLOSED 40 "red"))

(define (door-render s)
  (text s 40 "red"))
