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
(define I1 (make-inventory "Inv1" "Description 1" 12.1 16.8))
(define I2 (make-inventory "Inv2" "Description 2" 14.1 15.8))
(define I3 (make-inventory "Inv3" "Description 3" 10.1 14.8))

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

;; Exercise 287

;; =================
;; Functions:

; Number [List-of Inventory] -> [List-of Inventory]
; produces a list of all those structures whose sales price is below ua
(check-expect (eliminate-expensive 16 LOI1) '())
(check-expect (eliminate-expensive 16 LOI2) '())
(check-expect (eliminate-expensive 16 LOI3) (list I2 I3))

(define (eliminate-expensive ua loi)
  (filter (lambda (i)
            (<= (inventory-sales-price i) ua))
          loi))

; String [List-of Inventory] -> [List-of Inventory]
; produces a list of inventory records that do not use the name ty
(check-expect (recall "Inv2" LOI1) '())
(check-expect (recall "Inv1" LOI2) '())
(check-expect (recall "Inv2" LOI2) (list I1))
(check-expect (recall "Inv2" LOI3) (list I1 I3))

(define (recall ty loi)
  (filter (lambda (i)
            (not (string=? (inventory-name i) ty)))
          loi))

; [List-of String] [List-of String] -> [List-of String]
; selects all those from the second one that are also on the first
(check-expect (selection '() '()) '())
(check-expect (selection '("A" "B" "C") '()) '())
(check-expect (selection '() '("A" "B" "C")) '())
(check-expect (selection '("A" "C" "D") '("A" "B" "C")) '("A" "C"))

(define (selection los1 los2)
  (filter (lambda (s)
            (member? s los2))
          los1))

;; Exercise 288


;; =================
;; Functions:

; Number -> [List-of Number]
; creates the list (list 0 ... (- n 1)) for any natural number n
(check-expect (f1 5) '(0 1 2 3 4))

(define (f1 n)
  (map sub1 (build-list n add1)))

; Number -> [List-of Number]
; creates the list (list 1 ... n) for any natural number n
(check-expect (f2 5) '(1 2 3 4 5))

(define (f2 n)
  (build-list n add1))

; Number -> [List-of Number]
; creates the list (list 1 1/2 ... 1/n) for any natural number n
(check-expect (f3 5) '(1/1 1/2 1/3 1/4 1/5))

(define (f3 n)
  (map (lambda (n)
         (/ 1 n))
       (build-list n add1)))

; Number -> [List-of Number]
; creates the list of the first n even numbers
(check-expect (f4 5) '(0 2 4 6 8))

(define (f4 n)
  (build-list n (lambda (n)
                  (* n 2))))

; Number -> [List-of [List-of Number]]
; creates a diagonal square of 0s and 1s
(check-expect (f5 3) '((1 0 0)
                       (0 1 0)
                       (0 0 1)))

(define (f5 n)
  (local ((define (numbers n s)
            (cond [(zero? n) '()]
                  [else
                   (cons (if (= n s) 1 0)
                         (numbers (sub1 n) s))])))
    (build-list n (lambda (i)
                    (numbers n (- n i))))))

; [Number -> X] Number -> [List-of X]
; tabulates a f function n times
(check-expect (tabulate add1 5)
              '(6 5 4 3 2 1))
(check-expect (tabulate number->string 5)
              '("5" "4" "3" "2" "1" "0"))

(define (tabulate f n)
  (reverse (build-list (add1 n) f)))

;; Exercise 289


;; =================
;; Functions:

; String [List-of String] -> Boolean
; determines whether any of the names on the latter are equal to or an extension of the former
(check-expect (find-name? "john" '())                  #false)
(check-expect (find-name? "john" '("marie"))           #false)
(check-expect (find-name? "john" '("john"))            #true)
(check-expect (find-name? "john" '("marie" "john"))    #true)
(check-expect (find-name? "jo"   '("marie" "john"))    #true)
(check-expect (find-name? "john" '("marie" "johnson")) #true)

(define (find-name? s los)
  (ormap (lambda (x)
           (string-contains? s x))
         los))

; [List-of String] -> Boolean
; checks all names on a list of names start with the letter "a"
(check-expect (check-name? '())               #false)
(check-expect (check-name? '("marie"))        #false)
(check-expect (check-name? '("arie"))         #true)
(check-expect (check-name? '("marie" "arie")) #false)
(check-expect (check-name? '("alf" "arie"))   #true)

(define (check-name? los)
  (cond [(empty? los) #false]
        [else
         (andmap (lambda (s)
                   (string=? "a" (string-ith s 0)))
                 los)]))

; Number [List-of String] -> Boolean
; ensures that no name on some list exceeds some given width
(check-expect (exceed-width? 5 '())                        #false)
(check-expect (exceed-width? 5 '("alf"))                   #false)
(check-expect (exceed-width? 5 '("alf" "marie"))           #false)
(check-expect (exceed-width? 5 '("alf" "marie" "johnson")) #true)

(define (exceed-width? n los)
  (ormap (lambda (s)
           (> (string-length s) n))
         los))

;; Exercise 290

(equal? (append '(1 2 3) '(4 5 6 7 8))
        '(1 2 3 4 5 6 7 8))


;; =================
;; Functions:

; [List-of Number] [List-of Number] -> [List-of Number]
; concatenates the items of two lists
(check-expect (append-from-fold '(1 2 3) '(4 5 6 7 8))
              '(1 2 3 4 5 6 7 8))

(define (append-from-fold lon1 lon2)
  (foldr (lambda (i lst)
           (cons i lst))
         lon2 lon1))

; [List-of Number] -> Number
; computes the sum of a list of numbers
(check-expect (sum '())  0)
(check-expect (sum '(1)) 1)
(check-expect (sum '(1 2 3)) 6)

(define (sum lon)
  (foldr + 0 lon))

; [List-of Number] -> Number
; computes the product of a list of numbers
(check-expect (product '())  1)
(check-expect (product '(1)) 1)
(check-expect (product '(1 2 3)) 6)

(define (product lon)
  (foldr * 1 lon))

; [List-of Image] -> Image
; composes a list of Images horizontally
(check-expect (compose-images '()) empty-image)
(check-expect (compose-images (list (circle 5 "solid" "blue")))
              (circle 5 "solid" "blue"))
(check-expect (compose-images (list (circle 5 "solid" "blue") (square 10 "solid" "red")))
              (beside (circle 5 "solid" "blue") (square 10 "solid" "red")))

(define (compose-images loi)
  (foldr beside empty-image loi))

;; Exercise 291


;; =================
;; Functions:

; [X Y] [X -> Y] [List-of X] -> [List-of Y]
; maps fn for each item in the list
(check-expect (map-via-fold (lambda (n) (* n 2)) '())      '())
(check-expect (map-via-fold (lambda (n) (* n 2)) '(1))     '(2))
(check-expect (map-via-fold (lambda (n) (* n 2)) '(1 2 3)) '(2 4 6))

(define (map-via-fold fn lox)
  (foldr (lambda (x lst)
           (cons (fn x) lst))
         '() lox))



;; 17.4 - Specifying with lambda

; [X] [List-of X] [X X -> Boolean] -> [List-of X]
; sorts alon0 according to cmp
;; (check-expect (sort-cmp '("c" "b") string<?) '("b" "c"))
;; (check-expect (sort-cmp '(2 1 3 4 6 5) <)    '(1 2 3 4 5 6))
;; (check-satisfied (sort-cmp '("c" "b") string<?)
;;                  (sorted string<?))
;; (check-satisfied (sort-cmp '(2 1 3 4 6 5) <)
;;                  (sorted <))

(define (sort-cmp alon0 cmp)
  (local (; [List-of X] -> [List-of X]
          ; produces a variant of alon sorted by cmp
          (define (isort alon) ...)

          ; X [List-of X] -> [List-of X]
          ; inserts n into the sorted list of numbers alon
          (define (insert n alon) ...))
    (isort alon0)))

;; Exercise 292


;; =================
;; Data definitions:

; A [NEList-of ITEM] is one of:
; - (cons ITEM '())
; - (cons ITEM [NEList-of ITEM])


;; =================
;; Functions:

; [X X -> Boolean] [NEList-of X] -> Boolean
; determine whether l is sorted according to cmp
(check-expect (sorted? < '(1 2 3)) #true)
(check-expect (sorted? < '(2 1 3)) #false)

(define (sorted? cmp l)
  (cond [(empty? (rest l)) #true]
        [else
         (and (cmp (first l)
                   (second l))
              (sorted? cmp (rest l)))]))

; [X X -> Boolean] -> [[List-of X] -> Boolean]
; produces a function that determines whether
; is the given list l0 is sorted according to cmp
(check-expect [(sorted string<?) '("b" "c")] #true)
(check-expect [(sorted <) '(1 2 3 4 5 6)]    #true)
(check-expect [(sorted <) '(1 2 3)]          #true)
(check-expect [(sorted <) '(2 1 3)]          #false)

(define (sorted cmp)
  (lambda (l0)
    (cond [(empty? l0) #true]
          [else
           (sorted? cmp l0)])))
