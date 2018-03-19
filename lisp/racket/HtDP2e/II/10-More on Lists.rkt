;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |10-More on Lists|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 10-More on Lists.rkt
;; II - Arbitrarily Large Data
;; 10 - More on Lists

(require 2htdp/image)
(require 2htdp/universe)
(require racket/string)


;; 10.1 - Functions that Produce Lists

;; Exercise 161


;; =================
;; Constants:

(define WAGE-COST 14)


;; =================
;; Functions:

; List-of-numbers -> List-of-numbers
; computes the weekly wages for all given weekly hours
(check-expect (wage* '()) '())
(check-expect (wage* (cons 28 '())) (cons (* WAGE-COST 28) '()))
(check-expect (wage* (cons 4 (cons 2 '()))) (cons (* WAGE-COST 4) (cons (* WAGE-COST 2) '())))

(define (wage* whrs)
  (cond [(empty? whrs) '()]
        [else (cons (wage (first whrs))
                    (wage* (rest whrs)))]))

; Number -> Number
; computes the wage for h hours of work
(define (wage h)
  (* WAGE-COST h))

;; Exercise 162

; List-of-numbers -> List-of-numbers
; computes the weekly wages for all given weekly hours
(check-expect (wage*.v2 '()) '())
(check-expect (wage*.v2 (cons 28 '())) (cons (* WAGE-COST 28) '()))
(check-expect (wage*.v2 (cons 4 (cons 2 '()))) (cons (* WAGE-COST 4) (cons (* WAGE-COST 2) '())))
(check-error  (wage*.v2 (cons 12 (cons 100 '()))) "No employee could possibly work more than 100 hours per week")

(define (wage*.v2 whrs)
  (cond [(empty? whrs) '()]
        [(>= (first whrs) 100)
         (error "No employee could possibly work more than 100 hours per week")]
        [else (cons (wage (first whrs))
                    (wage*.v2 (rest whrs)))]))

;; Exercise 163


;; =================
;; Functions:

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
(check-expect (fahrenheit->celsius 212)  100)
(check-expect (fahrenheit->celsius -40)  -40)

(define (fahrenheit->celsius f)
  (* (- f 32) (/ 5 9)))

;; Exercise 164


;; =================
;; Constants:

(define RATE 0.920)


;; =================
;; Functions:

; List-of-numbers -> List-of-numbers
; converts a list of US$ amounts into a list of € amounts
(check-expect (convert-euro* '()) '())
(check-within (convert-euro* (cons 1 '())) (cons 0.92 '()) 0.1)
(check-within (convert-euro* (cons 1 (cons 3.5 '()))) (cons 0.92 (cons 3.22 '())) 0.1)

(define (convert-euro* d)
  (cond [(empty? d) '()]
        [else (cons (convert-euro (first d))
              (convert-euro* (rest d)))]))

; Number -> Number
; converts the US$ in € with the current exchange rate
(check-within (convert-euro 1)   0.92 0.1)
(check-within (convert-euro 3.5) 3.22 0.1)

(define (convert-euro d)
  (* d RATE))

;; Exercise 165


;; =================
;; Functions:

; List-of-strings -> List-of-strings
; consumes a list of toy descriptions (one-word strings) and
; replaces all occurrences of "robot" with "r2d2"
(check-expect (subst-robot '()) '())
(check-expect (subst-robot (cons "robot-1" '())) (cons "r2d2-1" '()))
(check-expect (subst-robot (cons "robot-1" (cons ">>robot<<" '())))
              (cons "r2d2-1" (cons ">>r2d2<<" '())))

(define (subst-robot los)
  (substitute "r2d2" "robot" los))

; String String List-of-strings -> List-of-strings
; replaces all occurrences of new with old in the List-of-strings
(define (substitute new old los)
  (cond [(empty? los) '()]
        [else (cons (string-replace (first los) old new)
                    (substitute new old (rest los)))]))
