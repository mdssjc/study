;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname |22-Project: The Commerce of XML|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; 22-Project: The Commerce of XML.rkt
;; IV - Intertwined Data
;; 22 - Project: The Commerce of XML



;; 22.1 - XML as S-expressions


;; =================
;; Data definitions:

; An Xexpr.v0 (short for X-expression) is a one-item list:
;   (cons Symbol '())

; An Xexpr.v1 is a list:
;   (cons Symbol [List-of Xexpr.v1])

; An Xexpr.v2 is a list:
; - (cons Symbol Body)
; - (cons Symbol (cons [List-of Attribute] Body))
; where Body is short for [List-of Xexpr.v2]
; An Attribute is a list of two items:
;   (cons Symbol (cons String '()))

;; Exercise 363

; An Xexpr.v2 is a list:
; - (cons Symbol XL)
; An XL is one of:
; - '()
; - Xexpr.v2
; - (cons Xexpr.v2 XL)
; - (cons AL (cons Xexpr.v2 XL))
; An AL is one of:
; - '()
; - (cons Attribute AL)
; An Attribute is a list of two items:
;   (cons Symbol (cons String '()))
