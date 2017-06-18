;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname Naturals-and-Helpers-Design-Quiz) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; SPD2-Design-Quiz-1.rkt

(require 2htdp/image)


;; ======================================================================
;; Constants
(define COOKIES (circle 10 "solid" "brown"))


;; ======================================================================
;; Data Definitions

;; Natural is one of:
;;  - 0
;;  - (add1 Natural)
;; interp. a natural number
(define N0 0)         ; 0
(define N1 (add1 N0)) ; 1
(define N2 (add1 N1)) ; 2

#;
(define (fn-for-natural n)
  (cond [(zero? n) (...)]
        [else
         (... n   ; n is added because it's often useful
              (fn-for-natural (sub1 n)))]))

;; Template rules used:
;;  - one-of: two cases
;;  - atomic distinct: 0
;;  - compound: 2 fields
;;  - self-reference: (sub1 n) is Natural


;; PROBLEM 1:
;;
;; Complete the design of a function called pyramid that takes a natural
;; number n and an image, and constructs an n-tall, n-wide pyramid of
;; copies of that image.
;;
;; For instance, a 3-wide pyramid of cookies would look like this:
;;   0
;;  0 0
;; 0 0 0

;; Natural Image -> Image
;; produce an n-wide pyramid of the given image
(check-expect (pyramid 0 COOKIES) empty-image)
(check-expect (pyramid 1 COOKIES) COOKIES)
(check-expect (pyramid 3 COOKIES) (above COOKIES
                                         (beside COOKIES COOKIES)
                                         (beside COOKIES COOKIES COOKIES)))

;(define (pyramid n i) empty-image) ; Stub

(define (pyramid n i)
  (cond [(zero? n) empty-image]
        [else (above (pyramid (sub1 n) i)
                     (replicate-images n i))]))

;; Natural Image -> Image
;; replicate images in the range of n..0 in beside
(check-expect (replicate-images 0 COOKIES) empty-image)
(check-expect (replicate-images 1 COOKIES) COOKIES)
(check-expect (replicate-images 3 COOKIES) (beside COOKIES COOKIES COOKIES))

;(define (replicate-images n i) empty-image) ; Stub

(define (replicate-images n i)
  (cond [(zero? n) empty-image]
        [else (beside i
                      (replicate-images (sub1 n) i))]))


;; Problem 2:
;; Consider a test tube filled with solid blobs and bubbles.  Over time the
;; solids sink to the bottom of the test tube, and as a consequence the bubbles
;; percolate to the top.  Let's capture this idea in BSL.
;;
;; Complete the design of a function that takes a list of blobs and sinks each
;; solid blob by one. It's okay to assume that a solid blob sinks past any
;; neighbor just below it.
;;
;; To assist you, we supply the relevant data definitions.

;; Blob is one of:
;; - "solid"
;; - "bubble"
;; interp.  a gelatinous blob, either a solid or a bubble
;; Examples are redundant for enumerations

#;
(define (fn-for-blob b)
  (cond [(string=? b "solid") (...)]
        [(string=? b "bubble") (...)]))

;; Template rules used:
;; - one-of: 2 cases
;; - atomic distinct: "solid"
;; - atomic distinct: "bubble"

;; ListOfBlob is one of:
;; - empty
;; - (cons Blob ListOfBlob)
;; interp. a sequence of blobs in a test tube, listed from top to bottom.
(define LOB0 empty) ; empty test tube
(define LOB2 (cons "solid" (cons "bubble" empty))) ; solid blob above a bubble

#;
(define (fn-for-lob lob)
  (cond [(empty? lob) (...)]
        [else
         (... (fn-for-blob (first lob))
              (fn-for-lob (rest lob)))]))

;; Template rules used
;; - one-of: 2 cases
;; - atomic distinct: empty
;; - compound: 2 fields
;; - reference: (first lob) is Blob
;; - self-reference: (rest lob) is ListOfBlob


;; ListOfBlob -> ListOfBlob
;; produce a list of blobs that sinks the given solid blobs by one
(check-expect (sink empty) empty)
(check-expect (sink (cons "bubble" (cons "solid" (cons "bubble" empty))))
              (cons "bubble" (cons "bubble" (cons "solid" empty))))
(check-expect (sink (cons "solid" (cons "solid" (cons "bubble" empty))))
              (cons "bubble" (cons "solid" (cons "solid" empty))))
(check-expect (sink (cons "solid" (cons "bubble" (cons "bubble" empty))))
              (cons "bubble" (cons "solid" (cons "bubble" empty))))
(check-expect (sink (cons "solid" (cons "bubble" (cons "solid" empty))))
              (cons "bubble" (cons "solid" (cons "solid" empty))))
(check-expect (sink (cons "bubble" (cons "solid" (cons "solid" empty))))
              (cons "bubble" (cons "solid" (cons "solid" empty))))
(check-expect (sink (cons "solid" (cons "solid" (cons "bubble" (cons "bubble" empty)))))
              (cons "bubble" (cons "solid" (cons "solid" (cons "bubble" empty)))))

;(define (sink lob) empty) ; Stub

(define (sink lob)
  (percolate lob))

;; ListOfBlob -> ListOfBlob
;; percolate each solid blob in the list
(check-expect (percolate empty) empty)
(check-expect (percolate (cons "bubble" (cons "solid" (cons "bubble" empty))))
              (cons "bubble" (cons "bubble" (cons "solid" empty))))

;(define (percolate lob) empty) ; Stub

(define (percolate lob)
  (cond [(empty? lob) empty]
        [else (swap (first lob)
                    (percolate (rest lob)))]))

;; Blob ListOfBlob -> ListOfBlob
;; swap the solid with the bubble blob in the list
(check-expect (swap "solid" empty)  (cons "solid" empty))
(check-expect (swap "bubble" empty) (cons "bubble" empty))
(check-expect (swap "solid" (cons "bubble" empty)) (cons "bubble" (cons "solid" empty)))
(check-expect (swap "bubble" (cons "solid" empty)) (cons "bubble" (cons "solid" empty)))

;(define (swap b lob) empty) ; Stub

(define (swap b lob)
  (cond [(empty? lob) (cons b empty)]
        [else (if (solid-blob? b)
                  (cons (first lob) (cons b (rest lob)))
                  (cons b lob))]))

;; Blob -> Boolean
;; check if the blob is solid
(check-expect (solid-blob? "solid")  true)
(check-expect (solid-blob? "bubble") false)

;(define (solid-blob? b) #false) ; Stub

(define (solid-blob? b)
  (string=? b "solid"))
