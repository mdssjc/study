module Parsing (module Parsing, module Control.Applicative) where

import Control.Applicative
import Data.Char

-- Basic definitions

newtype Parser a = P (String -> [(a,String)])

parse :: Parser a -> String -> [(a,String)]
parse (P p) inp = p inp

item :: Parser Char
item = P (\inp -> case inp of
                     []     -> []
                     (x:xs) -> [(x,xs)])

-- Sequencing parsers

instance Functor Parser where
   -- fmap :: (a -> b) -> Parser a -> Parser b
   fmap g p = P (\inp -> case parse p inp of
                            []        -> []
                            [(v,out)] -> [(g v, out)])

instance Applicative Parser where
   -- pure :: a -> Parser a
   pure v = P (\inp -> [(v,inp)])

   -- <*> :: Parser (a -> b) -> Parser a -> Parser b
   pg <*> px = P (\inp -> case parse pg inp of
                             []        -> []
                             [(g,out)] -> parse (fmap g px) out)

instance Monad Parser where
   -- (>>=) :: Parser a -> (a -> Parser b) -> Parser b
   p >>= f = P (\inp -> case parse p inp of
                           []        -> []
                           [(v,out)] -> parse (f v) out)

-- Making choices

instance Alternative Parser where
   -- empty :: Parser a
   empty = P (\inp -> [])

   -- (<|>) :: Parser a -> Parser a -> Parser a
   p <|> q = P (\inp -> case parse p inp of
                           []        -> parse q inp
                           [(v,out)] -> [(v,out)])

-- Derived primitives

sat :: (Char -> Bool) -> Parser Char
sat p = do x <- item
           if p x then return x else empty

digit :: Parser Char
digit = sat isDigit

lower :: Parser Char
lower = sat isLower

upper :: Parser Char
upper = sat isUpper

letter :: Parser Char
letter = sat isAlpha

alphanum :: Parser Char
alphanum = sat isAlphaNum

char :: Char -> Parser Char
char x = sat (== x)

string :: String -> Parser String
string []     = return []
string (x:xs) = do char x
                   string xs
                   return (x:xs)

ident :: Parser String
ident = do x  <- lower
           xs <- many alphanum
           return (x:xs)

nat :: Parser Int
nat = do xs <- some digit
         return (read xs)

int :: Parser Int
int = do char '-'
         n <- nat
         return (-n)
       <|> nat

-- Handling spacing

space :: Parser ()
space = do many (sat isSpace)
           return ()

token :: Parser a -> Parser a
token p = do space
             v <- p
             space
             return v

identifier :: Parser String
identifier = token ident

natural :: Parser Int
natural = token nat

integer :: Parser Int
integer = token int

symbol :: String -> Parser String
symbol xs = token (string xs)

-- 13.1
comment :: Parser ()
comment = do string "--"
             many (sat (/= '\n'))
             return ()

-- 13.2
-- 2+3+4
-- expr
-- expr   + expr
-- term   + term
-- factor + expr   + expr
-- nat    + term   + term
-- 2      + factor + factor
-- 2      + nat    + nat
-- 2      + 3      + 4

-- 13.3
-- 2+3
-- expr
-- term   + expr
-- factor + term
-- nat    + factor
-- 2      + nat
-- 2      + 3

-- 2*3*4
-- expr
-- term
-- factor * term
-- nat    * factor * term
-- 2      * nat    * factor
-- 2      * 3      * nat
-- 2      * 3      * 4

-- (2+3)+4
-- expr
-- term              + expr
-- factor            + term
-- (expr)            + factor
-- (term   + expr)   + nat
-- (factor + term)   + 4
-- (nat    + factor) + 4
-- (2      + nat)    + 4
-- (2      + 3)      + 4

-- 13.4
-- The final simplification evaluates to the primitives faster by decreasing the execution stack.

-- 13.5
data Expr = Val Int | Add Expr Expr
  deriving Show

expr :: Parser Expr
expr = do addition <|> value

addition :: Parser Expr
addition = do a <- value
              symbol "+"
              b <- value
              return (Add a b)

value :: Parser Expr
value = do n <- natural
           return (Val n)

-- 13.6
expr' :: Parser Int
expr' = do t <- term
           do symbol "+"
              e <- expr'
              return (t + e)
              <|> do symbol "-"
                     e <- expr'
                     return (t - e)
                     <|> return t

term :: Parser Int
term = do ep <- factor
          do symbol "*"
             t <- term
             return (ep * t)
             <|> do symbol "/"
                    t <- term
                    return (ep `div` t)
                    <|> return ep

factor :: Parser Int
factor = do symbol "("
            e <- expr'
            symbol ")"
            return e
            <|> integer

-- 13.7
term' :: Parser Int
term' = do ep <- expo
           do symbol "*"
              t <- term'
              return (ep * t)
                <|> do symbol "/"
                       t <- term'
                       return (ep `div` t)
                       <|> return ep

expo :: Parser Int
expo = do f <- factor
          do symbol "^"
             e <- expo
             return (f ^ e)
             <|> return f

-- 13.8
expr'' :: Parser Int
expr'' = do n  <- natural
            xs <- many (symbol "-" >>= \_ -> natural)
            return (foldl (-) n xs)

-- 13.9
-- warn function with the x, y and message parameters.
