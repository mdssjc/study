import System.Random

check :: String -> String -> Char -> (Bool, String)
check word display c = (c `elem` word, [if x==c then c else y | (x,y) <- zip word display])

turn :: String -> String -> Int -> IO ()
turn word display n =
  if n==0
    then putStrLn "You lose"
    else if word==display
            then putStrLn "You win!"
         else mkguess word display n

mkguess :: String -> String -> Int -> IO ()
mkguess word display n =
  do putStrLn (display ++ "  " ++ replicate n '*')
     putStr "  Enter your guess: "
     q <- getLine
     let (correct, display') = check word display (head q)
     let n' = if correct then n else n-1
     turn word display' n'

starman :: String -> Int -> IO ()
starman word n = turn word ['-' | x <- word] n

main = do
  words <- fmap lines (readFile "/usr/share/dict/words")
  index <- getStdRandom(randomR(0, length words - 1))
  let word = words !! index
  starman word 5
