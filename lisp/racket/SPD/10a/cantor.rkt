;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname cantor) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; cantor.rkt
;; Generative Recursion P3 - Cantor
;; Design a world program to create the cantor set.

(require 2htdp/image)
(require 2htdp/universe)


;; PROBLEM:
;;
;; A Cantor Set is another fractal with a nice simple geometry.
;; The idea of a Cantor set is to have a bar (or rectangle) of
;; a certain width w, then below that are two recursive calls each
;; of 1/3 the width, separated by a whitespace of 1/3 the width.
;;
;; So this means that the
;;   width of the whitespace   wc  is  (/ w 3)
;;   width of recursive calls  wr  is  (/ (- w wc) 2)
;;
;; To make it look better a little extra whitespace is put between
;; the bars.
;;
;;
;; Here are a couple of examples (assuming a reasonable CUTOFF)
;;
;; (cantor CUTOFF) produces:
;;
;; -
;;
;; (cantor (* CUTOFF 3)) produces:
;;
;; ---
;; - -
;;
;; And that keeps building up to something like the following. So
;; as it goes it gets wider and taller of course.
;;
;; ---------
;; ---   ---
;; - -   - -
;;
;;
;; PROBLEM A:
;;
;; Design a function that consumes a width and produces a cantor set
;; of the given width.
;;
;;
;; PROBLEM B:
;;
;; Add a second parameter to your function that controls the
;; percentage of the recursive call that is white each time. Calling
;; your new function with a second argument of 1/3 would produce the
;; same images as the old function.
;;
;;
;; PROBLEM C:
;;
;; Now you can make a fun world program that works this way:
;;   The world state should simply be the most recent x coordinate of
;;   the mouse.
;;
;;   The to-draw handler should just call your new cantor function
;;   with the width of your MTS as its first argument and the last x
;;   coordinate of the mouse divided by that width as its second
;;   argument.

;; A world program for running a cantor set
;; The mouse position controls parameters of the fractal.

;; =================
;; Constants:
(define CUTOFF 4)
(define BAR-HEIGHT 20)
(define SPACING-HEIGHT (/ BAR-HEIGHT 2))

(define WIDTH  640)
(define HEIGHT 320)


;; =================
;; Data definitions:

;; WorldState is (make-posn Number Number)
;; interp. the last x-coordinate of the mouse 
(define WS1 (make-posn   0 10))
(define WS2 (make-posn 100 10))
(define WS3 (make-posn 300 10))

#;
(define (fn-for-ws ws)
  (... (posn-x ws)
       (posn-y ws)))


;; =================
;; Functions:

;; WorldState -> WorldState
;; start the world with (main WS1)
(define (main ws)
  (big-bang ws
            (to-draw  render)
            (on-mouse handler)))

;; WorldState -> Image
;; render cantor set based on current mouse position
(check-expect (render WS1) (scantor WIDTH (/ (posn-x WS1) WIDTH)))
(check-expect (render WS2) (scantor WIDTH (/ (posn-x WS2) WIDTH)))
(check-expect (render WS3) (scantor WIDTH (/ (posn-x WS3) WIDTH)))

(define (render ws)
  (scantor WIDTH (/ (posn-x ws) WIDTH)))

;; WorldState Integer Integer MouseEvent -> WorldState
;; update the current ws according to mouse position
(check-expect (handler WS1  0 10 "move") (make-posn  0 10))
(check-expect (handler WS2  0 10 "move") (make-posn  0 10))
(check-expect (handler WS3 10 10 "move") (make-posn 10 10))
(check-expect (handler WS1  0 10 "button-down") WS1)

(define (handler ws x y mv)
  (cond [(string=? mv "move") (make-posn x y)]
        [else ws]))

;; Natural Number -> Image 
;; produces a cantor set of the given width and percentage of white width
(check-expect (scantor 0 .5)
              (rectangle 0 BAR-HEIGHT "solid" "blue"))

(check-expect (scantor 32 0)
              (above (rectangle 32 BAR-HEIGHT "solid" "blue")
                     (rectangle 32 SPACING-HEIGHT "solid" "white")
                     (rectangle 32 BAR-HEIGHT "solid" "blue")
                     (rectangle 32 SPACING-HEIGHT "solid" "white")
                     (rectangle 32 BAR-HEIGHT "solid" "blue")
                     (rectangle 32 SPACING-HEIGHT "solid" "white")
                     (rectangle 32 BAR-HEIGHT "solid" "blue")))

(check-expect (scantor 32 1)
              (above (rectangle 32 BAR-HEIGHT "solid" "blue")
                     (rectangle 32 SPACING-HEIGHT "solid" "white")
                     (rectangle 32 BAR-HEIGHT "solid" "white")))

(check-expect (scantor 32 .5)
              (above (rectangle 32 BAR-HEIGHT "solid" "blue")
                     (rectangle 32 SPACING-HEIGHT "solid" "white")
                     (beside (above (rectangle 8 BAR-HEIGHT "solid" "blue")
                                    (rectangle 8 SPACING-HEIGHT "solid" "white")
                                    (beside (rectangle 2 BAR-HEIGHT "solid" "blue")
                                            (rectangle 4 BAR-HEIGHT "solid" "white")
                                            (rectangle 2 BAR-HEIGHT "solid" "blue")))
                             (rectangle 16 BAR-HEIGHT "solid" "white")
                             (above (rectangle 8 BAR-HEIGHT "solid" "blue")
                                    (rectangle 8 SPACING-HEIGHT "solid" "white")
                                    (beside (rectangle 2 BAR-HEIGHT "solid" "blue")
                                            (rectangle 4 BAR-HEIGHT "solid" "white")
                                            (rectangle 2 BAR-HEIGHT "solid" "blue"))))))

;(define (scantor w p) empty-image) ; Stub

(define (scantor w p)
  (cond [(<= w CUTOFF) (rectangle w BAR-HEIGHT "solid" "blue")]
        [else
         (local ((define wc (* w p))
                 (define sub (scantor (/ (- w wc) 2) p))
                 (define blk (rectangle wc BAR-HEIGHT "solid" "white")))
           (above (rectangle w BAR-HEIGHT     "solid" "blue")
                  (rectangle w SPACING-HEIGHT "solid" "white")
                  (beside sub blk sub)))]))
