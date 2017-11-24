#lang racket/base

(require racket/list
         db)


;; =================
;; Data definitions:

; A blog is a (blog db)
; where db is an sqlite connection
(struct blog (db))

; A post is a (post blog id)
; where blog is a blog and id is an integer?
(struct post (blog id))


;; ==========
;; Functions:

; initialize-blog! : path? -> blog?
; sets up a blog database (if it doesn't exist)
(define (initialize-blog! home)
  (define db (sqlite3-connect #:database home #:mode 'create))
  (define the-blog (blog db))
  (unless (table-exists? db "posts")
    (query-exec db
                (string-append
                 "CREATE TABLE posts "
                 "(id INTEGER PRIMARY KEY, title TEXT, body TEXT)"))
    (blog-insert-post!
     the-blog "First Post" "This is my first post")
    (blog-insert-post!
     the-blog "Second Post" "This is another post"))
  (unless (table-exists? db "comments")
    (query-exec db
                "CREATE TABLE comments (pid INTEGER, content TEXT)")
    (post-insert-comment!
     the-blog (first (blog-posts the-blog))
     "First comment!"))
  the-blog)

; blog-posts : blog -> (listof post?)
; queries for the post ids
(define (blog-posts a-blog)
  (define (id->post an-id)
    (post a-blog an-id))
  (map id->post
       (query-list
        (blog-db a-blog)
        "SELECT id FROM posts")))

; post-title : post -> string?
; queries for the title
(define (post-title a-post)
  (query-value
   (blog-db (post-blog a-post))
   "SELECT title FROM posts WHERE id = ?"
   (post-id a-post)))

; post-body : post -> string?
; queries for the body
(define (post-body p)
  (query-value
   (blog-db (post-blog p))
   "SELECT body FROM posts WHERE id = ?"
   (post-id p)))

; post-comments : post -> (listof string?)
; queries for the comments
(define (post-comments p)
  (query-list
   (blog-db (post-blog p))
   "SELECT content FROM comments WHERE pid = ?"
   (post-id p)))

; blog-insert-post!: blog? string? string? -> void
; consumes a blog and a post, adds the post at the top of the blog.
(define (blog-insert-post! a-blog title body)
  (query-exec
   (blog-db a-blog)
   "INSERT INTO posts (title, body) VALUES (?, ?)"
   title body))

; post-insert-comment!: blog? post string -> void
; consumes a blog, a post and a comment string. as a side-efect,
; adds the comment to the bottom of the post's list of comments.
(define (post-insert-comment! a-blog p a-comment)
  (query-exec
   (blog-db a-blog)
   "INSERT INTO comments (pid, content) VALUES (?, ?)"
   (post-id p) a-comment))

(provide blog? blog-posts
         post? post-title post-body post-comments
         initialize-blog!
         blog-insert-post! post-insert-comment!)
