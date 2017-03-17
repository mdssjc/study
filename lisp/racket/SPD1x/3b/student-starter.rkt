;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname student-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))

;; student-starter.rkt

;; =================
;; Data definitions:

; 
; PROBLEM A:
; 
; Design a data definition to help a teacher organize their next field trip. 
; On the trip, lunch must be provided for all students. For each student, track 
; their name, their grade (from 1 to 12), and whether or not they have allergies.
; 


(define-struct student (name grade allergie?))
;; Student is (make-student String Natural[1..12] Boolean)
;; interp. a student in trip with name, grade (1 to 12) and allergies

(define S1 (make-student "Joseph" 5 false))
(define S2 (make-student "Maria" 10 true))

#;
(define (fn-for-student s)
  (... (student-name s)        ; String
       (student-grade s)       ; Natural[1..12]
       (student-allergie? s))) ; Boolean

;; Template rules used:
;;  - compound: 3 fields

;; =================
;; Functions:

; 
; PROBLEM B:
; 
; To plan for the field trip, if students are in grade 6 or below, the teacher 
; is responsible for keeping track of their allergies. If a student has allergies, 
; and is in a qualifying grade, their name should be added to a special list. 
; Design a function to produce true if a student name should be added to this list.
; 


;; Student -> Boolean
;; produce true if a student is special: grade 6 or below with allergies
(check-expect (special? S1) false)
(check-expect (special? S2) false)
(check-expect (special? (make-student "Petter" 3 true)) true)

#;
(define (special? s) false) ; Stub

(define (special? s)
  (and (<= (student-grade s) 6)
       (student-allergie? s)))
