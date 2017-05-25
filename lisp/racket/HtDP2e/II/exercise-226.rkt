;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-226) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 226


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
; FSM-State is a Color
; interpretation A FSM represents the transitions that a
; finite state machine can take from one state to another 
; in reaction to key strokes


; FSM-State FSM-State -> Boolean
; checks an equality predicate for states
(check-expect (state=? "white" "white") #true)
(check-expect (state=? "white" "yellow") #false)

(define (state=? s1 s2)
  (string=? s1 s2))
