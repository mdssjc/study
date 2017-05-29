;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname spinning-bears) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; spinning-bears.rkt
;; Reference P2 - Spinning Bears

(require 2htdp/image)
(require 2htdp/universe)


;; PROBLEM:
;;
;; In this problem you will design another world program. In this program the changing
;; information will be more complex - your type definitions will involve arbitrary
;; sized data as well as the reference rule and compound data. But by doing your
;; design in two phases you will be able to manage this complexity. As a whole, this problem
;; will represent an excellent summary of the material covered so far in the course, and world
;; programs in particular.
;;
;; This world is about spinning bears. The world will start with an empty screen. Clicking
;; anywhere on the screen will cause a bear to appear at that spot. The bear starts out upright,
;; but then rotates counterclockwise at a constant speed. Each time the mouse is clicked on the
;; screen, a new upright bear appears and starts spinning.
;;
;; So each bear has its own x and y position, as well as its angle of rotation. And there are an
;; arbitrary amount of bears.
;;
;; To start, design a world that has only one spinning bear. Initially, the world will start
;; with one bear spinning in the center at the screen. Clicking the mouse at a spot on the
;; world will replace the old bear with a new bear at the new spot. You can do this part
;; with only material up through compound.
;;
;; Once this is working you should expand the program to include an arbitrary number of bears.
;;
;; Here is an image of a bear for you to use: [Bear Image]

;; Constants:

(define BEAR (overlay/align "middle" "top"
                            (circle 10 "solid" "blue")
                            (rectangle 8 30 "solid" "blue")))
(define SPEED -2)
(define WIDTH  320)
(define HEIGHT 200)
(define CENTER-X (/ WIDTH  2))
(define CENTER-Y (/ HEIGHT 2))
(define MTS (empty-scene WIDTH HEIGHT))


;; Data definitions

(define-struct bear (first? x y angle))
;; Bear is (make-bear Boolean Natural[0, WIDTH] Natural[0, HEIGHT] Natural[0, 360))
;; interp. a bear with predicate for first at position x, y and rotation angle
(define BEAR1 (make-bear #true CENTER-X CENTER-Y 0))
(define BEAR2 (make-bear #false CENTER-X CENTER-Y 0))
(define BEAR3 (make-bear #false 0 0 0))
(define BEAR4 (make-bear #false CENTER-X CENTER-Y 180))
(define BEAR5 (make-bear #false WIDTH HEIGHT 359))

#;
(define (fn-for-bear b)
  (... (bear-first? b)  ; Boolean
       (bear-x b)       ; Natural[0, WIDTH]
       (bear-y b)       ; Natural[0, HEIGHT]
       (bear-angle b))) ; Natural[0, 360)

;; Template rules used:
;;  - compound: 4 fields

;; ListOfBear is one of:
;; - empty
;; - (cons Bear ListOfBear)
;; interp. a list of bears
(define LOB1 empty)
(define LOB2 (cons BEAR1 empty))
(define LOB3 (cons BEAR1 (cons BEAR2 empty)))

#;
(define (fn-for-lob lob)
  (cond [(empty? lob) (...)]                   ; Base Case
        [else (... (first lob)                 ; Bear
                   (fn-for-lob (rest lob)))])) ; Natural Recursion

;; Template rules used:
;;  - one of: 2 cases
;;  - atomic distinct: empty
;;  - compound: (cons Bear ListOfBear)
;;  - self-reference: (rest lob) is ListOfBear


;; Functions:

;; ListOfBear -> ListOfBear
;; start the world with (main BEAR1)
(define (main b)
  (big-bang b                     ; ListOfBear
            (on-tick   tock)      ; ListOfBear -> ListOfBear
            (to-draw   render)    ; ListOfBear -> Image
            (on-mouse  handler))) ; ListOfBear Integer Integer MouseEvent -> ListOfBear

;; ListOfBear -> ListOfBear
;; produce the next bear
;; !!!
(define (tock b) ...)

;; ListOfBear -> Image
;; render the bears on MTS at x, y position
(check-expect (render LOB1) MTS)
(check-expect (render LOB2) (place-image BEAR CENTER-X CENTER-Y MTS))
(check-expect (render (list BEAR4)) (place-image (rotate -180 BEAR) CENTER-X CENTER-Y MTS))

;(define (render b) MTS) ; stub

(define (render lob)
  (cond [(empty? lob) MTS]          
        [else (place-image (rotate (bear-angle (first lob)) BEAR)
                           (bear-x (first lob))
                           (bear-y (first lob))
                           (render (rest lob)))]))

;; ListOfBear Integer Integer MouseEvent -> ListOfBear
;; add a new bear upright in x, y position of the mouse
(check-expect (handler empty 10 10 "button-down") (list (make-bear #false 10 10 0)))
(check-expect (handler LOB3 10 10 "button-down") (cons (make-bear #false 10 10 0) LOB3))
(check-expect (handler empty 10 10 "move") empty)
(check-expect (handler LOB3 10 10 "move") LOB3)

;(define (handler lob x y me) empty) ; stub

(define (handler lob x y me)
  (cond [(mouse=? "button-down" me) (cons (make-bear #false x y 0) lob)]
        [else lob]))