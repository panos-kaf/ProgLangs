/* eightqueens(?Queens)  (+ for input, - for output, ? for both*/ 
eightqueens(Queens) :-
	Queens=[1/_, 2/_, 3/_, 4/_, 5/_, 6/_, 7/_, 8/_],
	qsafe(Queens).

qsafe([]).
qsafe(X/Y|Qs):-
	qsafe(Qs), 
	member(X,[1,2,3,4,5,6,7,8]),
	member(Y,[1,2,3,4,5,6,7,8]),
	no_attack(Qs,X/Y).

no_attack([],_).
no_attack([X1/Y1|Qs],X/Y):-
	X =\= X1,
	Y =\= Y1,
	abs(Y1-Y) =\= abs(X1-X),
	no_attack(Qs,X/Y).
