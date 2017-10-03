-- 6.1
fac :: Int -> Int
fac n
  | n < 0 = 1
  | n == 0 = 1
  | otherwise = n * fac(n-1)

-- 6.2
sumdown :: Int -> Int
sumdown 0 = 0
sumdown n = n + sumdown (n - 1)

-- 6.3
(<^>) :: Int -> Int -> Int
b <^> 0 = 1
b <^> e = b * (b <^> (e - 1))

-- 6.4
euclid :: Int -> Int -> Int
euclid a b
  | a == b = a
  | otherwise = if (a < b) then euclid a (b - a) else euclid (a - b) b

-- 6.5
length' :: [a] -> Int
length' [] = 0
length' (_:xs) = 1 + length' xs

drop' :: Int -> [a] -> [a]
drop' 0 xs = xs
drop' _ [] = []
drop' n (_:xs) = drop (n - 1) xs

init' :: [a] -> [a]
init' [_] = []
init' (x:xs) = x : init' xs
