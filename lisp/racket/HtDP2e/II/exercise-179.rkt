;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-179) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 179

(define-struct editor [pre post])
; An Editor is a structure:
;   (make-editor Lo1S Lo1S)
; An Lo1S is one of: 
; - '()
; - (cons 1String Lo1S)


; String String -> Editor
; consumes two strings and produces an Editor
(check-expect (create-editor "left" "right")
              (make-editor (explode "left") (explode "right")))

(define (create-editor lo1s1 lo1s2)
  (make-editor (explode lo1s1) (explode lo1s2)))

(define e1 (create-editor "" ""))
(define e2 (create-editor "left" "right"))
(define e3 (create-editor "" "right"))
(define e4 (create-editor "left" ""))

; Lo1s 1String -> Lo1s
; creates a new list by adding s to the end of l
(check-expect (add-at-end (cons "c" (cons "b" '())) "a") (cons "c" (cons "b" (cons "a" '()))))

(define (add-at-end l s)
  (cond
    [(empty? l) (cons s '())]
    [else (cons (first l) (add-at-end (rest l) s))]))


; Editor -> Editor
; moves the cursor position one 1String left, 
; if possible
(check-expect (editor-lft e1) e1)
(check-expect (editor-lft e2) (create-editor "lef" "tright"))
(check-expect (editor-lft e3) e3)

(define (editor-lft ed)
  (cond [(empty? (editor-pre ed)) ed]
        [else (make-editor (reverse (rest (reverse (editor-pre ed))))
                           (cons (first (reverse (editor-pre ed)))
                                 (editor-post ed)))]))
 
; Editor -> Editor
; moves the cursor position one 1String right, 
; if possible
(check-expect (editor-rgt e1) e1)
(check-expect (editor-rgt e2) (create-editor "leftr" "ight"))
(check-expect (editor-rgt e4) e4)

(define (editor-rgt ed)
  (cond [(empty? (editor-post ed)) ed]
        [else (make-editor (add-at-end (editor-pre ed)
                                       (first (editor-post ed)))
                           (rest (editor-post ed)))]))
 
; Editor -> Editor
; deletes a 1String to the left of the cursor
; if possible
(check-expect (editor-del e1) e1)
(check-expect (editor-del e2) (create-editor "lef""right"))
(check-expect (editor-del e3) e3)

(define (editor-del ed)
  (cond [(empty? (editor-pre ed)) ed]
        [else (make-editor (reverse (rest (reverse (editor-pre ed))))
                           (editor-post ed))]))
