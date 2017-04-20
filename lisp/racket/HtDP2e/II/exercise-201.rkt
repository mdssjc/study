;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-201) (read-case-sensitive #t) (teachpacks ((lib "itunes.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "itunes.rkt" "teachpack" "2htdp")) #f)))
;; Exercise 201

(require 2htdp/itunes)

; A LTracks is one of:
; - '()
; - (cons Track LTracks)
(define T1 (create-track "title A" "two" "three" 4 5 (create-date 1 2 3 4 5 6) 7 (create-date 1 2 3 4 5 6)))
(define T2 (create-track "title B" "two" "three" 4 5 (create-date 6 5 4 3 2 1) 7 (create-date 6 5 4 3 2 1)))
(define LT1 (cons T1 (cons T2 '())))
(define LT2 (cons T1 (cons T2 (cons T1 '()))))

; A List-of-strings is one of:
; - '()
; - (cons String List-of-strings)
; interpretation a list of String values.


; LTracks -> List-of-strings
; produces the list of album titles
(check-expect (select-all-album-titles '()) '())
(check-expect (select-all-album-titles LT1) (list "title A" "title B"))
(check-expect (select-all-album-titles LT2) (list "title A" "title B" "title A"))

(define (select-all-album-titles lt)
  (cond [(empty? lt) '()]
        [else (cons (track-name (first lt))
                    (select-all-album-titles (rest lt)))]))

; List-of-strings -> String
; constructs one that contains every String from the given list exactly once
(check-expect (create-set '()) "")
(check-expect (create-set (select-all-album-titles LT1)) "title A title B")
(check-expect (create-set (select-all-album-titles LT2)) "title A title B")

(define (create-set los)
  (cond [(empty? los) ""]
        [(empty? (rest los)) (first los)]
        [else (string-append (first los) " "
                             (create-set (remove-all (first los) (rest los))))]))

; LTracks -> List-of-strings
; produces a list of unique album titles
(check-expect (select-album-titles/unique '()) '())
(check-expect (select-album-titles/unique LT1) (list "title A" "title B"))
(check-expect (select-album-titles/unique LT2) (list "title A" "title B"))

(define (select-album-titles/unique lt)
  (cond [(empty? lt) '()]
        [else (cons (track-name (first lt))
                    (select-album-titles/unique (remove-all (first lt) (rest lt))))]))
