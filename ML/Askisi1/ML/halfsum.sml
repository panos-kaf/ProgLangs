fun sumUntilHalfSum (lst : int list) =
    let
        val totalSum = List.foldl op+ 0 lst
        fun sumAcc ([], _) = []
          | sumAcc (x::xs, acc) =
            let
                val newAcc = x + acc
				val best = 2*newAcc - sumAcc
            in
				
                if 2*newAcc >= totalSum then [newAcc]
                else newAcc :: sumAcc(xs, newAcc)
				
            end
    in
        sumAcc(lst, 0)
    end;

val myList = [1, 2, 3, 4, 5];
val result = sumUntilHalfSum myList;
print ("The sum of numbers until surpassing half of the total sum is: " ^ Int.toString (List.last result) ^ "\n");


fun fairsolve ( lst : int list ) = 
	let 
		val totalSum= List.foldl op+ 0 lst
		fun best current bestsofar sum = 
			if abs(2*current-sum)<abs(2*bestsofar-sum) 
			then current else bestsofar

