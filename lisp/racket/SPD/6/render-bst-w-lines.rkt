;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname render-bst-w-lines) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; render-bst-w-lines.rkt
;; BST P6 - Render BST With Lines

(require 2htdp/image)


;; PROBLEM:
;;
;; Given the following data definition for a binary search tree,
;; design a function that consumes a bst and produces a SIMPLE
;; rendering of that bst including lines between nodes and their
;; subnodes.
;;
;; To help you get started, we've added some sketches below of
;; one way you could include lines to a bst.

;; Constants

(define TEXT-SIZE  14)
(define TEXT-COLOR "BLACK")
(define KEY-VAL-SEPARATOR ":")
(define LINE-COLOR "BLACK")
(define VSPACE (rectangle  1 10 "solid" "white"))
(define HSPACE (rectangle 10  1 "solid" "white"))
(define MTTREE (rectangle 20  1 "solid" "white"))


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
;;               10:why
;;      /                   \
;;    3:ilk                42:ily
;;   /     \              /      \
;; 1:abc   4:dcj       27:wit   50:dug
;;           \          /
;;           7:ruf   14:olp
(define BST0 false)
(define BST1 (make-node 1 "abc" false false))
(define BST7 (make-node 7 "ruf" false false))
(define BST4 (make-node 4 "dcj" false (make-node 7 "ruf" false false)))
(define BST3 (make-node 3 "ilk" BST1 BST4))
(define BST42
  (make-node 42 "ily"
             (make-node 27 "wit" (make-node 14 "olp" false false) false)
             (make-node 50 "dug" false false)))
(define BST10
  (make-node 10 "why" BST3 BST42))
(define BST100
  (make-node 100 "large" BST10 false))

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

;; Here is a sketch of one way the lines could work. What
;; this sketch does is allows us to see the structure of
;; the functions pretty clearly. We'll have one helper for
;; the key value image, and one helper to draw the lines.
;; Each of those produces a rectangular image of course.
;;                 [Key Value Image]
;;                        /\
;; Background            /  \  Helper
;; Rectangle            /    \
;;                     /      \
;; [Left Subtree Image]         [Right Subtree Image]
;; <left natural recursion>     <right natural recursion>
;;
;; And here is a sketch of the helper that draws the lines:
;;                   lw + rw
;;                   <------------------------------------->
;;                   (lr + rw) / 2
;;                   <------------------>
;;               / \ +-------------------------------------+
;;                |  |                 ---                 |
;;                |  |              --/   \--              |
;; (lw + rw) / 4  |  |           --/         \--           |
;;                |  |        --/               \--        |
;;                |  |      -/                     \-      |
;;               \ / +------------------+------------------+
;;                   <------->
;;                   lw / 2
;;                   <----------------------------->
;;                   lw + (rw / 2)
;;
;; where lw means width of left subtree image and
;;       rw means width of right subtree image

;; BST -> Image
;; produces a SIMPLE rendering of that bst including lines between nodes and their subnodes
(check-expect (render-bst BST0) MTTREE)
(check-expect (render-bst BST1) (above (text (string-append "1" KEY-VAL-SEPARATOR "abc")
                                             TEXT-SIZE
                                             TEXT-COLOR)
                                       VSPACE
                                       (draw-lines (render-bst false)
                                                   HSPACE
                                                   (render-bst false))))
(check-expect (render-bst BST7) (above (text (string-append "7" KEY-VAL-SEPARATOR "ruf")
                                             TEXT-SIZE
                                             TEXT-COLOR)
                                       VSPACE
                                       (draw-lines (render-bst false)
                                                   HSPACE
                                                   (render-bst false))))
(check-expect (render-bst BST4) (above (text (string-append "4" KEY-VAL-SEPARATOR "dcj")
                                             TEXT-SIZE
                                             TEXT-COLOR)
                                       VSPACE
                                       (draw-lines (render-bst false)
                                                   HSPACE
                                                   (render-bst BST7))))
(check-expect (render-bst BST3) (above (text (string-append "3" KEY-VAL-SEPARATOR "ilk")
                                             TEXT-SIZE
                                             TEXT-COLOR)
                                       VSPACE
                                       (draw-lines (render-bst BST1)
                                                   HSPACE
                                                   (render-bst BST4))))

;(define (render-bst t) MTTREE) ; Stub

(define (render-bst t)
  (cond [(false? t) MTTREE]
        [else
         (above (text (string-append (number->string (node-key t)) KEY-VAL-SEPARATOR (node-val t))
                      TEXT-SIZE
                      TEXT-COLOR)
                VSPACE
                (draw-lines
                 (render-bst (node-l t))
                 HSPACE
                 (render-bst (node-r t))))]))

;; Image Image -> Image
;; draw the lines between nodes and their subnodes
(define T1 (text "1:abc" TEXT-SIZE TEXT-COLOR))
(define T1W (image-width T1))
(define T2 (text "7:ruf" TEXT-SIZE TEXT-COLOR))
(define T2W (image-width T2))
(define MW (image-width MTTREE))

(check-expect (draw-lines MTTREE HSPACE MTTREE) MTTREE)
(check-expect (draw-lines T1 HSPACE MTTREE)
              (above (place-image
                      (line (/ T1W -2) (/ (+ T1W MW) 4) LINE-COLOR)
                      (/ (+ T1W MW) 2) 0
                      (place-image
                       MTTREE
                       (/ (+ T1W MW) 2) 0
                       (rectangle (+ T1W MW) (/ (+ T1W MW) 4) "solid" "white")))
                     (beside T1 HSPACE MTTREE)))
(check-expect (draw-lines MTTREE HSPACE T2)
              (above (place-image
                      MTTREE
                      (/ (+ T1W MW) 2) 0
                      (place-image
                       (line (+ (/ T2W 2) MW) (/ (+ MW T2W) 4) LINE-COLOR)
                       (/ (+ MW T2W) 2) 0
                       (rectangle (+ MW T2W) (/ (+ MW T2W) 4) "solid" "white")))
                     (beside MTTREE HSPACE T2)))
(check-expect (draw-lines T1 HSPACE T2)
              (above (place-image
                      (line (/ T1W -2) (/ (+ T1W T2W) 4) LINE-COLOR)
                      (/ (+ T1W T2W) 2) 0
                      (place-image
                       (line (+ (/ T2W 2) T1W) (/ (+ T1W T2W) 4) LINE-COLOR)
                       (/ (+ T1W T2W) 2) 0
                       (rectangle (+ T1W T2W) (/ (+ T1W T2W) 4) "solid" "white")))
                     (beside T1 HSPACE T2)))

;(define (draw-lines l s r) MTTREE) ; Stub

(define (draw-lines l s r)
  (cond [(and (eq? l MTTREE) (eq? r MTTREE)) MTTREE]
        [else
         (above (place-image
                 (if (eq? l MTTREE)
                     MTTREE
                     (line (/ (image-width l) -2) (total-height l r) LINE-COLOR))
                 (middle-width l r) 0
                 (place-image
                  (if (eq? r MTTREE)
                      MTTREE
                      (line (+ (/ (image-width r) 2) (image-width l))
                            (total-height l r)
                            LINE-COLOR))
                  (middle-width l r) 0
                  (rectangle (+ (image-width l) (image-width r))
                             (total-height l r)
                             "solid" "white")))
                (beside l s r))]))

;; Image Image -> Number
;; calculate the total height of images 1 and 2
(check-expect (total-height T1 T2)
              (/ (+ (image-width T1) (image-width T2)) 4))

;(define (total-height l r) 0) ; Stub

(define (total-height l r)
  (/ (+ (image-width l) (image-width r)) 4))

;; Image Image -> Number
;; calculate the middle width of images 1 and 2
(check-expect (middle-width T1 T2)
              (/ (+ (image-width T1) (image-width T2)) 2))

;(define (middle-width l r) 0) ; Stub

(define (middle-width l r)
  (/ (+ (image-width l) (image-width r)) 2))
