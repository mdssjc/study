;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname insert) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; insert.rkt
;; BST P4 - Insert


;; PROBLEM:
;;
;; Design a function that consumes an Integer, String and BST, and adds a node
;; that has the given key and value to the tree. The node should be inserted in
;; the proper place in the tree. The function can assume there is not already
;; an entry for that number in the tree. The function should produce the new BST.
;;
;; Do not worry about keeping the tree balanced. We will come back to this later.

;; Data definitions:

(define-struct node (key val l r))
;; A BST (Binary Search Tree) is one of:
;;  - false
;;  - (make-node Integer String BST BST)
;; interp. false means no BST, or empty BST
;;         key is the node key
;;         val is the node val
;;         l and r are left and right subtrees
;; INVARIANT: for a given node:
;;     key is > all keys in its l(eft)  child
;;     key is < all keys in its r(ight) child
;;     the same key never appears twice in the tree
(define BST0 false)
(define BST1 (make-node 1 "abc" false false))
(define BST4 (make-node 4 "dcj" false (make-node 7 "ruf" false false)))
(define BST3 (make-node 3 "ilk" BST1 BST4))
(define BST42
  (make-node 42 "ily"
             (make-node 27 "wit" (make-node 14 "olp" false false) false)
             false))
(define BST10 (make-node 10 "why" BST3 BST42))
;;               10:why
;;      /                   \
;;    3:ilk                42:ily
;;   /     \              /
;; 1:abc   4:dcj       27:wit
;;           \          /
;;           7:ruf   14:olp

#;
(define (fn-for-bst t)
  (cond [(false? t) (...)]
        [else
         (... (node-key t)    ;Integer
              (node-val t)    ;String
              (fn-for-bst (node-l t))
              (fn-for-bst (node-r t)))]))

;; Template rules used:
;;  - one of: 2 cases
;;  - atomic-distinct: false
;;  - compound: (make-node Integer String BST BST)
;;  - self reference: (node-l t) has type BST
;;  - self reference: (node-r t) has type BST


;; Functions:

;; Integer String BST -> BST
;; Adds a node that has the given key and value to the tree
(check-expect (insert 1 "abc" BST0) (make-node 1 "abc" false false))
(check-expect (insert 2 "cba" BST1) (make-node 1 "abc" false (make-node 2 "cba" false false)))
(check-expect (insert 0 "cba" BST1) (make-node 1 "abc" (make-node 0 "cba" false false) false))
(check-expect (insert 0 "cba" BST3) (make-node 3 "ilk" (insert 0 "cba" BST1) BST4))
(check-expect (insert 0 "cba" BST42)
              (make-node 42 "ily"
                         (make-node 27 "wit"
                                    (make-node 14 "olp"
                                               (make-node 0 "cba" false false) false) false) false))
(check-expect (insert 0 "cba" BST10) (make-node 10 "why" (insert 0 "cba" BST3) BST42))

;(define (insert k v t) BST1) ; Stub

(define (insert k v t)
  (cond [(false? t) (make-node k v false false)]
        [else
         (make-node (node-key t)
                    (node-val t)
                    (if (< k (node-key t))
                        (insert k v (node-l t))
                        (node-l t))
                    (if (> k (node-key t))
                        (insert k v (node-r t))
                        (node-r t)))]))
