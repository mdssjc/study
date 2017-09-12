;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-339) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 339

(require htdp/dir)


;; =================
;; Constants:

;(define O (create-dir "/Users/...")) ; on OS X 
(define L (create-dir "/var/log/")) ; on Linux
;(define W (create-dir "C:\\Users\\...")) ; on Windows 


;; ====================
;; Functions:

; Dir String -> Boolean
; determines whether or not a file with this name occurs in the directory tree
(check-expect (find? (make-dir "root" empty empty) "") #false)
(check-expect (find? L "pacman.log") #true) ; check on your system

(define (find? d fn)
  (or (foldl (lambda (d acc)
               (or (find? d fn) acc))
             #false (dir-dirs d))
      (foldl (lambda (f acc)
               (or (string=? (file-name f) fn) acc))
             #false (dir-files d))))
