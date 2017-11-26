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

-- 15.4
fibs :: [Integer]
fibs = 0 : 1 : [a+b | (a,b) <- zip fibs (tail fibs)]

-- 15.5
data Tree a = Leaf | Node (Tree a) a (Tree a)
            deriving Show

repeat' :: a -> Tree a
repeat' x = Node (repeat' x) x (repeat' x)

take' :: Int -> Tree a -> Tree a
take' 0 _            = Leaf
take' n (Node l v r) = Node (take' (n-1) l) v (take' (n-1) r)

replicate' :: Int -> a -> Tree a
replicate' n = take' n . repeat'
