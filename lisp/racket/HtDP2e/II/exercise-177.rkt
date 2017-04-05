;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-177) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 177

(define-struct editor [pre post])
; An Editor is a structure:
;   (make-editor Lo1S Lo1S)
; An Lo1S is one of: 
; - '()
; - (cons 1String Lo1S)


; String String -> Editor
; consumes two strings and produces an Editor
(check-expect (create-editor "left" "right")
              (make-editor (explode "left") (explode "right")))

(define (create-editor lo1s1 lo1s2)
  (make-editor (explode lo1s1) (explode lo1s2)))
