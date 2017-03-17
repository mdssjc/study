;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-141) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 141

; List-of-string -> String
; concatenate all strings in l into one long string
(check-expect (cat '()) "")
(check-expect (cat (cons "a" (cons "b" '()))) "ab")
(check-expect (cat (cons "ab" (cons "cd" (cons "ef" '())))) "abcdef")
 
(define (cat l)
  (cond [(empty? l) ""]
        [else (string-append (first l) (cat (rest l)))]))


(cat (cons "a" '()))
(cond [(empty? (cons "a" '())) ""]
      [else (string-append (first (cons "a" '())) (cat (rest (cons "a" '()))))])
(cond [#false ""]
      [else (string-append (first (cons "a" '())) (cat (rest (cons "a" '()))))])
(cond [else (string-append (first (cons "a" '())) (cat (rest (cons "a" '()))))])
(string-append (first (cons "a" '())) (cat (rest (cons "a" '()))))
(string-append "a" (cat (rest (cons "a" '()))))
(string-append "a" (cat '()))
(string-append "a" (cond [(empty? '()) ""]
                         [else (string-append (first '()) (cat (rest '())))]))
(string-append "a" (cond [#true ""]
                         [else (string-append (first '()) (cat (rest '())))]))
(string-append "a" "")
"a"
