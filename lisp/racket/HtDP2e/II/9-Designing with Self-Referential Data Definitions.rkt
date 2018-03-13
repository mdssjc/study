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
        [else (+ (first loa) (sum (rest loa)))]))


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
