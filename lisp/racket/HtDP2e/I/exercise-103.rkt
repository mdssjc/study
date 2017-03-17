;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-103) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 103

(define-struct spider (legs space))
; Spider is a structure:
; interpretation (make-spider Number Number)
;  legs means the total of legs remaining
;  space means the amount of space to transport
(define S1 (make-spider 4 10))
(define S2 (make-spider 8 20))

(define-struct elephant (space))
; Elephante is a structure:
; interpretation (make-elephant Number)
;  space means the amount of space to transport
(define E1 (make-elephant 10))
(define E2 (make-elephant 20))

(define-struct boa-constrictor (length girth))
; Boa-constrictor is a structure:
; interpretation (make-boa-constrictor Number(0..N] Number(0..N])
;  length means its horizontal size, between 0 and N
;  girth means its vertical size, between 0 and N
(define B1 (make-boa-constrictor 5 2))
(define B2 (make-boa-constrictor 5 4))

(define-struct armadillo (claws space))
; Armadillo is a structure:
; interpretation (make-armadillo Number[0..100] Number)
;  claws means the percentage of durability
;  space means the amount of space to transport
(define A1 (make-armadillo 100 10))
(define A2 (make-armadillo 100 20))

(define-struct zoo (spider elephant boa-constrictor armadillo))
; A Zoo is a structure:
; interpretation (make-spider Spider Elephant Boa-constrictor Armadillo)
;  represents four kinds of zoo animals
(define Z1 (make-zoo S1 E1 B1 A1))
(define Z2 (make-zoo S2 E2 B2 A2))

(define (fn-for-zoo z)
  (... (zoo-spider z)
       (zoo-elephant z)
       (zoo-boa-constrictor z)
       (zoo-armadillo z)))


; Zoo Number -> Boolean
; determines whether the cage is large enough for the animal
(check-expect (fits? Z1 50) #true)
(check-expect (fits? Z2 50) #false)

(define (fits? z v)
  (<= (+ (spider-space (zoo-spider z))
         (elephant-space (zoo-elephant z))
         (* (boa-constrictor-length (zoo-boa-constrictor z))
            (boa-constrictor-girth (zoo-boa-constrictor z)))
         (armadillo-space (zoo-armadillo z)))
      v))
