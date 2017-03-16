;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-135) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 135

; List-of-names -> Boolean
; determines whether "Flatt" occurs on alon
(check-expect
 (contains-flatt? (cons "X" (cons "Y"  (cons "Z" '()))))
 #false)
(check-expect
 (contains-flatt? (cons "A" (cons "Flatt" (cons "C" '()))))
 #true)
(check-expect
 (contains-flatt? (cons "Fagan"
                        (cons "Findler"
                              (cons "Fisler"
                                    (cons "Flanagan"
                                          (cons "Flatt"
                                                (cons "Felleisen"
                                                      (cons "Friedman" '()))))))))
 #true)

(define (contains-flatt? alon)
  (cond [(empty? alon) #false]
        [(string=? (first alon) "Flatt") #true]
        [else (contains-flatt? (rest alon))]))


(contains-flatt? (cons "Flatt" (cons "C" '())))
(cond [(empty? (cons "Flatt" (cons "C" '()))) #false]
      [(string=? (first (cons "Flatt" (cons "C" '()))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
(cond [#false #false]
      [(string=? (first (cons "Flatt" (cons "C" '()))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
(cond [(string=? (first (cons "Flatt" (cons "C" '()))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
(cond [(string=? "Flatt" "Flatt") #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
(cond [#true #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
#true

; ---

(contains-flatt? (cons "A" (cons "Flatt" (cons "C" '()))))
(cond [(empty? (cons "A" (cons "Flatt" (cons "C" '())))) #false]
      [(string=? (first (cons "A" (cons "Flatt" (cons "C" '())))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "A" (cons "Flatt" (cons "C" '())))))])
(cond [#false #false]
      [(string=? (first (cons "A" (cons "Flatt" (cons "C" '())))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "A" (cons "Flatt" (cons "C" '())))))])
(cond [(string=? (first (cons "A" (cons "Flatt" (cons "C" '())))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "A" (cons "Flatt" (cons "C" '())))))])
(cond [(string=? "A" "Flatt") #true]
      [else (contains-flatt? (rest (cons "A" (cons "Flatt" (cons "C" '())))))])
(cond [#false #true]
      [else (contains-flatt? (rest (cons "A" (cons "Flatt" (cons "C" '())))))])
(cond [else (contains-flatt? (rest (cons "A" (cons "Flatt" (cons "C" '())))))])
(contains-flatt? (rest (cons "A" (cons "Flatt" (cons "C" '())))))
(contains-flatt? (cons "Flatt" (cons "C" '())))
(cond [(empty? (cons "Flatt" (cons "C" '()))) #false]
      [(string=? (first (cons "Flatt" (cons "C" '()))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
(cond [#false #false]
      [(string=? (first (cons "Flatt" (cons "C" '()))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
(cond [(string=? (first (cons "Flatt" (cons "C" '()))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
(cond [(string=? "Flatt" "Flatt") #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
(cond [#true #true]
      [else (contains-flatt? (rest (cons "Flatt" (cons "C" '()))))])
#true

; ---

(contains-flatt? (cons "A" (cons "B" (cons "C" '()))))
(cond [(empty? (cons "A" (cons "B" (cons "C" '())))) #false]
      [(string=? (first (cons "A" (cons "B" (cons "C" '())))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "A" (cons "B" (cons "C" '())))))])
(cond [#false #false]
      [(string=? (first (cons "A" (cons "B" (cons "C" '())))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "A" (cons "B" (cons "C" '())))))])
(cond [(string=? (first (cons "A" (cons "B" (cons "C" '())))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "A" (cons "B" (cons "C" '())))))])
(cond [(string=? "A" "Flatt") #true]
      [else (contains-flatt? (rest (cons "A" (cons "B" (cons "C" '())))))])
(cond [#false #true]
      [else (contains-flatt? (rest (cons "A" (cons "B" (cons "C" '())))))])
(cond [else (contains-flatt? (rest (cons "A" (cons "B" (cons "C" '())))))])
(contains-flatt? (rest (cons "A" (cons "B" (cons "C" '())))))
(contains-flatt? (cons "B" (cons "C" '())))
(cond [(empty? (cons "B" (cons "C" '()))) #false]
      [(string=? (first (cons "B" (cons "C" '()))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "B" (cons "C" '()))))])
(cond [#false #false]
      [(string=? (first (cons "B" (cons "C" '()))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "B" (cons "C" '()))))])
(cond [(string=? (first (cons "B" (cons "C" '()))) "Flatt") #true]
      [else (contains-flatt? (rest (cons "B" (cons "C" '()))))])
(cond [(string=? "B" "Flatt") #true]
      [else (contains-flatt? (rest (cons "B" (cons "C" '()))))])
(cond [#false #true]
      [else (contains-flatt? (rest (cons "B" (cons "C" '()))))])
(cond [else (contains-flatt? (rest (cons "B" (cons "C" '()))))])
(contains-flatt? (rest (cons "B" (cons "C" '()))))
(contains-flatt? (cons "C" '()))
(cond [(empty? (cons "C" '())) #false]
      [(string=? (first (cons "C" '())) "Flatt") #true]
      [else (contains-flatt? (rest (cons "C" '())))])
(cond [#false #false]
      [(string=? (first (cons "C" '())) "Flatt") #true]
      [else (contains-flatt? (rest (cons "C" '())))])
(cond [(string=? (first (cons "C" '())) "Flatt") #true]
      [else (contains-flatt? (rest (cons "C" '())))])
(cond [(string=? "C" "Flatt") #true]
      [else (contains-flatt? (rest (cons "C" '())))])
(cond [#false #true]
      [else (contains-flatt? (rest (cons "C" '())))])
(cond [else (contains-flatt? (rest (cons "C" '())))])
(contains-flatt? (rest (cons "C" '())))
(contains-flatt? '())
(cond [(empty? '()) #false]
      [(string=? (first '()) "Flatt") #true]
      [else (contains-flatt? (rest '()))])
(contains-flatt? '())
(cond [#true #false]
      [(string=? (first '()) "Flatt") #true]
      [else (contains-flatt? (rest '()))])
#false
