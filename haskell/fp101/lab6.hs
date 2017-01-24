import           Data.Foldable

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

--
data Rose a = a :> [Rose a] deriving Show

root :: Rose a -> a
root (a :> _) = a

children :: Rose a -> [Rose a]
children (_ :> rs) = rs

size :: Rose a -> Int
size (_ :> rs) = 1 + sum (map size rs)

leaves :: Rose a -> Int
leaves (_ :> []) = 1
leaves (_ :> rs) = sum (map leaves rs)

instance Functor Rose where
  fmap f (a :> rs) = f a :> map (fmap f) rs

--
newtype Sum a = Sum a deriving Show
newtype Product a = Product a deriving Show

unSum :: Sum a -> a
unSum (Sum a) = a

unProduct :: Product a -> a
unProduct (Product a) = a

instance Num x => Monoid (Sum x) where
  mempty = Sum 0
  mappend (Sum a) (Sum b) = Sum (a + b)

instance Num x => Monoid (Product x) where
  mempty = Product 1
  mappend (Product a) (Product b) = Product (a * b)

--
instance Foldable Rose where
  fold (a :> rs) = (h.g) rs `mappend` a
    where g = map (fold)
          h = foldr (mappend) mempty
  foldMap f a = fold $ fmap f a
  foldr = undefined

--
fproduct, fsum :: (Foldable f, Num a) => f a -> a
fsum f = unSum $ foldMap (\a -> Sum a) f
fproduct f = unProduct $ foldMap (\a -> Product a) f
