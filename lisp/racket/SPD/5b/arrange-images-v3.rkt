;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname arrange-images-v3) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; arrange-images.rkt         (problem statement)
;; arrange-images-v1.rkt      (includes ListOfImage)
;; arrange-images-v2.rkt      (includes arrange-images and 2 wish-list entries)
;; arrange-images-v3.rkt      (includes arrange-images and layout-images, stub for sort-images)

(require 2htdp/image)


;; PROBLEM:
;;
;; In this problem imagine you have a bunch of pictures that you would like to
;; store as data and present in different ways. We'll do a simple version of that
;; here, and set the stage for a more elaborate version later.
;;
;; (A) Design a data definition to represent an arbitrary number of images.
;;
;; (B) Design a function called arrange-images that consumes an arbitrary number
;;     of images and lays them out left-to-right in increasing order of size.

;; Constants:
;(define BLANK (square 0 "solid" "white"))


;; Data definitions:

;; ListOfImage is one of:
;;  - empty
;;  - (cons Image ListOfImage)
;; interp. An arbitrary number of images
(define LOI1 empty)
(define LOI2 (cons (rectangle 10 20 "solid" "blue")
                   (cons (rectangle 20 30 "solid" "red")
                         empty)))
#;
(define (fn-for-loi loi)
  (cond [(empty? loi) (...)]
        [else
         (... (first loi)
              (fn-for-loi (rest loi)))]))


;; Functions:

;; ListOfImage -> Image
;; lay out images left to right in increasing order of size
;; sort images in increasing order of size and then lay them out left-to-right
(check-expect (arrange-images (cons (rectangle 10 20 "solid" "blue")
                                    (cons (rectangle 20 30 "solid" "red")
                                          empty)))
              (beside (rectangle 10 20 "solid" "blue")
                      (rectangle 20 30 "solid" "red")
                      empty-image))
(check-expect (arrange-images (cons (rectangle 20 30 "solid" "red")
                                    (cons (rectangle 10 20 "solid" "blue")
                                          empty)))
              (beside (rectangle 10 20 "solid" "blue")
                      (rectangle 20 30 "solid" "red")
                      empty-image))

;(define (arrange-images loi) empty-image) ;stub

(define (arrange-images loi)
  (layout-images (sort-images loi)))


;; ListOfImage -> Image
;; place images beside each other in order of list
(check-expect (layout-images empty) empty-image)
(check-expect (layout-images (cons (rectangle 10 20 "solid" "blue")
                                   (cons (rectangle 20 30 "solid" "red")
                                         empty)))
              (beside (rectangle 10 20 "solid" "blue")
                      (rectangle 20 30 "solid" "red")
                      empty-image))

;(define (layout-images loi) empty-image) ;stub

(define (layout-images loi)
  (cond [(empty? loi) empty-image]
        [else
         (beside (first loi)
                 (layout-images (rest loi)))]))

;; ListOfImage -> ListOfImage
;; sort images in increasing order of size (area)
(check-expect (sort-images empty) empty)
(check-expect (sort-images (cons (rectangle 10 20 "solid" "blue")
                                 (cons (rectangle 20 30 "solid" "red")
                                       empty)))
              (cons (rectangle 10 20 "solid" "blue")
                    (cons (rectangle 20 30 "solid" "red")
                          empty)))
(check-expect (sort-images (cons (rectangle 20 30 "solid" "red")
                                 (cons (rectangle 10 20 "solid" "blue")
                                       empty)))
              (cons (rectangle 10 20 "solid" "blue")
                    (cons (rectangle 20 30 "solid" "red")
                          empty)))
(check-expect (sort-images (cons (rectangle 30 40 "solid" "green")
                                 (cons (rectangle 10 20 "solid" "blue")
                                       (cons (rectangle 20 30 "solid" "red")
                                             empty))))
              (cons (rectangle 10 20 "solid" "blue")
                    (cons (rectangle 20 30 "solid" "red")
                          (cons (rectangle 30 40 "solid" "green")
                                empty))))

;(define (sort-images loi) loi) ; Stub

(define (sort-images loi)
  (cond [(empty? loi) empty]
        [else
         (insert (first loi)
                 (sort-images (rest loi)))])) ; result of natural recursion will be sorted

;; Image ListOfImage -> ListOfImage
;; insert img in proper place in lst (in increasing order of size)
;; ASSUME: lst is already sorted
;; !!!
(define (insert img lst) lst) ; Stub
