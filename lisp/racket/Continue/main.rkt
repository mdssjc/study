#lang web-server/insta


;; =================
;; Data definitions:

(struct post (title body))
(define P1 (post "New release" "The new version..."))
(define P2 (post "Summary #3" "02/05 - all tests are ok."))
(define P3 (post "Courses" "HTDP - new course in..."))
(define BLOG (list (post "First Post!"
                         "Hey, this is my first post!")))


;; ==========
;; Functions:

; render-greeting: string -> response
; consumes a name, and produces a dynamic response
(define (render-greeting a-name)
  (response/xexpr
   `(html (head (title "Welcome"))
          (body (p ,(string-append "Hello " a-name))))))

; render-post: post -> xexpr/c
; consumes a post and produces an X-expression representing that content
(define (render-post p)
  `(div ((class "post"))
        ,(post-title p)
        (p ,(post-body p))))

(define (start request)
  (response/xexpr
   `(html
     (head (title "My Blog"))
     (body (h1 "Under construction")
           ,(render-post (post "First post!" "This is a first post."))))))
