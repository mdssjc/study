;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-104) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 104

; Vehicle is one of:
; - "automobile"
; - "van"
; - "bus"
; - "SUV"
; - "truck"
; interpretation a vehicle of fleet

(define-struct fleet (vehicle passenger license fuel))
; Fleet is a structure:
; interpretation (make-fleet Vehicle Number Number Number)
;  vehicle means a vehicle type
;  passenger means the total number
;  license means the code
;  fuel means the current value
(define (fn-to-fleet f)
  (... (fleet-vehicle f)
       (fleet-passenger f)
       (fleet-license f)
       (fleet-fuel f)))
