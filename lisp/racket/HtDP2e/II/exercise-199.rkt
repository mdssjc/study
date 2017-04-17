;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname exercise-199) (read-case-sensitive #t) (teachpacks ((lib "itunes.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "itunes.rkt" "teachpack" "2htdp")) #f)))
;; Exercise 199

(require 2htdp/itunes)

; Any Any Any Any Any Any Any Any -> Track or #false
; creates an instance of Track for legitimate inputs
; otherwise it produces #false.
(check-expect (create-track "one"
                            "two"
                            "three"
                            4
                            5
                            (create-date 1 2 3 4 5 6)
                            7
                            (create-date 1 2 3 4 5 6))
              (create-track "one" "two" "three" 4 5 (create-date 1 2 3 4 5 6) 7 (create-date 1 2 3 4 5 6)))
(check-expect (create-track "one" "two" "three" 4 5 "a date" 7 "another date") #false)

;(define (create-track name artist album time track# added play# played)
;  ...)
 
; Any Any Any Any Any Any -> Date or #false
; creates an instance of Date for legitimate inputs 
; otherwise it produces #false.
(check-expect (create-date 1 2 3 4 5 6) (create-date 1 2 3 4 5 6))
(check-expect (create-date 1 2 3 "four" 5 6) #false)

;(define (create-date y mo day h m s)
;  ...)
 
; String -> LTracks
; creates a “list of tracks” representation from the
; text in file-name (an XML export from iTunes)
(check-expect (read-itunes-as-tracks "Library.xml")
              (cons (create-track "one" "two" "three" 4 5 (create-date 1 2 3 4 5 6) 7 (create-date 1 2 3 4 5 6)) '()))

;(define (read-itunes-as-tracks file-name)
;  ...)
