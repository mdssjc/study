;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname dinner-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))

;; dinner-starter.rkt

;; =================
;; Data definitions:

; 
; PROBLEM A:
; 
; You are working on a system that will automate delivery for 
; YesItCanFly! airlines catering service. 
; There are three dinner options for each passenger, chicken, pasta 
; or no dinner at all. 
; 
; Design a data definition to represent a dinner order. Call the type 
; DinnerOrder.
; 


;; DinnerOrder is one of:
;; - false
;; - "chicken"
;; - "pasta"
;; interp. false means no dinner, the other values are dinner options for each passenger
(define DO false)
(define D1 "chicken")
(define D2 "pasta")

#;
(define (fn-for-dinner-order do)
  (cond [(false? do) (...)]
        [(string=? do "chicken") (...)]
        [(string=? do "pasta") (...)]))

;; Template rules used:
;; - one of: 3 cases
;; - atomic distinct: false
;; - atomic distinct: "chicken"
;; - atomic distinct: "pasta"

;; =================
;; Functions:

; 
; PROBLEM B:
; 
; Design the function dinner-order-to-msg that consumes a dinner order 
; and produces a message for the flight attendants saying what the
; passenger ordered. 
; 
; For example, calling dinner-order-to-msg for a chicken dinner would
; produce "The passenger ordered chicken."
; 


;; DinnerOrder -> String
;; Produce a message with what the passenger ordered
(check-expect (dinner-order-to-msg false) "The passenger ordered nothing.")
(check-expect (dinner-order-to-msg "chicken") "The passenger ordered chicken.")
(check-expect (dinner-order-to-msg "pasta") "The passenger ordered pasta.")

;(define (dinner-order-to-msg do) "") ; Stub

;<template from DinnerOrder>

(define (dinner-order-to-msg do)
  (cond [(false? do) "The passenger ordered nothing."]
        [(string=? do "chicken") "The passenger ordered chicken."]
        [(string=? do "pasta") "The passenger ordered pasta."]))
