;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname HtDDDesignQuiz) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; HtDD Design Quiz

;; Age is Natural
;; interp. the age of a person in years
(define A0 18)
(define A1 25)

#;
(define (fn-for-age a)
  (... a))

;; Template rules used:
;; - atomic non-distinct: Natural


; Problem 1:
; 
; Consider the above data definition for the age of a person.
; 
; Design a function called teenager? that determines whether a person
; of a particular age is a teenager (i.e., between the ages of 13 and 19).


;; Age -> Boolean
;; Test if an age is teenager, between the ages of 13 and 19
(check-expect (teenager? 12) false)
(check-expect (teenager? 15) true)
(check-expect (teenager? 20) false)

;(define (teenager? a) false) ; Stub

(define (teenager? a)
  (and (>= a 13) (<= a 19)))

; Problem 2:
; 
; Design a data definition called MonthAge to represent a person's age
; in months.


;; MonthAge is Natural
;; interp. number months of age
(define MA 25)

#;
(define (fn-for-month-age ma)
  (... ma))

;; Template rules used:
;; - atomic non-distinct: Natural

; Problem 3:
; 
; Design a function called months-old that takes a person's age in years 
; and yields that person's age in months.
; 


;; Age -> MonthAge
;; Produces age in months from the person's age
(check-expect (months-old 15) (* 15 12))
(check-expect (months-old 32) (* 32 12))

;(define (months-old mo) 0) ; Stub

(define (months-old mo)
  (* mo 12))

; Problem 4:
; 
; Consider a video game where you need to represent the health of your
; character. The only thing that matters about their health is:
; 
;   - if they are dead (which is shockingly poor health)
;   - if they are alive then they can have 0 or more extra lives
; 
; Design a data definition called Health to represent the health of your
; character.
; 
; Design a function called increase-health that allows you to increase the
; lives of a character.  The function should only increase the lives
; of the character if the character is not dead, otherwise the character
; remains dead.


;; Health is one of:
;;  - false
;;  - Natural
;; interp. false means dead, number is x extra lives

(define H1 false)
(define H2 5)

#;
(define (fn-for-health h)
  (cond [(false? h) (...)]
        [(number? h) (... h)]))

;; Template rules used:
;;  - one of: 2 cases
;;  - atomic distinct: false
;;  - atomic non-distinct: Natural

;; Health -> Health
;; Produce increase the lives, if not dead
(check-expect (increase-health false) false)
(check-expect (increase-health 0) 1)
(check-expect (increase-health 5) 6)

;(define (increase-health ih) 0) ; Stub

(define (increase-health ih)
  (cond [(false? ih) false]
        [(number? ih) (+ ih 1)]))
