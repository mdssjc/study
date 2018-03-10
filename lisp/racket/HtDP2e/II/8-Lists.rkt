;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |8-Lists|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 8-Lists.rkt
;; II - Arbitrarily Large Data
;; 8 Lists

(require 2htdp/image)
(require 2htdp/universe)



;; 8.1 - Creating Lists

;; Exercise 129

; a list of celestial bodies
(cons "Mercury"
      (cons "Venus"
            (cons "Earth"
                  (cons "Mars"
                        (cons "Jupiter"
                              (cons "Saturn"
                                    (cons "Uranus"
                                          (cons "Neptune" '()))))))))

; a list of items for a meal
(cons "steak"
      (cons "frenck fries"
            (cons "beans"
                  (cons "bread"
                        (cons "water"
                              (cons "brie cheese"
                                    (cons "ice cream" '())))))))

; a list of colors
(cons "white"
      (cons "black"
            (cons "red"
                  (cons "green"
                        (cons "blue" '())))))

;; Exercise 130

; A List-of-names is one of:
; - '()
; - (cons String List-of-names)
; interpretation a list of invitees, by last name
(cons "Findler"
      (cons "Flatt"
            (cons "Felleisen"
                  (cons "Krishnamurthi"
                        (cons "dos Santos" '())))))

(cons "1" (cons "2" '())) ; "1" and "2" are strings, match with List-of-names
(cons 2 '())              ; 2 is a number, doesn't match with List-of-names

;; Exercise 131

; A List-of-booleans is one of:
; - '()
; - (cons Boolean List-of-booleans)
; interpretation a list of boolean values
(cons #true
      (cons #false
            (cons #true '())))
