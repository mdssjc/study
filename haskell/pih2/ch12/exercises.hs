-- 12.1
data Tree a = Leaf | Node (Tree a) a (Tree a)
  deriving Show

instance Functor Tree where
  fmap f Leaf = Leaf
  fmap f (Node l x r) = Node (fmap f l) (f x) (fmap f r)

-- 12.2
-- instance Functor ((->) a) where
-- fmap :: (b -> c) -> (a -> b) -> (a -> c)
--   fmap = (.)

-- 12.3
-- instance Applicative ((->) a) where
--   pure = const
--   g <*> h = \x -> g x (h x)

-- 12.4
newtype ZipList a = Z[a]
  deriving Show

instance Functor ZipList where
  fmap f (Z xs) = Z(fmap f xs)

instance Applicative ZipList where
  pure x = Z(repeat x)
  (Z gs) <*> (Z xs) = Z[g x | (g,x) <- zip gs xs]

-- 12.5
-- instance Applicative Type where
--   pure id <*> x   = x
--   pure (g x)      = pure g <*> pure x
--   x <*> pure y    = pure (\g -> g y) <*> x
--   x <*> (y <*> z) = (pure (.) <*> x <*> y) <*> z

-- 12.6
newtype Fun a b = F (a -> b)

instance Functor (Fun a) where
  fmap g (F h) = F (g . h)

instance Applicative (Fun a) where
  pure x = F (\_ -> x)
  F g <*> F h = F (\x -> (g x) (h x))

instance Monad (Fun a) where
  return = pure
  F f >>= g = F h
    where h x = h' x
            where (F h') = g (f x)
