;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-145) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 145

; A CTemperature is a Number greater than -273.

; A NEList-of-temperatures is one of: 
; - (cons CTemperature '())
; - (cons CTemperature NEList-of-temperatures)
; interpretation non-empty lists of Celsius temperatures


; NEList-of-temperatures -> Boolean
; produces true if the temperatures are sorted in descending order
(check-expect (sorted>? (cons 1 (cons 2 '()))) #false)
(check-expect (sorted>? (cons 3 (cons 2 '()))) #true)
(check-expect (sorted>? (cons 0 (cons 3 (cons 2 '())))) #false)

(define (sorted>? l)
  (cond [(empty? (rest l)) #true]
        [else (and (>= (first l)
                       (first (rest l)))
                   (sorted>? (rest l)))]))
