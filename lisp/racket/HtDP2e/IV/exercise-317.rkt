;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-317) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 317


;; ====================
;; Data definitions:

; An S-expr is one of:
; - Atom
; - SL
 
; An SL is one of:
; - '()
; - (cons S-expr SL)
	
; An Atom is one of:
; - Number
; - String
; - Symbol


;; ====================
;; Functions:

; Atom -> Boolean
; predicates if it's an atom
(check-expect (atom? #true) #false)
(check-expect (atom? 1) #true)
(check-expect (atom? "abc") #true)
(check-expect (atom? 'sb) #true)

(define (atom? a)
  (or (number? a) (string? a) (symbol? a)))

; S-expr Symbol -> N 
; counts all occurrences of sy in sexp
(check-expect (count 'world 'hello) 0)
(check-expect (count '(world hello) 'hello) 1)
(check-expect (count '(((world) hello) hello) 'hello) 2)

(define (count sexp sy)
  (local ((define (count sexp)
            (cond [(atom? sexp) (count-atom sexp)]
                  [else
                   (count-sl sexp)]))
          
          (define (count-sl sl)
            (cond [(empty? sl) 0]
                  [else
                   (+ (count (first sl))
                      (count-sl (rest sl)))]))
          
          (define (count-atom at)
            (cond [(number? at) 0]
                  [(string? at) 0]
                  [(symbol? at) (if (symbol=? at sy) 1 0)])))
    (count sexp)))
