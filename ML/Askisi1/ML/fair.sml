fun min (a,b) = if a<b then a else b
fun last lst = hd (rev lst)
fun minlist x::xs = 
	let
		min(x,hd(tl xs)) 
	in
	end

	
fun checkBest (bestSoFar,newBest,lst)= min(bestSoFar,newBest,)

fun solve [] = 0
|	solve sequence =
	let
		val totalSum=List.foldr (op+) 0 sequence
		val bestSoFar=min(totalSum,best)
		fun solve_helper (sequence,0)= 0
		|	solve_helper (sequence,1)= 1
		|	solve_helper (sequence,best)=
			let
				fun halfSum ([],_) = 0
				|	halfSum (x::xs,acc)= 
					let 
						val new=x+acc
					in
						if 2*new>totalSum then new else halfSum(xs,new)
					end
			in
				halfSum(sequence,0)*2-totalSum
			end
		in
			best
		end 


		solver (first,last,list,best,sum)=
			newbest= min(best,solver())
