;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-286) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 286


(define-struct inventory [name description acq-price sales-price])
; An Inventory is a structure:
;   (make-inventory String String Number Number)
; interpretation (make-inventory n d ap sp) specifies
;   n: the name of an item;
;   d: a description;
;  ap: the acquisition price; and
;  sp: the recommended sales price
(define I1 (make-inventory "Inv1" "Description 1" 12.1 15.8))
(define I2 (make-inventory "Inv2" "Description 2" 14.1 15.8))
(define I3 (make-inventory "Inv3" "Description 3" 10.1 15.8))

; [List-of Inventory] is one of:
; - empty
; - (cons Inventory [List-of Inventory])
; interpretation is a list of inventories
(define LOI1 empty)
(define LOI2 (list I1))
(define LOI3 (list I1 I2 I3))


; [List-of Inventory] -> [List-of Inventory]
; sorts a list of inventory records by the difference between the two prices
(check-expect (sort-loi LOI1) empty)
(check-expect (sort-loi LOI2) LOI2)
(check-expect (sort-loi LOI3) (list I2 I1 I3))

(define (sort-loi loi)
  (sort loi (lambda (i1 i2)
              (< (abs (- (inventory-acq-price i1)
                         (inventory-sales-price i1)))
                 (abs (- (inventory-acq-price i2)
                         (inventory-sales-price i2)))))))
