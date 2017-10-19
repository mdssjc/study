-- 7.1
hofmf :: (a -> b) -> (a -> Bool) -> [a] -> [b]
hofmf f p xs = map f $ filter p xs

-- 7.2
all' :: (a -> Bool) -> [a] -> Bool
all' p xs = and $ map p xs

any' :: (a -> Bool) -> [a] -> Bool
any' p xs = or $ map p xs

takeWhile' :: (a -> Bool) -> [a] -> [a]
takeWhile' _ [] = []
takeWhile' p (x:xs)
  | p x = x : takeWhile' p xs
  | otherwise = []

dropWhile' :: (a -> Bool) -> [a] -> [a]
dropWhile' _ [] = []
dropWhile' p (x:xs)
  | p x = dropWhile' p xs
  | otherwise = x:xs

-- 7.3
map2 :: (a -> b) -> [a] -> [b]
map2 f xs = foldr (\x acc -> f x:acc) [] xs

filter2 :: (a -> Bool) -> [a] -> [a]
filter2 p xs = foldr (\x acc -> if p x then x:acc else acc) [] xs

-- 7.4
dec2int :: [Int] -> Int
dec2int (x:xs) = foldl (\acc x -> x + acc * 10) x xs

-- 7.5
curry' :: ((a, b) -> c) -> a -> b -> c
curry' fn = \x -> \y -> fn(x, y)

uncurry' :: (a -> b -> c) -> ((a, b) -> c)
uncurry' fn = \(x, y) -> fn x y
