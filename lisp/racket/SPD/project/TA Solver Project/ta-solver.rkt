;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname ta-solver) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
;; ta-solver.rkt


;; PROBLEM 1:
;; 
;; Consider a social network similar to Twitter called Chirper. Each user has a name, a note about
;; whether or not they are a verified user, and follows some number of people. 
;; 
;; Design a data definition for Chirper, including a template that is tail recursive and avoids 
;; cycles. 
;; 
;; Then design a function called most-followers which determines which user in a Chirper Network is 
;; followed by the most people.
 
;; Data definitions:

(define-struct user (name verified following))
;; User is (make-user String Boolean (listof User)
;; interp. represents an user with
;;         - a name;
;;         - a note about whether or not they are a verified user; and
;;         - follows some number of people
(define C1 (make-user "Joseph" #true  empty))
(define C2 (make-user "Marie"  #false empty))
(define C3 (make-user "Paul"   #true (list C1 C2)))
(define C4 (make-user "Jones"  #true (list C1 C3)))

#;
(define (fn-for-user u0)
  (local ((define (fn-for-user u todo visited)
            (if (member u visited)
                (fn-for-lou todo visited)
                (fn-for-lou (append (user-following u) todo)
                            (cons u visited))))

          (define (fn-for-lou todo visited)
            (cond [(empty? todo) ...]
                  [else
                   (fn-for-user (first todo)
                                (rest todo)
                                visited)])))
    (fn-for-user u0 ... ...)))


;; Functions:

;; User -> User
;; determines which user in a Chirper Network is followed by the most people
(check-expect (most-followers C1) empty)
(check-expect (most-followers C3) C1)
(check-expect (most-followers C4) C1)

;(define (most-followers u) u) ; Stub

(define (most-followers u0)
  (local ((define (fn-for-user u todo visited rsf)
            (if (member u visited)
                (fn-for-lou todo visited rsf)
                (fn-for-lou (append (user-following u) todo)
                            (cons u visited)
                            (append (user-following u) rsf))))

          (define (fn-for-lou todo visited rsf)
            (cond [(empty? todo) (max-user rsf)]
                  [else
                   (fn-for-user (first todo)
                                (rest todo)
                                visited
                                rsf)]))

          (define (count-user r rsf)
            (length (filter (lambda (r)
                              (string=? (user-name r) (user-name r)))
                            rsf)))

          (define (max-user r)
            (cond [(empty? r) empty]
                  [else
                   (local ((define try (max-user (rest r))))
                     (if (>= (count-user (first r) r)
                             (count-user try r))
                         (first r)
                         try))])))
    (fn-for-user u0 empty empty empty)))


;; PROBLEM 2:
;; 
;; In UBC's version of How to Code, there are often more than 800 students taking 
;; the course in any given semester, meaning there are often over 40 Teaching Assistants. 
;; 
;; Designing a schedule for them by hand is hard work - luckily we've learned enough now to write 
;; a program to do it for us! 
;; 
;; Below are some data definitions for a simplified version of a TA schedule. There are some 
;; number of slots that must be filled, each represented by a natural number. Each TA is 
;; available for some of these slots, and has a maximum number of shifts they can work. 
;; 
;; Design a search program that consumes a list of TAs and a list of Slots, and produces one
;; valid schedule where each Slot is assigned to a TA, and no TA is working more than their 
;; maximum shifts. If no such schedules exist, produce false. 
;;
;; You should supplement the given check-expects and remember to follow the recipe!

;; Slot is Natural
;; interp. each TA slot has a number, is the same length, and none overlap

(define-struct ta (name max avail))
;; TA is (make-ta String Natural (listof Slot))
;; interp. the TA's name, number of slots they can work, and slots they're available for

(define SOBA (make-ta "Soba" 2 (list 1 3)))
(define UDON (make-ta "Udon" 1 (list 3 4)))
(define RAMEN (make-ta "Ramen" 1 (list 2)))

(define NOODLE-TAs (list SOBA UDON RAMEN))

(define-struct assignment (ta slot))
;; Assignment is (make-assignment TA Slot)
;; interp. the TA is assigned to work the slot

;; Schedule is (listof Assignment)


;; ============================= FUNCTIONS

;; (listof TA) (listof Slot) -> Schedule or false
;; produce valid schedule given TAs and Slots; false if impossible
(check-expect (schedule-tas empty empty) empty)
(check-expect (schedule-tas empty (list 1 2)) false)
(check-expect (schedule-tas (list SOBA) empty) empty)
(check-expect (schedule-tas (list SOBA) (list 1)) (list (make-assignment SOBA 1)))
(check-expect (schedule-tas (list SOBA) (list 2)) false)
(check-expect (schedule-tas (list SOBA) (list 1 3)) (list (make-assignment SOBA 3)
                                                          (make-assignment SOBA 1)))
(check-expect (schedule-tas NOODLE-TAs (list 1 2 3 4)) 
              (list
               (make-assignment UDON 4)
               (make-assignment SOBA 3)
               (make-assignment RAMEN 2)
               (make-assignment SOBA 1)))
(check-expect (schedule-tas NOODLE-TAs (list 1 2 3 4 5)) false)

;(define (schedule-tas tas slots) empty) ; Stub

(define (schedule-tas tas slots)
  (local ((define (schedule-tas tas slots rsf)   
            (cond [(empty? slots) rsf]
                  [(empty? tas) false]
                  [else
                   (local ((define slot (first slots))
                           (define (count ta rsf)
                             (length (filter (lambda (x)
                                               (equal? x ta))
                                             rsf)))
                           (define try (filter (lambda (ta)
                                                 (and (<= (count ta rsf) (ta-max ta))
                                                      (member slot (ta-avail ta))))
                                               tas)))
                     (if (not (empty? try))
                         (schedule-tas tas
                                       (rest slots)
                                       (cons (make-assignment (first try) slot) rsf))
                         false))])))
    (schedule-tas tas slots empty)))
