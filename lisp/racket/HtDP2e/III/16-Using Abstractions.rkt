;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname |16-Using Abstractions|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 16-Using Abstractions.rkt
;; III - Abstraction
;; 16  - Using Abstractions



;; 16.1 - Existing Abstractions

; [X] N [N -> X] -> [List-of X]
; constructs a list by applying f to 0, 1, ..., (sub1 n)
; (build-list n f) == (list (f 0) ... (f (- n 1)))
; (define (build-list n f) ...)

(build-list 3 add1)

; [X] [X -> Boolean] [List-of X] -> [List-of X]
; produces a list from those items on lx for which p holds
; (define (filter p lx) ...)

(filter odd? (list 1 2 3 4 5))

; [X] [List-of X] [X X -> Boolean] -> [List-of X]
; produces a version of lx that is sorted according to cmp
; (define (sort lx cmp) ...)

(sort (list 3 2 1 4 5) >)

; [X Y] [X -> Y] [List-of X] -> [List-of Y]
; constructs a list by applying f to each item on lx
; (map f (list x-1 ... x-n)) == (list (f x-1) ... (f x-n))
; (define (map f lx) ...)

(map add1 (list 1 2 2 3 3 3))

; [X] [X -> Boolean] [List-of X] -> Boolean
; determines whether p holds for every item on lx
; (andmap p (list x-1 ... x-n)) == (and (p x-1) ... (p x-n))
; (define (andmap p lx) ...)

(andmap odd? (list 1 2 3 4 5))

; [X] [X -> Boolean] [List-of X] -> Boolean
; determines whether p holds for at least one item on lx
; (ormap p (list x-1 ... x-n)) == (or (p x-1) ... (p x-n))
; (define (ormap p lx) ...)

(ormap odd? (list 1 2 3 4 5))


; [X Y] [X Y -> Y] Y [List-of X] -> Y
; applies f from right to left to each item in lx and b
; (foldr f b (list x-1 ... x-n)) == (f x-1 ... (f x-n b))
; (define (foldr f b lx) ...)

(foldr + 0 '(1 2 3 4 5))

; [X Y] [X Y -> Y] Y [List-of X] -> Y
; applies f from left to right to each item in lx and b
; (foldl f b (list x-1 ... x-n)) == (f x-n ... (f x-1 b))
; (define (foldl f b lx) ...)

(foldl + 0 '(1 2 3 4 5))


;; Exercise 256


;; =================
;; Data definitions:

; A [NEList-of X] is one of:
; - (cons X '())
; - (cons X [NEList-of X])
; interpretation non-empty lists of X
(define NEL1 (list 5 2 4 7 1))
(define NEL2 (list (make-posn 2 4) (make-posn 3 1) (make-posn 1 5)))


;; =================
;; Functions:

; [X] [X -> Number] [NEList-of X] -> X
; finds the (first) item in lx that maximizes f
; if (argmax f (list x-1 ... x-n)) == x-i,
; then (>= (f x-i) (f x-1)), (>= (f x-i) (f x-2)), ...
(check-expect (argmax  add1 NEL1) 7)
(check-expect (argmax2 add1 NEL1) 7)
(check-expect (argmax  posn-x NEL2) (make-posn 3 1))
(check-expect (argmax2 posn-x NEL2) (make-posn 3 1))
(check-expect (argmax  posn-y NEL2) (make-posn 1 5))
(check-expect (argmax2 posn-y NEL2) (make-posn 1 5))

(define (argmax2 f lx)
  (cond [(empty? (rest lx)) (first lx)]
        [else
         (if (>= (f (first  lx))
                 (f (argmax2 f (rest lx))))
             (first lx)
             (argmax2 f (rest lx)))]))

; argmin: Finds the (first) element of the list that minimizes the output of the function.


(define-struct address [first-name last-name street])
; An Addr is a structure:
;   (make-address String String String)
; interpretation associates an address with a person's name

; [List-of Addr] -> String
; creates a string from first names,
; sorted in alphabetical order,
; separated and surrounded by blank spaces
(define (listing l)
  (foldr string-append-with-space " "
         (sort (map address-first-name l) string<?)))

; String String -> String
; appends two strings, prefixes with " "
(define (string-append-with-space s t)
  (string-append " " s t))

(define ex0 (list (make-address "Robert"  "Findler" "South")
                  (make-address "Matthew" "Flatt"   "Canyon")
                  (make-address "Shriram" "Krishna" "Yellow")))

(check-expect (listing ex0) " Matthew Robert Shriram ")


;; Exercise 257


;; =================
;; Functions:

; [X Y] [X Y -> Y] Y [List-of X] -> Y
; f*oldl works just like foldl
(check-expect (f*oldl cons '() '(a b c)) (foldl cons '() '(a b c)))
(check-expect (f*oldl / 1 '(6 3 2))      (foldl / 1 '(6 3 2)))

(define (f*oldl f e l)
  (foldr f e (reverse l)))

; Natural [Natural -> X] -> [List-of X]
; build-l*st works just like build-list
(check-expect (build-l*st 0 add1) (build-list 0 add1))
(check-expect (build-l*st 5 add1) (build-list 5 add1))

(define (build-l*st n f)
  (cond [(zero? n) '()]
        [else
         (append (build-l*st (sub1 n) f)
                 (list (f (sub1 n))))]))
