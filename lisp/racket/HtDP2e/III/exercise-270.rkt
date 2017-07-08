;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-270) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 270


(define (f1 n)
  (map sub1 (build-list n add1)))

(define (f2 n)
  (build-list n add1))

(define (f3 n)
  (local ((define (reciprocal n)
            (/ 1 n)))
    (map reciprocal (build-list n add1))))

(define (f4 n)
  (local ((define (doubles n)
            (* n 2)))
    (build-list n doubles)))

(define (f5 n)
  (local ((define (identityM i)
            (numbers n (- n i)))
          (define (numbers n s)
            (cond [(zero? n) empty]
                  [else
                   (cons (if (= n s) 1 0)
                         (numbers (sub1 n) s))])))
    (build-list n identityM)))

(define (tabulate f n)
  (reverse (build-list (add1 n) f)))


; Test drive
(f1 10)
(f2 10)
(f3 10)
(f4 10)
(f5 3)
(tabulate add1 5)
