;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-82) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 82

(define-struct word-3 (l1 l2 l3))
; Word-3 is a structure:
;  (make-word-3 String String String)
; interpretation l1 is a lower-case letter
;                l2 is a lower-case letter
;                l3 is a lower-case letter
; Each letter is represented by "a" through "z" plus #false


; Word-3 Word-3 -> Word-3
; produces a word that indicates where the given ones agree and disagree
(check-expect (compare-word (make-word-3 "a" "b" "c")
                            (make-word-3 "a" "b" "d"))
              (make-word-3 "a" "b" #false))

(define (compare-word w1 w2)
  (make-word-3 (res (word-3-l1 w1) (word-3-l1 w2))
               (res (word-3-l2 w1) (word-3-l2 w2))
               (res (word-3-l3 w1) (word-3-l3 w2))))

; String String -> String/Boolean
; helper function to compare-word
(check-expect (res "a" "a") "a")
(check-expect (res "a" "b") #false)
(check-expect (res "a" #false) #false)
(check-expect (res #false "a") #false)

(define (res w1 w2)
  (cond [(and (string? w1)
              (string? w2)
              (string=? w1 w2)) w1]
        [else #false]))
