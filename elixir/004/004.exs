IO.puts 100..999
|> Enum.map(fn x -> 100..999 |> Enum.map(fn y -> x * y end) end)
|> List.flatten
|> Enum.filter(fn x -> integer_to_list(x) == integer_to_list(x) |> Enum.reverse end)
|> :lists.sort
|> List.last
|> to_string
