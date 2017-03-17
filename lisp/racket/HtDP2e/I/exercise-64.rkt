;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-64) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 64

(define (manhattan-distance p1 p2)
  (+ (abs (- (posn-x p1)
             (posn-x p2)))
     (abs (- (posn-y p1)
             (posn-y p2)))))

(manhattan-distance (make-posn 0 0)
                    (make-posn 4 4))
