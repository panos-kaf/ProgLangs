(* Function to check if a number N can be represented with the same digits in base B *)
fun sameDigitsInBase(N, B) =
    let
        (* Function to convert a number to a list of digits in base B *)
        fun toDigits(0, _) = []
          | toDigits(num, base) = (num mod base) :: toDigits(num div base, base)
        
        (* Convert the number N to a list of digits in base B *)
        val digits = toDigits(N, B)
    in
        (* Check if all digits are the same *)
        case digits of
             [] => false
           | h :: t => List.all (fn x => x = h) t
    end

(* Function to find the smallest base for which N can be represented with same digits *)
fun bases Lst = 
	let 
		fun smallestBase(N) =
			let
				(* Recursive function to find the base *)
				fun findBase(b) =
					if sameDigitsInBase(N, b) then b
					else findBase(b + 1)
			in
				findBase(2) (* Start searching from base 2 *)
			end
		in
			map(smallestBase,Lst)
		end

(* Testing the function *)
val N = 42
val base = smallestBase(N)
(*val _ = print ("The smallest base for " ^ Int.toString(N) ^ " to be represented with same digits is " ^ Int.toString(base) ^ "\n")
*)

