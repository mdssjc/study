;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-305) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 305

(require 2htdp/abstraction)


(define D1 (list 1.00 5.00 12.34))


; [List-of Number] -> [List-of Number]
; converts a list of US$ amounts into a list of € amounts
; based on an exchange rate of €1.22 per US$
(check-expect (convert-euro empty) empty)
(check-expect (convert-euro D1) (list (* 1.00 1.22) (* 5.00 1.22) (* 12.34 1.22)))

(define (convert-euro lon)
  (for/list ([n lon])
    (* n 1.22)))
