-- 12.1
data Tree a = Leaf | Node (Tree a) a (Tree a)
  deriving Show

instance Functor Tree where
  -- fmap :: (a -> b) -> Tree a -> Tree b
  fmap f Leaf = Leaf
  fmap f (Node l x r) = Node (fmap f l) (f x) (fmap f r)

-- 12.2
-- instance Functor ((->) a) where
--   -- fmap :: (b -> c) -> (a -> b) -> (a -> c)
--   fmap = (.)

-- 12.3
-- instance Applicative ((->) a) where
--   -- pure :: b -> (a -> b)
--   pure = const
--   -- (<*>) :: (a -> b -> c) -> (a -> b) -> (a -> c)
--   g <*> h = \x -> g x (h x)

-- 12.4
newtype ZipList a = Z[a]
  deriving Show

instance Functor ZipList where
  -- fmap :: (a -> b) -> ZipList a -> ZipList b
  fmap f (Z xs) = Z(fmap f xs)

instance Applicative ZipList where
  -- pure :: a -> ZipList a
  pure x = Z(repeat x)
  -- (<*>) :: ZipList (a -> b) -> ZipList a -> ZipList b
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

-- 12.7
data Expr a = Var a | Val Int | Add (Expr a) (Expr a)
  deriving Show

instance Functor Expr where
  fmap _ (Val x)   = Val x
  fmap g (Var x)   = Var (g x)
  fmap g (Add x y) = Add (fmap g x) (fmap g y)

instance Applicative Expr where
  pure x = Var x
  _       <*> Val x   = Val x
  Val x   <*> _       = Val x
  Var f   <*> Var x   = Var (f x)
  Var f   <*> Add x y = Add (fmap f x) (fmap f y)
  Add f g <*> x       = Add (f <*> x)  (g <*> x)

instance Monad Expr where
  return = pure
  Val x   >>= _ = Val x
  Var x   >>= f = f x
  Add x y >>= f = Add (x >>= f) (y >>= f)

-- 12.8
type State = Int
newtype ST a = S(State -> (a, State))

app :: ST a -> State -> (a, State)
app (S st) x = st x

instance Functor ST where
  -- fmap :: (a -> b) -> ST a -> ST b
  fmap g st = do s <- st
                 return $ g s

instance Applicative ST where
  -- pure :: a -> ST a
  pure x = S(\s -> (x,s))
  -- (<*>) :: ST (a -> b) -> ST a -> ST b
  stf <*> stx = do f <- stf
                   x <- stx
                   return $ f x

instance Monad ST where
  -- (>>=) :: ST a -> (a -> ST b) -> ST b
  st >>= f = S(\s -> let (x,s') = app st s in app (f x) s')
