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

-- 8.5
data Expr = Val Int | Add Expr Expr

folde :: (Int -> a) -> (a -> a -> a) -> Expr -> a
folde f _ (Val a) = f $ a
folde f g (Add e1 e2) = g (folde f g e1) (folde f g e2)

-- 8.6
eval :: Expr -> Int
eval = folde id (+)

size :: Expr -> Int
size = folde (\_ -> 1) (+)

-- 8.7
-- instance Eq a => Eq (Maybe a) where
-- (==) Nothing Nothing   = True
-- (==) (Just x) (Just y) = x == y
-- (==) _ _               = False

-- instance Eq a => Eq [a] where
-- (==) [] []         = True
-- (==) (x:xs) (y:ys) = x == y && xs == ys
-- (==) _ _           = False

-- 8.8
data Prop = Const Bool
  | Var Char
  | Not Prop
  | And Prop Prop
  | Imply Prop Prop
  | Or Prop Prop
  | Xnor Prop Prop

p1 :: Prop
p1 = And (Var 'A') (Not (Var 'A'))

p2 :: Prop
p2 = Imply (And (Var 'A') (Var 'B')) (Var 'A')

p3 :: Prop
p3 = Imply (Var 'A') (And (Var 'A') (Var 'B'))

p4 :: Prop
p4 = Imply (And (Var 'A') (Imply (Var 'A') (Var 'B'))) (Var 'B')

p5 :: Prop
p5 = Or (Var 'A') (Not (Var 'A'))

p6 :: Prop
p6 = Xnor (Var 'A') (Var 'A')

p7 :: Prop
p7 = Xnor (Var 'A') (Var 'B')

type Assoc k v = [(k,v)]
type Subst = Assoc Char Bool

find :: Eq k => k -> Assoc k v -> v
find k t = head [v | (k', v) <- t, k == k']

rmdups :: Eq a => [a] -> [a]
rmdups [] = []
rmdups (x:xs) = x:filter (/=x) (rmdups xs)

eval' :: Subst -> Prop -> Bool
eval' _ (Const b)   = b
eval' s (Var x)     = find x s
eval' s (Not p)     = not $ eval' s p
eval' s (And p q)   = eval' s p && eval' s q
eval' s (Imply p q) = eval' s p <= eval' s q
eval' s (Or p q)    = eval' s p || eval' s q
eval' s (Xnor p q)  = eval' s p == eval' s q

vars :: Prop -> [Char]
vars (Const _)   = []
vars (Var x)     = [x]
vars (Not p)     = vars p
vars (And p q)   = vars p ++ vars q
vars (Imply p q) = vars p ++ vars q
vars (Or p q)    = vars p ++ vars q
vars (Xnor p q)  = vars p ++ vars q

bools :: Int -> [[Bool]]
bools 0 = [[]]
bools n = map (False:) bss ++ map (True:) bss
  where bss = bools $ n - 1

substs :: Prop -> [Subst]
substs p = map (zip vs) (bools $ length vs)
  where vs = rmdups $ vars p

isTaut :: Prop -> Bool
isTaut p = and[eval' s p | s <- substs p]

-- 8.9
data Expr' = Val' Int | Add' Expr' Expr' | Mult' Expr' Expr'
data Op = ADD Expr' | MULT Expr' | PLUS Int | TIMES Int
type Cont = [Op]

eval'' :: Expr' -> Cont -> Int
eval'' (Val' n) c    = exec c n
eval'' (Add' x y) c  = eval'' x (ADD y : c)
eval'' (Mult' x y) c = eval'' x (MULT y : c)

exec :: Cont -> Int -> Int
exec [] n            = n
exec (ADD y : c) n   = eval'' y (PLUS n : c)
exec (MULT y : c) n  = eval'' y (TIMES n : c)
exec (PLUS n : c)  m = exec c (n + m)
exec (TIMES n : c) m = exec c (n * m)
