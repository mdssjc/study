;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname rocket-error-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))

;; rocket-error-starter.rkt

; PROBLEM:
; 
; Consider the following data definition from the Rocket practice problem.
; 
; We have designed a function has-landed?, but there are errors in the function design.
; Uncomment the program below, and make the minimal changes possible to a) make this 
; program work properly and b) make the function design consistent.
; 


;; =================
;; Data Definitions 


;; RocketDescent is one of:
;; - Number(0, 100]
;; - false
;; Interp. false if rocket's descent has ended, otherwise number of kilometers left to Earth

(define RD1 100)
(define RD2 40)
(define RD3 0.5)
(define RD4 false)

#;
(define (fn-for-rocket-descent rd)
  (cond [(and (number? rd)
              (<   0 rd)
              (<= rd 100))
         (... rd)]
        [else (...)])) 

;; Template Rules Used:
;;  - one of: 2 cases
;;  - atomic non-distinct: Number(0, 100] 
;;  - atomic distinct: false


;; =================
;; Functions:

;; RocketDescent -> Boolean
;; produces true if the rocket's descent has ended and false if it's still descending
(check-expect (has-landed? 100) false)
(check-expect (has-landed? 23) false)
(check-expect (has-landed? 0.25) false)
(check-expect (has-landed? false) true)

;(define (has-landed? r) false) ; stub

;; Took template from RocketDescent
(define (has-landed? rd)
  (cond [(and (number? rd)
              (<   0 rd)
              (<= rd 100))
         false]
        [else true])) 
