;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-341) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 341

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

; Dir -> Natural
; computes the total size of all the files in the entire directory tree
(check-expect (du (make-dir "root" empty empty)) 0)
(check-expect (du D-DOCS) 19)
(check-expect (du D-CODE) 10)
(check-expect (du D-LIBS) 31)
(check-expect (du D-TEXT) (+ 99 52 17))
(check-expect (du D-TS) (+ 99 52 17 31 2 10))

(define (du d)
  (+ (foldl (lambda (d acc)
              (+ 1 (du d) acc))
            0 (dir-dirs d))
     (foldl (lambda (f acc)
              (+ (file-size f) acc))
            0 (dir-files d))))
