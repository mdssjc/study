;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-234) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 234

(define one-list
  '("Asia: Heat of the Moment"
    "U2: One"
    "The White Stripes: Seven Nation Army"))


; ListOfSong -> ListOfHTML
; produces a list representation of an HTML table
(define (make-ranking lor)
  `(html
    (body
     (table ((border "1"))
            ,@(make-row (ranking one-list))))))

; ListOfSong -> ... nested list ...
; creates a row for an HTML table from l
(define (make-row l)
  (cond [(empty? l) '()]
        [else (cons (list 'tr (make-cell (first (first l)))
                          (make-cell(second (first l))))
                    (make-row (rest l)))]))

; Anything -> ... nested list ...
; creates a cell for an HTML table
(define (make-cell a)
  `(td ,a))

; ListOfSong -> ListOfSong
; reverses the list of song
(define (ranking los)
  (reverse (add-ranks (reverse los))))

; ListOfSong -> ListOfSong
; adds an index for each element in the list of song
(define (add-ranks los)
  (cond
    [(empty? los) '()]
    [else (cons (list (length los) (first los))
                (add-ranks (rest los)))]))
