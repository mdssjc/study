;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname |17-Nameless Functions|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 17-Nameless Functions.rkt
;; III - Abstraction
;; 17  - Nameless Functions



(define-struct ir [name price])
; An IR is a structure:
;   (make-ir String Number)
; An Inventory is one of:
; - '()
; - (cons IR Inventory)


; [List-of IR] Number -> Boolean
#;
(define (find l th)
  (local (; IR -> Boolean
          (define (acceptable? ir)
            (<= (ir-price ir) th)))
    (filter acceptable? l)))
(define (find l th)
  (filter (lambda (ir) (<= (ir-price ir) th)) l))
