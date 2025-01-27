;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname max-exits-to) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
;; max-exits-to.rkt
;; Graphs P5 - Max Exits To
;; Design a function that produces a room to which the greatest number
;; of other rooms have exits.


;; PROBLEM:
;;
;; Using the following data definition, design a function that produces the room to which the greatest
;; number of other rooms have exits (in the case of a tie you can produce any of the rooms in the tie).

;; Data Definitions:

(define-struct room (name exits))
;; Room is (make-room String (listof Room))
;; interp. the room's name, and list of rooms that the exits lead to

;; A -> B
(define H1 (make-room "A" (list (make-room "B" empty))))

;; A -> B -> A
(define H2
  (shared ((-0- (make-room "A" (list (make-room "B" (list -0-))))))
    -0-))

;; A -> B -> C -> A
(define H3
  (shared ((-A- (make-room "A" (list -B-)))
           (-B- (make-room "B" (list -C-)))
           (-C- (make-room "C" (list -A-))))
    -A-))

;; A -> B D
;; B -> C E
;; C -> B
;; D -> E
;; E -> F A
;; F
(define H4
  (shared ((-A- (make-room "A" (list -B- -D-)))
           (-B- (make-room "B" (list -C- -E-)))
           (-C- (make-room "C" (list -B-)))
           (-D- (make-room "D" (list -E-)))
           (-E- (make-room "E" (list -F- -A-)))
           (-F- (make-room "F" (list))))
    -A-))

;; template: structural recursion, encapsulate w/ local, tail-recursive w/ worklist,
;;           context-preserving accumulator what rooms have we already visited

(define (fn-for-house r0)
  ;; todo is (listof Room); a worklist accumulator
  ;; visited is (listof String); context preserving accumulator, names of rooms already visited
  (local [(define (fn-for-room r todo visited)
            (if (member (room-name r) visited)
                (fn-for-lor todo visited)
                (fn-for-lor (append (room-exits r) todo)
                            (cons (room-name r) visited)))) ; (... (room-name r))
          (define (fn-for-lor todo visited)
            (cond [(empty? todo) (...)]
                  [else
                   (fn-for-room (first todo)
                                (rest todo)
                                visited)]))]
    (fn-for-room r0 empty empty)))


;; Functions:

;; Using the following data definition, design a function that produces the room to which the greatest
;; number of other rooms have exits (in the case of a tie you can produce any of the rooms in the tie).

;; Room -> Room
;; produces the room to which the greatest number of other rooms have exits
(check-expect (max-exits-to H1) (first (room-exits H1)))
(check-expect (max-exits-to H2) (first (room-exits H2)))
(check-expect (max-exits-to H3) (first (room-exits H3)))
(check-expect (max-exits-to H4) (first (room-exits H4)))
(check-expect (max-exits-to (first (rest (room-exits H4))))
              (first (rest (room-exits (first (room-exits H4))))))

(define (max-exits-to r0)
  ;; todo is (listof Room); a worklist accumulator
  ;; visited is (listof String); context preserving accumulator, names of rooms already visited
  ;; rsf is Room; the room to which the greatest number of other rooms have exits
  (local [(define (fn-for-room r todo visited rsf)
            (if (member (room-name r) visited)
                (fn-for-lor todo visited rsf)
                (fn-for-lor (append (room-exits r) todo)
                            (cons (room-name r) visited)
                            (append rsf (room-exits r))))) ; (... (room-name r))

          (define (fn-for-lor todo visited rsf)
            (cond [(empty? todo) (max-exits rsf)]
                  [else
                   (fn-for-room (first todo)
                                (rest todo)
                                visited
                                rsf)]))

          (define (count-exits r rsf)
            (length (filter (lambda (r)
                              (string=? (room-name r) (room-name r)))
                            rsf)))

          (define (max-exits r)
            (cond [(empty? r) empty]
                  [else
                   (local ((define try (max-exits (rest r))))
                     (if (>= (count-exits (first r) r)
                             (count-exits try r))
                         (first r)
                         try))]))]
    (fn-for-room r0 empty empty empty)))
