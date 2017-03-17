;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname exercise-69) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; Exercise 69

(define-struct movie [title producer year])
(make-movie "Title" "Producer" 2017)
;                  +-----+
;                  |movie|
;+-------+---------++----+
;|title  |producer  |year|
;| ----- | -------- | -- |
;|"Title"|"Producer"|2017|
;+-------+----------+----+

(define-struct person [name hair eyes phone])
(make-person "Name" "Hair" "Eyes" "Phone")
;                      +------+
;                      |person|
;+------+------+------++------+
;|name  |hair  |eyes  |phone  |
;| ---- | ---- | ---- | ----- |
;|"Name"|"Hair"|"Eyes"|"Phone"|
;+------+------+------+-------+

(define-struct pet [name number])
(make-pet "Name" 123)
;          +---+
;          |pet|
;+------+--+---+
;|name  |number|
;| ---- | ---- |
;|"Name"|123   |
;+------+------+

(define-struct CD [artist title price])
(make-CD "Artist" "Title" 1.99)
;                    +--+
;                    |CD|
;+--------+-------+--+--+
;|artist  |title  |price|
;| ------ | ----- | --- |
;|"Artist"|"Title"|1.99 |
;+--------+-------+-----+

(define-struct sweater [material size producer])
(make-sweater "Material" 4 "Producer")
;                   +-------+
;                   |sweater|
;+----------+----+--+-------+
;|material  |size|producer  |
;| -------- | -- | -------- |
;|"Material"|4   |"Producer"|
;+----------+----+----------+
