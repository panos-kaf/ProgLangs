sameDigits(0,_):-!.
sameDigits(Number,Base):-
    NextNum is Number//Base,
    NextNum =\= 0,
    Digit is Number mod Base,
    NextDigit is NextNum mod Base,
    Digit =:= NextDigit,
    sameDigits(NextNum,Base).

sameDigits(Number,Base):-
    NextNum is Number//Base,
    NextNum =:= 0,
    Digit is Number mod Base,
    Digit =:= Number.

minbase(Number,Base):- minbaseHelper(Number,2,Base).

minbaseHelper(Number,Base,Result):-
    sameDigits(Number,Base) -> Result is Base;
    NextBase is Base+1, NextBase < Number -> minbaseHelper(Number,NextBase,Result);
    Result is Number-1.

minbases([],[]).
minbases([Number|Numbers],[Base|Bases]):-
    minbase(Number,Base),
    minbases(Numbers,Bases).


