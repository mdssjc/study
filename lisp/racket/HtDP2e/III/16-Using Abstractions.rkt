;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname |16-Using Abstractions|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 16-Using Abstractions.rkt
;; III - Abstraction
;; 16  - Using Abstractions

(require 2htdp/image)


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
