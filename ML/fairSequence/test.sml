fun square x = x * x

fun max (a,b) = if a > b then a else b

fun g x = 2*x + 1

fun f x=
	let 
		val gg = g(square(max(x,4)))
	in
		gg  + (if x < 1 then 1 else gg)
	end	


