;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-174) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 174

(require 2htdp/batch-io)

; A Los is one of:
; - '()
; - (cons String Los)
; interpretation a list of Strings, each is a String

; A LLS is one of: 
; - '()
; - (cons Los LLS)
; interpretation a list of lines, each is a list of Strings


; LLS -> LLS
; encodes text files numerically
(define (encode lls)
  (cond [(empty? lls) '()]
        [else (cons (encode-lines (first lls))
                    (encode (rest lls)))]))

; Los -> Los
; encodes list of Strings numerically
(define (encode-lines los)
  (cond [(empty? los) '()]
        [else (cons (encode-letters (explode (first los)))
                    (encode-lines (rest los)))]))

; Los -> String
; encodes String numerically
(define (encode-letters s)
  (cond [(empty? s) ""]
        [else (string-append (encode-letter (first s))
                             (encode-letters (rest s)))]))

; 1String -> String
; converts the given 1String to a 3-letter numeric String
(check-expect (encode-letter "z")  (code1 "z"))
(check-expect (encode-letter "\t") (string-append "00" (code1 "\t")))
(check-expect (encode-letter "a")  (string-append "0" (code1 "a")))

(define (encode-letter s)
  (cond [(>= (string->int s) 100) (code1 s)]
        [(< (string->int s) 10)   (string-append "00" (code1 s))]
        [(< (string->int s) 100)  (string-append "0" (code1 s))]))

; 1String -> String
; convert the given 1String into a String
(check-expect (code1 "z") "122")

(define (code1 c)
  (number->string (string->int c)))


; Test drive
(encode (read-words/line "ttt.txt"))
