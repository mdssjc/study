;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-338) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 338

(require htdp/dir)


;; =================
;; Constants:

;(define O (create-dir "/Users/...")) ; on OS X 
(define L (create-dir "/var/log/")) ; on Linux
;(define W (create-dir "C:\\Users\\...")) ; on Windows 


;; ====================
;; Functions:

; Dir -> Natural
; determines how many files a given Dir.v3 contains
(check-expect (how-many (make-dir "root" empty empty)) 0)
(check-expect (how-many L) 91) ; check on your system

(define (how-many d)
  (+ (foldr (lambda (d acc)
              (+ (how-many d) acc))
            0 (dir-dirs d))
     (length (dir-files d))))
