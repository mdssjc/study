;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-155) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 155

(define-struct layer [color doll])

; An RD (short for Russian doll) is one of: 
; - String 
; - (make-layer String RD)
(define RD1 (make-layer "yellow" (make-layer "green" "red")))

; RD -> String
; produces the (color of the) innermost doll
(check-expect (inner RD1) "red")

(define (inner rd)
  (cond [(string? rd) rd]
        [else (inner (layer-doll rd))]))


(inner RD1)
(inner (make-layer "yellow" (make-layer "green" "red")))
(cond [(string? (make-layer "yellow" (make-layer "green" "red"))) (make-layer "yellow" (make-layer "green" "red"))]
      [else (inner (layer-doll (make-layer "yellow" (make-layer "green" "red"))))])
(cond [#false (make-layer "yellow" (make-layer "green" "red"))]
      [else (inner (layer-doll (make-layer "yellow" (make-layer "green" "red"))))])
(cond [else (inner (layer-doll (make-layer "yellow" (make-layer "green" "red"))))])
(inner (layer-doll (make-layer "yellow" (make-layer "green" "red"))))
(inner (make-layer "green" "red"))
(cond [(string? (make-layer "green" "red")) (make-layer "green" "red")]
      [else (inner (layer-doll (make-layer "green" "red")))])
(cond [#false (make-layer "green" "red")]
      [else (inner (layer-doll (make-layer "green" "red")))])
(cond [else (inner (layer-doll (make-layer "green" "red")))])
(inner "red")
(cond [(string? "red") "red"]
      [else (inner (layer-doll "red"))])
(cond [#true "red"]
      [else (inner (layer-doll "red"))])
"red"
