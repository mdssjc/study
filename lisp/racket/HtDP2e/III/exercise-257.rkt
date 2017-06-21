;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-257) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 257


; [X Y] (X Y -> Y) Y [List-of X] -> Y
; f*oldl works just like foldl
(check-expect (f*oldl cons '() '(a b c)) (foldl cons '() '(a b c)))
(check-expect (f*oldl / 1 '(6 3 2)) (foldl / 1 '(6 3 2)))

(define (f*oldl f e l)
  (foldr f e (reverse l)))

; Natural (Natural -> X) -> [List-of X]
; build-l*st works just like build-list
(check-expect (build-list 0 add1) empty)
(check-expect (build-list 5 add1) (list 1 2 3 4 5))
(check-expect (build-l*st 0 add1) empty)
(check-expect (build-l*st 5 add1) (list 1 2 3 4 5))

(define (build-l*st n f)
  (cond [(zero? n) empty]
        [else
         (append (build-l*st (sub1 n) f)
                 (list (f (sub1 n))))]))
