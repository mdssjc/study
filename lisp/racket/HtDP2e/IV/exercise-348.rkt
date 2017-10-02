;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-348) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 348


;; ====================
;; Data definitions:

(define-struct and2 [left right])
; An And is a structure:
;   (make-and BSL-boolean BSL-boolean)
; interpretation (make-and2 l r) specifies an AND operation
;  l: is the left operand; and
;  r: is the right operand

(define-struct or2 [left right])
; An Or is a structure:
;   (make-or BSL-boolean BSL-boolean)
; interpretation (make-or2 l r) specifies an OR operation
;  l: is the left operand; and
;  r: is the right operand

(define-struct not2 [operand])
; A Not is a structure:
;   (make-not BSL-boolean)
; interpretation (make-not2 o) specifies a NOT operation
;  o: is an operand

; A BSL-boolean is one of:
;  - #false
;  - #true
;  - (make-and2 BSL-boolean BSL-boolean)
;  - (make-or2  BSL-boolean BSL-boolean)
;  - (make-not2 BSL-boolean)
; interpretation class of values to which a representation of a BSL boolean expression can evaluate


;; ====================
;; Functions:

; BSL-boolean -> Boolean
; computes their values
(check-expect (eval-bool-expression #false) #false)
(check-expect (eval-bool-expression #true) #true)
(check-expect (eval-bool-expression (make-and2 #true #true)) #true)
(check-expect (eval-bool-expression (make-and2 #true #false)) #false)
(check-expect (eval-bool-expression (make-or2 #true #false)) #true)
(check-expect (eval-bool-expression (make-or2 #false #false)) #false)
(check-expect (eval-bool-expression (make-not2 #false)) #true)
(check-expect (eval-bool-expression (make-not2 #true)) #false)
(check-expect (eval-bool-expression (make-not2 (make-and2 #true (make-or2 #false #true)))) #false)

(define (eval-bool-expression b)
  (cond [(boolean? b) b]
        [(and2? b)
         (and (eval-bool-expression (and2-left b))
              (eval-bool-expression (and2-right b)))]
        [(or2? b)
         (or (eval-bool-expression (or2-left b))
             (eval-bool-expression (or2-right b)))]
        [(not2? b)
         (not (eval-bool-expression (not2-operand b)))]))
