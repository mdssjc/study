;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname |20-Iterative Refinement|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 20-Iterative Refinement.rkt
;; IV - Intertwined Data
;; 20 - Iterative Refinement



;; 20.1 - Data Analysis

;; Exercise 329

; How many times does a file name read! occur in the directory tree TS?
; Occur 2 times.

; Can you describe the path from the root directory to the occurrences?
; Yes.
; TS (DIR) -> read! (10)
; TS (DIR) -> Libs (DIR) -> Docs (DIR) -> read! (19)

; What is the total size of all the files in the tree?
; Total of 207.

; What is the total size of the directory if each directory node has size 1?
; Total of 5.

; How many levels of directories does it contain?
; It has 3 levels.



;; 20.2 - Refining Data Definitions


;; =================
;; Data definitions:

; A Dir.v1 (short for directory) is one of:
; - '()
; - (cons File.v1 Dir.v1)
; - (cons Dir.v1  Dir.v1)

; A File.v1 is a String.

;; Exercise 330

(define D-CODE '("hang" "draw"))
(define D-DOCS '("read!"))
(define D-LIBS `(,D-CODE ,D-DOCS))
(define D-TEXT '("part1" "part2" "part3"))
(define D-TS   `(,D-TEXT "read!" ,D-LIBS))

;; Exercise 331


;; =================
;; Functions:

; Dir.v1 -> Natural
; determines how many files a given Dir.v1 contains
(check-expect (how-many '())    0)
(check-expect (how-many D-CODE) 2)
(check-expect (how-many D-LIBS) 3)
(check-expect (how-many D-TS)   7)

(define (how-many d)
  (foldl (lambda (d acc)
           (+ acc
              (if (string? d) 1 (how-many d))))
         0 d))


;; =================
;; Data definitions:

(define-struct dir [name content])
; A Dir.v2 is a structure:
;   (make-dir String LOFD)

; An LOFD (short for list of files and directories) is one of:
; - '()
; - (cons File.v2 LOFD)
; - (cons Dir.v2  LOFD)

; A File.v2 is a String.

;; Exercise 332

(define D-CODE.V2 (make-dir "Code" '("hang" "draw")))
(define D-DOCS.V2 (make-dir "Docs" '("read!")))
(define D-LIBS.V2 (make-dir "Libs" `(,D-CODE.V2 ,D-DOCS.V2)))
(define D-TEXT.V2 (make-dir "Text" '("part1" "part2" "part3")))
(define D-TS.V2   (make-dir "TS"   `(,D-TEXT.V2 "read!" ,D-LIBS.V2)))

;; Exercise 333

#;
(define (fn-for-dir d)
  (... (dir-name d)
       (fn-for-lofd (dir-content d))))

#;
(define (fn-for-lofd lofd)
  (cond [(empty? lofd) ...]
        [(string? (first lofd))
         (... (first lofd)
              (fn-for-lofd (rest lofd)))]
        [else
         (... (fn-for-dir  (first lofd))
              (fn-for-lofd (rest  lofd)))]))


;; =================
;; Functions:

; Dir.v2 -> Natural
; determines how many files a given Dir.v2 contains
(check-expect (how-many.v2 (make-dir "root" '())) 0)
(check-expect (how-many.v2 D-CODE.V2) 2)
(check-expect (how-many.v2 D-LIBS.V2) 3)
(check-expect (how-many.v2 D-TS.V2)   7)

(define (how-many.v2 d)
  (foldl (lambda (d acc)
           (+ acc
              (if (string? d) 1 (how-many.v2 d))))
         0 (dir-content d)))

;; Exercise 334


;; =================
;; Data definitions:

(define-struct dir.v2 (name content size readability))
; A Dir.v2b is a structure:
;   (make-dir String LOFD N Boolean)

; A LOFD (short for list of files and directories) is one of:
; - '()
; - (cons File.v2 LOFD)
; - (cons Dir.v2b LOFD)

; A File.v2 is a String.

(define-struct file.v3 [name size content])
; A File.v3 is a structure:
;   (make-file.v3 String N String)

(define-struct dir.v3 [name dirs files])
; A Dir.v3 is a structure:
;   (make-dir.v3 String Dir* File*)

; A Dir* is one of:
; - '()
; - (cons Dir.v3 Dir*)

; A File* is one of:
; - '()
; - (cons File.v3 File*)

;; Exercise 335

(define F7 (make-file.v3 "read!" 19 ""))
(define D-DOCS.V3 (make-dir.v3 "Docs" '() `(,F7)))
(define F5 (make-file.v3 "hang" 8 ""))
(define F6 (make-file.v3 "draw" 2 ""))
(define D-CODE.V3 (make-dir.v3 "Code" '() `(,F5 ,F6)))
(define D-LIBS.V3 (make-dir.v3 "Libs" `(,D-CODE.V3 ,D-DOCS.V3) '()))
(define F2 (make-file.v3 "part1" 99 ""))
(define F3 (make-file.v3 "part2" 52 ""))
(define F4 (make-file.v3 "part3" 17 ""))
(define D-TEXT.V3 (make-dir.v3 "Text" '() `(,F2 ,F3 ,F4)))
(define F1 (make-file.v3 "read!" 10 ""))
(define D-TS.V3 (make-dir.v3 "TS" `(,D-TEXT.V3 ,D-LIBS.V3) `(,F1)))

;; Exercise 336

#;
(define (fn-for-dir d0)
  (local ((define (fn-for-dir d)
            (... (dir-name d)
                 (fn-for-lod (dir.v3-dirs  d))
                 (fn-for-lof (dir.v3-files d))))

          (define (fn-for-lod lod)
            (cond [(empty? lod) ...]
                  [else
                   (... (fn-for-dir (first lod))
                        (fn-for-lod (rest  lod)))]))

          (define (fn-for-lof lof)
            (cond [(empty? lof) ...]
                  [else
                   (... (fn-for-file (first lof))
                        (fn-for-lof  (rest  lof)))]))

          (define (fn-for-file f)
            (... (file-name f)
                 (file-size f)
                 (file-content f))))

    (fn-for-dir d0)))


;; =================
;; Functions:

; Dir.v3 -> Natural
; determines how many files a given Dir.v3 contains
(check-expect (how-many.v3 (make-dir.v3 "root" '() '())) 0)
(check-expect (how-many.v3 D-CODE.V3) 2)
(check-expect (how-many.v3 D-LIBS.V3) 3)
(check-expect (how-many.v3 D-TS.V3)   7)

(define (how-many.v3 d)
  (+ (foldl (lambda (d acc)
              (+ (how-many.v3 d) acc))
            0 (dir.v3-dirs d))
     (foldl (lambda (f acc)
              (add1 acc))
            0 (dir.v3-files d))))

;; Exercise 337


;; =================
;; Data definitions:

; A Dir.v3 is a structure:
;   (make-dir.v3 String [List-of Dir.v3] [List-of File.v3])

; A [List-of ITEM] is one of:
; - '()
; - (cons ITEM [List-of ITEM])


;; =================
;; Functions:

; Dir.v3 -> Natural
; determines how many files a given Dir.v3 contains
(check-expect (how-many.v4 (make-dir.v3 "root" '() '())) 0)
(check-expect (how-many.v4 D-CODE.V3) 2)
(check-expect (how-many.v4 D-LIBS.V3) 3)
(check-expect (how-many.v4 D-TS.V3)   7)

(define (how-many.v4 d)
  (+ (foldr (lambda (d acc)
              (+ (how-many.v4 d) acc))
            0 (dir.v3-dirs d))
     (length (dir.v3-files d))))



;; 20.3 - Refining Functions

(require htdp/dir)


;; (define O (create-dir "/Users/..."))     ; on OS X
(define L (create-dir "/var/log/"))      ; on Linux
;; (define W (create-dir "C:\\Users\\...")) ; on Windows

;; Exercise 338


;; =================
;; Functions:

; Dir -> Natural
; determines how many files a given Dir contains
(define (how-many.v5 d)
  (+ (foldl (lambda (d acc)
              (+ (how-many.v5 d) acc))
            0 (dir-dirs d))
     (foldl (lambda (f acc)
              (add1 acc))
            0 (dir-files d))))

(how-many.v5 L)

;; Exercise 339


;; =================
;; Functions:

; Dir String -> Boolean
; determines whether or not a file with this name occurs in the directory tree
(define (find? d fn)
  (or (foldl (lambda (d acc)
               (or (find? d fn) acc))
             #false (dir-dirs d))
      (foldl (lambda (f acc)
               (or (string=? (file-name f) fn) acc))
             #false (dir-files d))))

(find? L "log.log")
(find? L "vboxadd-setup.log")

;; Exercise 340


;; =================
;; Functions:

; Dir -> [List-of String]
; lists the names of all files and directories in a given Dir
(define (ls d)
  (append (foldl (lambda (d acc)
                   (append (ls d) acc))
                 '() (dir-dirs d))
          (foldl (lambda (f acc)
                   (cons (file-name f) acc))
                 '() (dir-files d))))

(ls L)
