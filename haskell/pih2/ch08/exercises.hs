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
