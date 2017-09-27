;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-328) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 328


;; ====================
;; Data definitions:

; A S-expr is one of:
; - Atom
; - SL
 
; A SL is one of:
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

; S-expr Symbol Atom -> S-expr
; replaces all occurrences of old in sexp with new
(check-expect (substitute '(((world) bye) bye) 'bye '42)
              '(((world) 42) 42))
(check-expect (substitute 1 'cba 'abc) 1)
(check-expect (substitute (list 1 'abc 'def) 'abc 'cba)
              (list 1 'cba 'def))
(check-expect (substitute (list 1 'abc 'cba 'abc) 'abc 'cba)
              (list 1 'cba 'cba 'cba))

#;
(define (substitute sexp old new)
  (local (; S-expr -> S-expr
          (define (for-sexp sexp)
            (cond [(atom? sexp) (for-atom sexp)]
                  [else
                   (for-sl sexp)]))
          ; SL -> S-expr 
          (define (for-sl sl)
            (cond [(empty? sl) empty]
                  [else
                   (cons (for-sexp (first sl))
                         (for-sl (rest sl)))]))
          ; Atom -> S-expr
          (define (for-atom at)
            (cond [(number? at) at]
                  [(string? at) at]
                  [(symbol? at) (if (equal? at old) new at)])))
    (for-sexp sexp)))

#;
(define (substitute sexp old new)
  (local (; S-expr -> S-expr
          (define (for-sexp sexp)
            (cond [(atom? sexp) (for-atom sexp)]
                  [else
                   (for-sl sexp)]))
          ; SL -> S-expr 
          (define (for-sl sl)
            (map for-sexp sl))
          ; Atom -> S-expr
          (define (for-atom at)
            (cond [(number? at) at]
                  [(string? at) at]
                  [(symbol? at) (if (equal? at old) new at)])))
    (for-sexp sexp)))

#;
(define (substitute sexp old new)
  (local (; S-expr -> S-expr
          (define (for-sexp sexp)
            (cond [(atom? sexp) (for-atom sexp)]
                  [else (for-sl sexp)]))
          ; SL -> S-expr 
          (define (for-sl sl) (map for-sexp sl))
          ; Atom -> S-expr
          (define (for-atom at)
            (if (equal? at old) new at)))
    (for-sexp sexp)))

#;
(define (substitute sexp old new)
  (local (; S-expr -> S-expr
          (define (for-sexp sexp)
            (cond [(atom? sexp) (if (equal? sexp old) new sexp)]
                  [else
                   (map for-sexp sexp)])))
    (for-sexp sexp)))

(define (substitute sexp old new)
  (cond [(atom? sexp) (if (equal? sexp old) new sexp)]
        [else
         (map (lambda (s) (substitute s old new)) sexp)]))
