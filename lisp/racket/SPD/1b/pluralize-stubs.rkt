;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname pluralize-stubs-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; pluralize-stubs.rkt
;; HtDF P4


;; PROBLEM:
;;
;; You are working on designing a function and have completed your signature and purpose.
;;
;; Write three stubs with different bodies that are consistent with the signature and purpose below.
;; Put the three stubs in a comment box.
;;
;; ;; String -> String
;; ;; pluralizes str by appending "s" to the end

;; String -> String
;; pluralizes str by appending "s" to the end
(check-expect (pluralize "cat") "cats")
(check-expect (pluralize "bread") "breads")
(check-expect (pluralize "wood") "woods")

;(define (pluralize str) str) ; Stub
;(define (pluralize str) "")  ; Stub
;(define (pluralize str) "s") ; Stub

;(define (pluralize str)      ; Template
;  (... str))

(define (pluralize str)
  (string-append str "s"))
