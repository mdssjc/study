;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname |Intermezzo 2|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Intermezzo 2.rkt
;; Intermezzo 2: Quote, Unquote

(require 2htdp/web-io)


;; Quote

;; Exercise 231

'(1 "a" 2 #false 3 "c")
(list 1 "a" 2 #false 3 "c")

'()
(list)

'(("alan" 1000)
  ("barb" 2000)
  ("carl" 1500))
(list (list "alan" 1000)
      (list "barb" 2000)
      (list "carl" 1500))



;; Quasiquote and Unquote

; String String -> ... deeply nested list ...
; produces a web page with given author and title
(define (my-first-web-page author title)
  `(html
     (head
       (title ,title)
       (meta ((http-equiv "content-type")
              (content "text-html"))))
     (body
       (h1 ,title)
       (p "I, " ,author ", made this page."))))

(my-first-web-page "Matthias" "Hello World")
(show-in-browser (my-first-web-page "Matthias" "Hello World"))

;; Exercise 232

`(1 "a" 2 #false 3 "c")
(list 1 "a" 2 #false 3 "c")

`(("alan" ,(* 2 500))
  ("barb" 2000)
  (,(string-append "carl" " , the great") 1500)
  ("dawn" 2300))
(list (list "alan" (* 2 500))
      (list "barb" 2000)
      (list (string-append "carl" " , the great") 1500)
      (list "dawn" 2300))

(define title "ratings")
`(html
  (head
   (title ,title))
  (body
   (h1 ,title)
   (p "A second web page")))
(list 'html
      (list 'head
            (list 'title title))
      (list 'body
            (list 'h1 title)
            (list 'p "A second web page")))
