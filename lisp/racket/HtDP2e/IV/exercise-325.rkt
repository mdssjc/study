;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-325) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 325


;; ====================
;; Data definitions:

(define-struct no-info [])
(define NONE (make-no-info))
 
(define-struct node [ssn name left right])
; A BinaryTree (short for BT) is one of:
; - NONE
; - (make-node Number Symbol BT BT)

; A BST (short for binary search tree) is a BT:
; The BST Invariant:
;  - NONE is always a BST
;  - (make-node ssn0 name0 L R) is a BST if
;      L is a BST,
;      R is a BST,
;      all ssn fields in L are smaller than ssn0,
;      all ssn fields in R are larger than ssn0

(define TA (make-node 63 'a
                      (make-node 29 'b
                                 (make-node 15 'c
                                            (make-node 10 'd NONE NONE)
                                            (make-node 24 'e NONE NONE))
                                 NONE)
                      (make-node 89 'f
                                 (make-node 77 'g NONE NONE)
                                 (make-node 95 'h NONE
                                            (make-node 99 'i NONE NONE)))))


;; ====================
;; Functions:

; Number BST -> Symbol or NONE
; produces the value of the name field in that node
; otherwise, the function produces NONE
; Invariant: rules for BST
(check-expect (search-bst 65 TA) NONE)
(check-expect (search-bst 63 TA) 'a)
(check-expect (search-bst 29 TA) 'b)
(check-expect (search-bst 24 TA) 'e)
(check-expect (search-bst 89 TA) 'f)
(check-expect (search-bst 99 TA) 'i)

(define (search-bst n bst)
  (cond [(no-info? bst) NONE]
        [else
         (cond [(= n (node-ssn bst)) (node-name bst)]
               [(< n (node-ssn bst)) (search-bst n (node-left bst))]
               [else
                (search-bst n (node-right bst))])]))
