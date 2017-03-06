;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-109) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 109

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define WIDTH  100)
(define HEIGHT WIDTH)
(define BACKGROUND (rectangle WIDTH HEIGHT "solid" "white"))


; ExpectsToSee is one of: 
; - "start, expect an 'a'"
; - "expect 'b', 'c', or 'd'"
; - "finished" 
; - "error, illegal key"


; ExpectsToSee -> World
; starts the world with (main "start")
(define (main ets)
  (big-bang ets
            (on-draw render)
            (on-key  event)))

; ExpectsToSee -> Image
; renders the current event into the BACKGROUND scene
(check-expect (render "start")    (rectangle WIDTH HEIGHT "solid" "white"))
(check-expect (render "expect")   (rectangle WIDTH HEIGHT "solid" "yellow"))
(check-expect (render "finished") (rectangle WIDTH HEIGHT "solid" "green"))
(check-expect (render "error")    (rectangle WIDTH HEIGHT "solid" "red"))

(define (render ets)
  (overlay (rectangle WIDTH HEIGHT "solid"
                      (cond [(string=? "start"    ets) "white"]
                            [(string=? "expect"   ets) "yellow"]
                            [(string=? "finished" ets) "green"]
                            [(string=? "error"    ets) "red"]))
           BACKGROUND))

; ExpectsToSee KeyEvent -> ExpectsToSee
; generates the next event to ExpectsToSee
(check-expect (event "start" "a")    "expect")
(check-expect (event "start" "b")    "error")
(check-expect (event "expect" "b")   "expect")
(check-expect (event "expect" "c")   "expect")
(check-expect (event "expect" "d")   "finished")
(check-expect (event "expect" "e")   "error")
(check-expect (event "finished" "e") "finished")
(check-expect (event "error"  "e")   "error")

(define (event ets ke)
  (cond [(and (string=? "start"  ets)
              (key=? "a" ke)) "expect"]
        [(and (string=? "expect" ets)
              (or (key=? "b" ke)
                  (key=? "c" ke))) "expect"]
        [(and (string=? "expect" ets)
              (key=? "d" ke)) "finished"]
        [(string=? "finished" ets) "finished"]
        [else "error"]))
