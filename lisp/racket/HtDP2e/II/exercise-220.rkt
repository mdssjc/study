;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-220) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 220

(require 2htdp/image)
(require 2htdp/universe)

; Constants
(define WIDTH 10) ; # of blocks, horizontally 
(define SIZE 10)  ; blocks are squares
(define SCENE-SIZE (* WIDTH SIZE))
(define BACKGROUND (empty-scene SCENE-SIZE SCENE-SIZE))

; red squares with black rims
(define BLOCK (overlay (square (- SIZE 1) "solid" "red")
                       (square SIZE "outline" "black")))


; Variability
(define-struct tetris [block landscape])
(define-struct block [x y])
 
; A Tetris is a structure:
;   (make-tetris Block Landscape)
; A Landscape is one of: 
; - '() 
; - (cons Block Landscape)
; Block is a structure:
;   (make-block N N)
 
; interpretations
; (make-block x y) depicts a block whose left 
; corner is (* x SIZE) pixels from the left and
; (* y SIZE) pixels from the top;
; (make-tetris b0 (list b1 b2 ...)) means b0 is the
; dropping block, while b1, b2, and ... are resting
(define landscape0 (cons (make-block 0 0)
                         (cons (make-block 0 (* 9 SIZE)) '())))
(define block-dropping (cons (make-block 0 1)
                             (cons (make-block 0 (* 9 SIZE)) '())))
(define tetris0 (make-tetris (make-block 0 0)
                             (cons (make-block 10 (* 9 SIZE))
                                   (cons (make-block 0 (* 9 SIZE)) '()))))
(define tetris0-drop (make-tetris (make-block 0 (* 7 SIZE))
                                  (cons (make-block 10 (* 9 SIZE))
                                        (cons (make-block 0 (* 9 SIZE)) '()))))
(define block-landed   (make-block 0 (- SCENE-SIZE 1)))
(define block-on-block (make-block 0 (- SCENE-SIZE 2)))


; Environment
; WS -> WS
; starts a world with !!!
(define (main t)
  (big-bang t
            (to-draw tetris-render)))

; Tetris -> Image
; renders the tetris on the BACKGROUND
(define (tetris-render t)
  (place-image/align BLOCK (block-x (tetris-block t)) (block-y (tetris-block t)) "left" "top"
                     (landscape-render (tetris-landscape t))))

; Landscape -> Image
; renders the landscape on the BACKGROUND
(define (landscape-render l)
  (cond [(empty? l) BACKGROUND]
        [else (place-image/align BLOCK (block-x (first l)) (block-y (first l)) "left" "top"
                                 (landscape-render (rest l)))]))

; TestDrive
(tetris-render tetris0)
(tetris-render tetris0-drop)
