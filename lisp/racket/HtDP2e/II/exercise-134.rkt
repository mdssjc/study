;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-134) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 134

; String List-of-Strings -> Boolean
; determines whether some given string occurs on a given list of strings
(check-expect (contains? "Car"   (cons "Egg" (cons "Car" (cons "White" '())))) #true)
(check-expect (contains? "Trunk" (cons "Egg" (cons "Car" (cons "White" '())))) #false)
(check-expect (contains? "Car" '()) #false)

(define (contains? s los)
  (cond [(empty? los) #false]
        [(and (cons? los)
              (string=? (first los) s)) #true]
        [else (contains? s (rest los))]))
