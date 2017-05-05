;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-223) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 223

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
(define tetris0-blocked (make-tetris (make-block 0 0)
                                     (cons (make-block (* 1 SIZE) 0) '())))
(define tetris0-drop (make-tetris (make-block 0 (* 8 SIZE))
                                  (cons (make-block 10 (* 9 SIZE))
                                        (cons (make-block 0 (* 9 SIZE)) '()))))
(define tetris0-drop-floor (make-tetris (make-block 0 (* 9 SIZE)) '()))
(define tetris9 (make-tetris (make-block (* 9 SIZE) 0) '()))
(define tetris9-blocked (make-tetris (make-block (* 9 SIZE) 0)
                                     (cons (make-block (* 8 SIZE) 0) '())))
(define tetris0-game-over (make-tetris (make-block 0 0)
                                       (cons (make-block 0 0) '())))
(define block-landed   (make-block 0 (- SCENE-SIZE 1)))
(define block-on-block (make-block 0 (- SCENE-SIZE 2)))


; Environment
; Tetris -> Tetris
; starts a world with (tetris-main (make-tetris (make-block (* 5 SIZE) 0) '()))
(define (tetris-main t)
  (big-bang t
            (on-tick   tetris-tock 0.1)
            (to-draw   tetris-render)
            (on-key    tetris-move)
            (stop-when tetris-over)))

; Tetris -> Tetris
; updates the Tetris states
(check-expect (tetris-tock tetris0) (make-tetris (make-block 0 (* 1 SIZE))
                                                 (cons (make-block 10 (* 9 SIZE))
                                                       (cons (make-block 0 (* 9 SIZE)) '()))))
(check-random (tetris-tock tetris0-drop) (make-tetris (make-block (* (block-generate (block-x (tetris-block tetris0-drop))) SIZE) 0)
                                                      (cons (make-block 0 (* 8 SIZE))
                                                            (cons (make-block 10 (* 9 SIZE))
                                                                  (cons (make-block 0 (* 9 SIZE)) '())))))
(check-random (tetris-tock tetris0-drop-floor) (make-tetris (make-block (* (block-generate (block-x (tetris-block tetris0-drop))) SIZE) 0)
                                                            (cons (make-block 0 (* 9 SIZE)) '())))

(define (tetris-tock t)
  (make-tetris
   (cond [(drop? t)
          (make-block (* (block-generate (block-x (tetris-block t))) SIZE) 0)]
         [else (next-block (tetris-block t))])
   (cond [(drop? t) (cons (tetris-block t)
                          (tetris-landscape t))]
         [else (tetris-landscape t)])))

; Tetris -> Boolean
; checks if the next block is dropped on the landscape or floor
(define (drop? t)
  (or (member? (next-block (tetris-block t)) (tetris-landscape t))
      (= (block-y (tetris-block t)) (* 9 SIZE))))

; Block -> Block
; suggests the next block
(define (next-block b)
  (make-block (block-x b) (+ (block-y b) SIZE)))

; Number -> Number
; generates the column to the right of the current one;
; else the left-most when in the limit (* 9 SIZE)
(define (block-new c)
  (if (= c (* 9 SIZE)) 0 (+ c SIZE)))

; Number -> Number
; randomly selects a column different from the current one
(check-satisfied (block-generate 5) not-equal-5?)

(define (block-generate c)
  (block-check-generate c (random SIZE)))

; Number Number -> Number 
; generative recursion 
; checks if the column exists, otherwise it creates a new column
(define (block-check-generate c candidate)
  (if (= c candidate) (block-generate c) candidate))

; Number -> Boolean
; use for testing only 
(define (not-equal-5? p)
  (not (= p 5)))

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

; Tetris KeyEvent -> Tetris
; controls the horizontal movement of the dropping block
(check-expect (tetris-move tetris0 " ") tetris0)
(check-expect (tetris-move tetris0-blocked "left")  tetris0-blocked)
(check-expect (tetris-move tetris0-blocked "right") tetris0-blocked)
(check-expect (tetris-move tetris9-blocked "left")  tetris9-blocked)
(check-expect (tetris-move tetris9-blocked "right") tetris9-blocked)
(check-expect (tetris-move tetris0 "right") (make-tetris (make-block (* 1 SIZE) 0)
                                                         (cons (make-block 10 (* 9 SIZE))
                                                               (cons (make-block 0 (* 9 SIZE)) '()))))
(check-expect (tetris-move tetris9 "left") (make-tetris (make-block (* 8 SIZE) 0) '()))

(define (tetris-move t ke)
  (make-tetris
   (cond [(key=? ke "left")
          (cond [(= (block-x (tetris-block t)) 0) (tetris-block t)]
                [(member? (block-other t -1) (tetris-landscape t)) (tetris-block t)]
                [else (block-other t -1)])]
         [(key=? ke "right")
          (cond [(= (block-x (tetris-block t)) (* 9 SIZE)) (tetris-block t)]
                [(member? (block-other t 1) (tetris-landscape t)) (tetris-block t)]
                [else (block-other t 1)])]
         [else (tetris-block t)])
   (tetris-landscape t)))

; Tetris -> Block
; creates a block in the left (-1) or right (1) column
(define (block-other t p)
  (make-block (+ (block-x (tetris-block t)) (* p SIZE))
              (block-y (tetris-block t))))

; Tetris -> Boolean
; checks if the current block is unable to move
(check-expect (tetris-over tetris0) #false)
(check-expect (tetris-over tetris0-game-over) #true)

(define (tetris-over t)
  (member? (tetris-block t) (tetris-landscape t)))

; TestDrive
(tetris-main (make-tetris (make-block 0 0) '()))
