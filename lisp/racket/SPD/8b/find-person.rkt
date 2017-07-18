;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname find-person) (read-case-sensitive #t) (teachpacks ((lib "itunes.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "itunes.rkt" "teachpack" "2htdp")) #f)))
;; find-person.rkt


;; The following program implements an arbitrary-arity descendant family
;; tree in which each person can have any number of children.
;;
;; PROBLEM A:
;;
;; Decorate the type comments with reference arrows and establish a clear
;; correspondence between template function calls in the templates and
;; arrows in the type comments.

;; Data definitions:

(define-struct person (name age kids))
;; Person is (make-person String Natural ListOfPerson)
;; interp. A person, with first name, age and their children
(define P1 (make-person "N1" 5 empty))
(define P2 (make-person "N2" 25 (list P1)))
(define P3 (make-person "N3" 15 empty))
(define P4 (make-person "N4" 45 (list P3 P2)))

#;
(define (fn-for-person p)
  (local ((define (fn-for-person p)
            (... (person-name p)
                 (person-age p)
                 (fn-for-lop (person-kids p))))
          (define (fn-for-lop lop)
            (cond [(empty? lop) (...)]
                  [else
                   (... (fn-for-person (first lop))
                        (fn-for-lop (rest lop)))])))
    (fn-for-person p)))

#;
(define (fn-for-person p)
  (... (person-name p)      ;String
       (person-age p)      ;Natural
       (fn-for-lop (person-kids p))))

;; ListOfPerson is one of:
;;  - empty
;;  - (cons Person ListOfPerson)
;; interp. a list of persons

#;
(define (fn-for-lop lop)
  (cond [(empty? lop) (...)]
        [else
         (... (fn-for-person (first lop))
              (fn-for-lop (rest lop)))]))


;; Functions:

;; PROBLEM B:
;;
;; Design a function that consumes a Person and a String. The function
;; should search the entire tree looking for a person with the given
;; name. If found the function should produce the person's age. If not
;; found the function should produce false.

;; Person String -> Integer or false
;; produce the person's age or false
(check-expect (find P1 "N0") false)
(check-expect (find P1 "N1") 5)
(check-expect (find P2 "N1") 5)
(check-expect (find P4 "N1") 5)

;(define (find p s) false) ; Stub

(define (find p s)
  (local ((define (find--person n p)
            (if (string=? (person-name p) n)
                (person-age p)
                (find--lop n (person-kids p))))
          (define (find--lop n lop)
            (cond [(empty? lop) false]
                  [else
                   (local ((define try (find--person n (first lop))))
                     (if (not (false? try))
                         try
                         (find--lop n (rest lop))))])))
    (find--person s p)))
