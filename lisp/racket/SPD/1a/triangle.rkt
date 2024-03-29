;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname triangle-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; triangle.rkt
;; BSL P10
;; Write an expression that operates on images using image primitives.

(require 2htdp/image)


;; PROBLEM:
;;
;; Write an expression that uses triangle, overlay, and rotate to
;; produce an image similar to this:
;;
;;  -----------
;;  \    X    / ---> Yellow
;;   \  / \  /
;;    \/   \/
;;    /     \
;;   /       \
;;  /         \ ---> Green
;;  -----------
;;
;; You can consult the DrRacket help desk for information on how to
;; use triangle and overlay.
;; Don't worry about the exact size of the triangles.

(overlay (triangle 40 "solid" "green")
         (rotate 180 (triangle 40 "solid" "yellow")))
