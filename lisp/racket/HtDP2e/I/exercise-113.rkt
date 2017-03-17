;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-113) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 113

(define-struct aim [ufo tank])
(define-struct fired [ufo tank missile])

; A SIGS is one of: 
; - (make-aim UFO Tank)
; - (make-fired UFO Tank Missile)
; interpretation represents the complete state of a 
; space invader game


; Any -> Boolean
; is s an element of the SIGS collection
(check-expect (is-a-sigs? (make-aim "ufo" "tank")) #true)
(check-expect (is-a-sigs? (make-fired "ufo" "tank" "missile")) #true)
(check-expect (is-a-sigs? "troops") #false)
(check-expect (is-a-sigs? 5) #false)

(define (is-a-sigs? s)
  (or (aim?   s)
      (fired? s)))

; ---

; A Coordinate is one of: 
; - a NegativeNumber 
; interpretation on the y axis, distance from top
; - a PositiveNumber 
; interpretation on the x axis, distance from left
; - a Posn
; interpretation an ordinary Cartesian point


; Any -> Boolean
; is c an element of the Coordinate collection
(check-expect (is-a-coordinate? -3) #true)
(check-expect (is-a-coordinate?  3) #true)
(check-expect (is-a-coordinate? (make-posn 10 10)) #true)
(check-expect (is-a-coordinate? "1,2") #false)

(define (is-a-coordinate? c)
  (or (and (number? c)
           (or (< c 0)
               (> c 0)))
      (posn? c)))

; ---

(define-struct vcat (x h))
; A VCat is a structure:
;   (make-vcat Number Number)
; interpretation (make-vcat x h) describes a virtual cat
; where x means x-coordinate
; and   h means your happiness

(define-struct vcham (x h c))
; A VCham is a structure:
;   (make-vcham Number Number String)
; interpretation (make-vcham x h c) describes a virtual cham
;   where x means x-coordinate
;   and   h means your happiness
;   and   c means your color

; A VAnimal is either
; - a VCat
; - a VCham


; Any -> Boolean
; is va an element of the VAnimal collection
(check-expect (is-a-vanimal? (make-vcat 20 100)) #true)
(check-expect (is-a-vanimal? (make-vcham 20 100 "red")) #true)
(check-expect (is-a-vanimal? "cat") #false)

(define (is-a-vanimal? va)
  (or (vcat?  va)
      (vcham? va)))
