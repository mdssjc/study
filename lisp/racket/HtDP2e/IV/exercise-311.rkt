;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-311) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 311


;; ====================
;; Data definitions:

(define-struct no-parent [])
(define-struct child [father mother name date eyes])
; An FT (short for family tree) is one of: 
; - (make-no-parent)
; - (make-child FT FT String N String)

(define NP (make-no-parent))
; An FT is one of: 
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


;; ====================
;; Functions:

; FT -> Natural
; counts the child structures in the tree
(check-expect (count-child NP)     0)
(check-expect (count-child Carl)   1)
(check-expect (count-child Gustav) 5)

(define (count-child ft)
  (cond [(no-parent? ft) 0]
        [else
         (+ 1
            (count-child (child-father ft))
            (count-child (child-mother ft)))]))

; FT Number -> Number
; produces the average age of all child structures in the family tree
(check-expect (average-age NP 2000) 0)
(check-expect (average-age Carl 2000) 74)
(check-expect (average-age Adam 2000) (- 2000 (/ (+ 1950 1926 1926) 3)))
(check-expect (average-age Gustav 2000) (- 2000 (/ (+ 1988 1966 1965 1926 1926) 5)))

(define (average-age ft year)
  (local ((define (sum-dates ft)
            (cond [(no-parent? ft) 0]
                  [else
                   (+ (child-date ft)
                      (sum-dates (child-father ft))
                      (sum-dates (child-mother ft)))])))
    (cond [(no-parent? ft) 0]
          [else
           (- year (/ (sum-dates ft) (count-child ft)))])))