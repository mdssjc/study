;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-203) (read-case-sensitive #t) (teachpacks ((lib "itunes.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "itunes.rkt" "teachpack" "2htdp")) #f)))
;; Exercise 203

(require 2htdp/itunes)

; A LTracks is one of:
; - '()
; - (cons Track LTracks)
(define T1 (create-track "title A" "two" "three" 4 5 (create-date 1 2 3 4 5 6) 7 (create-date 1 2 3 4 5 6)))
(define T2 (create-track "title B" "two" "three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define LT1 (cons T1 (cons T2 '())))
(define LT2 (cons T1 (cons T2 (cons T1 '()))))


; String String Date LTracks -> LTracks
; extracts from the latter the list of tracks that belong
; to the given album and have been played after the given date
(check-expect (select-album-date "title A" "three" (create-date 1 2 3 4 5 5) LT1) (list T1))
(check-expect (select-album-date "title A" "three" (create-date 1 2 3 4 5 6) LT1) '())
(check-expect (select-album-date "title A" "three" (create-date 1 2 3 4 5 5) LT2) (list T1 T1))
(check-expect (select-album-date "title A" "three" (create-date 1 2 3 4 5 6) LT2) '())
(check-expect (select-album-date "title AB" "three" (create-date 1 2 3 4 5 5) LT1) '())

(define (select-album-date t a d lt)
  (cond [(empty? lt) '()]
        [(and (string=? (track-name  (first lt)) t)
              (string=? (track-album (first lt)) a)
              (date>? (track-played (first lt)) d)) (cons (first lt)
                                                          (select-album-date t a d (rest lt)))]
        [else (select-album-date t a d (rest lt))]))

; Date Date -> Boolean
; determines whether the first occurs before the second
(check-expect (date>? (create-date 1 2 3 4 5 6) (create-date 1 2 3 4 5 5)) #true)
(check-expect (date>? (create-date 1 2 3 4 5 6) (create-date 1 2 3 4 5 6)) #false)

(define (date>? d1 d2)
  (or
   (> (date-year d1)   (date-year d2))
   (> (date-month d1)  (date-month d2))
   (> (date-day d1)    (date-day d2))
   (> (date-hour d1)   (date-hour d2))
   (> (date-minute d1) (date-minute d2))
   (> (date-second d1) (date-second d2))))
