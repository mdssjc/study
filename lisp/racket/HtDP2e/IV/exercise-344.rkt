;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-344) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 344

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
;; Data definitions:

; A Path is [List-of String]
; interpretation directions into a directory tree


;; ====================
;; Functions:

; Dir String -> [List-of Path] or False
; produces the list of all paths that lead to f in d; otherwise it produces #false
(check-expect (find-all (make-dir "root" empty empty) "") #false)
(check-expect (find-all D-TS "part0") #false)
(check-expect (find-all D-TS "part1") (list (list "TS" "Text" "part1")))

(define (find-all d f)
  (local ((define result (filter (lambda (p) (member f p)) (ls-R d))))
    (if (empty? result)
        #false
        result)))

; Dir -> [List-of Path]
; lists the paths to all files contained in a given Dir
(check-expect (ls-R (make-dir "root" empty empty)) empty)
(check-expect (ls-R D-DOCS) (list (list "Docs" "read!")))
(check-expect (ls-R D-CODE) (list (list "Code" "hang")
                                  (list "Code" "draw")))
(check-expect (ls-R D-LIBS) (list (list "Libs" "Code" "hang")
                                  (list "Libs" "Code" "draw")
                                  (list "Libs" "Docs" "read!")))

(define (ls-R d0)
  (local ((define (ls-R d)
            (append (foldr (lambda (d acc)
                             (append (ls-R d) acc))
                           empty (dir-dirs d))
                    (foldr (lambda (f acc)
                             (cons (find d0 (file-name f)) acc))
                           empty (dir-files d)))))
    (ls-R d0)))

; Dir String -> Path or False
; produces a path to a file with name f; otherwise it produces #false
(check-expect (find (make-dir "root" empty empty) "") #false)
(check-expect (find D-TS "part0") #false)
(check-expect (find D-TS "part1") (list "TS" "Text" "part1"))

(define (find d f)
  (local ((define (fn-for-dir d)
            (cons (dir-name d)
                  (if (string=? (fn-for-lof (dir-files d)) "")
                      (fn-for-lod (dir-dirs d))
                      (cons (fn-for-lof (dir-files d)) empty))))

          (define (fn-for-lod lod)
            (cond [(empty? lod) empty]
                  [else
                   (if (find? (first lod) f)
                       (fn-for-dir (first lod))
                       (fn-for-lod (rest lod)))]))

          (define (fn-for-lof lof)
            (cond [(empty? lof) ""]
                  [else
                   (if (string=? (fn-for-file (first lof)) f)
                       (fn-for-file (first lof))
                       (fn-for-lof (rest lof)))]))

          (define (fn-for-file fn)
            (file-name fn)))
    (if (find? d f)
        (fn-for-dir d)
        #false)))

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
