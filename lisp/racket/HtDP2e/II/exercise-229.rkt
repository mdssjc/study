;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-229) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 229

(require 2htdp/image)
(require 2htdp/universe)


; ExpectsToSee is one of: 
; - "start, expect an 'a'"
; - "expect 'b', 'c', or 'd'"

; A FSM is one of:
;   - '()
;   - (cons Transition FSM)

(define-struct ktransition [current key next])
; A KTransition is a structure:
;   (make-ktransition FSM-State KeyEvent FSM-State)
; FSM-State is a ExpectsToSee.
; interpretation A FSM represents the transitions that a
; finite state machine can take from one state to another 
; in reaction to key strokes

(define-struct fs [fsm current])
; A SimulationState is a structure: 
;   (make-fs FSM FSM-State)

(define fsm-expectstosee
  (list (make-ktransition "start" "a" "expect")
        (make-ktransition "expect" "b" "expect")
        (make-ktransition "expect" "c" "expect")
        (make-ktransition "expect" "d" "expect")))


; FSM FSM-State -> SimulationState
; match the keys pressed with the given FSM 
(define (simulate a-fsm s0)
  (big-bang (make-fs a-fsm s0)
            [to-draw state-as-colored-square]
            [on-key find-next-state]))

; SimulationState -> Image 
; renders current world state as a colored square 
(check-expect (state-as-colored-square (make-fs fsm-expectstosee "start"))
              (square 100 "solid" "white"))
(check-expect (state-as-colored-square (make-fs fsm-expectstosee "expect"))
              (square 100 "solid" "yellow"))
 
(define (state-as-colored-square a-fs)
  (square 100 "solid" 
          (cond [(state=? "start" (fs-current a-fs)) "white"]
                [else "yellow"])))

; SimulationState KeyEvent -> SimulationState
; finds the next state from ke and cs
(check-expect (find-next-state (make-fs fsm-expectstosee "start") "b")
              (make-fs fsm-expectstosee "start"))
(check-expect (find-next-state (make-fs fsm-expectstosee "start") "a")
              (make-fs fsm-expectstosee "expect"))
(check-expect (find-next-state (make-fs fsm-expectstosee "expect") "b")
              (make-fs fsm-expectstosee "expect"))
(check-expect (find-next-state (make-fs fsm-expectstosee "expect") "c")
              (make-fs fsm-expectstosee "expect"))
(check-expect (find-next-state (make-fs fsm-expectstosee "expect") "d")
              (make-fs fsm-expectstosee "expect"))

(define (find-next-state a-fs ke)
  (make-fs (fs-fsm a-fs)
           (find (fs-fsm a-fs) (fs-current a-fs) ke)))

; FSM FSM-State KeyEvent -> FSM-State
; finds the state representing current in transitions
; and retrieve the next field 
(check-expect (find fsm-expectstosee "start" "a") "expect")
(check-expect (find fsm-expectstosee "start" "b") "start")
(check-expect (find fsm-expectstosee "expect" "b") "expect")
(check-expect (find fsm-expectstosee "expect" "c") "expect")
(check-expect (find fsm-expectstosee "expect" "d") "expect")

(define (find transitions current key)
  (cond [(empty? transitions) current]
        [(and (state=? (ktransition-current (first transitions)) current)
              (key=? (ktransition-key (first transitions)) key))
         (ktransition-next (first transitions))]
        [else
         (find (rest transitions) current key)]))

; FSM-State FSM-State -> Boolean
; checks an equality predicate for states
(check-expect (state=? "start" "start") #true)
(check-expect (state=? "start" "expect") #false)

(define (state=? s1 s2)
  (string=? s1 s2))
