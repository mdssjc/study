;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-337) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 337


;; ====================
;; Data definitions:

(define-struct dir [name dirs files])
; A Dir.v3 is a structure:
;   (make-dir.v3 String [List-of Dir.v3] [List-of File.v3])

; A [List-of ITEM] is one of:
; - '()
; - (cons ITEM [List-of ITEM])

(define-struct file [name size content])
; A File.v3 is a structure: 
;   (make-file String N String)
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

; Dir.v3 -> Natural
; determines how many files a given Dir.v3 contains
(check-expect (how-many (make-dir "root" empty empty)) 0)
(check-expect (how-many D-CODE) 2)
(check-expect (how-many D-LIBS) 3)
(check-expect (how-many D-TS) 7)

(define (how-many d)
  (+ (foldr (lambda (d acc)
              (+ (how-many d) acc))
            0 (dir-dirs d))
     (length (dir-files d))))
