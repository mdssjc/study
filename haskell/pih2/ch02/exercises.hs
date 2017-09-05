-- 2.1
double x = x + x
quadruple x = double(double x)
average ns = sum ns `div` length ns

-- 2.2
x1 = (2 ^ 3) * 4
x2 = (2 * 3) + (4 * 5)
x3 = 2 + (3 * (4 ^ 5))

-- 2.3
n = a `div` (length xs)
  where
    a = 10
    xs = [1,2,3,4,5]

-- 2.4
x4 = head (reverse [1,2,3,4,5])

-- 2.5
x5 = reverse (tail (reverse [1,2,3,4,5]))
x6 = take (length xs - 1) xs
  where
    xs = [1,2,3,4,5]
