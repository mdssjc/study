;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-86) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 86

(require 2htdp/image)
(require 2htdp/universe)

(define-struct editor [pre post])
; An Editor is a structure:
;   (make-editor String String)
; interpretation (make-editor s t) describes an editor
; whose visible text is (string-append s t) with 
; the cursor displayed between s and t


; Editor KeyEvent -> Editor
; produces a new editor with base in key event
(check-expect (edit (make-editor "abc" "def") "a")     (make-editor "abca" "def"))
(check-expect (edit (make-editor "abc" "def") "\b")    (make-editor "ab" "def"))
(check-expect (edit (make-editor "" "def")    "\b")    (make-editor "" "def"))
(check-expect (edit (make-editor "abc" "def") "\t")    (make-editor "abc" "def"))
(check-expect (edit (make-editor "abc" "def") "\r")    (make-editor "abc" "def"))
(check-expect (edit (make-editor "abc" "def") "left")  (make-editor "ab" "cdef"))
(check-expect (edit (make-editor "" "abcdef") "left")  (make-editor "" "abcdef"))
(check-expect (edit (make-editor "abc" "def") "right") (make-editor "abcd" "ef"))
(check-expect (edit (make-editor "abcdef" "") "right") (make-editor "abcdef" ""))
(check-expect (edit (make-editor "abcdefghij" "") "k") (make-editor "abcdefghij" ""))

(define (edit e ke)
  (cond
    [(key=? ke  "left") (make-editor (string-remove-last (editor-pre e))
                                     (string-append (string-last (editor-pre e))
                                                    (editor-post e)))]
    [(key=? ke "right") (make-editor (string-append (editor-pre e)
                                                    (string-first (editor-post e)))
                                     (string-rest (editor-post e)))]
    [(or (key=? ke "\t") (key=? ke "\r")) e]
    [(= (string-length ke) 1)
     (make-editor
      (cond
        [(key=? ke "\b") (string-remove-last (editor-pre e))]
        [(and (= (string-length ke) 1)
              (< (string-length (editor-pre e)) 10))
         (string-append (editor-pre e) ke)]
        [else (editor-pre e)])
      (editor-post e))]
    [else e]))

;; String -> String
;; extracts the first character from a non-empty string
(check-expect (string-first "Hello") "H")
(check-expect (string-first "apple") "a")
(check-expect (string-first "")      "")

(define (string-first s)
  (if (= (string-length s) 0)
      ""
      (substring s 0 1)))

;; String -> String
;; produces a string like the given one with the first character removed
(check-expect (string-rest "Hello") "ello")
(check-expect (string-rest "apple") "pple")
(check-expect (string-rest "")      "")

(define (string-rest s)
  (if (= (string-length s) 0)
      ""
      (substring s 1)))

;; String -> String
;; extracts the last character from a non-empty string
(check-expect (string-last "Hello") "o")
(check-expect (string-last "apple") "e")
(check-expect (string-last "")      "")

(define (string-last s)
  (if (= (string-length s) 0)
      ""
      (substring s (- (string-length s) 1))))

;; String -> String
;; produces a string like the given one with the last character removed
(check-expect (string-remove-last "Hello") "Hell")
(check-expect (string-remove-last "apple") "appl")
(check-expect (string-remove-last "")      "")

(define (string-remove-last s)
  (if (= (string-length s) 0)
      ""
      (substring s 0 (- (string-length s) 1))))
