fun split1 (lst : int list) =
  let
    val n = length lst
    fun splitAt k [] = ([], [])
      | splitAt 0 lst = ([], lst)
      | splitAt k (h::t) =
          let
            val (left,right) = splitAt (k-1) t
          in
            (h::left, right)
          end
  in
    splitAt ((n+1) div 2) lst
  end
