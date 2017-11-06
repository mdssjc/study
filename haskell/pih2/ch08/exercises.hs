-- 8.1
data Nat = Zero | Succ Nat
  deriving (Show, Eq)

add :: Nat -> Nat -> Nat
add Zero n = n
add (Succ m) n = Succ(add m n)

mult :: Nat -> Nat -> Nat
mult Zero n = Zero
mult m Zero = Zero
mult m (Succ n) = if n == Zero then m else mult (add m m) n

-- 8.2
data Tree a = Leaf a | Node (Tree a) a (Tree a)

t :: Tree Int
t = Node (Node (Leaf 1) 3 (Leaf 4)) 5 (Node (Leaf 6) 7 (Leaf 9))

occurs :: Ord a => a -> Tree a -> Bool
occurs x (Leaf y) = x == y
occurs x (Node l y r) = case compare x y of
                          EQ -> True
                          LT -> occurs x l
                          GT -> occurs x r

-- 8.3
data Tree2 a = Leaf2 a | Node2 (Tree2 a) (Tree2 a)

balanced :: Tree2 a -> Bool
balanced (Leaf2 _) = True
balanced (Node2 l r) = (abs $ leafs l - leafs r) <= 1

leafs :: Tree2 a -> Int
leafs (Leaf2 a) = 1
leafs (Node2 l r) = leafs l + leafs r

-- 8.4
data Tree3 a = Leaf3 a | Node3 (Tree3 a) (Tree3 a)
  deriving (Show)

balance :: [a] -> Tree3 a
balance [a] = Leaf3 a
balance xs  = Node3 (balance h1) (balance h2)
  where (h1, h2) = halve xs

halve :: [a] -> ([a], [a])
halve xs = (take n xs, drop n xs)
  where n = length xs `div` 2
