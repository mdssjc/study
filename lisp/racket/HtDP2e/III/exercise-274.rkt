;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-274) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 274


; ([List-of X] -> [List-of X]) [List-of X] -> [List-of [List-of X]]
; produces the list of all fixes
(check-expect (fixes pre empty) empty)
(check-expect (fixes pre (list "a")) (list (list "a")))
(check-expect (fixes pre (list "a" "b")) (list (list "a" "b") (list "a")))
(check-expect (fixes pre (list "a" "b" "c")) (list (list "a" "b" "c") (list "a" "b") (list "a")))
(check-expect (fixes suf empty) empty)
(check-expect (fixes suf (list "a")) (list (list "a")))
(check-expect (fixes suf (list "a" "b")) (list (list "a" "b") (list "b")))
(check-expect (fixes suf (list "a" "b" "c")) (list (list "a" "b" "c") (list "b" "c") (list "c")))

(define pre (lambda (lst) (reverse (rest (reverse lst)))))
(define suf (lambda (lst) (rest lst)))

(define (fixes f lo1s)
  (cond [(empty? lo1s) '()]
        [else
         (cons lo1s
               (fixes f (f lo1s)))]))
