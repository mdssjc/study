-- 14.1
-- instance (Monoid a, Monoid b) => Monoid (a,b) where
--   -- mempty :: (a,b)
--   mempty = (mempty, mempty)

--   -- mappend :: (a,b) -> (a,b) -> (a,b)
--   (x1,y1) `mappend` (x2,y2) = (x1 `mappend` x2, y1 `mappend` y2)

-- 14.2
-- instance Monoid b => Monoid (a -> b) where
--   -- mempty :: a -> b
--   mempty = \_ -> mempty

--   -- mappend :: (a -> b) -> (a -> b) -> (a -> b)
--   f `mappend` g = \x -> f x `mappend` g x

-- 14.3
-- instance Foldable Maybe where
--   --fold :: Monoid a => Maybe a -> a
--   fold Nothing  = mempty
--   fold (Just x) = x

--   --foldMap :: Monoid b => (a -> b) -> Maybe a -> b
--   foldMap _ Nothing  = mempty
--   foldMap g (Just x) = g x

--   --foldr :: (a -> b -> b) -> b -> Maybe a -> b
--   foldr _ v _ Nothing = v
--   foldr g v (Just x)  = g x v

--   --foldl :: (a -> b -> a) -> a -> Maybe b -> a
--   foldl _ v Nothing  = v
--   foldl g v (Just x) = g v x

-- instance Traversable Maybe where
--   -- traverse :: Applicative f => (a -> f b) -> Maybe a -> f (Maybe b)
--   traverse _ Nothing  = pure Nothing
--   traverse g (Just x) = fmap Just (g x)

-- 14.4
-- data Tree a = Leaf | Node (Tree a) a (Tree a)
--             deriving Show

-- instance Foldable Tree where
--   --fold :: Monoid a => Tree a -> a
--   fold Leaf         = mempty
--   fold (Node l v r) = fold l `mappend` v `mappend` fold r

--   --foldMap :: Monoid b => (a -> b) -> Tree a -> b
--   foldMap _ Leaf         = mempty
--   foldMap g (Node l v r) = foldMap g l `mappend` g v `mappend` foldMap g r

--   --foldr :: (a -> b -> b) -> b -> Tree a -> b
--   foldr g a Leaf         = a
--   foldr g a (Node l v r) = foldr g (foldr g (g v a) r) l

--   --foldl :: (a -> b -> a) -> a -> Tree b -> a
--   foldl _ a Leaf         = a
--   foldl g a (Node l v r) = foldl g (foldl g (g a v) r) r

-- instance Traversable Maybe where
--   -- traverse :: Applicative f => (a -> f b) -> Tree a -> f (Tree b)
--   traverse _ Leaf         = pure Leaf
--   traverse g (Node l v r) = fmap Node (traverse g l) (g x) (traverse g r)

-- 14.5
filterF :: Foldable t => (a -> Bool) -> t a -> [a]
filterF f = foldl (\xs x -> (if f x then [x] else []) ++ xs) []
