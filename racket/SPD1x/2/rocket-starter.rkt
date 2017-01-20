;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname rocket-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))

;; rocket-starter.rkt

;; =================
;; Data definitions:

; 
; PROBLEM A:
; 
; You are designing a program to track a rocket's journey as it descends 
; 100 kilometers to Earth. You are only interested in the descent from 
; 100 kilometers to touchdown. Once the rocket has landed it is done.
; 
; Design a data definition to represent the rocket's remaining descent. 
; Call it RocketDescent.
; 


;; RocketDescent is one of:
;;  - Number[0, 100]
;;  - "touchdown"
;; Interp. "touchdown" if rocket's descent has ended, otherwise number of kilometers left to Earth

(define RD1 0)
(define RD2 50)
(define RD3 100)
(define RD4 "touchdown")

#;
(define (fn-for-rocket-descent rd)
  (cond [(and (number? rd)
              (>= rd 0)
              (<= rd 100)) (... x)]
        [(and (string? rd)
              (string=? rd "touchdown")) (...)]))

;; Template rules used:
;;  - one of: 2 cases
;;  - atomic non-distinct: Number[0, 100]
;;  - atomic distinct: "touchdown"

;; =================
;; Functions:

; 
; PROBLEM B:
; 
; Design a function that will output the rocket's remaining descent distance 
; in a short string that can be broadcast on Twitter. 
; When the descent is over, the message should be "The rocket has landed!".
; Call your function rocket-descent-to-msg.
; 


;; RocketDescent -> String
;; produce a Twitter update on rocket's descent distance
(check-expect (rocket-descent-to-msg 100) "Remaining 100 km")
(check-expect (rocket-descent-to-msg 50) "Remaining 50 km")
(check-expect (rocket-descent-to-msg 0) "Remaining less than 0 km")
(check-expect (rocket-descent-to-msg "touchdown") "The rocket has landed!")

;(define (rocket-descent-to-msg rd) "") ; Stub

;<use template from RocketDescent>

(define (rocket-descent-to-msg rd)
  (cond [(and (number? rd)
              (> rd 0)
              (<= rd 100)) (string-append "Remaining " (number->string rd) " km")]
        [(and (number? rd)
              (= rd 0)) (string-append "Remaining less than " (number->string rd) " km")]
        [(and (string? rd)
              (string=? rd "touchdown")) "The rocket has landed!"]))
