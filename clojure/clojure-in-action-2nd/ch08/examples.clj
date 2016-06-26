(defn square [x]
  (* x x))
(defn square-all [numbers]
  (if (empty? numbers)
    nil
    (cons (square (first numbers))
          (square-all (rest numbers)))))
(square-all [1 2 3 4 5 6])

(defn cube [x]
  (* x x x))
(defn cube-all [numbers]
  (if (empty? numbers)
    nil
    (cons (cube (first numbers))
          (cube-all (rest numbers)))))
(cube-all [1 2 3 4 5 6])

(defn do-to-all [f numbers]
  (lazy-seq
   (if (empty? numbers)
     ()
     (cons (f (first numbers))
           (do-to-all f (rest numbers))))))
(do-to-all square [1 2 3 4 5 6])
(do-to-all cube [1 2 3 4 5 6])
(do-to-all square (range 11000))

(map square [1 2 3 4 5 6])
