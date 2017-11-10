subs :: [a] -> [[a]]
subs [] = [[]]
subs (x:xs) = yss ++ map (x:) yss
  where yss = subs xs

interleave :: a -> [a] -> [[a]]
interleave x [] = [[x]]
interleave x (y:ys) = (x:y:ys) : map (y:) (interleave x ys)

perms :: [a] -> [[a]]
perms [] = [[]]
perms (x:xs) = concat $ map (interleave x) (perms xs)

choices :: [a] -> [[a]]
choices = concat . map perms . subs

-- 9.1
choices' :: [a] -> [[a]]
choices' xs = [xs | xss <- subs xs, xs <- perms xss]

-- 9.2
isChoice :: Eq a => [a] -> [a] -> Bool
isChoice [] ys = True
isChoice (x:xs) ys = (elem x ys) && (isChoice xs ys)

-- 9.3
split :: [a] -> [([a], [a])]
split xs = [(take n xs, drop n xs) | n <- [0..length xs]]
