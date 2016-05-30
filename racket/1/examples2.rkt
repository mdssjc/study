#lang slideshow
(require "examples1.rkt")
(require pict/flash)
(require slideshow/code)

(provide pict+code)

(list "red" "green" "blue")
(list (circle 10) (square 10))

(define (rainbow p)
  (map (lambda (color)
         (colorize p color))
       (list "red" "orange" "yellow" "green" "blue" "purple")))
(rainbow (square 5))
(apply vc-append (rainbow (square 5)))

(filled-flash 40 30)
(code (circle 10))

(define-syntax pict+code
  (syntax-rules ()
    [(pict+code expr)
     (hc-append 10
                expr
                (code expr))]))
(pict+code (circle 10))
