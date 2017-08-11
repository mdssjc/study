;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname genrec-quiz) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; genrec-quiz.rkt

(require 2htdp/image)
(require racket/list)


;; PROBLEM 1:
;;
;; In the lecture videos we designed a function to make a Sierpinski triangle fractal.
;;
;; Here is another geometric fractal that is made of circles rather than triangles:
;;
;; [Circle Fractal]
;;
;; Design a function to create this circle fractal of size n and colour c.

(define CUT-OFF 5)

;; Natural String -> Image
;; produce a circle fractal of size n and colour c
(check-expect (circle-fractal CUT-OFF "blue")
              (circle CUT-OFF "outline" "blue"))
(check-expect (circle-fractal (* CUT-OFF 2) "blue")
              (overlay (circle (* CUT-OFF 2) "outline" "blue")
                       (beside (circle CUT-OFF "outline" "blue")
                               (circle CUT-OFF "outline" "blue"))))

;(define (circle-fractal n c) empty-image) ; Stub

(define (circle-fractal n c)
  (cond [(<= n CUT-OFF) (circle n "outline" c)]
        [else
         (local ((define sub (circle-fractal (/ n 2) c)))
           (overlay (circle n "outline" c)
                    (beside sub sub)))]))

;; PROBLEM 2:
;;
;; Below you will find some data definitions for a tic-tac-toe solver.
;;
;; In this problem we want you to design a function that produces all
;; possible filled boards that are reachable from the current board.
;;
;; In actual tic-tac-toe, O and X alternate playing. For this problem
;; you can disregard that. You can also assume that the players keep
;; placing Xs and Os after someone has won. This means that boards that
;; are completely filled with X, for example, are valid.
;;
;; Note: As we are looking for all possible boards, rather than a winning
;; board, your function will look slightly different than the solve function
;; you saw for Sudoku in the videos, or the one for tic-tac-toe in the
;; lecture questions.

;; Value is one of:
;; - false
;; - "X"
;; - "O"
;; interp. a square is either empty (represented by false) or has and "X" or an "O"

#;
(define (fn-for-value v)
  (cond [(false? v) (...)]
        [(string=? v "X") (...)]
        [(string=? v "O") (...)]))

;; Board is (listof Value)
;; a board is a list of 9 Values
(define B0 (list false false false
                 false false false
                 false false false))

(define B1 (list false "X"   "O"   ; a partly finished board
                 "O"   "X"   "O"
                 false false "X"))

(define B2 (list "X"  "X"  "O"     ; a board where X will win
                 "O"  "X"  "O"
                 "X" false "X"))

(define B3 (list "X" "O" "X"       ; a board where Y will win
                 "O" "O" false
                 "X" "X" false))

#;
(define (fn-for-board b)
  (cond [(empty? b) (...)]
        [else
         (... (fn-for-value (first b))
              (fn-for-board (rest b)))]))

;; Board -> Board or false
;; produce a solution for b; or false if b is unsolvable
;; ASSUME: b is valid
(check-expect (solve (list "X" "O"   "O"
                           "O" "X"   "X"
                           "X" false "O")) false)
(check-expect (solve B2) (list "X" "X"   "O"
                               "O" "X"   "O"
                               "X" false "X"))
(check-expect (solve B3) (list "X" "O" "X"
                               "O" "O" "O"
                               "X" "X" false))

;(define (solve b) false) ; Stub

(define (solve b)
  (local ((define (solve--bd b)
            (if (solved? b)
                b
                (solve--lob (next-boards b))))

          (define (solve--lob lob)
            (cond [(empty? lob) false]
                  [else
                   (local ((define try (solve--bd (first lob))))
                     (if (not (false? try))
                         try
                         (solve--lob (rest lob))))])))
    (solve--bd b)))

;; Board -> Boolean
;; produce true if board is solved
;; ASSUME: board is valid, so it is solved if it is full
(check-expect (solved? B1) false)
(check-expect (solved? B2) true)
(check-expect (solved? B3) false)
(check-expect (solved? (list "X" "X" "O"
                             "O" "O" "X"
                             "X" "X" "X")) true)

;(define (solved? b) false) ; Stub

(define (solved? b)
  (local ((define (pass? p1 p2 p3)
            (local ((define st (first (drop b p1)))
                    (define nd (first (drop b p2)))
                    (define rd (first (drop b p3))))
              (cond [(or (false? st)
                         (false? nd)
                         (false? rd)) false]
                    [else
                     (string=? st nd rd)]))))
    (or (pass? 0 1 2)
        (pass? 3 4 5)
        (pass? 6 7 8)
        (pass? 0 3 6)
        (pass? 1 4 7)
        (pass? 2 5 8)
        (pass? 0 4 8)
        (pass? 2 4 6))))

;; Board -> (listof Board)
;; produce list of valid next boards from board
;; finds first empty slot, fills it with Value
(check-expect (next-boards B2) (list (list "X" "X" "O"
                                           "O" "X" "O"
                                           "X" "X" "X")
                                     (list "X" "X" "O"
                                           "O" "X" "O"
                                           "X" "O" "X")))

;(define (next-boards b) empty) ; Stub

(define (next-boards b)
  (fill-with-value (find-slot b) b))

;; Board -> Pos
;; produces the position of the first slot square
;; ASSUME: the board has at least one slot square
(check-expect (find-slot B0) 0)
(check-expect (find-slot B1) 0)
(check-expect (find-slot B2) 7)
(check-expect (find-slot B3) 5)

;(define (find-slot b) 0) ; Stub

(define (find-slot b)
  (cond [(empty? b) (error "The board didn't have a slot space.")]
        [else
         (if (false? (first b))
             0
             (+ 1 (find-slot (rest b))))]))

;; Pos Board -> (listof Board)
;; produce 2 boards, with slot filled with Value
(check-expect (fill-with-value 7 B2) (list (list "X" "X" "O"
                                                 "O" "X" "O"
                                                 "X" "X" "X")
                                           (list "X" "X" "O"
                                                 "O" "X" "O"
                                                 "X" "O" "X")))

;(define (fill-with-value p b) empty) ; Stub

(define (fill-with-value p b)
  (local ((define (build-one n)
            (fill-slot b p (if (zero? n) "X" "O")))

          (define (fill-slot b p v)
            (append (take b p)
                    (list v)
                    (drop b (add1 p)))))
    (build-list 2 build-one)))

;; PROBLEM 3:
;;
;; Now adapt your solution to filter out the boards that are impossible if
;; X and O are alternating turns. You can continue to assume that they keep
;; filling the board after someone has won though.
;;
;; You can assume X plays first, so all valid boards will have 5 Xs and 4 Os.
;;
;; NOTE: make sure you keep a copy of your solution from problem 2 to answer
;; the questions on edX.
