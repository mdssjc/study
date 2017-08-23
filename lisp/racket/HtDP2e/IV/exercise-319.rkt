;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-319) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 319


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

; S-expr Symbol Symbol -> S-expr
; substitutes all occurrences of old by new in S-expression s
(check-expect (substitute 1 'abc 'cba) 1)
(check-expect (substitute (list 1 'abc 'def) 'cba 'abc) (list 1 'cba 'def))
(check-expect (substitute (list 1 'abc 'cba 'abc) 'cba 'abc) (list 1 'cba 'cba 'cba))

(define (substitute s new old)
  (local ((define (substitute s)
            (cond [(atom? s) (replace-symbol s)]
                  [else
                   (substitute-sl s)]))

          (define (substitute-sl sl)
            (cond [(empty? sl) empty]
                  [else
                   (cons (substitute (first sl))
                         (substitute-sl (rest sl)))]))

          (define (replace-symbol s)
            (cond [(number? s) s]
                  [(string? s) s]
                  [(symbol? s) (if (symbol=? s old) new s)])))
    (substitute s)))
