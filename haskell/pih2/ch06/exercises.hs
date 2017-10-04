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

-- 6.6
and' :: [Bool] -> Bool
and' [] = True
and' (x:xs) = x && and' xs

concat' :: [[a]] -> [a]
concat' [] = []
concat' (xs:xss) = xs ++ concat' xss

replicate' :: Int -> a -> [a]
replicate' 0 e = []
replicate' n e = e : replicate' (n - 1) e

(<!!>) :: [a] -> Int -> a
[] <!!> _ = error "index too large"
(x:_) <!!> 0 = x
(x:xs) <!!> n = xs <!!> (n - 1)

elem' :: Eq a => a -> [a] -> Bool
elem' _ [] = False
elem' e (x:xs) = if e == x then True else elem' e xs

-- 6.7
merge :: Ord a => [a] -> [a] -> [a]
merge xs [] = xs
merge [] ys = ys
merge xs_@(x:xs) ys_@(y:ys) =
  if x < y
  then x : merge xs ys_
  else y : merge xs_ ys

-- 6.8
msort :: Ord a => [a] -> [a]
msort [] = []
msort [a] = [a]
msort xs = merge (msort l) (msort r)
  where
    halves = halve xs
    l = fst halves
    r = snd halves

halve :: [a] -> ([a], [a])
halve xs = (take n xs, drop n xs)
  where n = length xs `div` 2
