-- 15.1
-- 1 + (2*3): both
-- (1+2) * (2+3): innermost
-- fst(1+2, 2+3): both
-- (\x -> 1+x)(2*3): both

-- 15.2
-- outermost
-- fst(1+2, 2+3)
-- 1+2
-- 3

-- innermost
-- fst(1+2, 2+3)
-- fst(3, 2+3)
-- fst(3, 5)
-- 3

-- Outermost is preferable.
