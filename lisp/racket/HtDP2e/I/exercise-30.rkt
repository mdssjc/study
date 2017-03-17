;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-30) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 30

(define PEOPLE 120)
(define TICKET-PRICE 5.0)
(define AVERAGE-CHANGES 15)
(define PERCENT 0.1)
(define FIXED-COST 180)
(define VARIABLE-COST 0.04)

(define ATTENDEES-PRICE (/ AVERAGE-CHANGES PERCENT))

(define (attendees ticket-price)
  (- PEOPLE (* (- ticket-price TICKET-PRICE) ATTENDEES-PRICE)))

(define (revenue ticket-price)
  (* ticket-price (attendees ticket-price)))

(define (cost ticket-price)
  (+ FIXED-COST (* VARIABLE-COST (attendees ticket-price))))

(define (profit ticket-price)
  (- (revenue ticket-price)
     (cost ticket-price)))

(profit 1)
(profit 2)
(profit 3)
(profit 4)
(profit 5)
