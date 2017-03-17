;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-80) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 80

(define-struct movie [title director year])

; Movie -> String
; format movie information for a string
(define (format-movie m)
  (... (movie-title m) ... (movie-director m) ... (movie-year m) ...))


(define-struct person [name hair eyes phone])

; Person -> String
; produces the information of a person
(define (do-person p)
  (... (person-name p) ... (person-hair p) ... (person-eyes p) ... (person-phone p) ...))


(define-struct pet [name number])

; Pet -> String
; produces the identification of pet
(define (pet-id p)
  (... (pet-name p) ... (pet-number p) ...))


(define-struct CD [artist title price])

; CD -> String
; produces the information of a CD
(define (do-price c)
  (... (CD-artist c) ... (CD-title c) ... (CD-price c) ...))


(define-struct sweater [material size color])

; Sweater -> String
; produces the information of a Sweater
(define (do-sweater s)
  (... (sweater-material s) ... (sweater-size s) ... (sweater-color s) ...))
