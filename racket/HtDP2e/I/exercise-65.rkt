;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-65) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 65

(define-struct movie [title producer year])
(define-struct person [name hair eyes phone])
(define-struct pet [name number])
(define-struct CD [artist title price])
(define-struct sweater [material size producer])

; constructors
(define M  (make-movie "Title" "Producer" 2017))
(define P1 (make-person "Name" "Hair" "Eyes" "Phone"))
(define P2 (make-pet "Name" 123))
(define C  (make-CD "Artist" "Title" 1.99))
(define S  (make-sweater "Material" 4 "Producer"))

; selectors
(movie-title    M)
(movie-producer M)
(movie-year     M)

(person-name  P1)
(person-hair  P1)
(person-eyes  P1)
(person-phone P1)

(pet-name   P2)
(pet-number P2)

(CD-artist C)
(CD-title  C)
(CD-price  C)

(sweater-material S)
(sweater-size     S)
(sweater-producer S)

; predicates
(movie?   M)
(person?  P1)
(pet?     P2)
(CD?      C)
(sweater? S)
