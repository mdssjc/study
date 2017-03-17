;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-115) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 115

(define MESSAGE "traffic light expected, given: ")

; Any -> Boolean
; is the given value an element of TrafficLight
(define (light? x)
  (cond [(string? x) (or (string=? "red"    x)
                         (string=? "green"  x)
                         (string=? "yellow" x))]
        [else #false]))

; Any Any -> Boolean
; are the two values elements of TrafficLight and, 
; if so, are they equal
(check-expect (light=? "red"    "red")    #true)
(check-expect (light=? "red"    "green")  #false)
(check-expect (light=? "green"  "green")  #true)
(check-expect (light=? "yellow" "yellow") #true)
 
(define (light=? a-value another-value)
  (if (and (light? a-value) (light? another-value))
      (string=? a-value another-value)
      (error (string-append MESSAGE (if (light? a-value)
                                        another-value
                                        a-value)))))

(light=? "white" "yellow")
