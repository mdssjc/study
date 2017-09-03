-- 1.1
double :: Num a => a -> a
double x = 2 * x

-- 1.2
sum' :: Num a => [a] -> a
sum' []     = 0
sum' (x:xs) = x + sum' xs
