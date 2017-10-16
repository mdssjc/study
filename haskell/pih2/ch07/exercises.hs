-- 7.1
hofmf :: (a -> b) -> (a -> Bool) -> [a] -> [b]
hofmf f p xs = map f $ filter p xs
