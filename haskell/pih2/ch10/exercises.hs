-- 10.1
putStr' :: String -> IO ()
putStr' xs = sequence_ [putChar s | s <- xs]
