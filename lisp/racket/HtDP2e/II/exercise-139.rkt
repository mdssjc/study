;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-139) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 139

; A List-of-numbers is one of: 
; - '()
; - (cons Number List-of-numbers)


; List-of-numbers -> Boolean
; determines whether all numbers are positive numbers
(check-expect (pos? (cons 5 '())) #true)
(check-expect (pos? (cons 5 (cons 10 '()))) #true)
(check-expect (pos? (cons -1 '())) #false)
(check-expect (pos? (cons 5 (cons -10 '()))) #false)

(define (pos? lon)
  (cond [(empty? lon) #true]
        [else (and (>= (first lon) 0) (pos? (rest lon)))]))

; List-of-amounts -> Number
; computes the sum of the amounts
(check-expect (sum '()) 0)
(check-expect (sum (cons 1 '())) 1)
(check-expect (sum (cons 1 (cons 2 '()))) 3)

(define (sum loa)
  (cond [(empty? loa) 0]
        [else (+ (first loa) (sum (rest loa)))]))

; List-of-numbers -> Number
; produces their sum if the input also belongs to List-of-amounts
(check-error (checked-sum (cons -1 '())) "The input doesn't belong to List-of-amounts")
(check-expect (checked-sum (cons 5 '())) 5)

(define (checked-sum lon)
  (if (pos? lon)
      (sum lon)
      (error "The input doesn't belong to List-of-amounts")))
