;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-327) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 327


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

; BST Number Symbol -> BST
; produces a BST that in place of one NONE subtree contains the node structure
(check-expect (create-bst TA 9 'j)
              (make-node 63 'a
                         (make-node 29 'b
                                    (make-node 15 'c
                                               (make-node 10 'd
                                                          (make-node 9 'j NONE NONE)
                                                          NONE)
                                               (make-node 24 'e NONE NONE))
                                    NONE)
                         (make-node 89 'f
                                    (make-node 77 'g NONE NONE)
                                    (make-node 95 'h NONE
                                               (make-node 99 'i NONE NONE)))))
(check-expect (create-bst TA 30 'j)
              (make-node 63 'a
                         (make-node 29 'b
                                    (make-node 15 'c
                                               (make-node 10 'd NONE NONE)
                                               (make-node 24 'e NONE NONE))
                                    (make-node 30 'j NONE NONE))
                         (make-node 89 'f
                                    (make-node 77 'g NONE NONE)
                                    (make-node 95 'h NONE
                                               (make-node 99 'i NONE NONE)))))
(check-expect (create-bst TA 80 'j)
              (make-node 63 'a
                         (make-node 29 'b
                                    (make-node 15 'c
                                               (make-node 10 'd NONE NONE)
                                               (make-node 24 'e NONE NONE))
                                    NONE)
                         (make-node 89 'f
                                    (make-node 77 'g
                                               NONE
                                               (make-node 80 'j NONE NONE))
                                    (make-node 95 'h NONE
                                               (make-node 99 'i NONE NONE)))))
(check-expect (create-bst TA 94 'j)
              (make-node 63 'a
                         (make-node 29 'b
                                    (make-node 15 'c
                                               (make-node 10 'd NONE NONE)
                                               (make-node 24 'e NONE NONE))
                                    NONE)
                         (make-node 89 'f
                                    (make-node 77 'g NONE NONE)
                                    (make-node 95 'h
                                               (make-node 94 'j NONE NONE)
                                               (make-node 99 'i NONE NONE)))))

(define (create-bst bst n s)
  (cond [(no-info? bst) (make-node n s NONE NONE)]
        [(< n (node-ssn bst))
         (make-node (node-ssn bst)
                    (node-name bst)
                    (create-bst (node-left bst) n s)
                    (node-right bst))]
        [else
         (make-node (node-ssn bst)
                    (node-name bst)
                    (node-left bst)
                    (create-bst (node-right bst) n s))]))

; [List-of [List Number Symbol]] -> BST
; produces a binary search tree by repeatedly applying create-bst
(check-expect (create-bst-from-list '((99 i)(77 g)(24 e)(10 d)(95 h)(15 c)(89 f)(29 b)(63 a))) TA)

(define (create-bst-from-list llon)
  (cond [(empty? llon) NONE]
        [else
         (local ((define pair (first llon)))
           (create-bst (create-bst-from-list (rest llon))
                       (first  pair)
                       (second pair)))]))
