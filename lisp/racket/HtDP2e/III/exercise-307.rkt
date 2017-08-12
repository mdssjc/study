;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-307) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 307

(require 2htdp/abstraction)


; String [List-of String] -> String or false
; retrieves the first name on the latter that is equal to, or an extension of, the former
(check-expect (find-name "John" empty) false)
(check-expect (find-name "John" (list "Marie" "Paul")) false)
(check-expect (find-name "John" (list "Marie" "Paul" "John")) "John")
(check-expect (find-name "John" (list "Marie" "Paul" "Jones")) false)
(check-expect (find-name "John" (list "Marie" "Paul" "Jones" "Johnson")) "Johnson")
(check-expect (find-name "Jo" (list "Marie" "Paul" "Jones")) "Jones")

(define (find-name n lon)
  (for/or ([name lon])
    (if (string-contains? n name)
        name
        false)))

; Number [List-of String] -> Boolean
; ensures that no name on some list exceeds some given width
(check-expect (exceed-width? 5 empty) false)
(check-expect (exceed-width? 5 (list "alf")) false)
(check-expect (exceed-width? 5 (list "alf" "marie")) false)
(check-expect (exceed-width? 5 (list "alf" "marie" "johnson")) true)

(define (exceed-width? n lon)
  (for/or ([name lon])
    (> (string-length name) n)))
