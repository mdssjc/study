;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-315) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 315


;; ====================
;; Data definitions:

(define-struct no-parent [])
(define-struct child [father mother name date eyes])
; A FT (short for family tree) is one of: 
; - (make-no-parent)
; - (make-child FT FT String N String)

(define NP (make-no-parent))
; A FT is one of: 
; - NP
; - (make-child FT FT String N String)

; Oldest Generation:
(define Carl (make-child NP NP "Carl" 1926 "green"))
(define Bettina (make-child NP NP "Bettina" 1926 "green"))
 
; Middle Generation:
(define Adam (make-child Carl Bettina "Adam" 1950 "hazel"))
(define Dave (make-child Carl Bettina "Dave" 1955 "black"))
(define Eva (make-child Carl Bettina "Eva" 1965 "blue"))
(define Fred (make-child NP NP "Fred" 1966 "pink"))
 
; Youngest Generation: 
(define Gustav (make-child Fred Eva "Gustav" 1988 "brown"))

; A [List-of X] is one of: 
; - '()
; - (cons X [List-of X])
; interpretation represents a list of X

(define ff1 (list Carl Bettina))
(define ff2 (list Fred Eva))
(define ff3 (list Fred Eva Carl))


;; ====================
;; Functions:

; [List-of FT] Number -> Number
; produces the average age of all child instances in the forest
(check-expect (average-age ff1 2000) 74)
(check-expect (average-age ff2 2000) 54.25)
(check-expect (average-age ff3 2000) 58.2)

(define (average-age lox n)
  (local ((define (sum-dates ft)
            (cond [(no-parent? ft) 0]
                  [else
                   (+ (- n (child-date ft))
                      (sum-dates (child-father ft))
                      (sum-dates (child-mother ft)))]))
          (define (count-child ft)
            (cond [(no-parent? ft) 0]
                  [else
                   (+ 1
                      (count-child (child-father ft))
                      (count-child (child-mother ft)))])))
    (/ (foldr + 0 (map sum-dates lox))
       (foldr + 0 (map count-child lox)))))
