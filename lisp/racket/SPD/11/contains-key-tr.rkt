;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname contains-key-tr-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; bt-contains-tr.rkt
;; Accumulators P12 - Contains Key Tail Recursive
;; Design a tail-recursive function that determines whether a binary
;; tree contains a given key.


;; Problem:
;;
;; Starting with the following data definition for a binary tree (not
;; a binary search tree) design a tail-recursive function called
;; contains? that consumes a key and a binary tree and produces true
;; if the tree contains the key.

(define-struct node (k v l r))
;; BT is one of:
;;  - false
;;  - (make-node Integer String BT BT)
;; Interp. A binary tree, each node has a key, value and 2 children
(define BT1 false)
(define BT2 (make-node 1 "a"
                       (make-node 6 "f"
                                  (make-node 4 "d" false false)
                                  false)
                       (make-node 7 "g" false false)))


;; Integer BT -> Boolean
;; produces true if the tree contains the key
(check-expect (contains? 2 BT1) false)
(check-expect (contains? 2 BT2) false)
(check-expect (contains? 1 BT2) true)
(check-expect (contains? 6 BT2) true)
(check-expect (contains? 4 BT2) true)
(check-expect (contains? 7 BT2) true)

;(define (contains? k bt) false) ; Stub

(define (contains? k bt)
  (local [(define (contains/one? bt todo)
            (cond [(false? bt) (contains/list? todo)]
                  [else
                   (if (= (node-k bt) k)
                       true
                       (contains/list? (cons (node-l bt)
                                             (cons (node-r bt)
                                                   todo))))]))
          (define (contains/list? todo)
            (cond [(empty? todo) false]
                  [else
                   (contains/one? (first todo) (rest todo))]))]
    (contains/one? bt empty)))
