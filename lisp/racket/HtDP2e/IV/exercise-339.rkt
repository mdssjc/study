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

(define F7 (make-file "read!" 19 ""))
(define D-DOCS (make-dir "Docs" empty (list F7)))
(define F5 (make-file "hang" 8 ""))
(define F6 (make-file "draw" 2 ""))
(define D-CODE (make-dir "Code" empty (list F5 F6)))
(define D-LIBS (make-dir "Libs" (list D-CODE D-DOCS) empty))
(define F2 (make-file "part1" 99 ""))
(define F3 (make-file "part2" 52 ""))
(define F4 (make-file "part3" 17 ""))
(define D-TEXT (make-dir "Text" empty (list F2 F3 F4)))
(define F1 (make-file "read!" 10 ""))
(define D-TS (make-dir "TS" (list D-TEXT D-LIBS) (list F1)))


;; ====================
;; Functions:

; Dir String -> Boolean
; determines whether or not a file with this name occurs in the directory tree
(check-expect (find? (make-dir "root" empty empty) "") #false)
(check-expect (find? D-TS "my-draw") #false)
(check-expect (find? D-TS "read!") #true)
(check-expect (find? D-TS "part1") #true)
(check-expect (find? D-TS "draw") #true)

(define (find? d fn)
  (or (foldl (lambda (d acc)
               (or (find? d fn) acc))
             #false (dir-dirs d))
      (foldl (lambda (f acc)
               (or (string=? (file-name f) fn) acc))
             #false (dir-files d))))
