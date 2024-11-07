incsubseq(L,K,S):-
	length(S,K),
	inc(S),
	subseq(L,S).

inc([]).
inc([_]).
inc([X1,X2]|Xs):-
	X1=<X2,
	inc(X2|Xs).

subseq(_,[]).	
subseq(X|Seq,X|Sub):- subseq(Seq,Sub).
subseq(_|Seq,X|Sub):- subseq(Seq,X|Sub).

