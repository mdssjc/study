;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname |14-Similarities Everywhere|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 14-Similarities Everywhere.rkt
;; III - Abstraction
;; 14  - Similarities Everywhere



;; 14.1 - Similarities in Functions


;; =================
;; Functions:

; Los -> Boolean
; does l contain "dog"
#;
(define (contains-dog? l)
  (cond [(empty? l) #false]
        [else
         (or (string=? (first l) "dog")
             (contains-dog? (rest l)))]))
(define (contains-dog? l)
  (contains? "dog" l))

; Los -> Boolean
; does l contain "cat"
#;
(define (contains-cat? l)
  (cond [(empty? l) #false]
        [else
         (or (string=? (first l) "cat")
             (contains-cat? (rest l)))]))
(define (contains-cat? l)
  (contains? "cat" l))

; String Los -> Boolean
; determines whether l contains the string s
(define (contains? s l)
  (cond [(empty? l) #false]
        [else
         (or (string=? (first l) s)
             (contains? s (rest l)))]))

;; Exercise 235


;; =================
;; Constants:

(define LH  '("car" "atom" "basic" "zoo"))
(define LNH '("rac" "mota" "cisab" "ooz"))


;; =================
;; Functions:

; Los -> Boolean
; checks if l contains the string atom
(check-expect (contains-atom? LH)  #true)
(check-expect (contains-atom? LNH) #false)

(define (contains-atom? l)
  (contains? "atom" l))

; Los -> Boolean
; checks if l contains the string basic
(check-expect (contains-basic? LH)  #true)
(check-expect (contains-basic? LNH) #false)

(define (contains-basic? l)
  (contains? "basic" l))

; Los -> Boolean
; checks if l contains the string zoo
(check-expect (contains-zoo? LH)  #true)
(check-expect (contains-zoo? LNH) #false)

(define (contains-zoo? l)
  (contains? "zoo" l))

;; Exercise 236


;; =================
;; Constants:

(define L1 '(0))
(define L2 '(1 2 3 4 5))


;; =================
;; Functions:

; Lon -> Lon
; add 1 to each item on l
(check-expect (add1* '()) '())
(check-expect (add1* L1)  '(1))
(check-expect (add1* L2)  '(2 3 4 5 6))

#;
(define (add1* l)
  (cond [(empty? l) '()]
        [else
         (cons (add1  (first l))
               (add1* (rest  l)))]))
(define (add1* l)
  (addn 1 l))

; Lon -> Lon
; adds 5 to each item on l
(check-expect (plus5 '()) '())
(check-expect (plus5 L1)  '(5))
(check-expect (plus5 L2)  '(6 7 8 9 10))

#;
(define (plus5 l)
  (cond [(empty? l) '()]
        [else
         (cons (+ (first l) 5)
               (plus5 (rest l)))]))
(define (plus5 l)
  (addn 5 l))

; Lon -> Lon
; subs 2 to each item on l
(check-expect (sub2 '()) '())
(check-expect (sub2 L1)  '(-2))
(check-expect (sub2 L2)  '(-1 0 1 2 3))

#;
(define (sub2 l)
  (cond [(empty? l) '()]
        [else
         (cons (- (first l) 2)
               (sub2 (rest l)))]))
(define (sub2 l)
  (addn -2 l))

; Number Lon -> Lon
; adds n to each item on l
(define (addn n l)
  (cond [(empty? l) '()]
        [else
         (cons (+ (first l) n)
               (addn n (rest l)))]))



;; 14.2 - Different Similarities


;; =================
;; Functions:

; Lon Number -> Lon
; select those numbers on l
; that are below t
(define (small l t)
  (cond [(empty? l) '()]
        [else
         (cond [(< (first l) t)
                (cons (first l)
                      (small (rest l) t))]
               [else
                (small (rest l) t)])]))
(define (small-1 l t)
  (extract < l t))

; Lon Number -> Lon
; select those numbers on l
; that are above t
(define (large l t)
  (cond [(empty? l) '()]
        [else
         (cond [(> (first l) t)
                (cons (first l)
                      (large (rest l) t))]
               [else
                (large (rest l) t)])]))
(define (large-1 l t)
  (extract > l t))

; [Number Number -> Boolean] Lon Number -> Lon
; select those numbers on l
; that are according to R in t
(check-expect (extract < '() 5)      (small '() 5))
(check-expect (extract < '(3) 5)     (small '(3) 5))
(check-expect (extract < '(1 6 4) 5) (small '(1 6 4) 5))

(define (extract R l t)
  (cond [(empty? l) '()]
        [else
         (cond [(R (first l) t)
                (cons (first l)
                      (extract R (rest l) t))]
               [else
                (extract R (rest l) t)])]))

; Number Number -> Boolean
; is the area of a square with side x larger than c
(define (squared>? x c)
  (> (* x x) c))


(check-expect (extract squared>? '(3 4 5) 10) '(4 5))

;; Exercise 237

(check-expect (squared>? 3 10) #false)
(check-expect (squared>? 4 10) #true)
(check-expect (squared>? 5 10) #true)

;; Exercise 238


;; =================
;; Constants:

(define L3 (list 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1))
(define L4 (list 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25))


;; =================
;; Functions:

; Nelon -> Number
; determines the smallest
; number on l
#;
(define (inf l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (if (< (first l)
                (inf (rest l)))
             (first l)
             (inf (rest l)))]))

(define (inf l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (min (first l)
              (inf (rest l)))]))

; Nelon -> Number
; determines the largest
; number on l
#;
(define (sup l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (if (> (first l)
                (sup (rest l)))
             (first l)
             (sup (rest l)))]))

(define (sup l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (max (first l)
              (sup (rest l)))]))

; Nelon -> Number
; determines a number in l with R
(define (extract.v2 R l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (if (R (first l)
                (extract.v2 R (rest l)))
             (first l)
             (extract.v2 R (rest l)))]))

(define (extract.v3 R l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (R (first l)
            (extract.v3 R (rest l)))]))

; Nelon -> Number
; determines the smallest number on l
; (check-expect (inf-1 L3) (inf L3))

(define (inf-1 l)
  (extract.v2 < l))

(check-expect (inf-2 L3) (inf L3))

(define (inf-2 l)
  (extract.v3 min l))

; Nelon -> Number
; determines the largest number on l
;(check-expect (sup-1 L4) (sup L4))

(define (sup-1 l)
  (extract.v2 > l))

(check-expect (sup-2 L4) (sup L4))

(define (sup-2 l)
  (extract.v3 max l))
