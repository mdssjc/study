-- 1.1
double :: Num a => a -> a
double x = 2 * x

-- 1.2
sum' :: Num a => [a] -> a
sum' []     = 0
sum' (x:xs) = x + sum' xs

-- 1.3
product' :: Num a => [a] -> a
product' []     = 1
product' (x:xs) = x * product' xs

-- 1.4
qsortReverse :: Ord a => [a] -> [a]
qsortReverse []     = []
qsortReverse (x:xs) = qsortReverse larger ++ [x] ++ qsortReverse smaller
  where
    smaller = [a | a <- xs, a <= x]
    larger  = [b | b <- xs, b > x]

-- 1.5
qsortBugged :: Ord a => [a] -> [a]
qsortBugged []     = []
qsortBugged (x:xs) = qsortBugged smaller ++ [x] ++ qsortBugged larger
  where
    smaller = [a | a <- xs, a < x]
    larger  = [b | b <- xs, b > x]
