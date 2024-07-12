
(*fun powerset []= [[]] 
| powerset(h::t) = map(fn x => h::x) (powerset(t))@powerset(t);
*)

fun powerset[]= [[]]
| powerset(h::t)= foldl (fn (x,acc) => x::(h::x)::acc) [] (powerset t)

fun comp ([],_)= false
| comp (_,[])= true
| comp ((h1::t1),(h2::t2))= if h1=h2 then comp (t1,t2) else h1>h2
