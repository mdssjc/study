evens :: [Integer] -> [Integer]
evens xs = [x | x <- xs, even x]

squares :: Integer -> [Integer]
squares 0 = []
squares n = [x*x | x <- [1..n]]

sumSquares :: Integer -> Integer
sumSquares n = sum (squares n)

squares' :: Integer -> Integer -> [Integer]
squares' 0 _ = []
squares' m n = [x*x | x <- [1+n..m+n]]

sumSquares' :: Integer -> Integer
sumSquares' x = sum . uncurry squares' $ (x, x)

coords :: Integer -> Integer -> [(Integer, Integer)]
coords m n = [(x,y) | x <- [0..m], y <- [0..n]]
