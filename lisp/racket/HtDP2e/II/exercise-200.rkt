;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-200) (read-case-sensitive #t) (teachpacks ((lib "itunes.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "itunes.rkt" "teachpack" "2htdp")) #f)))
;; Exercise 200

(require 2htdp/itunes)

; A LTracks is one of:
; - '()
; - (cons Track LTracks)
(define T1 (create-track "one" "two" "three" 4 5 (create-date 1 2 3 4 5 6) 7 (create-date 1 2 3 4 5 6)))
(define T2 (create-track "one" "two" "three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define LT1 (cons T1 (cons T2 '())))


; LTracks -> Number
; produces the total amount of play time
(check-expect (total-time LT1) (+ 4 (/ 5 60) (/ 6 60 60)
                                  3 (/ 2 60) (/ 1 60 60)))

(define (total-time lt)
  (cond [(empty? lt) 0]
        [else (+ (date-hour (track-played (first lt)))
                 (/ (date-minute (track-played (first lt))) 60)
                 (/ (date-second (track-played (first lt))) 60 60)
                 (total-time (rest lt)))]))
