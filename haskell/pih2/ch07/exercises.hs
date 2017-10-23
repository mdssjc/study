import Data.Char

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

-- 7.6
type Bit = Int

unfold :: (a -> Bool) -> (a -> b) -> (a -> a) -> a -> [b]
unfold p h t x
  | p x = []
  | otherwise = h x : unfold p h t (t x)

chop8 :: [Bit] -> [[Bit]]
chop8 = unfold (\x -> (length x) == 0) (take 8) (drop 8)

map3 :: (a -> b) -> [a] -> [b]
map3 f = unfold (null) (f . head) (tail)

iterate2 :: (a -> a) -> a -> [a]
iterate2 f = unfold (\_ -> False) (\x -> x) (f)

-- 7.7
int2bin :: Int -> [Bit]
int2bin 0 = []
int2bin n = n `mod` 2 : int2bin(n `div` 2)

bin2int :: [Bit] -> Int
bin2int bits = sum[w*b | (w,b) <- zip weights bits]
  where weights = iterate(*2) 1

parity :: [Int] -> Int
parity xs = if (odd . length $ filter (==1) xs) then 1 else 0

make8 :: [Bit] -> [Bit]
make8 bits = take 8 (bits ++ repeat 0)

encode :: String -> [Int]
encode = addParity . concat . map(make8 . int2bin . ord)
  where
    addParity xs =  xs ++ [parity xs]

decode :: [Bit] -> String
decode = map(chr . bin2int) . chop8 . checkParity
  where
    checkParity xs = if (parity . init $ xs) == last xs && length xs == 9
                     then init xs
                     else error "Parity Error"

channel :: [Bit] -> [Bit]
channel = id

transmit :: String -> String
transmit = decode . channel . encode

-- 7.8
channelFaulty :: [Bit] -> [Bit]
channelFaulty = tail

transmitFaulty :: String -> String
transmitFaulty = decode . channelFaulty . encode

-- 7.9
altMap :: (a -> b) -> (a -> b) -> [a] -> [b]
altMap f1 f2 []       = []
altMap f1 f2 (x:[])   = [f1 x]
altMap f1 f2 (x:y:[]) = [f1 x, f2 y]
altMap f1 f2 (x:y:xs) = [f1 x, f2 y] ++ altMap f1 f2 xs

-- 7.10
luhnDouble :: Int -> Int
luhnDouble d
  | v > 9 = v - 9
  | otherwise = v
  where v = 2 * d

luhn :: [Int] -> Bool
luhn xs = sum(altMap (luhnDouble) (\x -> x) xs) `mod` 10 == 0
