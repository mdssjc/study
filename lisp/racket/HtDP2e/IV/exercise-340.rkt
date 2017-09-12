;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname exercise-340) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 340

(require htdp/dir)


;; =================
;; Constants:

;(define O (create-dir "/Users/...")) ; on OS X 
(define L (create-dir "/var/log/")) ; on Linux
;(define W (create-dir "C:\\Users\\...")) ; on Windows 


;; ====================
;; Functions:

; Dir -> [List-of String]
; lists the names of all files and directories in a given Dir
(check-expect (ls (make-dir "root" empty empty)) empty)
(check-satisfied (ls L)
                 (lambda (result)
                   (local ((define (ok? l count)
                             (cond [(or (empty? l)
                                        (zero? count)) #true]
                                   [else
                                    (and (member? (first l)
                                                  (list "user-1000@f7e498fc2d7342298246e14066beb6fd-000000000000021f-00054c0e15c92f52.journal"
                                                        "user-1000@f34b467b51394441962018f2b047cef3-00000000000001fd-00055788e364614d.journal"
                                                        "user-1000@ba0521e63c5e41c893ab55bff49876db-0000000000000214-000542d3bb66aed4.journal"
                                                        "user-1000@00055788e3647d7d-48a165f7930d75e9.journal~"
                                                        "user-1000@0005574344263612-354112e20df69f19.journal~"))
                                         (ok? (rest l) (sub1 count)))])))
                     (ok? result 5)))) ; check on your system

(define (ls d)
  (append (foldl (lambda (d acc)
                   (append (ls d) acc))
                 empty (dir-dirs d))
          (foldl (lambda (f acc)
                   (cons (file-name f) acc))
                 empty (dir-files d))))
