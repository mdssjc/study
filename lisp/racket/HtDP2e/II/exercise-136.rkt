;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-136) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 136

(define-struct pair [left right])
; A ConsPair is a structure:
;   (make-pair Any Any).

; Any Any -> ConsPair
(define (our-cons a-value a-list)
  (make-pair a-value a-list))


; ConsOrEmpty -> Any
; extracts the left part of the given pair
(define (our-first a-list)
  (if (empty? a-list)
      (error 'our-first "...")
      (pair-left a-list)))

; ConsOrEmpty -> Any
; extracts the right part of the given pair
(define (our-rest a-list)
  (if (empty? a-list)
      (error 'our-rest "...")
      (pair-right a-list)))

(check-expect (our-first (our-cons "a" '())) "a")
(check-expect (our-rest  (our-cons "a" '())) "a")

; ---

(our-first (our-cons "a" '()))
(our-first (make-pair "a" '()))
(if (empty? (make-pair "a" '()))
    (error 'our-first "...")
    (pair-left (make-pair "a" '())))
(if #false
    (error 'our-first "...")
    (pair-left (make-pair "a" '())))
(pair-left (make-pair "a" '()))
"a"

; ---

(our-rest (our-cons "a" '()))
(our-rest (make-pair "a" '()))
(if (empty? (make-pair "a" '()))
    (error 'our-rest "...")
    (pair-right (make-pair "a" '())))
(if #false
    (error 'our-rest "...")
    (pair-right (make-pair "a" '())))
(pair-right (make-pair "a" '()))
'()
