;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-279) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 279


(lambda (x y) (x y y))
((lambda (x y) (x y y)) + 1)

;(lambda () 10)

(lambda (x) x)
((lambda (x) x) 2)

(lambda (x y) x)
((lambda (x y) x) 2 1)

;(lambda x 10)
