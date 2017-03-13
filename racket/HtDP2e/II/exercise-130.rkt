;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-130) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 130

; A List-of-names is one of: 
; - '()
; - (cons String List-of-names)
; interpretation a list of invitees, by last name
(cons "Findler"
      (cons "Flatt"
            (cons "Felleisen"
                  (cons "Krishnamurthi"
                        (cons "Marcelo" '())))))

(cons "1" (cons "2" '())) ; "1" and "2" are strings, match with List-of-names
(cons 2 '()) ; 2 is a number, doesn't match with List-of-names
