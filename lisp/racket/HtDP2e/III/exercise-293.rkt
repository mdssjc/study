;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-293) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 293


(define LST (list 0 2 4 6 8 10))


; X [List-of X] -> [Maybe [List-of X]]
; returns the first sublist of l that starts
; with x, #false otherwise
(define (find x l)
  (cond
    [(empty? l) #false]
    [else
     (if (equal? (first l) x) l (find x (rest l)))]))

; X -> [[Maybe [List-of X]] -> Boolean]
; a specification for the find function
(define (found? x l)
  (lambda (l0)
    (equal? (reverse (foldl (lambda (i res)
                              (if (or (member? x res)
                                      (equal? i x))
                                  (cons i res)
                                  res))
                            empty l))
            l0)))

(check-satisfied (find   4 LST)
                 (found? 4 LST))
