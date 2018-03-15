;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |9-Designing with Self-Referential Data Definitions|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 9-Designing with Self-Referential Data Definitions.rkt
;; II - Arbitrarily Large Data
;; 9 - Designing with Self-Referential Data Definitions

(require 2htdp/image)
(require 2htdp/universe)


;; 9.1 - Finger Exercises: Lists

;; Exercise 137

; Yes, both have a cond for base and recursive conditions, with selectors for components.

;; Exercise 138


;; =================
;; Data definitions:

; A PositiveNumber is a Number greater than/equal to 0.

; A List-of-amounts is one of:
; - '()
; - (cons PositiveNumber List-of-amounts)
(define LOA1 '())
(define LOA2 (cons 1 '()))
(define LOA3 (cons 1 (cons 2 '())))


;; =================
;; Functions:

; List-of-amounts -> Number
; computes the sum of the amounts
(check-expect (sum LOA1) 0)
(check-expect (sum LOA2) 1)
(check-expect (sum LOA3) 3)

(define (sum loa)
  (cond [(empty? loa) 0]
        [else (+ (first loa)
                 (sum (rest loa)))]))


(sum LOA3)
(sum (cons 1 (cons 2 '())))
(cond [(empty? (cons 1 (cons 2 '()))) 0]
      [else (+ (first (cons 1 (cons 2 '()))) (sum (rest (cons 1 (cons 2 '())))))])
(cond [#false 0]
      [else (+ (first (cons 1 (cons 2 '()))) (sum (rest (cons 1 (cons 2 '())))))])
(cond [else (+ (first (cons 1 (cons 2 '()))) (sum (rest (cons 1 (cons 2 '())))))])
(+ (first (cons 1 (cons 2 '()))) (sum (rest (cons 1 (cons 2 '())))))
(+ 1 (sum (rest (cons 1 (cons 2 '())))))
(+ 1 (sum (cons 2 '())))
(+ 1 (cond [(empty? (cons 2 '())) 0]
           [else (+ (first (cons 2 '())) (sum (rest (cons 2 '()))))]))
(+ 1 (cond [#false 0]
           [else (+ (first (cons 2 '())) (sum (rest (cons 2 '()))))]))
(+ 1 (cond [else (+ (first (cons 2 '())) (sum (rest (cons 2 '()))))]))
(+ 1 (+ (first (cons 2 '())) (sum (rest (cons 2 '())))))
(+ 1 (+ 2 (sum (rest (cons 2 '())))))
(+ 1 (+ 2 (sum '())))
(+ 1 (+ 2 (cond [(empty? '()) 0]
                [else (+ (first '()) (sum (rest '())))])))
(+ 1 (+ 2 (cond [#true 0]
                [else (+ (first '()) (sum (rest '())))])))
(+ 1 (+ 2 0))
(+ 1 2)
3

;; Exercise 139


;; =================
;; Data definitions:

; A List-of-numbers is one of:
; - '()
; - (cons Number List-of-numbers)


;; =================
;; Functions:

; List-of-numbers -> Boolean
; determines whether all numbers are positive numbers
(check-expect (pos? (cons 5 '())) #true)
(check-expect (pos? (cons 5 (cons 10 '()))) #true)
(check-expect (pos? (cons -1 '())) #false)
(check-expect (pos? (cons 5 (cons -10 '()))) #false)

(define (pos? lon)
  (cond [(empty? lon) #true]
        [else (and (>= (first lon) 0) (pos? (rest lon)))]))

; List-of-numbers -> Number
; produces their sum if the input also belongs to List-of-amounts
(check-error  (checked-sum (cons -1 '())) "The input doesn't belong to List-of-amounts")
(check-expect (checked-sum (cons 5 '())) 5)
(check-expect (checked-sum LOA1) 0)
(check-expect (checked-sum LOA2) 1)
(check-expect (checked-sum LOA3) 3)

(define (checked-sum lon)
  (if (pos? lon)
      (sum lon)
      (error "The input doesn't belong to List-of-amounts")))

;; Exercise 140


;; =================
;; Data definitions:

; A List-of-booleans is one of:
; - '()
; - (cons Boolean List-of-booleans)
(define LOB1 '())
(define LOB2 (cons #true '()))
(define LOB3 (cons #false '()))
(define LOB4 (cons #true (cons #false '())))


;; =================
;; Functions:

; List-of-booleans -> Boolean
; determines whether all of them are true
(check-expect (all-true LOB1) #true)
(check-expect (all-true LOB2) #true)
(check-expect (all-true LOB3) #false)
(check-expect (all-true LOB4) #false)

(define (all-true lob)
  (cond [(empty? lob) #true]
        [else (and (first lob)
                   (all-true (rest lob)))]))

; List-of-booleans -> Boolean
; determines whether at least one item on the list is true
(check-expect (one-true LOB1) #true)
(check-expect (one-true LOB2) #true)
(check-expect (one-true LOB3) #true)
(check-expect (all-true LOB4) #false)

(define (one-true lob)
  (cond [(empty? lob) #true]
        [else (or (first lob)
                  (one-true (rest lob)))]))

;; Exercise 141


;; =================
;; Functions:

; List-of-string -> String
; concatenate all strings in l into one long string
(check-expect (cat '()) "")
(check-expect (cat (cons "a" (cons "b" '()))) "ab")
(check-expect (cat (cons "ab" (cons "cd" (cons "ef" '())))) "abcdef")
(check-expect (cat (cons "a" '())) "a")

(define (cat l)
  (cond [(empty? l) ""]
        [else (string-append (first l)
                             (cat (rest l)))]))


(cat (cons "a" '()))
(cond [(empty? (cons "a" '())) ""]
      [else (string-append (first (cons "a" '())) (cat (rest (cons "a" '()))))])
(cond [#false ""]
      [else (string-append (first (cons "a" '())) (cat (rest (cons "a" '()))))])
(cond [else (string-append (first (cons "a" '())) (cat (rest (cons "a" '()))))])
(string-append (first (cons "a" '())) (cat (rest (cons "a" '()))))
(string-append "a" (cat (rest (cons "a" '()))))
(string-append "a" (cat '()))
(string-append "a" (cond [(empty? '()) ""]
                         [else (string-append (first '()) (cat (rest '())))]))
(string-append "a" (cond [#true ""]
                         [else (string-append (first '()) (cat (rest '())))]))
(string-append "a" "")
"a"

;; Exercise 142


;; =================
;; Constants:

(define I1 (rectangle 10 10 "solid" "black")) ; 10x10
(define I2 (rectangle 20 20 "solid" "black")) ; 20x20
(define I3 (rectangle 30 30 "solid" "black")) ; 30x30


;; =================
;; Data definitions:

; A List-of-images is one of:
; - '()
; - (cons Image List-of-images)
(define LOI1 '())
(define LOI2 (cons I1 '()))
(define LOI3 (cons I1 (cons I2 '())))
(define LOI4 (cons I1 (cons I2 (cons I3 '()))))

; ImageOrFalse is one of:
; - Image
; - #false


;; =================
;; Functions:

; List-of-images Number -> ImageOrFalse
; produces the first image on loi that is not an n by n square;
; if it cannot find such an image, it produces false
(check-expect (ill-sized? LOI1 20) #false)
(check-expect (ill-sized? LOI2 20) #false)
(check-expect (ill-sized? LOI3 20) I2)
(check-expect (ill-sized? LOI4 30) I3)

(define (ill-sized? loi n)
  (cond [(empty? loi) #false]
        [(= (image-width (first loi)) n) (first loi)]
        [else (ill-sized? (rest loi) n)]))



;; 9.2 - Non-empty Lists

;; Exercise 143


;; =================
;; Data definitions:

; A CTemperature is a Number greater than -273.

; A List-of-temperatures is one of:
; - '()
; - (cons CTemperature List-of-temperatures)


;; =================
;; Functions:

; List-of-temperatures -> Number
; computes the average temperature
(check-expect (average (cons 1 (cons 2 (cons 3 '())))) 2)

(define (average alot)
  (/ (sum.v2 alot) (how-many alot)))

; List-of-temperatures -> Number
; computes the average temperature
; produces an informative error message when it is applied to '()
(check-expect (checked-average (cons 1 (cons 2 (cons 3 '())))) 2)
(check-error  (checked-average '()) "Invalid input (empty list)")

(define (checked-average alot)
  (cond [(empty? alot) (error "Invalid input (empty list)")]
        [else (average alot)]))

; List-of-temperatures -> Number
; adds up the temperatures on the given list
(define (sum.v2 alot)
  (cond [(empty? alot) 0]
        [else (+ (first alot)
                 (sum.v2 (rest alot)))]))

; List-of-temperatures -> Number
; counts the temperatures on the given list
(define (how-many alot)
  (cond [(empty? alot) 0]
        [else (+ (how-many (rest alot)) 1)]))

;; Exercise 144

; NEList-of-temperatures is a subset of List-of-temperatures so the sum and
; how-manu functions work.


;; =================
;; Data definitions:

; A NEList-of-temperatures is one of:
; - (cons CTemperature '())
; - (cons CTemperature NEList-of-temperatures)
; interpretation non-empty lists of Celsius temperatures


;; =================
;; Functions:

; NEList-of-temperatures -> Number
; computes the average temperature
(check-expect (average.v3 (cons 1 '())) 1)
(check-expect (average.v3 (cons 1 (cons 2 (cons 3 '())))) 2)

(define (average.v3 ne-l)
  (/ (sum.v2   ne-l)
     (how-many ne-l)))

;; Exercise 145


;; =================
;; Functions:

; NEList-of-temperatures -> Boolean
; produces true if the temperatures are sorted in descending order
(check-expect (sorted>? (cons 1 (cons 2 '()))) #false)
(check-expect (sorted>? (cons 3 (cons 2 '()))) #true)
(check-expect (sorted>? (cons 0 (cons 3 (cons 2 '())))) #false)

(define (sorted>? l)
  (cond [(empty? (rest l)) #true]
        [else (and (>= (first l)
                       (first (rest l)))
                   (sorted>? (rest l)))]))

;; Exercise 146


;; =================
;; Functions:

; NEList-of-temperatures -> Number
; computes the average temperature
(check-expect (average.v4 (cons 1 '())) 1)
(check-expect (average.v4 (cons 1 (cons 2 (cons 3 '())))) 2)

(define (average.v4 ne-l)
  (/ (sum.v4 ne-l)
     (how-many.v4 ne-l)))

; NEList-of-temperatures -> Number
; computes the sum of the given temperatures
(check-expect (sum.v4 (cons 1 '())) 1)
(check-expect (sum.v4 (cons 1 (cons 2 (cons 3 '())))) 6)

(define (sum.v4 ne-l)
  (cond [(empty? (rest ne-l)) (first ne-l)]
        [else (+ (first ne-l)
                 (sum.v4 (rest ne-l)))]))

; NEList-of-temperatures -> Number
; counts the temperatures on the given list
(check-expect (how-many.v4 (cons 1 '())) 1)
(check-expect (how-many.v4 (cons 1 (cons 2 (cons 3 '())))) 3)

(define (how-many.v4 ne-l)
  (cond [(empty? (rest ne-l)) 1]
        [else (+ (how-many.v4 (rest ne-l)) 1)]))

;; Exercise 147


;; =================
;; Data definitions:

; A NEList-of-booleans is one of:
; - (cons Boolean '())
; - (cons Boolean NEList-of-booleans)
; interpretation non-empty lists of Boolean values
(define NELOB1 (cons #true  '()))
(define NELOB2 (cons #false '()))
(define NELOB3 (cons #true  (cons #false '())))
(define NELOB4 (cons #true  (cons #false (cons #true '()))))


;; =================
;; Functions:

; NEList-of-booleans -> Boolean
; determines whether all of them are true
(check-expect (all-true.v5 NELOB1) #true)
(check-expect (all-true.v5 NELOB2) #false)
(check-expect (all-true.v5 NELOB3) #false)
(check-expect (all-true.v5 NELOB4) #false)

(define (all-true.v5 ne-l)
  (cond [(empty? (rest ne-l)) (first ne-l)]
        [else (and (first ne-l)
                   (all-true.v5 (rest ne-l)))]))

; NEList-of-booleans -> Boolean
; determines whether at least one item on the list is true
(check-expect (one-true.v5 NELOB1) #true)
(check-expect (one-true.v5 NELOB2) #false)
(check-expect (one-true.v5 NELOB3) #true)
(check-expect (one-true.v5 NELOB4) #true)

(define (one-true.v5 ne-l)
  (cond [(empty? (rest ne-l)) (first ne-l)]
        [else (or (first ne-l)
                  (one-true.v5 (rest ne-l)))]))

;; Exercise 148

; Yes, with empty list, the function has better expressiveness, however, it
; always executes an extra loop.



;; 9.3 - Natural Numbers

;; Exercise 149

; Both functions are equal and works with any data type.


;; =================
;; Data definitions:

; An N is one of:
; - 0
; - (add1 N)
; interpretation represents the counting numbers


;; =================
;; Functions:

; N String -> List-of-strings
; creates a list of n copies of s
(check-expect (copier 0 "hello") '())
(check-expect (copier 2 "hello") (cons "hello" (cons "hello" '())))
(check-expect (copier.v6 0 "hello") '())
(check-expect (copier.v6 2 "hello") (cons "hello" (cons "hello" '())))

(define (copier n s)
  (cond [(zero? n) '()]
        [(positive? n) (cons s (copier (sub1 n) s))]))

(define (copier.v6 n s)
  (cond [(zero? n) '()]
        [else (cons s (copier.v6 (sub1 n) s))]))


(copier 3 0.1)
(copier 3 "x")
(copier 3 #true)
(copier 3 (rectangle 10 10 "solid" "black"))
(copier.v6 3 0.1)
(copier.v6 3 "x")

;; Exercise 150


;; =================
;; Functions:

; N -> Number
; computes (+ n pi) without using +
(check-within (add-to-pi 3) (+ 3 pi) 0.001)

(define (add-to-pi n)
  (cond [(zero? n) pi]
        [else (add1 (add-to-pi (sub1 n)))]))

; N Number -> Number
; computes (+ n x) without using +
(check-within (add 3 pi) (+ 3 pi) 0.001)
(check-expect (add 3 6) (+ 3 6))

(define (add n x)
  (cond [(zero? n) x]
        [else (add1 (add (sub1 n) x))]))

;; Exercise 151


;; =================
;; Functions:

; N -> Number
; computes (* n x) without using *
(check-expect (multiply 3 6) (* 3 6))

(define (multiply n x)
  (cond [(zero? n) 0]
        [else (add (multiply (sub1 n) x) x)]))

;; Exercise 152


;; =================
;; Functions:

; N Image -> Image
; produces a column, a vertical arrangement, of n copies of img
(check-expect (col 5  (rectangle 10 10 "outline" "black"))
              (beside (rectangle 10 10 "outline" "black")
                      (rectangle 10 10 "outline" "black")
                      (rectangle 10 10 "outline" "black")
                      (rectangle 10 10 "outline" "black")
                      (rectangle 10 10 "outline" "black")))

(define (col n img)
  (cond [(zero? n) empty-image]
        [else (beside img (col (sub1 n) img))]))

; N Image -> Image
; produces a row, a horizontal arrangement, of n copies of img
(check-expect (row 5 (rectangle 10 10 "outline" "black"))
              (above (rectangle 10 10 "outline" "black")
                     (rectangle 10 10 "outline" "black")
                     (rectangle 10 10 "outline" "black")
                     (rectangle 10 10 "outline" "black")
                     (rectangle 10 10 "outline" "black")))

(define (row n img)
  (cond [(zero? n) empty-image]
        [else (above img (row (sub1 n) img))]))

;; Exercise 153


;; =================
;; Constants:

(define WIDTH-V7  100)
(define HEIGHT-V7 180)
(define DOT (circle 4 "solid" "red"))
(define HALL (place-image (col 10 (row 18 (rectangle 10 10 "outline" "black")))
                          (/ WIDTH-V7 2)
                          (/ HEIGHT-V7 2)
                          (empty-scene WIDTH-V7 HEIGHT-V7)))


;; =================
;; Data definitions:

; List-of-posn is one of:
; - '()
; - (cons Posn List-of-posn)
; interpretation a list of Posn


;; =================
;; Functions:

; List-of-posn -> Image
; produces an image of the lecture hall with red dots added as specified by the Posns
(check-expect (add-balloons '()) HALL)
(check-expect (add-balloons (cons (make-posn 0 0) '())) (place-image DOT  0  0 HALL))
(check-expect (add-balloons (cons (make-posn 1 1) '())) (place-image DOT 10 10 HALL))
(check-expect (add-balloons (cons (make-posn 1 1) (cons (make-posn 5 5) '())))
              (place-image DOT 10 10 (place-image DOT 50 50 HALL)))

(define (add-balloons lop)
  (cond [(empty? lop) HALL]
        [else (place-image DOT
                           (* (posn-x (first lop)) 10)
                           (* (posn-y (first lop)) 10)
                           (add-balloons (rest lop)))]))
