;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-189) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 189

; Number List-of-numbers -> Boolean
(define (search n alon)
  (cond [(empty? alon) #false]
        [else (or (= (first alon) n)
                  (search n (rest alon)))]))

; Number List-of-numbers -> Boolean
; determines whether a number n occurs in a sorted list of numbers l
(check-expect (search-sorted 0 (list 1 2 3 4 5)) #false)
(check-expect (search-sorted 1 (list 1 2 3 4 5)) #true)
(check-expect (search-sorted 5 (list 1 2 3 4 5)) #true)
(check-expect (search-sorted 6 (list 1 2 3 4 5)) #false)

(define (search-sorted n l)
  (search n l))
