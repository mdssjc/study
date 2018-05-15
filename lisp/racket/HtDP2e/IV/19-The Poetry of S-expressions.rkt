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
