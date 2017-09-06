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
(define (start request)
  (response/xexpr
   '(html
     (head (title "My Blog"))
     (body (h1 "Under construction")))))
