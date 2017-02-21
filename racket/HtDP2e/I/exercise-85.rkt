;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-85) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 85

(require 2htdp/image)
(require 2htdp/universe)

; String -> World
; Starts with (main "abc")
(define (main pre)
  (big-bang pre
            (to-draw render)
            (on-key  edit)))

; Editor -> Image
; !!!
(define (render e) (empty-scene 200 20))

; Editor KeyEvent -> Editor
; !!!
(define (edit e ke) e)
