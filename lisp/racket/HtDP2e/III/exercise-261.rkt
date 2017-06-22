;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-261) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 261


(define-struct ir [name price])
; An IR is a structure:
;   (make-ir String Number)
; An Inventory is one of: 
; - '()
; - (cons IR Inventory)
(define IR1  (list (make-ir "doll" 21.0)
                   (make-ir "bear" 13.0)
                   (make-ir "ball" 0.50)
                   (make-ir "tv"   5.0)
                   (make-ir "pen"  0.25)))
(define IR2 (append IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1))


; Inventory -> Inventory
; creates an Inventory from an-inv for all
; those items that cost less than a dollar
(define (extract1 an-inv)
  (cond [(empty? an-inv) '()]
        [else
         (cond [(<= (ir-price (first an-inv)) 1.0)
                (cons (first an-inv) (extract1 (rest an-inv)))]
               [else (extract1 (rest an-inv))])]))

(define (extract2 an-inv)
  (cond [(empty? an-inv) '()]
        [else
         (local ((define ext (extract2 (rest an-inv)))
                 (define item (first an-inv)))
           (cond [(<= (ir-price item) 1.0) (cons item ext)]
                 [else ext]))]))


; Tests
(time (extract1 IR1))
(time (extract1 IR2))
(time (extract2 IR1))
(time (extract2 IR2))
