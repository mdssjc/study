;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-202) (read-case-sensitive #t) (teachpacks ((lib "itunes.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "itunes.rkt" "teachpack" "2htdp")) #f)))
;; Exercise 202

(require 2htdp/itunes)

; A LTracks is one of:
; - '()
; - (cons Track LTracks)
(define T1 (create-track "title A" "two" "three" 4 5 (create-date 1 2 3 4 5 6) 7 (create-date 1 2 3 4 5 6)))
(define T2 (create-track "title B" "two" "three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define LT1 (cons T1 (cons T2 '())))
(define LT2 (cons T1 (cons T2 (cons T1 '()))))


; String String LTracks -> LTracks
; extracts from the latter the list of tracks that belong to the given album
(check-expect (select-album "title A" "three" LT1) (list T1))
(check-expect (select-album "title B" "three" LT1) (list T2))
(check-expect (select-album "title A" "three" LT2) (list T1 T1))
(check-expect (select-album "title B" "three" LT2) (list T2))
(check-expect (select-album "title AB" "three" LT1) '())

(define (select-album t a lt)
  (cond [(empty? lt) '()]
        [(and (string=? (track-name  (first lt)) t)
              (string=? (track-album (first lt)) a)) (cons (first lt)
                                                           (select-album t a (rest lt)))]
        [else (select-album t a (rest lt))]))
