fun list_product (xs : int list) =
  if null xs
  then 1
  else hd xs * list_product(tl xs)

val x = list_product [];
val y = list_product [5];
val z = list_product [2,4,2];
