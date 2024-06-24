
fun parse file= 
	let
		fun readInt input= 
			Option.valOf(TextIO.scanStream (Int.scan StringCvt.DEC) input)
		val inStream=TextIO.openIn file
		val n = readInt inStream
		val _ = TextIO.inputLine inStream

		fun readInts 0 acc = acc
		| readInts i acc = readInts(i-1) (readInt inStream::acc)
	in
		(n,readInts n [])
	end
 
fun findSum [] = 0
|   findSum (x::xs) = x + findSum xs

val sum=findSum[1,2]

fun solve(n,sizeList)=(42,42)
fun fairseq fileName = solve (parse fileName)


fun halfsum (lst : int list) = 
	let 
		val totalSum= List.foldl op+ 0 lst
		fun sumAcc ([],_)= []
		  | sumAcc (x::xs, acc) = 
			let 
				val newAcc = x + acc
			in
				if newAcc > totalSum div 2 then [newAcc]
				else newAcc :: sumAcc(xs, newAcc)
			end

	in
		sumAcc(lst,0)
	end

fun fairseq 
