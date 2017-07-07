;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname hp-family-tree) (read-case-sensitive #t) (teachpacks ((lib "batch-io.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "batch-io.rkt" "teachpack" "2htdp")) #f)))
;; hp-family-tree.rkt
;; Mutual Reference P3 - HP Family Tree
;; Represent information about descendant family trees from Harry
;; Potter and design functions that operate on them.


;; In this problem set you will represent information about descendant family
;; trees from Harry Potter and design functions that operate on those trees.
;;
;; To make your task much easier we suggest two things:
;;   - you only need a DESCENDANT family tree
;;   - read through this entire problem set carefully to see what information
;;     the functions below are going to need. Design your data definitions to
;;     only represent that information.
;;   - you can find all the information you need by looking at the individual
;;     character pages like the one we point you to for Arthur Weasley.

;; PROBLEM 1:
;;
;; Design a data definition that represents a family tree from the
;; Harry Potter wiki, which contains all necessary information for the
;; other problems. You will use this data definition throughout the
;; rest of the homework.
(define-struct family (name patronus wand descendant))
;; Family is (make-family String String String ListofFamily)
;; interp. a family is represented by name, patronus, wand and yours descendants
;; ListofFamily is one of:
;; - empty
;; - (cons Family ListofFamily)
;; interp. a list with the descendants

#;
(define (fn-for-f f)
  (... (family-name f)
       (family-patronus f)
       (family-wand f)
       (fn-for-lof (family-descendant f))))

#;
(define (fn-for-lof lof)
  (cond [(empty? lof) (...)]
        [else
         (... (fn-for-f (first lof))
              (fn-for-lof (rest lof)))]))

;; PROBLEM 2:
;;
;; Define a constant named ARTHUR that represents the descendant family tree for
;; Arthur Weasley. You can find all the infomation you need by starting
;; at: http://harrypotter.wikia.com/wiki/Arthur_Weasley.
;;
;; You must include all of Arthur's children and these grandchildren: Lily,
;; Victoire, Albus, James.
;;
;;
;; Note that on the Potter wiki you will find a lot of information. But for some
;; people some of the information may be missing. Enter that information with a
;; special value of "" (the empty string) meaning it is not present. Don't forget
;; this special value when writing your interp.
(define F1 (make-family "Victoire" "Bill" "" empty))
(define F2 (make-family "Bill" "Arthur" "Unknown" (list F1)))
(define F3 (make-family "Charlie" "Arthur" "Unknown" empty))
(define F4 (make-family "Percy" "Arthur" "Unknown" empty))
(define F5 (make-family "Fred" "Arthur" "Unknown" empty))
(define F6 (make-family "George" "Arthur" "Unknown" empty))
(define F7 (make-family "Ron" "Arthur" "AWC" empty))
(define F8 (make-family "James" "Ginny" "" empty))
(define F9 (make-family "Albus" "Ginny" "Unknown" empty))
(define F10 (make-family "Lily" "Ginny" "" empty))
(define LOF1 (list F8 F9 F10))
(define F11 (make-family "Ginny" "Arthur" "Unknown" LOF1))
(define LOF2 (list F2 F3 F4 F5 F6 F7 F11))
(define ARTHUR (make-family "Arthur" "Stag" "Unknown" LOF2))

;; PROBLEM 3:
;;
;; Design a function that produces a pair list (i.e. list of two-element lists)
;; of every person in the tree and his or her patronus. For example, assuming
;; that HARRY is a tree representing Harry Potter and that he has no children
;; (even though we know he does) the result would be: (list (list "Harry" "Stag")).
;;
;; You must use ARTHUR as one of your examples.
;; Family -> Listof Listof String
;; ListofFamily -> Listof Listof String
;; produces a pair list (i.e. list of two-element lists) of every person in the tree and his or her patronus
(check-expect (pair--family F1) (list (list "Victoire" "Bill")))
(check-expect (pair--lof empty) empty)
(check-expect (pair--family F11) (list (list "Ginny" "Arthur")
                                       (list "James" "Ginny")
                                       (list "Albus" "Ginny")
                                       (list "Lily" "Ginny")))
(check-expect (pair--lof LOF1) (list (list "James" "Ginny")
                                     (list "Albus" "Ginny")
                                     (list "Lily" "Ginny")))
(check-expect (pair--family ARTHUR) (append (list (list "Arthur" "Stag")
                                                  (list "Bill" "Arthur")
                                                  (list "Victoire" "Bill")
                                                  (list "Charlie" "Arthur")
                                                  (list "Percy" "Arthur")
                                                  (list "Fred" "Arthur")
                                                  (list "George" "Arthur")
                                                  (list "Ron" "Arthur"))
                                            (pair--family F11)))

;(define (pair--family f) empty) ; Stubs
;(define (pair--lof lof) empty)

(define (pair--family f)
  (cons (list (family-name f) (family-patronus f))
        (pair--lof (family-descendant f))))

(define (pair--lof lof)
  (cond [(empty? lof) empty]
        [else
         (append (pair--family (first lof))
                 (pair--lof (rest lof)))]))

;; PROBLEM 4:
;;
;; Design a function that produces the names of all descendants of a given person
;; whose wands are made of a given material.
;;
;; You must use ARTHUR as one of your examples.
