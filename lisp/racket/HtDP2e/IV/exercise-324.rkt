;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-324) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 324


;; ====================
;; Data definitions:

(define-struct no-info [])
(define NONE (make-no-info))
 
(define-struct node [ssn name left right])
; A BinaryTree (short for BT) is one of:
; - NONE
; - (make-node Number Symbol BT BT)

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

(define TB (make-node 63 'a
                      (make-node 29 'b
                                 (make-node 15 'c
                                            (make-node 87 'd NONE NONE)
                                            (make-node 24 'e NONE NONE))
                                 NONE)
                      (make-node 89 'f
                                 (make-node 33 'g NONE NONE)
                                 (make-node 95 'h NONE
                                            (make-node 99 'i NONE NONE)))))


;; ====================
;; Functions:

; BinaryTree -> [List-of Number]
; produces the sequence of all the ssn numbers in the tree as they show up
; from left to right when looking at a tree drawing
(check-expect (inorder TA) (list 10 15 24 29 63 77 89 95 99))
(check-expect (inorder TB) (list 87 15 24 29 63 33 89 95 99))

(define (inorder bt)
  (cond [(no-info? bt) empty]
        [else
         (append (inorder (node-left bt))
                 (list (node-ssn bt))
                 (inorder (node-right bt)))]))
