;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-88) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 88

(define-struct vcat (x h))
; A VCat is a structure:
;   (make-vcat Number Number)
; interpretation (make-vcat x h) describes a virtual cat
; where x means x-coordinate
; and   h means your happiness
