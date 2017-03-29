;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-172) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 172

(require 2htdp/batch-io)

; A Los is one of:
; - '()
; - (cons String Los)
; interpretation a list of Strings, each is a String
(define line0 (cons "hello" (cons "world" '())))
(define line1 '())

; A LLS is one of: 
; - '()
; - (cons Los LLS)
; interpretation a list of lines, each is a list of Strings
(define lls0 '())
(define lls1 (cons line0 (cons line1 '())))
(define lls2 (cons line0 (cons line1 (cons line0 '()))))
(define lls3 (cons line0 (cons line0 (cons line0 '()))))


; LLS -> String
; converts a list of lines into a string
; the strings should be separated by blank spaces (" ")
; the lines should be separated with a newline ("\n")
(check-expect (collapse lls0) "")
(check-expect (collapse lls1) "hello world\n")
(check-expect (collapse lls2) "hello world\n\nhello world")
(check-expect (collapse lls3) "hello world\nhello world\nhello world")

(define (collapse lls)
  (cond [(empty? lls) ""]
        [else (string-append (collapse-line (first lls))
                             (if (empty? (rest lls)) "" "\n")
                             (collapse (rest lls)))]))

; Los -> String
; converts a list of String into a string separated by blank spaces (" ")
(check-expect (collapse-line line0) "hello world")
(check-expect (collapse-line line1) "")

(define (collapse-line los)
  (cond [(empty? los) ""]
        [else (string-append (first los)
                             (if (empty? (rest los)) "" " ")
                             (collapse-line (rest los)))]))


; Test drive
(write-file "ttt.dat"
            (collapse (read-words/line "ttt.txt")))
