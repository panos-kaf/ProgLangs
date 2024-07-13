human(bob).
human(alex).
human(Someone):- Someone=bob. 

movie(interstellar).

genre(interstellar,scifi).
director(interstellar,nolan).

human(Dir):- director(X,Dir).
