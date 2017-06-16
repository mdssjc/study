;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname making-rain-filtered) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; making-rain-filtered.rkt
;; Helpers P2 - Making Rain Filtered

(require 2htdp/image)
(require 2htdp/universe)


;; PROBLEM:
;;
;; Design a simple interactive animation of rain falling down a screen. Wherever we click,
;; a rain drop should be created and as time goes by it should fall. Over time the drops
;; will reach the bottom of the screen and "fall off". You should filter these excess
;; drops out of the world state - otherwise your program is continuing to tick and
;; and draw them long after they are invisible.
;;
;; In your design pay particular attention to the helper rules. In our solution we use
;; these rules to split out helpers:
;;   - function composition
;;   - reference
;;   - knowledge domain shift
;;
;;
;; NOTE: This is a fairly long problem.  While you should be getting more comfortable with
;; world problems there is still a fair amount of work to do here. Our solution has 9
;; functions including main. If you find it is taking you too long then jump ahead to the
;; next homework problem and finish this later.

;; Make it rain where we want it to.

;; =================
;; Constants:

(define WIDTH  300)
(define HEIGHT 300)
(define SPEED 1)
(define DROP (ellipse 4 8 "solid" "blue"))
(define MTS (rectangle WIDTH HEIGHT "solid" "light blue"))


;; =================
;; Data definitions:

(define-struct drop (x y))
;; Drop is (make-drop Integer Integer)
;; interp. A raindrop on the screen, with x and y coordinates.
(define D1 (make-drop 10 30))
(define D2 (make-drop 50 20))
(define D3 (make-drop 10 HEIGHT))

#;
(define (filter? d)
  (... (drop-x d)
       (drop-y d)))

;; Template Rules used:
;; - compound: 2 fields

;; ListOfDrop is one of:
;;  - empty
;;  - (cons Drop ListOfDrop)
;; interp. a list of drops
(define LOD1 empty)
(define LOD2 (cons (make-drop 10 20) (cons (make-drop 3 6) empty)))
(define LOD3 (cons (make-drop 10 HEIGHT) (cons (make-drop 3 6) empty)))

#;
(define (fn-for-lod lod)
  (cond [(empty? lod) (...)]
        [else
         (... (filter? (first lod))
              (fn-for-lod (rest lod)))]))

;; Template Rules used:
;; - one-of: 2 cases
;; - atomic distinct: empty
;; - compound: (cons Drop ListOfDrop)
;; - reference: (first lod) is Drop
;; - self reference: (rest lod) is ListOfDrop


;; =================
;; Functions:

;; ListOfDrop -> ListOfDrop
;; start rain program by evaluating (main empty)
(define (main lod)
  (big-bang lod
            (on-mouse handle-mouse)   ; ListOfDrop Integer Integer MouseEvent -> ListOfDrop
            (on-tick  next-drops)     ; ListOfDrop -> ListOfDrop
            (to-draw  render-drops))) ; ListOfDrop -> Image

;; ListOfDrop Integer Integer MouseEvent -> ListOfDrop
;; if mevt is "button-down" add a new drop at that position
(check-expect (handle-mouse LOD1 10 10 "button-up")        empty)
(check-expect (handle-mouse LOD1 10 30 "button-down")      (list D1))
(check-expect (handle-mouse (list D1) 50 20 "button-up")   (list D1))
(check-expect (handle-mouse (list D1) 50 20 "button-down") (list D2 D1))

;(define (handle-mouse lod x y mevt) empty) ; Stub

(define (handle-mouse lod x y mevt)
  (cond [(mouse=? mevt "button-down")
         (insert-drop x y lod)]
        [else lod]))

;; Drop ListOfDrop -> ListOfDrop
;; insert drop d in ListOfDrop lod
(check-expect (insert-drop 10 30 empty)     (list D1))
(check-expect (insert-drop 50 20 (list D1)) (list D2 D1))

;(define (insert-drop x y lod) empty) ; Stub

(define (insert-drop x y lod)
  (cons (make-drop x y) lod))

;; ListOfDrop -> ListOfDrop
;; produce filtered and ticked list of drops
(check-expect (next-drops LOD1) empty)
(check-expect (next-drops LOD2) (list (make-drop 10 21) (make-drop 3 7)))
(check-expect (next-drops LOD3) (list (make-drop 3 7)))

;(define (next-drops lod) empty) ; Stub

(define (next-drops lod)
  (cond [(empty? lod) empty]
        [else
         (filter-drops (uptade-drop (first lod))
                       (next-drops (rest lod)))]))

;; Drop -> Drop
;; update the y position by SPEED
(check-expect (uptade-drop D1) (make-drop 10 (+ (drop-y D1) SPEED)))

;(define (uptade-drop d) d) ; Stub

(define (uptade-drop d)
  (make-drop (drop-x d)
             (+ (drop-y d) SPEED)))

;; Drop ListOfDrop -> ListOfDrop
;; filter the drop d to the list lod
(check-expect (filter-drops D1 empty) (list D1))
(check-expect (filter-drops D3 empty) empty)

;(define (filter-drops d lod) empty) ; Stub

(define (filter-drops d lod)
  (cond [(filter? d) lod]
        [else (cons d lod)]))

;; Drop -> Boolean
;; check if the y position of the drop d is equal or after HEIGHT
(check-expect (filter? D1) false)
(check-expect (filter? D2) false)
(check-expect (filter? D3) true)

;(define (filter? d) false) ; Stub

(define (filter? d)
  (>= (drop-y d) HEIGHT))

;; ListOfDrop -> Image
;; render the drops onto MTS
(check-expect (render-drops LOD1) MTS)
(check-expect (render-drops LOD2)
              (place-image DROP 10 20 (place-image DROP 3 6 MTS)))

;(define (render-drops lod) MTS) ; Stub

(define (render-drops lod)
  (cond [(empty? lod) MTS]
        [else
         (place-image DROP (drop-x (first lod)) (drop-y (first lod))
                      (render-drops (rest lod)))]))
