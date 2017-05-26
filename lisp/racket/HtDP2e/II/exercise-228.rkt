;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-228) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 228

(require 2htdp/image)
(require 2htdp/universe)


; A Color is one of: 
; - "white"
; - "yellow"
; - "orange"
; - "green"
; - "red"
; - "blue"
; - "black"

; A FSM is one of:
;   - '()
;   - (cons Transition FSM)

(define-struct transition [current next])
; A Transition is a structure:
;   (make-transition FSM-State FSM-State)
; FSM-State is a Color.
; interpretation A FSM represents the transitions that a
; finite state machine can take from one state to another 
; in reaction to key strokes

(define-struct fs [fsm current])
; A SimulationState is a structure: 
;   (make-fs FSM FSM-State)

(define fsm-traffic
  (list (make-transition "red" "green")
        (make-transition "green" "yellow")
        (make-transition "yellow" "red")))
(define fsm-bw
  (list (make-transition "black" "white")
        (make-transition "white" "black")))


; FSM FSM-State -> SimulationState 
; match the keys pressed with the given FSM 
(define (simulate a-fsm s0)
  (big-bang (make-fs a-fsm s0)
            [to-draw state-as-colored-square]
            [on-key find-next-state]))

; SimulationState -> Image 
; renders current world state as a colored square 
(check-expect (state-as-colored-square
               (make-fs fsm-traffic "red"))
              (square 100 "solid" "red"))
 
(define (state-as-colored-square a-fs)
  (square 100 "solid" (fs-current a-fs)))

; SimulationState KeyEvent -> SimulationState
; finds the next state from ke and cs
(check-expect (find-next-state (make-fs fsm-traffic "red") "n")
              (make-fs fsm-traffic "green"))
(check-expect (find-next-state (make-fs fsm-traffic "red") "a")
              (make-fs fsm-traffic "green"))
(check-expect (find-next-state (make-fs fsm-traffic "green") "q")
              (make-fs fsm-traffic "yellow"))

(define (find-next-state a-fs ke)
  (make-fs (fs-fsm a-fs)
           (find (fs-fsm a-fs) (fs-current a-fs))))

; FSM FSM-State -> FSM-State
; finds the state representing current in transitions
; and retrieve the next field 
(check-expect (find fsm-traffic "red") "green")
(check-expect (find fsm-traffic "green") "yellow")
(check-error (find fsm-traffic "black")
             "not found: black")

(define (find transitions current)
  (cond [(empty? transitions)
         (error "not found: " current)]
        [(state=? (transition-current (first transitions)) current)
         (transition-next (first transitions))]
        [else
         (find (rest transitions) current)]))

; FSM-State FSM-State -> Boolean
; checks an equality predicate for states
(check-expect (state=? "white" "white") #true)
(check-expect (state=? "white" "yellow") #false)

(define (state=? s1 s2)
  (string=? s1 s2))
