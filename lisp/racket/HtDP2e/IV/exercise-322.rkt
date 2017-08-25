;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-322) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 322


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

; BinaryTree Number -> Boolean
; determines whether a given number occurs in some given BT
(check-expect (contains-bt? TA 64) #false)
(check-expect (contains-bt? TA 63) #true)
(check-expect (contains-bt? TA 99) #true)
(check-expect (contains-bt? TA 24) #true)

(define (contains-bt? bt n)
  (cond [(no-info? bt) #false]
        [else
         (or (= (node-ssn bt) n)
             (contains-bt? (node-left bt) n)
             (contains-bt? (node-right bt) n))]))
