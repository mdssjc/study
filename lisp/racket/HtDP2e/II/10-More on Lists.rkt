;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |10-More on Lists|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 10-More on Lists.rkt
;; II - Arbitrarily Large Data
;; 10 - More on Lists

(require 2htdp/image)
(require 2htdp/universe)
(require 2htdp/batch-io)
(require racket/string)


;; 10.1 - Functions that Produce Lists

;; Exercise 161


;; =================
;; Constants:

(define WAGE-COST 14)


;; =================
;; Functions:

; List-of-numbers -> List-of-numbers
; computes the weekly wages for all given weekly hours
(check-expect (wage* '()) '())
(check-expect (wage* (cons 28 '())) (cons (* WAGE-COST 28) '()))
(check-expect (wage* (cons 4 (cons 2 '()))) (cons (* WAGE-COST 4) (cons (* WAGE-COST 2) '())))

(define (wage* whrs)
  (cond [(empty? whrs) '()]
        [else (cons (wage (first whrs))
                    (wage* (rest whrs)))]))

; Number -> Number
; computes the wage for h hours of work
(define (wage h)
  (* WAGE-COST h))

;; Exercise 162

; List-of-numbers -> List-of-numbers
; computes the weekly wages for all given weekly hours
(check-expect (wage*.v2 '()) '())
(check-expect (wage*.v2 (cons 28 '())) (cons (* WAGE-COST 28) '()))
(check-expect (wage*.v2 (cons 4 (cons 2 '()))) (cons (* WAGE-COST 4) (cons (* WAGE-COST 2) '())))
(check-error  (wage*.v2 (cons 12 (cons 100 '()))) "No employee could possibly work more than 100 hours per week")

(define (wage*.v2 whrs)
  (cond [(empty? whrs) '()]
        [(>= (first whrs) 100)
         (error "No employee could possibly work more than 100 hours per week")]
        [else (cons (wage (first whrs))
                    (wage*.v2 (rest whrs)))]))

;; Exercise 163


;; =================
;; Functions:

; List-of-numbers -> List-of-numbers
; converts a list of measurements in Fahrenheit to a list of Celsius measurements
(check-expect (convertFC '()) '())
(check-expect (convertFC (cons 98.6 '())) (cons 37 '()))
(check-within (convertFC (cons 98.6 (cons 85 '()))) (cons 37 (cons 29.4 '())) 0.1)

(define (convertFC t)
  (cond [(empty? t) '()]
        [else (cons (fahrenheit->celsius (first t))
                    (convertFC (rest t)))]))

; Number -> Number
; converts the temperature Fahrenheit in Celsius
(check-expect (fahrenheit->celsius 98.6) 37)
(check-expect (fahrenheit->celsius 212)  100)
(check-expect (fahrenheit->celsius -40)  -40)

(define (fahrenheit->celsius f)
  (* (- f 32) (/ 5 9)))

;; Exercise 164


;; =================
;; Constants:

(define RATE 0.920)


;; =================
;; Functions:

; List-of-numbers -> List-of-numbers
; converts a list of US$ amounts into a list of € amounts
(check-expect (convert-euro* '()) '())
(check-within (convert-euro* (cons 1 '())) (cons 0.92 '()) 0.1)
(check-within (convert-euro* (cons 1 (cons 3.5 '()))) (cons 0.92 (cons 3.22 '())) 0.1)

(define (convert-euro* d)
  (cond [(empty? d) '()]
        [else (cons (convert-euro (first d))
              (convert-euro* (rest d)))]))

; Number -> Number
; converts the US$ in € with the current exchange rate
(check-within (convert-euro 1)   0.92 0.1)
(check-within (convert-euro 3.5) 3.22 0.1)

(define (convert-euro d)
  (* d RATE))

;; Exercise 165


;; =================
;; Functions:

; List-of-strings -> List-of-strings
; consumes a list of toy descriptions (one-word strings) and
; replaces all occurrences of "robot" with "r2d2"
(check-expect (subst-robot '()) '())
(check-expect (subst-robot (cons "robot-1" '())) (cons "r2d2-1" '()))
(check-expect (subst-robot (cons "robot-1" (cons ">>robot<<" '())))
              (cons "r2d2-1" (cons ">>r2d2<<" '())))

(define (subst-robot los)
  (substitute "r2d2" "robot" los))

; String String List-of-strings -> List-of-strings
; replaces all occurrences of new with old in the List-of-strings
(define (substitute new old los)
  (cond [(empty? los) '()]
        [else (cons (string-replace (first los) old new)
                    (substitute new old (rest los)))]))



;; 10.2 - Structures in Lists

;; Exercise 166


;; =================
;; Data definitions:

(define-struct work [employee number rate hours])
; A (piece of) Work is a structure:
;   (make-work String Number Number Number)
; interpretation (make-work n num r h) combines the name
; with the number num, pay rate r and the number of hours h

(define-struct pay-check (number name amount))
; A Pay-check is a structure:
;  (make-pay-check Number String Number)
; interpretation (make-pay-check num n a) contains
; the employee's number num, name n and an amount a

; A Low (short for list of works) is one of:
; - '()
; - (cons Work Low)
; interpretation an instance of Low represents the
; hours worked for a number of employees

; A Lop is one of:
; - '()
; - (cons Pay-check Lop)
; interpretation an instance of Lop represents the
; employee's name and an amount


;; =================
;; Functions:

; Low -> Lop
; consumes a list of work records and computes a list of pay checks
(check-expect (wage*.v3 '()) '())
(check-expect (wage*.v3 (cons (make-work "Robby" 1 11.95 39) '()))
              (cons (make-pay-check 1 "Robby" (* 11.95 39)) '()))
(check-expect (wage*.v3 (cons (make-work "Matthew" 1 12.95 45)
                              (cons (make-work "Robby" 2 11.95 39) '())))
              (cons (make-pay-check 1 "Matthew" (* 12.95 45))
                    (cons (make-pay-check 2 "Robby" (* 11.95 39)) '())))

(define (wage*.v3 an-low)
  (cond [(empty? an-low) '()]
        [(cons? an-low) (cons (create-paycheck (first an-low))
                              (wage*.v3 (rest an-low)))]))

; Work -> Pay-check
; creates a paycheck for the given work w
(define (create-paycheck w)
  (make-pay-check (work-number w)
                  (work-employee w)
                  (wage.v3 w)))

; Work -> Number
; computes the wage for the given work record w
(define (wage.v3 w)
  (* (work-rate w) (work-hours w)))

;; Exercise 167


;; =================
;; Data definitions:

; A Lop is one of:
; - '()
; - (cons Posn Lop)
; interpretation an instance of Lop represents a Posn list


;; =================
;; Functions:

; Lop -> Number
; consumes a list of Posns and produces the sum of all of its x-coordinates
(check-expect (sum '()) 0)
(check-expect (sum (cons (make-posn 11 20) '())) 11)
(check-expect (sum (cons (make-posn 11 20) (cons (make-posn 48 66) '()))) (+ 11 48))

(define (sum lop)
  (cond [(empty? lop) 0]
        [else (+ (posn-x (first lop))
                 (sum (rest lop)))]))

;; Exercise 168


;; =================
;; Functions:

; Lop -> Lop
; produces lists of Posns with (make-posn x (+ y 1)) - known as translation
(check-expect (translate '()) '())
(check-expect (translate (cons (make-posn 10 10) '()))
              (cons (make-posn 10 11) '()))
(check-expect (translate (cons (make-posn 10 10) (cons (make-posn 20 20) '())))
              (cons (make-posn 10 11) (cons (make-posn 20 21) '())))

(define (translate lop)
  (cond [(empty? lop) '()]
        [else (cons (make-posn (posn-x (first lop))
                               (add1 (posn-y (first lop))))
              (translate (rest lop)))]))

;; Exercise 169


;; =================
;; Functions:

; Lop -> Lop
; produces lists of Posns whose x-coordinates are between 0 and 100
; and whose y-coordinates are between 0 and 200
(check-expect (legal '()) '())
(check-expect (legal (cons (make-posn -1  100)  '())) '())
(check-expect (legal (cons (make-posn 0   100)  '())) (cons (make-posn 0 100)   '()))
(check-expect (legal (cons (make-posn 50  100)  '())) (cons (make-posn 50 100)  '()))
(check-expect (legal (cons (make-posn 100 100)  '())) (cons (make-posn 100 100) '()))
(check-expect (legal (cons (make-posn 101 100)  '())) '())
(check-expect (legal (cons (make-posn 50  -1)   '())) '())
(check-expect (legal (cons (make-posn 50  0)    '())) (cons (make-posn 50 0)   '()))
(check-expect (legal (cons (make-posn 50  100)  '())) (cons (make-posn 50 100) '()))
(check-expect (legal (cons (make-posn 50  200)  '())) (cons (make-posn 50 200) '()))
(check-expect (legal (cons (make-posn 50  201)  '())) '())
(check-expect (legal (cons (make-posn -1  100)
                           (cons (make-posn 50 100)
                                 (cons (make-posn 50 -1)
                                       (cons (make-posn 50 100) '())))))
              (cons (make-posn 50 100) (cons (make-posn 50 100) '())))

(define (legal lop)
  (cond [(empty? lop) '()]
        [(< (posn-x (first lop)) 0)   (legal (rest lop))]
        [(> (posn-x (first lop)) 100) (legal (rest lop))]
        [(< (posn-y (first lop)) 0)   (legal (rest lop))]
        [(> (posn-y (first lop)) 200) (legal (rest lop))]
        [else (cons (first lop)
                    (legal (rest lop)))]))

;; Exercise 170


;; =================
;; Data definitions:

(define-struct phone [area switch four])
; A Phone is a structure:
;   (make-phone Three Three Four)
; A Three is a Number between 100 and 999.
; A Four is a Number between 1000 and 9999.
(define P1 (make-phone 713 123 4567))
(define P2 (make-phone 281 123 4567))
(define P3 (make-phone 123 123 4567))

; A Lop is one of:
; - '()
; - (cons Phone Lop)
; interpretation an instance of Lop represents a Phone list


;; =================
;; Functions:

; Lop -> Lop
; replaces all occurrence of area code 713 with 281
(check-expect (replace* '()) '())
(check-expect (replace* (cons P1 '())) (cons P2 '()))
(check-expect (replace* (cons P1 (cons P3 '()))) (cons P2 (cons P3 '())))

(define (replace* lop)
  (cond [(empty? lop) '()]
        [else (cons (replace (first lop))
                    (replace* (rest lop)))]))

; Phone -> Phone
; replaces the area code 713 with 281
(define (replace p)
  (cond [(= (phone-area p) 713)
         (make-phone 281 (phone-switch p) (phone-four p))]
        [else p]))



;; 10.3 - Lists in Lists, Files

;; Exercise 171


;; =================
;; Data definitions:

; A Los is one of:
; - '()
; - (cons String Los)
; interpretation a list of Strings, each is a String
(define line0 (cons "hello" (cons "world" '())))
(define line1 '())

; A LLS is one of:
; - '()
; - (cons Los LLS)
; interpretation a list of lines, each is a list of Strings
(define lls0 '())
(define lls1 (cons line0 (cons line1 '())))
