;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-295) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 295


; distances in terms of pixels 
(define WIDTH 300)
(define HEIGHT 300)


; N -> [List-of Posn]
; generate n random Posns in [0,WIDTH) by [0,HEIGHT)
(check-satisfied (random-posns 3)
                 (n-inside-playground? 3))

(define (random-posns n)
  (build-list
   n
   (lambda (i)
     (make-posn (random WIDTH) (random HEIGHT)))))

; N -> [[List-of Posn] Boolean?]
; a specification for the random-posns function
(define (n-inside-playground? n)
  (lambda (l0)
    (and (= (length l0) n)
         (foldr (lambda (p res)
                  (or (and (<= 0 (posn-x p) WIDTH)
                           (<= 0 (posn-y p) HEIGHT))
                      res))
                #false l0))))

; N -> [List-of Posn]
; produces n Posns in [0,WIDTH) by [0,HEIGHT)
(check-satisfied (random-posns/bad 3)
                 (n-inside-playground? 3))

(define (random-posns/bad n)
  (list (make-posn  40  56)
        (make-posn  63 254)
        (make-posn 100  22)))
