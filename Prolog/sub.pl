
subseq([],[]).
subseq([],_).
subseq([Item|RestX],[Item|RestY]):-
	subseq(RestX,RestY).

subseq(X,[_|RestY]):-
	subseq(X,RestY).
