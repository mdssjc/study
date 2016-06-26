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
(map square (range 11000))

;;;
(defn total-of [numbers]
  (loop [nums numbers sum 0]
    (if (empty? nums)
      sum
      (recur (rest nums) (+ sum (first nums))))))
(total-of [5 7 9 3 4 1 2 8])

(defn larger-of [x y]
  (if (> x y) x y))
(defn largest-of [numbers]
  (loop [l numbers candidate (first numbers)]
    (if (empty? l)
      candidate
      (recur (rest l) (larger-of candidate (first l))))))
(largest-of [5 7 9 3 4 1 2 8])
(largest-of [])

(defn compute-across [func elements value]
  (if (empty? elements)
    value
    (recur func (rest elements) (func value (first elements)))))
(defn total-of [numbers]
  (compute-across + numbers 0))
(defn largest-of [numbers]
  (compute-across larger-of numbers (first numbers)))
(total-of [5 7 9 3 4 1 2 8])
(largest-of [5 7 9 3 4 1 2 8])

(defn all-greater-than [threshold numbers]
  (compute-across #(if (> %2 threshold) (conj %1 %2) %1) numbers []))
(defn all-greater-than [threshold numbers]
  (reduce #(if (> %2 threshold) (conj %1 %2) %1) [] numbers))
(all-greater-than 5 [5 7 9 3 4 1 2 8])
