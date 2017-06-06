;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-235) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 235


(define LH  (list "car" "atom" "basic" "zoo"))
(define LNH (list "rac" "mota" "cisab" "ooz"))


; Los -> Boolean
; checks if l contains the string atom
(check-expect (contains-atom? LH) #true)
(check-expect (contains-atom? LNH) #false)

(define (contains-atom? l)
  (contains? "atom" l))

; Los -> Boolean
; checks if l contains the string basic
(check-expect (contains-basic? LH) #true)
(check-expect (contains-basic? LNH) #false)

(define (contains-basic? l)
  (contains? "basic" l))

; Los -> Boolean
; checks if l contains the string zoo
(check-expect (contains-zoo? LH) #true)
(check-expect (contains-zoo? LNH) #false)

(define (contains-zoo? l)
  (contains? "zoo" l))

; String Los -> Boolean
; determines whether l contains the string s
(define (contains? s l)
  (cond [(empty? l) #false]
        [else (or (string=? (first l) s)
                  (contains? s (rest l)))]))
