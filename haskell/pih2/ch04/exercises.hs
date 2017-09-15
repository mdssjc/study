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
