;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-288) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 288


(define (f1 n)
  (map sub1 (build-list n add1)))

(define (f2 n)
  (build-list n add1))

(define (f3 n)
  (map (lambda (n)
         (/ 1 n))
       (build-list n add1)))

(define (f4 n)
  (build-list n (lambda (n)
                  (* n 2))))

(define (f5 n)
  (local ((define (numbers n s)
            (cond [(zero? n) empty]
                  [else
                   (cons (if (= n s) 1 0)
                         (numbers (sub1 n) s))])))
    (build-list n (lambda (i)
                    (numbers n (- n i))))))

(define (tabulate f n)
  (reverse (build-list (add1 n) f)))


; Test drive
(f1 10)
(f2 10)
(f3 10)
(f4 10)
(f5 3)
(tabulate add1 5)
