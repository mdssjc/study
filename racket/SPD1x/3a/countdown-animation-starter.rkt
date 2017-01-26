;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname countdown-animation-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)
(require 2htdp/universe)

;; countdown-animation-starter.rkt

; 
; PROBLEM:
; 
; Design an animation of a simple countdown. 
; 
; Your program should display a simple countdown, that starts at ten, and
; decreases by one each clock tick until it reaches zero, and stays there.
; 
; To make your countdown progress at a reasonable speed, you can use the 
; rate option to on-tick. If you say, for example, 
; (on-tick advance-countdown 1) then big-bang will wait 1 second between 
; calls to advance-countdown.
; 
; Remember to follow the HtDW recipe! Be sure to do a proper domain 
; analysis before starting to work on the code file.
; 
; Once you are finished the simple version of the program, you can improve
; it by reseting the countdown to ten when you press the spacebar.
; 


;; HtDW P1 - Countdown

;; =================
;; Constants:
(define WIDTH  800)
(define HEIGHT 600)
(define START   10)
(define SIZE   200)
(define POS-X (/ WIDTH  2))
(define POS-Y (/ HEIGHT 2))
(define MTS (empty-scene WIDTH HEIGHT))

;; =================
;; Data definitions:

;; Countdown is Number[0, 10]
;; interp. 10 to 0 count
(define C0 10)
(define C1  5)
(define C2  0)

#;
(define (fn-to-countdown c)
  (... c))

;; Template rules used:
;;  - atomic non-distinct: Number[0, 10]

;; =================
;; Functions:

;; Countdown -> Countdown
;; start the world with (main 0)
;; 
(define (main c)
  (big-bang START                          ; Countdown
            (on-tick  advance-countdown 1) ; Countdown -> Countdown
            (to-draw  render)              ; Countdown -> Image
            (on-key   reset)))             ; Countdown KeyEvent -> Countdown

;; Countdown -> Countdown
;; produce the next 10 to 0 count
(check-expect (advance-countdown 10) 9)
(check-expect (advance-countdown  1) 0)
(check-expect (advance-countdown  0) 0)

;(define (advance-countdown c) 0) ; Stub

;<use template from Countdown>

(define (advance-countdown c)
  (if (> c 0)
      (- c 1)
      0))

;; Countdown -> Image
;; render the countdown image at appropriate place on MTS 
(check-expect (render 10) (place-image (text (number->string 10) SIZE "black")
                                       POS-X POS-Y
                                       MTS)) 

;(define (render c) MTS) ; Stub

;<use template from Countdown>

(define (render c)
  (place-image (text (number->string c) SIZE "black")
               POS-X POS-Y
               MTS))

;; Countdown KeyEvent -> Countdown
;; resets counter to START when <space> is pressed
(check-expect (reset 10 " ") 10)
(check-expect (reset  1 " ") 10)
(check-expect (reset  0 " ") 10)
(check-expect (reset  4 "left") 4)

;(define (reset c ke) 0) ; Stub

;<use template from Countdown>

(define (reset c ke)
  (cond [(key=? ke " ") 10]
        [else            c]))
