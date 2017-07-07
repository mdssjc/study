;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-269) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 269


(define-struct inventory [name description acq-price sales-price])
; An Inventory is a structure:
;   (make-inventory String String Number Number)
; interpretation (make-inventory n d ap sp) specifies
;   n: the name of an item;
;   d: a description;
;  ap: the acquisition price; and
;  sp: the recommended sales price
(define I1 (make-inventory "Inv1" "Description 1" 13.1 16.8))
(define I2 (make-inventory "Inv2" "Description 2" 13.1 14.8))
(define I3 (make-inventory "Inv3" "Description 3" 10.1 15.8))

; [List-of Inventory] is one of:
; - empty
; - (cons Inventory [List-of Inventory])
; interpretation is a list of inventories
(define LOI1 empty)
(define LOI2 (list I1))
(define LOI3 (list I1 I2 I3))


; Number [List-of Inventory] -> [List-of Inventory]
; produces a list of all those structures whose sales price is below ua
(check-expect (eliminate-expensive 16 LOI1) empty)
(check-expect (eliminate-expensive 16 LOI3) (list I2 I3))

(define (eliminate-expensive ua loi)
  (local ((define (below? i)
            (<= (inventory-sales-price i) ua)))
    (filter below? loi)))

; String [List-of Inventory] -> [List-of Inventory]
; produces a list of inventory records that do not use the name ty
(check-expect (recall "Inv2" LOI1) empty)
(check-expect (recall "Inv2" LOI3) (list I1 I3))

(define (recall ty loi)
  (local ((define (not-equals? i)
            (not (string=? (inventory-name i) ty))))
    (filter not-equals? loi)))

; [List-of String] [List-of String] -> [List-of String]
; selects all those from the second one that are also on the first
(check-expect (selection empty empty) empty)
(check-expect (selection (list "A" "B" "C") empty) empty)
(check-expect (selection empty (list "A" "B" "C")) empty)
(check-expect (selection (list "A" "C" "D") (list "A" "B" "C")) (list "A" "C"))

(define (selection los1 los2)
  (local ((define (contains? s)
            (member? s los2)))
    (filter contains? los1)))
