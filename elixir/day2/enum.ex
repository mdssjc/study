x = 1..1000 |> Enum.map(&(&1 * 2)) |> Enum.sum

IO.puts x
