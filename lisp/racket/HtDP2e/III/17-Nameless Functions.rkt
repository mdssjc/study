;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname |17-Nameless Functions|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 17-Nameless Functions.rkt
;; III - Abstraction
;; 17  - Nameless Functions

(require 2htdp/image)


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



;; 17.1 - Functions from lambda

;; Exercise 279

(lambda (x y) (x y y))
((lambda (x y) (x y y)) + 1)

;(lambda () 10)

(lambda (x) x)
((lambda (x) x) 2)

(lambda (x y) x)
((lambda (x y) x) 2 1)

;(lambda x 10)

;; Exercise 280

(check-expect ((lambda (x y) (+ x (* x y)))
               1 2)
              3)

(check-expect ((lambda (x y)
                 (+ x
                    (local ((define z (* y y)))
                      (+ (* 3 z) (/ 1 x)))))
               1 2)
              14)

(check-expect ((lambda (x y)
                 (+ x
                    ((lambda (z)
                       (+ (* 3 z) (/ 1 z)))
                     (* y y))))
               1 2)
              53/4)

;; Exercise 281

; consumes a number and decides whether it is less than 10
(define lambda1 (lambda (n) (< n 10)))

(check-expect (lambda1 5)  #true)
(check-expect (lambda1 20) #false)

; multiplies two given numbers and turns the result into a string
(define lambda2 (lambda (x y) (number->string (* x y))))

(check-expect (lambda2 2 5) "10")

; consumes a natural number and produces 0 if it is even and 1 if odd
(define lambda3 (lambda (n) (if (odd? n) 1 0)))

(check-expect (lambda3 2) 0)
(check-expect (lambda3 3) 1)

; consumes two inventory records and compares them by price
(define lambda4 (lambda (c ir1 ir2)
                  (if (c (ir-price ir1) (ir-price ir2))
                      (ir-price ir1)
                      (ir-price ir2))))

(check-expect (lambda4 > (make-ir "TV" 123) (make-ir "Radio" 23)) 123)
(check-expect (lambda4 < (make-ir "TV" 123) (make-ir "Radio" 23)) 23)

; adds a red dot at a given Posn to a given Image
(define MTS (rectangle 10 10 "outline" "black"))

(define lambda5 (lambda (p) (place-image (circle 2 "solid" "red") (posn-x p) (posn-y p) MTS)))

(check-expect (lambda5 (make-posn 5 5))
              (place-image (circle 2 "solid" "red") 5 5 MTS))



;; 17.2 - Computing with lambda

;; Exercise 282

(define (f-plain x)
  (* 10 x))

(define f-lambda
  (lambda (x)
    (* 10 x)))

; Number -> Boolean
(define (compare x)
  (= (f-plain x) (f-lambda x)))

(compare (random 100000))

;; Exercise 283

(define th 20)


(map (lambda (x) (* 10 x))
     '(1 2 3))

(foldl (lambda (name rst)
         (string-append name ", " rst))
       "etc."
       '("Matthew" "Robby"))

(filter (lambda (ir) (<= (ir-price ir) th))
        (list (make-ir "bear" 10)
              (make-ir "doll" 33)))

;; Exercise 284

((lambda (x) x) (lambda (x) x))
(((lambda (x) x)
  (lambda (x) x))
 10)

((lambda (x) (x x)) (lambda (x) x))
(((lambda (x) (x x))
  (lambda (x) x))
 10)

; Indirect self-reference
#;
((lambda (x) (x x))
 (lambda (x) (x x)))



;; 17.3 - Abstracting with lambda


;; =================
;; Functions:

; [List-of Posn] -> [List-of Posn]
; adds 3 to each x-coordinate on the given list
(check-expect (add-3-to-all (list (make-posn 3 1) (make-posn 0 0)))
              (list (make-posn 6 1) (make-posn 3 0)))

(define (add-3-to-all lop)
  (map (lambda (p)
         (make-posn (+ (posn-x p) 3) (posn-y p)))
       lop))

; [List-of Posn] -> [List-of Posn]
; eliminates Posns whose y-coordinate is > 100
(check-expect (keep-good (list (make-posn 0 110) (make-posn 0 60)))
              (list (make-posn 0 60)))

(define (keep-good lop)
  (filter (lambda (p) (<= (posn-y p) 100)) lop))

; Posn Posn Number -> Boolean
; is the distance between p and q less than d
(define (close-to p q d)
  (<= (sqrt (+ (sqr (- (posn-x q) (posn-x p)))
               (sqr (- (posn-y q) (posn-y p)))))
      d))

; [List-of Posn] Posn -> Boolean
; is any Posn on lop close to pt
(check-expect (close? (list (make-posn 47 54) (make-posn 0 60)) (make-posn 50 50))
              #true)

(define (close? lop pt)
  (ormap (lambda (p) (close-to p pt CLOSENESS))
         lop))

(define CLOSENESS 5) ; in terms of pixels

;; Exercise 285


;; =================
;; Constants:

(define US-DOLLAR-RATE 1.06)


;; =================
;; Functions:

; [List-of Number] -> [List-of Number]
; converts a list of US$ amounts into a list of € amounts
; based on an exchange rate of US$ US-DOLLAR-RATE per €
(check-expect (convert-euro '()) '())
(check-expect (convert-euro '(1.00 5.00 12.34))
              (list (* 1.00  US-DOLLAR-RATE)
                    (* 5.00  US-DOLLAR-RATE)
                    (* 12.34 US-DOLLAR-RATE)))

(define (convert-euro lon)
  (map (lambda (n)
         (* n US-DOLLAR-RATE))
       lon))

; [List-of Number] -> [List-of Number]
; converts a list of Fahrenheit measurements to a list of Celsius measurements
(check-expect (convertFC '()) '())
(check-within (convertFC '(0 10 20 30 40 50))
              '(-17.78 -12.22 -6.67 -1.11 4.44 10) 0.01)

(define (convertFC lon)
  (map (lambda (f)
         (/ (- f 32) 1.8))
       lon))

; [List-of Posn] -> [List-of [List-of Number]]
; translates a list of Posns into a list of list of pairs of numbers
(check-expect (translate '()) '())
(check-expect (translate (list (make-posn 1 2) (make-posn 5 3) (make-posn 9 6)))
              '((1 2) (5 3) (9 6)))

(define (translate lop)
  (map (lambda (p)
         (list (posn-x p) (posn-y p)))
       lop))

;; Exercise 286


;; =================
;; Data definitions:

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
; - '()
; - (cons Inventory [List-of Inventory])
; interpretation is a list of inventories
(define LOI1 '())
(define LOI2 (list I1))
(define LOI3 (list I1 I2 I3))


;; =================
;; Functions:

; [List-of Inventory] -> [List-of Inventory]
; sorts a list of inventory records by the difference between the two prices
(check-expect (sort-loi LOI1) '())
(check-expect (sort-loi LOI2) LOI2)
(check-expect (sort-loi LOI3) (list I2 I1 I3))

(define (sort-loi loi)
  (sort loi (lambda (i1 i2)
              (< (abs (- (inventory-acq-price i1)
                         (inventory-sales-price i1)))
                 (abs (- (inventory-acq-price i2)
                         (inventory-sales-price i2)))))))
