;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-165) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 165

(require racket/string)

; List-of-strings -> List-of-strings
; consumes a list of toy descriptions (one-word strings) and
; replaces all occurrences of "robot" with "r2d2"
(check-expect (subst-robot '()) '())
(check-expect (subst-robot (cons "robot-1" '())) (cons "r2d2-1" '()))
(check-expect (subst-robot (cons "robot-1" (cons ">>robot<<" '())))
              (cons "r2d2-1" (cons ">>r2d2<<" '())))

(define (subst-robot los)
  (substitute "r2d2" "robot" los))

; String String List-of-strings -> List-of-strings
; replaces all occurrences of new with old in the List-of-strings
(define (substitute new old los)
  (cond [(empty? los) '()]
        [else (cons (string-replace (first los) old new)
                    (substitute new old (rest los)))]))
