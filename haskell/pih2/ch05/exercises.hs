-- 5.1
res = [x | x <- [12,22..1002]]

-- 5.2
grid :: Int -> Int -> [(Int, Int)]
grid x y = [(a, b) | a <- [0..x], b <- [0..y]]
