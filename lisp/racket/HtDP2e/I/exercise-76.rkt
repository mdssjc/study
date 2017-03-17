;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-76) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 76

(define-struct movie [title producer year])
; Movie is (make-movie String String Number[0..9999])
; interpretation title is a string
;                producer is a string
;                year is a number, between 0 and 9999

(define-struct person [name hair eyes phone])
; Person is (make-person String String String String)
; interpretation name is a string
;                hair is a string
;                eyes is a string
;                phone is a string in format ###-####

(define-struct pet [name number])
; Pet is (make-pet String Number)
; interpretation name is a string
;                number is a identification number

(define-struct CD [artist title price])
; CD is (make-CD String String Number[0..])
; interpretation artist is a string
;                title is a string
;                price is a positive number

(define-struct sweater [material size producer])
; Sweater is (make-sweater String Number[0..] String)
; interpretation material is a string
;                size is a positive number
;                producer is a string
