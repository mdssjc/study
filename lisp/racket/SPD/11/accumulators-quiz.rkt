;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname accumulators-quiz) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; accumulators-quiz.rkt


;; PROBLEM 1:
;;
;; Design a function that consumes a list of strings, and produces the length
;; of the longest word in the list.

;; (listof String) -> Natural
;; produces the length of the longest word in the list
(check-expect (longest-length empty) 0)
(check-expect (longest-length (list "abc" "abcd" "ab")) 4)
(check-expect (longest-length (list "abcdef" "abcd" "ab")) 6)

;(define (longest-length los) 0) ; Stub

(define (longest-length los0)
  (local ((define (longest-length los acc)
            (cond [(empty? los) acc]
                  [else
                   (local ((define len (string-length (first los))))
                     (longest-length (rest los)
                                     (if (> len acc) len acc)))])))
    (longest-length los0 0)))

;; PROBLEM 2:
;;
;; The Fibbonacci Sequence https://en.wikipedia.org/wiki/Fibonacci_number is
;; the sequence 0, 1, 1, 2, 3, 5, 8, 13,... where the nth element is equal to
;; n-2 + n-1.
;;
;; Design a function that given a list of numbers at least two elements long,
;; determines if the list obeys the fibonacci rule, n-2 + n-1 = n, for every
;; element in the list. The sequence does not have to start at zero, so for
;; example, the sequence 4, 5, 9, 14, 23 would follow the rule.

;; (listof Number) -> Boolean
;; determines if the list obeys the fibonacci rule, n-2 + n-1 = n, for every element in the list
(check-expect (fibonacci? (list 1 2 4)) false)
(check-expect (fibonacci? (list 4 5 9 14 23)) true)
(check-expect (fibonacci? (list 0 1 1 2 3 5 8 13)) true)

;(define (fibonacci? lon) false) ; Stub

(define (fibonacci? lon0)
  (local ((define (fibonacci? lon n2 n1)
            (cond [(empty? lon) true]
                  [else
                   (and (= (+ n1 n2) (first lon))
                        (fibonacci? (rest lon) n1 (first lon)))])))
    (fibonacci? (rest (rest lon0)) (first lon0) (first (rest lon0)))))

;; PROBLEM 3:
;;
;; Refactor the function below to make it tail recursive.

;; Natural -> Natural
;; produces the factorial of the given number
(check-expect (fact 0) 1)
(check-expect (fact 3) 6)
(check-expect (fact 5) 120)

#;
(define (fact n)
  (cond [(zero? n) 1]
        [else
         (* n (fact (sub1 n)))]))

(define (fact n)
  (local ((define (fact n acc)
            (cond [(zero? n) acc]
                  [else
                   (fact (sub1 n) (* n acc))])))
    (fact n 1)))

;; PROBLEM 4:
;;
;; Recall the data definition for Region from the Abstraction Quiz. Use a worklist
;; accumulator to design a tail recursive function that counts the number of regions
;; within and including a given region.
;; So (count-regions CANADA) should produce 7

(define-struct region (name type subregions))
;; Region is (make-region String Type (listof Region))
;; interp. a geographical region

;; Type is one of:
;; - "Continent"
;; - "Country"
;; - "Province"
;; - "State"
;; - "City"
;; interp. categories of geographical regions

(define VANCOUVER (make-region "Vancouver" "City" empty))
(define VICTORIA (make-region "Victoria" "City" empty))
(define BC (make-region "British Columbia" "Province" (list VANCOUVER VICTORIA)))
(define CALGARY (make-region "Calgary" "City" empty))
(define EDMONTON (make-region "Edmonton" "City" empty))
(define ALBERTA (make-region "Alberta" "Province" (list CALGARY EDMONTON)))
(define CANADA (make-region "Canada" "Country" (list BC ALBERTA)))

#;
(define (fn-for-region r)
  (local [(define (fn-for-region r)
            (... (region-name r)
                 (fn-for-type (region-type r))
                 (fn-for-lor (region-subregions r))))

          (define (fn-for-type t)
            (cond [(string=? t "Continent") (...)]
                  [(string=? t "Country") (...)]
                  [(string=? t "Province") (...)]
                  [(string=? t "State") (...)]
                  [(string=? t "City") (...)]))

          (define (fn-for-lor lor)
            (cond [(empty? lor) (...)]
                  [else
                   (... (fn-for-region (first lor))
                        (fn-for-lor (rest lor)))]))]
    (fn-for-region r)))

;; Region -> Natural
;; counts the number of regions within and including a given region
(check-expect (count-regions CANADA) 7)

(define (count-regions r)
  (local [(define (count-regions r acc todo)
            (fn-for-lor (if (empty? todo) (+ acc 1) (+ acc 2))
                        (if (empty? todo) (region-subregions r) todo)))
          (define (fn-for-lor acc todo)
            (cond [(empty? todo) acc]
                  [else
                   (count-regions (first todo) acc (rest todo))]))]
    (count-regions r 0 empty)))
