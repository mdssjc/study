;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname overlay-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; overlay.rkt
;; BSL P14

(require 2htdp/image)


;; PROBLEM:
;;
;; Write an expression that uses star and overlay to produce an image similar to this:
;; [Overlay Star Image]
;;
;; You can consult the DrRacket help desk for information on how to use star and overlay.
;; Don't worry about the exact size of the stars.

(overlay (star 10 "solid" "blue")
         (star 30 "solid" "yellow")
         (star 50 "solid" "blue"))
