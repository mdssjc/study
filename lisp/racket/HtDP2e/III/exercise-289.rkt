;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-289) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 289


; String [List-of String] -> Boolean
; determines whether any of the names on the latter are equal to or an extension of the former
(check-expect (find-name? "john" empty) #false)
(check-expect (find-name? "john" (list "marie")) #false)
(check-expect (find-name? "john" (list "john")) #true)
(check-expect (find-name? "john" (list "marie" "john")) #true)
(check-expect (find-name? "jo"   (list "marie" "john")) #true)
(check-expect (find-name? "john" (list "marie" "johnson")) #true)

(define (find-name? s los)
  (ormap (lambda (x)
           (string-contains? s x))
         los))

; [List-of String] -> Boolean
; checks all names on a list of names start with the letter "a"
(check-expect (check-name? empty) #false)
(check-expect (check-name? (list "marie")) #false)
(check-expect (check-name? (list "arie")) #true)
(check-expect (check-name? (list "marie" "arie")) #false)
(check-expect (check-name? (list "alf" "arie")) #true)

(define (check-name? los)
  (if (empty? los)
      #false
      (andmap (lambda (s)
                (string=? "a" (string-ith s 0)))
              los)))

; Number [List-of String] -> Boolean
; ensures that no name on some list exceeds some given width
(check-expect (exceed-width? 5 empty) #false)
(check-expect (exceed-width? 5 (list "alf")) #false)
(check-expect (exceed-width? 5 (list "alf" "marie")) #false)
(check-expect (exceed-width? 5 (list "alf" "marie" "johnson")) #true)

(define (exceed-width? n los)
  (ormap (lambda (s)
           (> (string-length s) n))
         los))
