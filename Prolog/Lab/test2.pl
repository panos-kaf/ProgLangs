factorial(0,1).
factorial(N,F):- N>0,N1 is N-1, factorial1(N1,F1), F is F1*N.
		 

factorial1(N,F) :- factorial(N,1,F).

factorial2(N,Fin,Fout):-
	(N >0 -> 
	 N1 is N-1, Fnext is Fin*N, factorial(N1,Fnext,Fout);
	 N=:=0, Fout=Fin
	).
