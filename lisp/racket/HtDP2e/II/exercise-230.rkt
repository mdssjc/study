;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-230) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 230

(require 2htdp/image)
(require 2htdp/universe)


; ExpectsToSee is one of: 
; - "start, expect an 'a'"
; - "expect 'b', 'c', or 'd'"
; - "finished" 
; - "error, illegal key"

(define-struct fsm [initial transitions final])
(define-struct transition [current key next])
; An FSM is a structure: 
;   (make-fsm FSM-State LOT FSM-State)
; A LOT is one of: 
; - '() 
; - (cons Transition LOT)
; A Transition is a structure: 
;   (make-transition FSM-State KeyEvent FSM-State)
; FSM-State is a ExpectsToSee.

(define fsm-expectstosee
  (list (make-transition "start" "a" "expect")
        (make-transition "start" "b" "error")
        (make-transition "expect" "b" "expect")
        (make-transition "expect" "c" "expect")
        (make-transition "expect" "d" "finished")
        (make-transition "expect" "e" "error")
        (make-transition "finished" "e" "finished")
        (make-transition "error" "e" "error")))


; FSM -> SimulationState
; match the keys pressed with the given FSM 
(define (fsm-simulate a-fsm)
  (big-bang a-fsm
            [to-draw state-as-colored-square]
            [on-key find-next-state]
            [stop-when reach-final-state? state-as-colored-square]))

; SimulationState -> Image 
; renders current world state as a colored square 
(check-expect (state-as-colored-square (make-fsm "start" fsm-expectstosee "finished"))
              (square 100 "solid" "white"))
(check-expect (state-as-colored-square (make-fsm "expect" fsm-expectstosee "finished"))
              (square 100 "solid" "yellow"))
(check-expect (state-as-colored-square (make-fsm "finished" fsm-expectstosee "finished"))
              (square 100 "solid" "green"))
(check-expect (state-as-colored-square (make-fsm "error" fsm-expectstosee "finished"))
              (square 100 "solid" "red"))
 
(define (state-as-colored-square a-fs)
  (square 100 "solid" 
          (cond [(state=? "start" (fsm-initial a-fs)) "white"]
                [(state=? "expect" (fsm-initial a-fs)) "yellow"]
                [(state=? "finished" (fsm-initial a-fs)) "green"]
                [else "red"])))

; SimulationState KeyEvent -> SimulationState
; finds the next state from ke and cs
(check-expect (find-next-state (make-fsm "start" fsm-expectstosee "finished") "a")
              (make-fsm "expect" fsm-expectstosee "finished"))
(check-expect (find-next-state (make-fsm "start" fsm-expectstosee "finished") "b")
              (make-fsm "error" fsm-expectstosee "finished"))
(check-expect (find-next-state (make-fsm "expect" fsm-expectstosee "finished") "b")
              (make-fsm "expect" fsm-expectstosee "finished"))
(check-expect (find-next-state (make-fsm "expect" fsm-expectstosee "finished") "c")
              (make-fsm "expect" fsm-expectstosee "finished"))
(check-expect (find-next-state (make-fsm "expect" fsm-expectstosee "finished") "d")
              (make-fsm "finished" fsm-expectstosee "finished"))
(check-expect (find-next-state (make-fsm "expect" fsm-expectstosee "finished") "e")
              (make-fsm "error" fsm-expectstosee "finished"))
(check-expect (find-next-state (make-fsm "finished" fsm-expectstosee "finished") "e")
              (make-fsm "finished" fsm-expectstosee "finished"))
(check-expect (find-next-state (make-fsm "error" fsm-expectstosee "finished") "e")
              (make-fsm "error" fsm-expectstosee "finished"))

(define (find-next-state a-fs ke)
  (make-fsm (find (fsm-transitions a-fs) (fsm-initial a-fs) ke)
            (fsm-transitions a-fs)
            (fsm-final a-fs)))

; FSM FSM-State KeyEvent -> FSM-State
; finds the state representing current in transitions
; and retrieve the next field 
(check-expect (find fsm-expectstosee "start" "a") "expect")
(check-expect (find fsm-expectstosee "start" "b") "error")
(check-expect (find fsm-expectstosee "expect" "b") "expect")
(check-expect (find fsm-expectstosee "expect" "c") "expect")
(check-expect (find fsm-expectstosee "expect" "d") "finished")
(check-expect (find fsm-expectstosee "expect" "e") "error")
(check-expect (find fsm-expectstosee "finished" "e") "finished")
(check-expect (find fsm-expectstosee "error" "e") "error")

(define (find transitions current key)
  (cond [(empty? transitions) "error"]
        [(and (state=? (transition-current (first transitions)) current)
              (key=? (transition-key (first transitions)) key))
         (transition-next (first transitions))]
        [else
         (find (rest transitions) current key)]))

; SimulationState -> Boolean
; stops when FSM-State is "finished" or "error"
(check-expect (reach-final-state? (make-fsm "start" fsm-expectstosee "finished")) #false)
(check-expect (reach-final-state? (make-fsm "expect" fsm-expectstosee "finished")) #false)
(check-expect (reach-final-state? (make-fsm "finished" fsm-expectstosee "finished")) #true)
(check-expect (reach-final-state? (make-fsm "error" fsm-expectstosee "finished")) #true)

(define (reach-final-state? a-fs)
  (or (state=? "finished" (fsm-initial a-fs))
      (state=? "error" (fsm-initial a-fs))))

; FSM-State FSM-State -> Boolean
; checks an equality predicate for states
(check-expect (state=? "start" "start") #true)
(check-expect (state=? "start" "expect") #false)

(define (state=? s1 s2)
  (string=? s1 s2))
