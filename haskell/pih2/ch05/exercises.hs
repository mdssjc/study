-- 5.1
res = [x | x <- [12,22..1002]]

-- 5.2
grid :: Int -> Int -> [(Int, Int)]
grid x y = [(a, b) | a <- [0..x], b <- [0..y]]

-- 5.3
square :: Int -> [(Int, Int)]
square x = [(a, b) | a <- [0..x], b <- [0..x], a /= b]

-- 5.4
replicate' :: Int -> a -> [a]
replicate' n t = [t | _ <- [1..n]]

-- 5.5
pyths :: Int -> [(Int, Int, Int)]
pyths n = [(a, b, c) | a <- [1..n], b <- [1..n], c <- [1..n], a*a + b*b == c*c]

-- 5.6
factors :: Int -> [Int]
factors n = [x | x <- [1..n], n `mod` x == 0]

perfects :: Int -> [Int]
perfects n = [last f | f <- [factors x | x <- [1..n]], (sum . init $ f) == (last f)]

-- 5.7
x1 = [(x,y) | x <- [1,2], y <- [3,4]]
x2 = concat [[(x,y) | y <- [3,4]] | x <- [1,2]]

-- 5.8
find :: Eq a => a -> [(a,b)] -> [b]
find k t = [v | (k',v) <- t, k == k']

positions :: Eq a => a -> [a] -> [Int]
positions x xs = find x $ zip xs [0..]

-- 5.9
scalarproduct :: [Int] -> [Int] -> Int
scalarproduct xs ys = sum [x * y | (x,y) <- zip xs ys]
