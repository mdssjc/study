;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname |14-Similarities Everywhere|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
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
