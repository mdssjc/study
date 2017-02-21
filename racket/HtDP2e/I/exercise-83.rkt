;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-83) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 83

(require 2htdp/image)

(define-struct editor [pre post])
; An Editor is a structure:
;   (make-editor String String)
; interpretation (make-editor s t) describes an editor
; whose visible text is (string-append s t) with 
; the cursor displayed between s and t


; Editor -> Image
; produces an image with the editor
(define (render e)
  (overlay/align "left" "center"
                 (beside
                  (text (editor-pre e)  16 "black")
                  (rectangle 1 20 "solid" "red")
                  (text (editor-post e) 16 "black"))
                 (empty-scene 200 20)))

(render (make-editor "Hello" "World"))
