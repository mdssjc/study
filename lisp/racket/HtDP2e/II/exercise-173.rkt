;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-173) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 173

(require 2htdp/batch-io)
(require racket/string)

; A Los is one of:
; - '()
; - (cons String Los)
; interpretation a list of Strings, each is a String
(define line0 '())
(define line1 (cons "the" (cons "car" '())))
(define line2 (cons "an" (cons "apple" '())))
(define line3 (cons "a" (cons "kite" '())))
(define line4 (cons "a" (cons "an" (cons "the" '()))))
(define line5 (cons "two" (cons "days" '())))

; A LLS is one of: 
; - '()
; - (cons Los LLS)
; interpretation a list of lines, each is a list of Strings
(define lls0 '())
(define lls1 (cons line1 (cons line0 (cons line2 (cons line3 '())))))


; String -> String
; consumes the name n of a file, reads the file, removes the articles,
; and writes the result out to a file whose name is the result of
; concatenating "no-articles-" with n
(define (remove-articles** n)
  (write-file (string-append "no-articles-" n)
              (remove-articles* (read-words/line "ttt.txt"))))

; LLS -> String
; converts a list of lines into a String without articles
; the Strings should be separated by blank spaces (" ")
; the lines should be separated with a newline ("\n")
(check-expect (remove-articles* lls0) "")
(check-expect (remove-articles* lls1) "car\n\napple\nkite")

(define (remove-articles* lls)
  (cond [(empty? lls) ""]
        [else (string-append (remove-articles (first lls))
                             (if (empty? (rest lls)) "" "\n")
                             (remove-articles* (rest lls)))]))

; Los -> String
; converts a list of Strings into a String without articles
; the Strings should be separated by blank spaces (" ")
; an article is one of the following three words: "a", "an", and "the"
(check-expect (remove-articles line0) "")
(check-expect (remove-articles line1) "car")
(check-expect (remove-articles line2) "apple")
(check-expect (remove-articles line3) "kite")
(check-expect (remove-articles line4) "")
(check-expect (remove-articles line5) "two days")

(define (remove-articles los)
  (cond [(empty? los) ""]
        [else (string-append (cond [(string=? (first los) "a")   ""]
                                   [(string=? (first los) "an")  ""]
                                   [(string=? (first los) "the") ""]
                                   [else (string-append (first los)
                                                        (if (empty? (rest los)) "" " "))])
                             (remove-articles (rest los)))]))


; Test drive
(remove-articles** "ttt")
