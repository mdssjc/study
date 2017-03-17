;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-87) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 87

(require 2htdp/image)
(require 2htdp/universe)

(define-struct editor [post index])
; An Editor is a structure:
;   (make-editor String Number)
; interpretation (make-editor s i) describes an editor
; whose visible text is s with the cursor displayed in t position


; Editor KeyEvent -> Editor
; produces a new editor with base in key event
(check-expect (edit (make-editor "abcdef" 3) "a")      (make-editor "abcadef" 4))
(check-expect (edit (make-editor "abcdef" 3) "\b")     (make-editor "abdef" 2))
(check-expect (edit (make-editor "def" 0)    "\b")     (make-editor "def" 0))
(check-expect (edit (make-editor "abcdef" 3) "\t")     (make-editor "abcdef" 3))
(check-expect (edit (make-editor "abcdef" 3) "\r")     (make-editor "abcdef" 3))
(check-expect (edit (make-editor "abcdef" 3) "left")   (make-editor "abcdef" 2))
(check-expect (edit (make-editor "abcdef" 0) "left")   (make-editor "abcdef" 0))
(check-expect (edit (make-editor "abcdef" 3) "right")  (make-editor "abcdef" 4))
(check-expect (edit (make-editor "abcdef" 6) "right")  (make-editor "abcdef" 6))
(check-expect (edit (make-editor "abcdefghij" 10) "k") (make-editor "abcdefghij" 10))

(define (edit e ke)
  (cond
    [(key=? ke "left")
     (make-editor (editor-post e)
                  (if (> (editor-index e) 0)
                      (sub1 (editor-index e))
                      0))]
    [(key=? ke "right")
     (make-editor (editor-post e)
                  (if (< (editor-index e) (string-length (editor-post e)))
                      (add1 (editor-index e))
                      (string-length (editor-post e))))]
    [(or (key=? ke "\t") (key=? ke "\r")) e]
    [(= (string-length ke) 1)
     (make-editor
      (cond
        [(key=? ke "\b") (if (> (editor-index e) 0)
                             (string-delete (editor-post e) (editor-index e))
                             (editor-post e))]
        [(and (= (string-length ke) 1)
              (< (string-length (editor-post e)) 10))
         (string-insert ke (editor-post e) (editor-index e))]
        [else (editor-post e)])
      (cond
        [(key=? ke "\b") (if (> (editor-index e) 0)
                             (sub1 (editor-index e))
                             (editor-index e))]
        [(and (= (string-length ke) 1)
              (< (editor-index e) 10)) (add1 (editor-index e))]
        [else (editor-index e)]))]
    [else e]))

;; String -> String
;; inserts character c into string s in position i
(check-expect (string-insert "_" "helloworld" 5) "hello_world")

(define (string-insert c s i)
  (string-append (substring s 0 i) c (substring s i)))

;; String -> String
;; deletes the character at position i of string str
(check-expect (string-delete "helloworld" 6) "helloorld")
(check-expect (string-delete "abcdef" 3)     "abdef")

(define (string-delete str i)
  (if (= i 0)
      str
      (string-append
       (substring str 0 (sub1 i))
       (substring str i))))
