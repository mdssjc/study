;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname |19-The Poetry of S-expressions|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 19-The Poetry of S-expressions.rkt
;; IV - Intertwined Data
;; 19 - The Poetry of S-expressions



;; 19.1 - Trees


;; =================
;; Data definitions:

(define-struct no-parent [])
(define NP (make-no-parent))
(define-struct child [father mother name date eyes])
; An FT is one of:
; - NP
; - (make-child FT FT String N String)

; Oldest Generation:
(define Carl    (make-child NP NP "Carl"    1926 "green"))
(define Bettina (make-child NP NP "Bettina" 1926 "green"))

; Middle Generation:
(define Adam (make-child Carl Bettina "Adam" 1950 "hazel"))
(define Dave (make-child Carl Bettina "Dave" 1955 "black"))
(define Eva  (make-child Carl Bettina "Eva"  1965 "blue"))
(define Fred (make-child NP NP "Fred" 1966 "pink"))

; Youngest Generation:
(define Gustav (make-child Fred Eva "Gustav" 1988 "brown"))


;; =================
;; Functions:

; FT -> ???
#;
(define (fun-FT an-ftree)
  (cond [(no-parent? an-ftree) ...]
        [else
         (... (fun-FT (child-father an-ftree)) ...
              ... (fun-FT (child-mother an-ftree)) ...
              ... (child-name an-ftree) ...
              ... (child-date an-ftree) ...
              ... (child-eyes an-ftree) ...)]))

; FT -> Boolean
; does an-ftree contain a child
; structure with "blue" in the eyes field
(check-expect (blue-eyed-child? Carl)   #false)
(check-expect (blue-eyed-child? Gustav) #true)

(define (blue-eyed-child? an-ftree)
  (cond [(no-parent? an-ftree) #false]
        [else
         (or (string=? (child-eyes an-ftree) "blue")
             (blue-eyed-child? (child-father an-ftree))
             (blue-eyed-child? (child-mother an-ftree)))]))

;; Exercise 310


;; =================
;; Functions:

; FT -> Natural
; counts the child structures in the tree
(check-expect (count-child NP)     0)
(check-expect (count-child Carl)   1)
(check-expect (count-child Gustav) 5)

(define (count-child ft)
  (cond [(no-parent? ft) 0]
        [else
         (+ 1
            (count-child (child-father ft))
            (count-child (child-mother ft)))]))

;; Exercise 311


;; =================
;; Constants:

(define CURRENT-YEAR 2000)


;; =================
;; Functions:

; FT Number -> Number
; produces the average age of all child structures in the family tree
(check-expect (average-age NP     CURRENT-YEAR) 0)
(check-expect (average-age Carl   CURRENT-YEAR) 74)
(check-expect (average-age Adam   CURRENT-YEAR) (- 2000 (/ (+ 1950 1926 1926) 3)))
(check-expect (average-age Gustav CURRENT-YEAR) (- 2000 (/ (+ 1988 1966 1965 1926 1926) 5)))

(define (average-age ft year)
  (local ((define (sum-dates ft)
            (cond [(no-parent? ft) 0]
                  [else
                   (+ (child-date ft)
                      (sum-dates (child-father ft))
                      (sum-dates (child-mother ft)))]))
          (define fn-for-average-age
            (cond [(no-parent? ft) 0]
                  [else
                   (- year
                      (/ (sum-dates   ft)
                         (count-child ft)))])))
    fn-for-average-age))

;; Exercise 312


;; =================
;; Functions:

; FT -> [List-of String]
; produces a list of all eye colors in the tree
(check-expect (eye-colors NP)     '())
(check-expect (eye-colors Carl)   '("green"))
(check-expect (eye-colors Gustav) '("brown" "pink" "blue" "green" "green"))

(define (eye-colors ft)
  (cond [(no-parent? ft) '()]
        [else
         (cons (child-eyes ft)
               (append (eye-colors (child-father ft))
                       (eye-colors (child-mother ft))))]))

;; Exercise 313


;; =================
;; Functions:

; FT -> Boolean
; responds with #true only when a proper ancestor not the given child itself,
; has blue eyes
(check-expect (blue-eyed-ancestor? Eva)    #false)
(check-expect (blue-eyed-ancestor? Gustav) #true)

(define (blue-eyed-ancestor? an-ftree)
  (cond [(no-parent? an-ftree) #false]
        [else
         (or (blue-eyed-child? (child-father an-ftree))
             (blue-eyed-child? (child-mother an-ftree)))]))



;; 19.2 - Forests


;; =================
;; Data definitions:

; An FF (short for family forest) is one of:
; - '()
; - (cons FT FF)
; interpretation a family forest represents several
; families (say, a town) and their ancestor trees
(define ff1 (list Carl Bettina))
(define ff2 (list Fred Eva))
(define ff3 (list Fred Eva Carl))

;; Exercise 314


;; =================
;; Functions:

; FF -> Boolean
; does the forest contain any child with "blue" eyes
(check-expect (blue-eyed-child-in-forest? ff1) #false)
(check-expect (blue-eyed-child-in-forest? ff2) #true)
(check-expect (blue-eyed-child-in-forest? ff3) #true)

#;
(define (blue-eyed-child-in-forest? a-forest)
  (cond [(empty? a-forest) #false]
        [else
         (or (blue-eyed-child? (first a-forest))
             (blue-eyed-child-in-forest? (rest a-forest)))]))

(define (blue-eyed-child-in-forest? a-forest)
  (local (; [X -> Boolean] [List-of X] -> Boolean
          ; determines whether p? holds for at least one items of l
          (define (ormap2 p? l)
            (cond [(empty? l) #false]
                  [else
                   (or (p? (first l))
                       (ormap2 p? (rest l)))])))
    (ormap2 blue-eyed-child? a-forest)))

;; Exercise 315


;; =================
;; Functions:

; [List-of FT] Number -> Number
; produces the average age of all child instances in the forest
(check-expect (average-age.v2 ff1 CURRENT-YEAR) 74)
(check-expect (average-age.v2 ff2 CURRENT-YEAR) 54.25)
(check-expect (average-age.v2 ff3 CURRENT-YEAR) 58.2)

(define (average-age.v2 lox n)
  (local ((define (sum-dates ft)
            (cond [(no-parent? ft) 0]
                  [else
                   (+ (- n (child-date ft))
                      (sum-dates (child-father ft))
                      (sum-dates (child-mother ft)))]))
          (define (count-child ft)
            (cond [(no-parent? ft) 0]
                  [else
                   (+ 1
                      (count-child (child-father ft))
                      (count-child (child-mother ft)))])))
    (/ (foldr + 0 (map sum-dates   lox))
       (foldr + 0 (map count-child lox)))))



;; 19.3 - S-expressions


;; =================
;; Data definitions:

; An S-expr is one of:
; - Atom
; - SL

; An SL is one of:
; - '()
; - (cons S-expr SL)

; An Atom is one of:
; - Number
; - String
; - Symbol

;; Exercise 316


;; =================
;; Functions:

; Atom -> Boolean
; predicates if it's an atom
(check-expect (atom? #true) #false)
(check-expect (atom? 1)     #true)
(check-expect (atom? "abc") #true)
(check-expect (atom? 'sb)   #true)

(define (atom? a)
  (or (number? a)
      (string? a)
      (symbol? a)))

;; Templates

#;
(define (count sexp sy)
  (cond [(atom? sexp) (count-atom sexp sy)]
        [else
         (count-sl sexp sy)]))

#;
(define (count-sl sl sy)
  (cond [(empty? sl) ...]
        [else
         (...
          (count (first sl) sy)
          ...
          (count-sl (rest sl) sy)
          ...)]))

#;
(define (count-atom at sy)
  (cond [(number? at) ...]
        [(string? at) ...]
        [(symbol? at) ...]))

; S-expr Symbol -> N
; counts all occurrences of sy in sexp
(check-expect (count 'world 'hello) 0)
(check-expect (count '(world hello) 'hello) 1)
(check-expect (count '(((world) hello) hello) 'hello) 2)

(define (count sexp sy)
  (cond [(atom? sexp) (count-atom sexp sy)]
        [else
         (count-sl sexp sy)]))

; SL Symbol -> N
; counts all occurrences of sy in sl
(define (count-sl sl sy)
  (cond [(empty? sl) 0]
        [else
         (+ (count    (first sl) sy)
            (count-sl (rest  sl) sy))]))

; Atom Symbol -> N
; counts all occurrences of sy in at
(define (count-atom at sy)
  (cond [(number? at) 0]
        [(string? at) 0]
        [(symbol? at) (if (symbol=? at sy) 1 0)]))

;; Exercise 317


;; =================
;; Functions:

; S-expr Symbol -> N
; counts all occurrences of sy in sexp
(check-expect (count.v2 'world 'hello) 0)
(check-expect (count.v2 '(world hello) 'hello) 1)
(check-expect (count.v2 '(((world) hello) hello) 'hello) 2)

(define (count.v2 sexp sy)
  (local (; S-expr -> N
          (define (count sexp)
            (cond [(atom? sexp) (count-atom sexp)]
                  [else
                   (count-sl sexp)]))

          ; SL -> N
          (define (count-sl sl)
            (cond [(empty? sl) 0]
                  [else
                   (+ (count    (first sl))
                      (count-sl (rest  sl)))]))

          ; Atom -> N
          (define (count-atom at)
            (cond [(number? at) 0]
                  [(string? at) 0]
                  [(symbol? at) (if (symbol=? at sy) 1 0)])))

    (count sexp)))

;; Exercise 318


;; =================
;; Functions:

; S-expr -> Number
; determines its depth
(check-expect (depth 12) 1)
(check-expect (depth '(12)) 1)
(check-expect (depth '(12 12)) 2)

(define (depth sexp)
  (local (; S-expr -> N
          (define (depth sexp)
            (cond [(atom? sexp) 1]
                  [else
                   (depth-sl sexp)]))

          ; SL -> N
          (define (depth-sl sl)
            (cond [(empty? sl) 0]
                  [else
                   (+ (depth    (first sl))
                      (depth-sl (rest  sl)))])))

    (depth sexp)))

;; Exercise 319


;; =================
;; Functions:

; S-expr Symbol Symbol -> S-expr
; substitutes all occurrences of old by new in S-expression s
(check-expect (substitute 1 'abc 'cba) 1)
(check-expect (substitute '(1 abc def)     'cba 'abc) '(1 cba def))
(check-expect (substitute '(1 abc cba abc) 'cba 'abc) '(1 cba cba cba))

(define (substitute s new old)
  (local (; S-expr -> S-expr
          (define (substitute s)
            (cond [(atom? s) (replace-symbol s)]
                  [else
                   (substitute-sl s)]))

          ; S-expr -> S-expr
          (define (substitute-sl sl)
            (cond [(empty? sl) '()]
                  [else
                   (cons (substitute    (first sl))
                         (substitute-sl (rest  sl)))]))

          ; S-expr -> S-expr
          (define (replace-symbol s)
            (cond [(number? s) s]
                  [(string? s) s]
                  [(symbol? s) (if (symbol=? s old) new s)])))

    (substitute s)))

;; Exercise 320


;; =================
;; Data definitions:

; A S-expr.v2 is one of:
; - Number
; - String
; - Symbol
; - [List-of S-expr.v2]


;; =================
;; Functions:

; S-expr.v2 Symbol -> N
; counts all occurrences of sy in sexp
(check-expect (count.v3 'world 'hello) 0)
(check-expect (count.v3 '(world hello) 'hello) 1)
(check-expect (count.v3 '(((world) hello) hello) 'hello) 2)
(check-expect (count.v3 1   'abc) 0)
(check-expect (count.v3 "a" 'abc) 0)
(check-expect (count.v3 '(1 hello "a" ((world) hello) hello) 'hello) 3)

(define (count.v3 sexp sy)
  (cond [(or (number? sexp)
             (string? sexp)) 0]
        [(symbol? sexp) (if (symbol=? sexp sy) 1 0)]
        [else
         (foldr (lambda (at res) (+ (count.v3 at sy) res)) 0 sexp)]))

;; Exercise 321


;; =================
;; Data definitions:

; A S-expr.v3 is one of:
; - X
; - [List-of S-expr.v3]


;; =================
;; Functions:

; S-expr.v3 Symbol -> N
; counts all occurrences of sy in sexp
(check-expect (count.v4 'world 'hello) 0)
(check-expect (count.v4 '(world hello) 'hello) 1)
(check-expect (count.v4 '(((world) hello) hello) 'hello) 2)
(check-expect (count.v4 1   'abc) 0)
(check-expect (count.v4 "a" 'abc) 0)
(check-expect (count.v4 '(1 hello "a" ((world) hello) hello) 'hello) 3)

(define (count.v4 sexp sy)
  (cond [(symbol? sexp) (if (symbol=? sexp sy) 1 0)]
        [(list?   sexp) (foldr (lambda (at res) (+ (count.v4 at sy) res)) 0 sexp)]
        [else 0]))
