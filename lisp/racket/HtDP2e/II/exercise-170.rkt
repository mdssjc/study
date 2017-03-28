;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-170) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 170

(define-struct phone [area switch four])
; A Phone is a structure: 
;   (make-phone Three Three Four)
; A Three is a Number between 100 and 999. 
; A Four is a Number between 1000 and 9999.
(define P1 (make-phone 713 123 4567))
(define P2 (make-phone 281 123 4567))
(define P3 (make-phone 123 123 4567))

; Lop is one of:
; - '()
; - (cons Phone Lop)
; interpretation an instance of Lop represents a Phone list


; Lop -> Lop
; consumes a list of Phones and produces one,
; it replaces all occurrence of area code 713 with 281
(check-expect (replace '()) '())
(check-expect (replace (cons P1 (cons P3 '()))) (cons P2 (cons P3 '())))

(define (replace lop)
  (cond [(empty? lop) '()]
        [else (cons (cond [(= (phone-area (first lop)) 713)
                           (make-phone 281 (phone-switch (first lop)) (phone-four (first lop)))]
                          [else (first lop)])
                    (replace (rest lop)))]))
