-- 4.1
halve :: [a] -> ([a], [a])
halve xs = (take n xs, drop n xs)
  where n = length xs `div` 2

-- 4.2
third :: [a] -> a
--third xs = head (tail (tail xs)) -- a. head and tail
--third xs = xs !! 2               -- b. list indexing !!
third (_:_:x:_) = x                -- c. pattern matching

-- 4.3
safetail :: [a] -> [a]
-- safetail xs = if null xs        -- a. conditional expression
--               then []
--               else tail xs
-- safetail xs                     -- b. guarded expression
--   | null xs = []
--   | otherwise = tail xs
safetail [] = []                   -- c. pattern matching
safetail xs = tail xs

-- 4.4
-- (||) :: Bool -> Bool -> Bool
-- True || True = True
-- True || False = True
-- False || True = True
-- False || False = False

-- False || False = False
-- _ || _ = True

-- True || _ = True
-- False || b = b

-- b || False = b
-- _ || _ = True

-- 4.5
and1 :: Bool -> Bool -> Bool
and1 a b = if a == True
           then if b == True
                then True
                else False
           else False

-- 4.6
and2 :: Bool -> Bool -> Bool
and2 a b = if a == True
           then b
           else False

-- 4.7
mult :: Int -> Int -> Int -> Int
mult = \x -> \y -> \z -> x * y * z
