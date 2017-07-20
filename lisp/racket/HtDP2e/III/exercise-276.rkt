;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname exercise-276) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 276


(require 2htdp/itunes)


; A LTracks is one of:
; - '()
; - (cons Track LTracks)
(define T1 (create-track "title A" "two" "three" 4 5 (create-date 1 2 3 4 5 6) 7 (create-date 1 2 3 4 5 6)))
(define T2 (create-track "title B" "two" "three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define T3 (create-track "title C" "two" "new-three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define T4 (create-track "title D" "two" "new-three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define LT1 (cons T1 (cons T2 empty)))
(define LT2 (cons T1 (cons T2 (cons T1 empty))))
(define LT3 (cons T4 (cons T2 (cons T3 (cons T1 empty)))))

; A LoLT is one of:
; - '()
; - (cons LTracks LoLT)
; interpretation a collection of LTracks


; String String Date LTracks -> LTracks
; extracts from the latter the list of tracks that belong
; to the given album and have been played after the given date
(check-expect (select-album-date "title A"  "three" (create-date 1 2 3 4 5 5) LT1) (list T1))
(check-expect (select-album-date "title A"  "three" (create-date 1 2 3 4 5 6) LT1) empty)
(check-expect (select-album-date "title A"  "three" (create-date 1 2 3 4 5 5) LT2) (list T1 T1))
(check-expect (select-album-date "title A"  "three" (create-date 1 2 3 4 5 6) LT2) empty)
(check-expect (select-album-date "title AB" "three" (create-date 1 2 3 4 5 5) LT1) empty)

(define (select-album-date t a d lt)
  (local ((define (date>? d1 d2)
            (or (> (date-year   d1) (date-year   d2))
                (> (date-month  d1) (date-month  d2))
                (> (date-day    d1) (date-day    d2))
                (> (date-hour   d1) (date-hour   d2))
                (> (date-minute d1) (date-minute d2))
                (> (date-second d1) (date-second d2))))
          (define (predicate? lt)
            (and (string=? (track-name   lt) t)
                 (string=? (track-album  lt) a)
                 (date>?   (track-played lt) d))))
    (filter predicate? lt)))

; LTracks -> LoLT
; produce a list of LTracks, one per album
(check-expect (select-albums empty) empty)
(check-expect (select-albums LT1) (list (list T1 T2)))
(check-expect (select-albums LT2) (list (list T1 T2)))
(check-expect (select-albums LT3) (list (list T4 T3) (list T2 T1)))

(define (select-albums lt)
  (local ((define (duplicates t lst)
            (if (member? t lst) lst (cons t lst)))
          (define lts (reverse (foldl duplicates empty lt)))
          (define (member-t? t lts)
            (local ((define (member-t? lt)
                      (member? t lt)))
              (ormap member-t? lts)))
          (define (separate t result)
            (if (member-t? t result)
                result
                (cons (local ((define (predicate-ta? pt)
                                (string=? (track-album t) (track-album pt))))
                        (filter predicate-ta? lts)) result))))
    (foldr separate empty lts)))
