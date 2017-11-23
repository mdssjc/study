#lang racket/base


;; =================
;; Data definitions:

; A blog is a (blog posts)
; where posts is a (listof post)
(struct blog (posts) #:mutable)

; Post is a (post title body comments)
; where title is a string, body is a string,
; and comments is a (listof string)
(struct post (title body comments) #:mutable)

; BLOG: blog
; the initial BLOG.
(define BLOG
  (blog
   (list (post "Second Post" "This is another post"  '())
         (post "First Post"  "This is my first post" '("First comment!")))))


;; ==========
;; Functions:

; blog-insert-post!: blog post -> void
; consumes a blog and a post, adds the post at the top of the blog.
(define (blog-insert-post! a-blog a-post)
  (set-blog-posts!
   a-blog
   (cons a-post (blog-posts a-blog))))

; post-insert-comment!: post string -> void
; consumes a post and a comment string.  As a side-efect,
; adds the comment to the bottom of the post's list of comments.
(define (post-insert-comment! a-post a-comment)
  (set-post-comments!
   a-post
   (append (post-comments a-post) (list a-comment))))

(provide (all-defined-out))
