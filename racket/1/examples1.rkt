#lang slideshow

(provide square)

5
"art gallery"
(circle 10)
(rectangle 10 20)
(hc-append (circle 10) (rectangle 10 20))

(define c (circle 10))
(define r (rectangle 10 20))
r
c
(hc-append c r)
(hc-append 20 c r c)

(define (square n)
  ; A semi-colon starts a line comment.
  ; The expression below is the function body.
  (filled-rectangle n n))
(square 10)

(define (four p)
  (define two-p (hc-append p p))
  (vc-append two-p two-p))
(four (circle 10))

(define (checker p1 p2)
  (let ([p12 (hc-append p1 p2)]
        [p21 (hc-append p2 p1)])
    (vc-append p12 p21)))
(checker (colorize (square 10) "red")
         (colorize (square 10) "black"))

(define (checkerboard p)
  (let* ([rp (colorize p "red")]
         [bp (colorize p "black")]
         [c (checker rp bp)]
         [c4 (four c)])
    (four c4)))
(checkerboard (square 10))

circle

(define (series mk)
  (hc-append 4 (mk 5) (mk 10) (mk 20)))
(series circle)
(series square)
(series (lambda (size) (checkerboard (square size))))

(define series2
   (lambda (mk)
      (hc-append 4 (mk 5) (mk 10) (mk 20))))
(series2 circle)

(define (rgb-series mk)
  (vc-append
   (series (lambda (sz) (colorize (mk sz) "red")))
   (series (lambda (sz) (colorize (mk sz) "green")))
   (series (lambda (sz) (colorize (mk sz) "blue")))))
(rgb-series circle)
(rgb-series square)

(define (rgb-maker mk)
  (lambda (sz)
    (vc-append (colorize (mk sz) "red")
               (colorize (mk sz) "green")
               (colorize (mk sz) "blue"))))
(series (rgb-maker circle))
(series (rgb-maker square))
