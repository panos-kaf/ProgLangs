/*house(Nationality,Color,Pet,Smoke,Drink)*/

drinks_water(Nationality):- zebra(Houses),member(house(Nationality,_,_,_,water),Houses).
owns_zebra(Nationality):- zebra(Houses),member(house(Nationality,_,zebra,_,_),Houses).

zebra(Houses) :-
	Houses = [house(norwegian,_,_,_,_),house(_,blue,_,_,_),house(_,_,_,_,milk),_,_],
	member(house(englishman,red,_,_,_),Houses),
	member(house(spaniard,_,dog,_,_),Houses),
	member(house(_,green,_,_,coffee),Houses),
	member(house(ukranian,_,_,_,tea),Houses),
	rightof(house(_,green,_,_,_),house(_,ivory,_,_,_),Houses),
	member(house(_,_,snails,oldGold,_),Houses),
	member(house(_,yellow,_,cools,_),Houses),
	nextto(house(_,_,_,chesterfields,_),house(_,_,fox,_,_),Houses),
	nextto(house(_,_,_,kools,_),house(_,_,horse,_,_),Houses),
	member(house(_,_,_,luckyStrike,orangeJuice),Houses),
	member(house(japanese,_,_,parliaments,_),Houses).



rightof(H1,H2,[H2,H1,_,_,_]).
rightof(H1,H2,[_,H2,H1,_,_]).
rightof(H1,H2,[_,_,H2,H1,_]).
rightof(H1,H2,[_,_,_,H2,H1]).

nextto(H1,H2,Houses) :- rightof(H1,H2,Houses).
nextto(H1,H2,Houses) :- rightof(H2,H1,Houses).

