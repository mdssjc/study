;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-204) (read-case-sensitive #t) (teachpacks ((lib "itunes.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "itunes.rkt" "teachpack" "2htdp")) #f)))
;; Exercise 204

(require 2htdp/itunes)

; A LTracks is one of:
; - '()
; - (cons Track LTracks)
(define T1 (create-track "title A" "two" "three" 4 5 (create-date 1 2 3 4 5 6) 7 (create-date 1 2 3 4 5 6)))
(define T2 (create-track "title B" "two" "three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define T3 (create-track "title C" "two" "new-three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define T4 (create-track "title D" "two" "new-three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define LT1 (cons T1 (cons T2 '())))
(define LT2 (cons T1 (cons T2 (cons T1 '()))))
(define LT3 (cons T4 (cons T2 (cons T3 (cons T1 '())))))

; A LoLT is one of:
; - '()
; - (cons LTracks LoLT)
; interpretation a collection of LTracks


; LTracks -> LoLT
; produce a list of LTracks, one per album
(check-expect (select-albums LT1) (list (list T1 T2)))
(check-expect (select-albums LT2) (list (list T1 T2)))
(check-expect (select-albums LT3) (list (list T4 T3)
                                        (list T2 T1)))
(check-expect (select-albums '()) '())

(define (select-albums lt)
  (cond [(empty? lt) '()]
        [else (cons (select-album (track-album (first lt)) lt)
                    (select-albums (remove-album (track-album (first lt)) (rest lt))))]))

; String LTracks -> LTracks
; extracts the tracks belonging to the given album from the list of tracks
(check-expect (select-album "three" LT1) (list T1 T2))
(check-expect (select-album "new-three" LT1) '())
(check-expect (select-album "three" LT2) (list T1 T2))
(check-expect (select-album "three" LT3) (list T2 T1))
(check-expect (select-album "new-three" LT3) (list T4 T3))

(define (select-album a lt)
  (cond [(empty? lt) '()]
        [(string=? (track-album (first lt)) a)
         (cons (first lt)
               (select-album a (remove (first lt) (rest lt))))]
        [else (select-album a (rest lt))]))

; String LTracks -> LTracks
; removes the tracks belonging to the given album from the list of tracks
(check-expect (remove-album "three" LT1) '())
(check-expect (remove-album "new-three" LT1) (list T1 T2))
(check-expect (remove-album "three" LT2) '())
(check-expect (remove-album "three" LT3) (list T4 T3))
(check-expect (remove-album "new-three" LT3) (list T2 T1))

(define (remove-album a lt)
  (cond [(empty? lt) '()]
        [(string=? (track-album (first lt)) a)
         (remove-album a (remove (first lt) (rest lt)))]
        [else (cons (first lt) (remove-album a (rest lt)))]))
