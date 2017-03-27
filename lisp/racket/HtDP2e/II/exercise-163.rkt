;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-163) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 163

; List-of-numbers -> List-of-numbers
; converts a list of measurements in Fahrenheit to a list of Celsius measurements
(check-expect (convertFC '()) '())
(check-expect (convertFC (cons 98.6 '())) (cons 37 '()))
(check-within (convertFC (cons 98.6 (cons 85 '()))) (cons 37 (cons 29.4 '())) 0.1)

(define (convertFC t)
  (cond [(empty? t) '()]
        [else (cons (fahrenheit->celsius (first t))
                    (convertFC (rest t)))]))

; Number -> Number
; converts the temperature Fahrenheit in Celsius
(check-expect (fahrenheit->celsius 98.6) 37)
(check-expect (fahrenheit->celsius 212) 100)
(check-expect (fahrenheit->celsius -40) -40)

(define (fahrenheit->celsius f)
  (* (- f 32) (/ 5 9)))
