-- 15.1
-- 1 + (2*3): both
-- (1+2) * (2+3): innermost
-- fst(1+2, 2+3): both
-- (\x -> 1+x)(2*3): both

-- 15.2
-- outermost
-- fst(1+2, 2+3)
-- 1+2
-- 3

-- innermost
-- fst(1+2, 2+3)
-- fst(3, 2+3)
-- fst(3, 5)
-- 3

-- Outermost is preferable.

-- 15.3
mult :: Int -> Int -> Int
mult = \x -> (\y -> x * y)

-- mult 3 4
-- (\x -> (\y -> x * y)) 3 4
-- (\y -> 3 * y) 4
-- 3 * 4
-- 12
