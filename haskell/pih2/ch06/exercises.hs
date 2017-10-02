-- 6.1
fac :: Int -> Int
fac n
  | n < 0 = 1
  | n == 0 = 1
  | otherwise = n * fac(n-1)

-- 6.2
sumdown :: Int -> Int
sumdown 0 = 0
sumdown n = n + sumdown (n - 1)
