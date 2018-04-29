;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname |16-Using Abstractions|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 16-Using Abstractions.rkt
;; III - Abstraction
;; 16  - Using Abstractions

(require 2htdp/image)
(require 2htdp/universe)


;; 16.1 - Existing Abstractions

; [X] N [N -> X] -> [List-of X]
; constructs a list by applying f to 0, 1, ..., (sub1 n)
; (build-list n f) == (list (f 0) ... (f (- n 1)))
; (define (build-list n f) ...)

(build-list 3 add1)

; [X] [X -> Boolean] [List-of X] -> [List-of X]
; produces a list from those items on lx for which p holds
; (define (filter p lx) ...)

(filter odd? (list 1 2 3 4 5))

; [X] [List-of X] [X X -> Boolean] -> [List-of X]
; produces a version of lx that is sorted according to cmp
; (define (sort lx cmp) ...)

(sort (list 3 2 1 4 5) >)

; [X Y] [X -> Y] [List-of X] -> [List-of Y]
; constructs a list by applying f to each item on lx
; (map f (list x-1 ... x-n)) == (list (f x-1) ... (f x-n))
; (define (map f lx) ...)

(map add1 (list 1 2 2 3 3 3))

; [X] [X -> Boolean] [List-of X] -> Boolean
; determines whether p holds for every item on lx
; (andmap p (list x-1 ... x-n)) == (and (p x-1) ... (p x-n))
; (define (andmap p lx) ...)

(andmap odd? (list 1 2 3 4 5))

; [X] [X -> Boolean] [List-of X] -> Boolean
; determines whether p holds for at least one item on lx
; (ormap p (list x-1 ... x-n)) == (or (p x-1) ... (p x-n))
; (define (ormap p lx) ...)

(ormap odd? (list 1 2 3 4 5))


; [X Y] [X Y -> Y] Y [List-of X] -> Y
; applies f from right to left to each item in lx and b
; (foldr f b (list x-1 ... x-n)) == (f x-1 ... (f x-n b))
; (define (foldr f b lx) ...)

(foldr + 0 '(1 2 3 4 5))

; [X Y] [X Y -> Y] Y [List-of X] -> Y
; applies f from left to right to each item in lx and b
; (foldl f b (list x-1 ... x-n)) == (f x-n ... (f x-1 b))
; (define (foldl f b lx) ...)

(foldl + 0 '(1 2 3 4 5))


;; Exercise 256


;; =================
;; Data definitions:

; A [NEList-of X] is one of:
; - (cons X '())
; - (cons X [NEList-of X])
; interpretation non-empty lists of X
(define NEL1 (list 5 2 4 7 1))
(define NEL2 (list (make-posn 2 4) (make-posn 3 1) (make-posn 1 5)))


;; =================
;; Functions:

; [X] [X -> Number] [NEList-of X] -> X
; finds the (first) item in lx that maximizes f
; if (argmax f (list x-1 ... x-n)) == x-i,
; then (>= (f x-i) (f x-1)), (>= (f x-i) (f x-2)), ...
(check-expect (argmax  add1 NEL1) 7)
(check-expect (argmax2 add1 NEL1) 7)
(check-expect (argmax  posn-x NEL2) (make-posn 3 1))
(check-expect (argmax2 posn-x NEL2) (make-posn 3 1))
(check-expect (argmax  posn-y NEL2) (make-posn 1 5))
(check-expect (argmax2 posn-y NEL2) (make-posn 1 5))

(define (argmax2 f lx)
  (cond [(empty? (rest lx)) (first lx)]
        [else
         (if (>= (f (first  lx))
                 (f (argmax2 f (rest lx))))
             (first lx)
             (argmax2 f (rest lx)))]))

; argmin: Finds the (first) element of the list that minimizes the output of the function.


(define-struct address [first-name last-name street])
; An Addr is a structure:
;   (make-address String String String)
; interpretation associates an address with a person's name

; [List-of Addr] -> String
; creates a string from first names,
; sorted in alphabetical order,
; separated and surrounded by blank spaces
(define (listing l)
  (foldr string-append-with-space " "
         (sort (map address-first-name l) string<?)))

; String String -> String
; appends two strings, prefixes with " "
(define (string-append-with-space s t)
  (string-append " " s t))

(define ex0 (list (make-address "Robert"  "Findler" "South")
                  (make-address "Matthew" "Flatt"   "Canyon")
                  (make-address "Shriram" "Krishna" "Yellow")))

(check-expect (listing ex0) " Matthew Robert Shriram ")


;; Exercise 257


;; =================
;; Functions:

; [X Y] [X Y -> Y] Y [List-of X] -> Y
; f*oldl works just like foldl
(check-expect (f*oldl cons '() '(a b c)) (foldl cons '() '(a b c)))
(check-expect (f*oldl / 1 '(6 3 2))      (foldl / 1 '(6 3 2)))

(define (f*oldl f e l)
  (foldr f e (reverse l)))

; Natural [Natural -> X] -> [List-of X]
; build-l*st works just like build-list
(check-expect (build-l*st 0 add1) (build-list 0 add1))
(check-expect (build-l*st 5 add1) (build-list 5 add1))

(define (build-l*st n f)
  (cond [(zero? n) '()]
        [else
         (append (build-l*st (sub1 n) f)
                 (list (f (sub1 n))))]))



;; 16.2 - Local Definitions

; (local (def ...)
;   ; — IN —
;   body-expression)

; [List-of Addr] -> String
; creates a string of first names,
; sorted in alphabetical order,
; separated and surrounded by blank spaces
(define (listing.v2 l)
  (local (; 1. extract names
          (define names  (map address-first-name l))
          ; 2. sort the names
          (define sorted (sort names string<?))
          ; 3. append them, add spaces
          ; String String -> String
          ; appends two strings, prefix with " "
          (define (helper s t)
            (string-append " " s t))
          (define concat+spaces
            (foldr helper " " sorted)))
    concat+spaces))

; [List-of Number] [Number Number -> Boolean] -> [List-of Number]
; produces a version of alon, sorted according to cmp
(define (sort-cmp alon0 cmp)
  (local (; [List-of Number] -> [List-of Number]
          ; produces the sorted version of alon
          (define (isort alon)
            (cond [(empty? alon) '()]
                  [else
                   (insert (first alon) (isort (rest alon)))]))

          ; Number [List-of Number] -> [List-of Number]
          ; inserts n into the sorted list of numbers alon
          (define (insert n alon)
            (cond [(empty? alon) (cons n '())]
                  [else
                   (if (cmp n (first alon))
                       (cons n alon)
                       (cons (first alon)
                             (insert n (rest alon))))])))
    (isort alon0)))

;; Exercise 258


;; =================
;; Constants:

; a plain background image
(define MT (empty-scene 50 50))


;; =================
;; Data definitions:

; A Polygon is one of:
; - (list Posn Posn Posn)
; - (cons Posn Polygon)
(define P1 (list (make-posn 20 20) (make-posn 30 20) (make-posn 30 30)))


;; =================
;; Functions:

; Image Polygon -> Image
; adds an image of p to MT
(define (render-polygon img p)
  (local (; Image Posn Posn -> Image
          ; draws a red line from Posn p to Posn q into im
          (define (render-line im p q)
            (scene+line im (posn-x p) (posn-y p) (posn-x q) (posn-y q) "red"))
          ; Polygon -> Posn
          ; extracts the last item from p
          (define (last p)
            (cond [(empty? (rest (rest (rest p)))) (third p)]
                  [else
                   (last (rest p))]))
          ; Image NELoP -> Image
          ; connects the Posns in p in an image
          (define (connect-dots img p)
            (cond [(empty? (rest p)) MT]
                  [else
                   (render-line (connect-dots img (rest p))
                                (first p)
                                (second p))])))
    (render-line (connect-dots img p) (first p) (last p))))


(render-polygon MT P1)

;; Exercise 259


;; =================
;; Data definitions:

; A 1String is a String of length 1,
; including
; - "\\" (the backslash),
; - " " (the space bar),
; - "\t" (tab),
; - "\r" (return), and
; - "\b" (backspace).
; interpretation represents keys on the keyboard

; A Word is one of:
; - '() or
; - (cons 1String Word)
; interpretation a String as a list of 1Strings (letters)

; A [List-of Word] is one of:
; - '() or
; - (cons Word [List-of Word])
; interpretation a collection of Word values


;; =================
;; Functions:

; [List-of String] -> Boolean
(define (all-words-from-rat? w)
  (and (member? "rat" w)
       (member? "art" w)
       (member? "tar" w)))

; String -> [List-of String]
; find all words that the letters of some given word spell
(check-member-of (alternative-words "cat") (list "act" "cat") (list "cat" "act"))
(check-satisfied (alternative-words "rat") all-words-from-rat?)
(check-expect    (alternative-words "")     '())
(check-expect    (alternative-words "test") '())

(define (alternative-words s)
  (local (; String -> Boolean
          ; verifies that the word is in the dictionary
          (define (in-dictionary? w)
            (member? w (list "rat" "art" "tar" "act" "cat" "hello" "world")))
          ; Word -> [List-of Word]
          ; creates all rearrangements of the letters in w
          (define (arrangements w)
            (cond [(empty? w) (list '())]
                  [else
                   (insert-everywhere/in-all-words (first w)
                                                   (arrangements (rest w)))]))
          ; 1String [List-of Word] -> [List-of Word]
          ; result is a list of words like its second argument,
          ; but with the first argument inserted at the beginning,
          ; between all letters, and at the end of all words of the given list
          (define (insert-everywhere/in-all-words 1s low)
            (cond [(empty? low) '()]
                  [else
                   (append (insert-everywhere/in-word 1s '()  (first low))
                           (insert-everywhere/in-all-words 1s (rest low)))]))
          ; 1String Word Word -> [List-of Word]
          ; arrangements the words (prefix sp and suffix ss) with 1String 1s
          (define (insert-everywhere/in-word 1s sp ss)
            (cond [(empty? ss) (list (append sp (list 1s) ss))]
                  [else
                   (cons (append sp (list 1s) ss)
                         (insert-everywhere/in-word 1s
                                                    (append sp (list (first ss)))
                                                    (rest ss)))])))
    (filter in-dictionary?
            (map implode (arrangements (explode s))))))


; Nelon -> Number
; determines the smallest number on l
(define (inf.v2 l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (local ((define smallest-in-rest (inf.v2 (rest l))))
           (if (< (first l) smallest-in-rest)
               (first l)
               smallest-in-rest))]))


;; Exercise 260


;; =================
;; Constants:

; A [NEList-of X] is one of:
; - (cons X '())
; - (cons X [NEList-of X])
; interpretation non-empty lists of X
(define L1 (list 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1))
(define L2 (list 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25))


;; =================
;; Functions:

; Nelon -> Number
; determines the smallest number on l
#;
(define (inf l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (if (< (first l)
                (inf (rest l)))
             (first l)
             (inf (rest l)))]))

(define (inf l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (min (first l)
              (inf (rest l)))]))


; Tests
(time (inf L1))
(time (inf L2))
(time (inf.v2 L1))
(time (inf.v2 L2))

;; Exercise 261


;; =================
;; Data definitions:

(define-struct ir [name price])
; An IR is a structure:
;   (make-ir String Number)
; An Inventory is one of:
; - '()
; - (cons IR Inventory)
(define IR1 '())
(define IR2  (list (make-ir "doll" 21.0)
                   (make-ir "bear" 13.0)
                   (make-ir "ball" 0.50)
                   (make-ir "tv"   5.0)
                   (make-ir "pen"  0.25)))
(define IR3 (append IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1 IR1))


;; =================
;; Functions:

; Inventory -> Inventory
; creates an Inventory from an-inv for all
; those items that cost less than a dollar
(check-expect (extract1 IR1) (extract2 IR1))
(check-expect (extract1 IR2) (extract2 IR2))
(check-expect (extract1 IR3) (extract2 IR3))

(define (extract1 an-inv)
  (cond [(empty? an-inv) '()]
        [else
         (cond [(<= (ir-price (first an-inv)) 1.0)
                (cons (first an-inv)
                      (extract1 (rest an-inv)))]
               [else
                (extract1 (rest an-inv))])]))

(define (extract2 an-inv)
  (cond [(empty? an-inv) '()]
        [else
         (local ((define ext (extract2 (rest an-inv)))
                 (define item (first an-inv)))
           (cond [(<= (ir-price item) 1.0) (cons item ext)]
                 [else ext]))]))


; Tests
(time (extract1 IR1))
(time (extract1 IR2))
(time (extract1 IR3))
(time (extract2 IR1))
(time (extract2 IR2))
(time (extract2 IR3))



;; 16.3 - Local Definitions Add Expressive Power


;; =================
;; Data definitions:

; An FSM is one of:
;   - '()
;   - (cons Transition FSM)

(define-struct transition [current next])
; A Transition is a structure:
;   (make-transition FSM-State FSM-State)

; FSM-State is a Color.

; interpretation An FSM represents the transitions that a
; finite state machine can take from one state to another
; in reaction to keystrokes


;; =================
;; Functions:

; FSM FSM-State -> FSM-State
; matches the keys pressed by a player with the given FSM
(define (simulate fsm s0)
  (local (; State of the World: FSM-State
          ; FSM-State KeyEvent -> FSM-State
          (define (find-next-state s key-event)
            (find fsm s)))
    (big-bang s0
              [to-draw state-as-colored-square]
              [on-key  find-next-state])))

; FSM-State -> Image
; renders current state as colored square
(define (state-as-colored-square s)
  (square 100 "solid" s))

; FSM FSM-State -> FSM-State
; finds the current state in fsm
(define (find transitions current)
  (cond [(empty? transitions) (error "not found")]
        [else
         (local ((define s (first transitions)))
           (if (state=? (transition-current s) current)
               (transition-next s)
               (find (rest transitions) current)))]))

; FSM-State FSM-State -> Boolean
; checks an equality predicate for states
(check-expect (state=? "white" "white")  #true)
(check-expect (state=? "white" "yellow") #false)
(check-expect (state=? "start" "start")  #true)
(check-expect (state=? "start" "expect") #false)

(define (state=? s1 s2)
  (string=? s1 s2))

;; Exercise 262


;; =================
;; Functions:

; Natural -> [List-of [List-of Natural]]
; creates diagonal squares of 0s and 1s
(check-expect (identityM 0) '())
(check-expect (identityM 1) (list (list 1)))
(check-expect (identityM 3) (list (list 1 0 0) (list 0 1 0) (list 0 0 1)))

(define (identityM n)
  (local ((define (rows i)
            (cond [(zero? i) '()]
                  [else
                   (cons (numbers n i)
                         (rows (sub1 i)))]))
          (define (numbers n s)
            (cond [(zero? n) '()]
                  [else
                   (cons (if (= n s) 1 0)
                         (numbers (sub1 n) s))])))
    (rows n)))



;; 16.4 - Computing with local

;; Exercise 263

(= (inf.v2 (list 2 1 3)) 1)

;; Exercise 264


;; =================
;; Data definitions:

; A [NEList-of X] is one of:
; - (cons X '())
; - (cons X [NEList-of X])
; interpretation non-empty lists of X


;; =================
;; Functions:

; Nelon -> Number
; determines the largest number on l
(define (sup.v2 l)
  (cond [(empty? (rest l)) (first l)]
        [else
         (local ((define smallest-in-rest (sup.v2 (rest l))))
           (if (> (first l) smallest-in-rest)
               (first l)
               smallest-in-rest))]))

(= (sup.v2 (list 2 1 3)) 3)

;; Exercise 265

(define result.v1 (local ((define (f x)
                         (+ (* 4 (sqr x)) 3)))
                 f))
(result.v1 1)

;; Exercise 266

(define result.v2 (local ((define (f x) (+ x 3))
                       (define (g x) (* x 4)))
                 (if (odd? (f (g 1)))
                     f
                     g)))
(result.v2 2)



;; 16.5 - Using Abstractions, by Example


;; =================
;; Functions:

; [List-of Posn] -> [List-of Posn]
; adds 3 to each x-coordinate on the given list
(check-expect (add-3-to-all (list (make-posn 3 1) (make-posn 0 0)))
              (list (make-posn 6 1) (make-posn 3 0)))

#;
(define (add-3-to-all lop) '())

#;
(define (add-3-to-all lop)
  (local (; Posn -> Posn
          ; ...
          (define (fp p)
            ... p ...))
    (map fp lop)))

(define (add-3-to-all lop)
  (local (; Posn -> Posn
          ; adds 3 to the x-coordinate of p
          (define (add-3-to-1 p)
            (make-posn (+ (posn-x p) 3) (posn-y p))))
    (map add-3-to-1 lop)))

; [List-of Posn] -> [List-of Posn]
; eliminates Posns whose y-coordinate is > 100
(check-expect (keep-good (list (make-posn 0 110) (make-posn 0 60)))
              (list (make-posn 0 60)))

#;
(define (keep-good lop) '())

#;
(define (keep-good lop)
  (local (; Posn -> Boolean
          ; should this Posn stay on the list
          (define (good? p) #true))
    (filter good? lop)))

(define (keep-good lop)
  (local (; Posn -> Posn
          ; should this Posn stay on the list
          (define (good? p)
            (not (> (posn-y p) 100))))
    (filter good? lop)))

; Posn Posn Number -> Boolean
; is the distance between p and q less than d
(define (close-to p q d)
  (<= (sqrt (+ (sqr (- (posn-x q) (posn-x p)))
               (sqr (- (posn-y q) (posn-y p)))))
      d))

; [List-of Posn] Posn -> Boolean
; is any Posn on lop close to pt
(check-expect (close? (list (make-posn 47 54) (make-posn 0 60)) (make-posn 50 50))
              #true)

#;
(define (close? lop pt) #false)

#;
(define (close? lop pt)
  (local (; Posn -> Boolean
          ; ...
          (define (is-one-close? p)
            ...))
    (ormap close-to? lop)))

(define (close? lop pt)
  (local (; Posn -> Boolean
          ; is one shot close to pt
          (define (is-one-close? p)
            (close-to p pt CLOSENESS)))
    (ormap is-one-close? lop)))

(define CLOSENESS 5) ; in terms of pixels



;; 16.6 - Designing with Abstractions


;; =================
;; Constants:

(define WIDTH  100)
(define HEIGHT 180)
(define DOT (circle 4 "solid" "red"))
(define MT-SCENE (empty-scene WIDTH HEIGHT))


;; =================
;; Functions:

; [List-of Posn] -> Image
; adds the Posns on lop to the empty scene
(check-expect (dots (list (make-posn 12 31)))
              (place-image DOT 12 31 MT-SCENE))

#;
(define (dots lop)
  MT-SCENE)

#;
(define (dots lop)
  (local (; Posn Image -> Image
          (define (add-one-dot p scene) ...))
    (foldr add-one-dot MT-SCENE lop)))

(define (dots lop)
  (local (; Posn Image -> Image
          ; adds a DOT at p to scene
          (define (add-one-dot p scene)
            (place-image DOT
                         (posn-x p) (posn-y p)
                         scene)))
    (foldr add-one-dot MT-SCENE lop)))

; foldr : [X Y] [X Y -> Y] Y [List-of X] -> Y
; foldl : [X Y] [X Y -> Y] Y [List-of X] -> Y
