;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-340) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 340

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

; Dir -> [List-of String]
; lists the names of all files and directories in a given Dir
(check-expect (ls (make-dir "root" empty empty)) empty)
(check-expect (ls D-DOCS) (list "read!"))
(check-expect (ls D-CODE) (list "draw" "hang"))
(check-expect (ls D-LIBS) (list "read!" "draw" "hang"))
(check-expect (ls D-TEXT) (list "part3" "part2" "part1"))
(check-expect (ls D-TS) (list "read!" "draw" "hang" "part3" "part2" "part1" "read!"))

(define (ls d)
  (append (foldl (lambda (d acc)
                   (append (ls d) acc))
                 empty (dir-dirs d))
          (foldl (lambda (f acc)
                   (cons (file-name f) acc))
                 empty (dir-files d))))
