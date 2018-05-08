;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname |Intermezzo 3|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Intermezzo 3.rkt
;; Intermezzo 3: Scope and Abstraction



;; Scope

(define (f x) (+ (* x x) 25))
(define (g x) (+ (f (+ x 1)) (f (- x 1))))

;; Exercise 300

(define (p1 x y)
  (+ (* x y)
     (+ (* 2 x)
        (+ (* 2 y) 22))))

(define (p2 x)
  (+ (* 55 x) (+ x 11)))

(define (p3 x)
  (+ (p1 x 0)
     (+ (p1 x 1) (p2 x))))

;; Exercise 301

(define (insertion-sort alon)
  (local ((define (sort alon)
            (cond [(empty? alon) '()]
                  [else
                   (add (first alon)
                        (sort (rest alon)))]))
          (define (add an alon)
            (cond [(empty? alon) (list an)]
                  [else
                   (cond [(> an (first alon)) (cons an alon)]
                         [else
                          (cons (first alon)
                                (add an (rest alon)))])])))
    (sort alon)))

(define (sort2 alon)
  (local ((define (sort alon)
            (cond [(empty? alon) '()]
                  [else
                   (add (first alon)
                        (sort (rest alon)))]))
          (define (add an alon)
            (cond [(empty? alon) (list an)]
                  [else
                   (cond [(> an (first alon)) (cons an alon)]
                         [else
                          (cons (first alon)
                                (add an (rest alon)))])])))
    (sort alon)))

;; Exercise 302

; x is used here before its definition
;(define x (cons 1 x))

;; Exercise 303

(lambda (x y)
  (+ x (* x y)))

(lambda (x y)
  (+ x
     (local ((define x (* y y)))
       (+ (* 3 x)
          (/ 1 x)))))

(lambda (x y)
  (+ x
     ((lambda (x)
        (+ (* 3 x)
           (/ 1 x)))
      (* y y))))
