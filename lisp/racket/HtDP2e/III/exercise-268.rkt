;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-268) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 268


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
  (cond [(empty? loi) empty]
        [else
         (insert (first loi) (sort-loi (rest loi)))]))

; Inventory [List-of Inventory] -> [List-of Inventory]
;; inserts inventory in proper place in loi
;; ASSUME: loi is already sorted
(check-expect (insert I1 empty) (list I1))
(check-expect (insert I1 (list I2)) (list I2 I1))
(check-expect (insert I1 (list I2 I3)) (list I2 I1 I3))

(define (insert i loi)
  (cond [(empty? loi) (cons i empty)]
        [else
         (if (smaller? i (first loi))
             (cons (first loi) (insert i (rest loi)))
             (cons i loi))]))

; Inventory Inventory -> Boolean
; produces true if inventory 1 is smaller than inventory 2
(check-expect (smaller? I1 I2) #true)
(check-expect (smaller? I2 I1) #false)
(check-expect (smaller? I1 I3) #false)

(define (smaller? i1 i2)
  (< (- (inventory-acq-price i1) (inventory-sales-price i1))
     (- (inventory-acq-price i2) (inventory-sales-price i2))))
