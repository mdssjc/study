import Data.Char
import System.IO

-- Game utilities

next :: Int -> Int
next 1 = 2
next 2 = 1

type Board = [Int]

initial :: Board
initial = [5,4,3,2,1]

finished :: Board -> Bool
finished = all (== 0)

valid :: Board -> Int -> Int -> Bool
valid board row num = board !! (row-1) >= num

move :: Board -> Int -> Int -> Board
move board row num = [update r n | (r,n) <- zip [1..] board]
   where update r n = if r == row then n-num else n

-- IO utilities

putRow :: Int -> Int -> IO ()
putRow row num = do putStr (show row)
                    putStr ": "
                    putStrLn (concat (replicate num "* "))

putBoard :: Board -> IO ()
putBoard [a,b,c,d,e] = do putRow 1 a
                          putRow 2 b
                          putRow 3 c
                          putRow 4 d
                          putRow 5 e

getDigit :: String -> IO Int
getDigit prompt = do putStr prompt
                     x <- getChar
                     newline
                     if isDigit x then
                        return (digitToInt x)
                     else
                        do putStrLn "ERROR: Invalid digit"
                           getDigit prompt

newline :: IO ()
newline = putChar '\n'

-- Game of nim

play :: Board -> Int -> IO ()
play board player =
   do newline
      putBoard board
      if finished board then
         do newline
            putStr "Player "
            putStr (show (next player))
            putStrLn " wins!!"
      else
         do newline
            putStr "Player "
            putStrLn (show player)
            row <- getDigit "Enter a row number: "
            num <- getDigit "Stars to remove : "
            if valid board row num then
               play (move board row num) (next player)
            else
               do newline
                  putStrLn "ERROR: Invalid move"
                  play board player

nim :: IO ()
nim = play initial 1

-- 10.1
putStr' :: String -> IO ()
putStr' xs = sequence_ [putChar s | s <- xs]

-- 10.2
putBoard' :: Board -> IO ()
putBoard' = putBoardAux 1

putBoardAux :: Int -> Board -> IO ()
putBoardAux _ [] = return ()
putBoardAux i (x:xs) = do putRow i x
                          putBoardAux (i+1) xs

-- 10.3
putBoard'' :: Board -> IO ()
putBoard'' xs = sequence_ [putRow i x | (i,x) <- zip xs [1..(length xs)]]

-- 10.4
adder :: IO ()
adder = do n <- getDigit "How many numbers? "
           if n <= 0
             then putStr "n > 0!"
             else do total <- adderAux 0 n
                     putStr "total: "
                     putStrLn $ show total

adderAux :: Int -> Int -> IO Int
adderAux t n = do if n == 0
                    then return t
                    else do x <- getDigit ""
                            adderAux (t+x) (n-1)

-- 10.5
adder' :: IO ()
adder' = do n <- getDigit "How many numbers? "
            if n <= 0
              then putStr "n > 0!"
              else do addList <- sequence [getDigit "" | _ <- [1..n]]
                      putStr "total: "
                      putStrLn $ show $ sum addList

-- 10.6
getCh :: IO Char
getCh = do hSetEcho stdin False
           x <- getChar
           hSetEcho stdin True
           return x

readLine :: IO String
readLine = readLine' ""

readLine' :: String -> IO String
readLine' xs = do x <- getCh
                  case x of '\n' -> return xs
                            '\DEL' -> if null xs
                                      then readLine' ""
                                      else do putStr "\b \b"
                                              readLine' $ init xs
                            _ -> do putChar x
                                    readLine' $ xs ++ [x]
