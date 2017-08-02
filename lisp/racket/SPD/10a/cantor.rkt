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

;; My world program  (make this more specific)

;; =================
;; Constants:
(define CUTOFF 3)

;; =================
;; Data definitions:

;; WS is ... (give WS a better name)



;; =================
;; Functions:

;; WS -> WS
;; start the world with ...
;;
(define (main ws)
  (big-bang ws                   ; WS
            (on-tick   tock)     ; WS -> WS
            (to-draw   render)   ; WS -> Image
            (stop-when ...)      ; WS -> Boolean
            (on-mouse  ...)      ; WS Integer Integer MouseEvent -> WS
            (on-key    ...)))    ; WS KeyEvent -> WS

;; WS -> WS
;; produce the next ...
;; !!!
(define (tock ws) ...)


;; WS -> Image
;; render ...
;; !!!
(define (render ws) ...)

;; Number Number -> Image
;; produces a cantor set of the given width and percentage of white width
(check-expect (scantor CUTOFF 1/3) (rectangle CUTOFF 3 "solid" "blue"))
(check-expect (scantor (* CUTOFF 3) 1/3)
              (local ((define sub (rectangle CUTOFF 3 "solid" "blue"))
                      (define blk (rectangle CUTOFF 3 "solid" "white")))
                (above (rectangle (* CUTOFF 3) 3 "solid" "blue")
                       blk
                       (beside sub blk sub))))

;(define (scantor w p) empty-image) ; Stub

(define (scantor w p)
  (cond [(<= w CUTOFF) (rectangle CUTOFF 3 "solid" "blue")]
        [else
         (local ((define wc (* w p))
                 (define sub (scantor (/ (- w wc) 2) p))
                 (define blk (rectangle wc 3 "solid" "white")))
           (above (rectangle w 3 "solid" "blue")
                  blk
                  (beside sub blk sub)))]))
