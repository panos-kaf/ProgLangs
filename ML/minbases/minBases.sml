
fun	allSame [] = false |
	allSame [x:int] = true |
	allSame (x1::x2::xs) = if x1 = x2 then allSame(x2::xs) else false

fun sameDigits(N, B) =
    let
        fun getDigits(0,_) = []
          | getDigits(n,b) = (n mod b) :: getDigits(n div b, b)
	in
		allSame(getDigits(N,B))
    end

fun map (f,l) = if null l then nil 
				else f (hd l) :: map(f,tl l);

fun minBase N =
    let
        fun findMin b =
            if sameDigits(N, b) then b
            else findMin (b+1)
    in
        findMin(2)
    end

fun minbases nums = map(minBase, nums) 

