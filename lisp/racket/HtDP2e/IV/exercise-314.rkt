;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-314) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 314


;; ====================
;; Data definitions:

(define-struct no-parent [])
(define-struct child [father mother name date eyes])
; A FT (short for family tree) is one of: 
; - (make-no-parent)
; - (make-child FT FT String N String)

(define NP (make-no-parent))
; A FT is one of: 
; - NP
; - (make-child FT FT String N String)

; Oldest Generation:
(define Carl (make-child NP NP "Carl" 1926 "green"))
(define Bettina (make-child NP NP "Bettina" 1926 "green"))
 
; Middle Generation:
(define Adam (make-child Carl Bettina "Adam" 1950 "hazel"))
(define Dave (make-child Carl Bettina "Dave" 1955 "black"))
(define Eva (make-child Carl Bettina "Eva" 1965 "blue"))
(define Fred (make-child NP NP "Fred" 1966 "pink"))
 
; Youngest Generation: 
(define Gustav (make-child Fred Eva "Gustav" 1988 "brown"))

; A [List-of X] is one of: 
; - '()
; - (cons X [List-of X])
; interpretation represents a list of X

(define ff1 (list Carl Bettina))
(define ff2 (list Fred Eva))
(define ff3 (list Fred Eva Carl))


;; ====================
;; Functions:

; FT -> Boolean
; does a-ftree contain a child
; structure with "blue" in the eyes field
(check-expect (blue-eyed-child? Carl)   #false)
(check-expect (blue-eyed-child? Gustav) #true)
(check-expect (blue-eyed-child? Eva)    #true)
 
(define (blue-eyed-child? a-ftree)
  (cond [(no-parent? a-ftree) #false]
        [else
         (or (string=? (child-eyes a-ftree) "blue")
             (blue-eyed-child? (child-father a-ftree))
             (blue-eyed-child? (child-mother a-ftree)))]))

; [List-of FT] -> Boolean
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
  (ormap2 blue-eyed-child? a-forest))

; [X -> Boolean] [List-of X] -> Boolean
; determines whether p? holds for at least one items of l
(check-expect (ormap2 blue-eyed-child? ff1) #false)
(check-expect (ormap2 blue-eyed-child? ff2) #true)
(check-expect (ormap2 blue-eyed-child? ff3) #true)
 
(define (ormap2 p? l)
  (cond [(empty? l) #false]
        [else
         (or (p? (first l))
             (ormap2 p? (rest l)))]))
