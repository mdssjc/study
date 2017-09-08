-- 3.1
x1 = ['a','b','c']              -- x1 :: [Char]
x2 = ('a','b','c')              -- x2 :: (Char, Char, Char)
x3 = [(False,'O'),(True,'1')]   -- x3 :: [(Bool, Char)]
x4 = ([False,True],['o','1'])   -- x4 :: ([Bool], [Char])
x5 = [tail,init,reverse]        -- x5 :: [[a] -> [a]]

-- 3.2
bools :: [Bool]
bools = [True, True, False]

nums :: [[Int]]
nums = [[1,2,3], [3,2,1]]

add' :: Int -> Int -> Int -> Int
add' a b c = a + b + c

copy :: a -> (a, a)
copy a = (a,a)

apply :: (a -> b) -> a -> b
apply f a = f a
