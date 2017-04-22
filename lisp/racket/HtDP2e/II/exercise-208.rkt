;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-208) (read-case-sensitive #t) (teachpacks ((lib "itunes.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "itunes.rkt" "teachpack" "2htdp")) #f)))
;; Exercise 208

(require 2htdp/itunes)

; An LLists is one of:
; - '()
; - (cons LAssoc LLists)

; An LAssoc is one of: 
; - '()
; - (cons Association LAssoc)
;
; An Association is a list of two items: 
;   (cons String (cons BSDN '()))

; A BSDN is one of: 
; - Boolean
; - Number
; - String
; - Date

(define A1 (list "Assoc A" true))
(define A2 (list "Assoc B" 5))
(define A3 (list "Assoc C" "123ABC"))
(define A4 (list "Assoc D" (create-date 1 2 3 4 5 6)))

(define LA1 (list A1 A2 A3 A4))
(define LA2 (list A4 A3 A2 A1))
(define LA3 '())

(define LL1 (list LA1 LA2))
(define LL2 (list LA1 LA2 LA3))
(define LL3 '())


; LLists -> String
; produces the Strings that are associated with a Boolean attribute
(check-expect (boolean-attributes LL1) "Assoc A Assoc A")
(check-expect (boolean-attributes LL2) "Assoc A Assoc A")
(check-expect (boolean-attributes LL3) "")

(define (boolean-attributes ll)
  (cond [(empty? ll) ""]
        [(empty? (rest ll)) (create-set (delete-non-boolean (first ll)))]
        [else (string-append (create-set (delete-non-boolean (first ll)))
                             (if (> (string-length (create-set (delete-non-boolean (first (rest ll))))) 0)
                                 " " "")
                             (boolean-attributes (rest ll)))]))

; LAssoc -> LAssoc
; deletes the association with BSDN non-Boolean
(check-expect (delete-non-boolean LA1) (list A1))
(check-expect (delete-non-boolean LA2) (list A1))
(check-expect (delete-non-boolean LA3) LA3)

(define (delete-non-boolean la)
  (cond [(empty? la) '()]
        [else (append (if (boolean? (second (first la)))
                          (list (first la))
                          '())
                      (delete-non-boolean (rest la)))]))

; LAssoc -> String
; constructs one that contains every String from the given list
(check-expect (create-set (delete-non-boolean LA1)) "Assoc A")
(check-expect (create-set (delete-non-boolean LA2)) "Assoc A")
(check-expect (create-set (delete-non-boolean (list A1 A2 A1))) "Assoc A Assoc A")
(check-expect (create-set (delete-non-boolean LA3)) "")

(define (create-set la)
  (cond [(empty? la) ""]
        [(empty? (rest la)) (first (first la))]
        [else (string-append (first (first la)) " " (create-set (rest la)))]))
