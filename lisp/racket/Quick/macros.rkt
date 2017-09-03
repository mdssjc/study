#lang slideshow

(require slideshow/code)
(provide pict+code)


(define-syntax pict+code
  (syntax-rules ()
    [(pict+code expr)
     (hc-append 10 expr (code expr))]))

(code (circle 10))
(pict+code (circle 10))
