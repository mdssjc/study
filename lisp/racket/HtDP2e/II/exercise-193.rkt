;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-193) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 193

(require 2htdp/image)

; a plain background image 
(define MT (empty-scene 50 50))

(define triangle-p (list
                    (make-posn 20 10)
                    (make-posn 20 20)
                    (make-posn 30 20)))
(define square-p (list
                  (make-posn 10 10)
                  (make-posn 20 10)
                  (make-posn 20 20)
                  (make-posn 10 20)))


; A Polygon is one of:
; - (list Posn Posn Posn)
; - (cons Posn Polygon)

; A NELoP is one of: 
; - (cons Posn '())
; - (cons Posn NELoP)


; Image Polygon -> Image 
; adds an image of p to MT
(check-expect (render-polygon MT triangle-p)
              (scene+line
               (scene+line
                (scene+line MT 20 10 20 20 "red")
                20 20 30 20 "red")
               30 20 20 10 "red"))
(check-expect (render-polygon MT square-p)
              (scene+line
               (scene+line
                (scene+line
                 (scene+line MT 10 10 20 10 "red")
                 20 10 20 20 "red")
                20 20 10 20 "red")
               10 20 10 10 "red"))

(define (render-polygon img p)
  (render-line (connect-dots img p) (first p) (last p)))

; Image Polygon -> Image 
; adds an image of p to MT
(check-expect (render-polygon-v2 MT triangle-p)
              (scene+line
               (scene+line
                (scene+line MT 20 10 20 20 "red")
                20 20 30 20 "red")
               30 20 20 10 "red"))
(check-expect (render-polygon-v2 MT square-p)
              (scene+line
               (scene+line
                (scene+line
                 (scene+line MT 10 10 20 10 "red")
                 20 10 20 20 "red")
                20 20 10 20 "red")
               10 20 10 10 "red"))

(define (render-polygon-v2 img p)
  (connect-dots img (cons (last p) p)))

; Image Polygon -> Image 
; adds an image of p to MT
(check-expect (render-polygon-v3 MT triangle-p)
              (scene+line
               (scene+line
                (scene+line MT 20 10 20 20 "red")
                20 20 30 20 "red")
               30 20 20 10 "red"))
(check-expect (render-polygon-v3 MT square-p)
              (scene+line
               (scene+line
                (scene+line
                 (scene+line MT 10 10 20 10 "red")
                 20 10 20 20 "red")
                20 20 10 20 "red")
               10 20 10 10 "red"))

(define (render-polygon-v3 img p)
  (connect-dots img (add-at-end p (first p))))

; Image NELoP -> Image
; connects the Posns in p in an image
(define (connect-dots img p)
  (cond [(empty? (rest p)) MT]
        [else (render-line (connect-dots img (rest p))
                           (first p)
                           (second p))]))

; Image Posn Posn -> Image 
; draws a red line from Posn p to Posn q into im
(define (render-line im p q)
  (scene+line
   im (posn-x p) (posn-y p) (posn-x q) (posn-y q) "red"))

; Polygon -> Posn
; extracts the last item from p
(define (last p)
  (cond [(empty? (rest (rest (rest p)))) (third p)]
        [else (last (rest p))]))

; NELoP Posn -> NELoP
; creates a new list by adding q to the end of p
(check-expect (add-at-end triangle-p (make-posn 0 0))
              (reverse (cons (make-posn 0 0) (reverse triangle-p))))

(define (add-at-end p q)
  (cond [(empty? p) (cons q '())]
        [else (cons (first p) (add-at-end (rest p) q))]))
