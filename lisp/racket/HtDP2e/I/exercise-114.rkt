;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-114) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 114

(require 2htdp/image)
(require 2htdp/universe)

(define-struct aim [ufo tank])
(define-struct fired [ufo tank missile])

; A SIGS is one of: 
; - (make-aim UFO Tank)
; - (make-fired UFO Tank Missile)
; interpretation represents the complete state of a 
; space invader game


; SIGS -> World
; stub function
(define (main-sigs s)
  (big-bang s
            (on-tick ...)
            (on-draw ...)
            (check-with is-a-sigs?)))

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


; VAnimal -> World
; stub function
(define (main-vanimal va)
  (big-bang va
            (on-tick ...)
            (on-draw ...)
            (check-with is-a-vanimal?)))

; Any -> Boolean
; is va an element of the VAnimal collection
(check-expect (is-a-vanimal? (make-vcat 20 100)) #true)
(check-expect (is-a-vanimal? (make-vcham 20 100 "red")) #true)
(check-expect (is-a-vanimal? "cat") #false)

(define (is-a-vanimal? va)
  (or (vcat?  va)
      (vcham? va)))

; ---

(define-struct editor [pre post])
; An Editor is a structure:
;   (make-editor String String)
; interpretation (make-editor s t) describes an editor
; whose visible text is (string-append s t) with 
; the cursor displayed between s and t


; Editor -> World
; stub function
(define (main-editor e)
  (big-bang e
            (on-tick ...)
            (on-draw ...)
            (check-with is-an-editor?)))

; Any -> Boolean
; is e an Editor structure
(check-expect (is-an-editor? (make-editor "Hello" "World")) #true)
(check-expect (is-an-editor? "Hello | World") #false)
(check-expect (is-an-editor? 10) #false)

(define (is-an-editor? e)
  (editor? e))
