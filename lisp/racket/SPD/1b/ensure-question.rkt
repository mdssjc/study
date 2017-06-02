;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ensure-question-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; ensure-question.rkt
;; HtDF P8


;; PROBLEM:
;;
;; Use the How to Design Functions (HtDF) recipe to design a function that consumes a string, and adds "?"
;; to the end unless the string already ends in "?".
;;
;; For this question, assume the string has length > 0. Follow the HtDF recipe and leave behind commented
;; out versions of the stub and template.

;; String -> String
;; Produces a string with "?" in end, unless the string already have.
(check-expect (ensure-question "is easy") "is easy?")
(check-expect (ensure-question "is hard?") "is hard?")

;(define (ensure-question str) "") ; Stub

;(define (ensure-question str)     ; Template
;  (... str))

(define (ensure-question str)
  (string-append str (if (string-contains? "?" str) "" "?")))
