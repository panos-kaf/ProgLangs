

initial(config(w,w,w,w)).

final(config(e,e,e,e)).

solve(Config,[]):- final(Config).
solve(Config,[Move|Moves]):- 
	move(Config,Move,NextConfig),
	solve(NextConfig,Moves).


move(config(M,W,G,C),wolf,config(

