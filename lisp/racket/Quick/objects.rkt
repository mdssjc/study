#lang slideshow

(require racket/class
         racket/gui/base
         pict/flash
         "macros.rkt")


(define f (new frame%
               [label "My Art"]
               [width 300]
               [height 300]
               [alignment '(center center)]))

(define (add-drawing p)
  (let ([drawer (make-pict-drawer p)])
    (new canvas%
         [parent f]
         [style '(border)]
         [paint-callback (lambda (self dc)
                           (drawer dc 0 0))])))

(send f show #t)
(add-drawing (pict+code (circle 10)))
(add-drawing (colorize (filled-flash 50 30) "yellow"))
