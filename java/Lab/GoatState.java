import java.util.*;

public class GoatState implements State {
    // represent all four entities as booleans where false = west, true = east
    private boolean man, wolf, goat, cabbage;
    // link to the parent state
    private State previous;

    /*
     * Goat state constructor.
     */
    public GoatState(boolean m, boolean w, boolean g, boolean c, State prev) {
        man = m; wolf = w; goat = g; cabbage = c;
        previous = prev;
    }

    /*
     * Goat state constructor for the initial state only, using constructor overloading.
     */
    public GoatState() {
        man = false; wolf = false; goat = false; cabbage = false;
        previous = null;
    }

    /*
     * A state is final if all four entities are on the east side.
     */
    @Override
    public boolean isFinal() {
        return man && wolf && goat && cabbage;
    }

    /*
     * A state is valid if the wold and the goat are not on the same side unattended (i.e. the man is not on the same side as them)
     * and if the goat and the cabbage are not on the same side unattended.
     */
    @Override
    public boolean isValid() {
        return !(wolf == goat && man != goat)
            && !(goat == cabbage && man != cabbage);
    }

    /*
     * Return all possible next state. May contain invalid states.
     */
    @Override
    public Collection<State> next() {
        Collection<State> states = new ArrayList<State>();

        // add all possible moves to the solution
        states.add(new GoatState(!man, wolf, goat, cabbage, this));
        if (man == goat) states.add(new GoatState(!man, wolf, !goat, cabbage, this));
        if (man == wolf) states.add(new GoatState(!man, !wolf, goat, cabbage, this));
        if (man == cabbage) states.add(new GoatState(!man, wolf, goat, !cabbage, this));

        return states;
    }

    /*
     * Return the parent state.
     */
    @Override
    public State getPrevious() {
        return previous;
    }

    /*
     * Override toSting to print a more informative representation.
     */
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("State: ");
       sb.append("man=").append(man ? "E" : "W");
       sb.append(", wolf=").append(wolf ? "E" : "W");
       sb.append(", goat=").append(goat ? "E" : "W");
       sb.append(", cabbage=").append(cabbage ? "E" : "W");

       return sb.toString();
    }

    /*
     * Override equals so that two states are equal iff the four entities have the same positions.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoatState s = (GoatState) o;
        return s.man == man && s.goat == goat && s.cabbage == cabbage && s.wolf == wolf;

    }

    /*
     * Override hashCode so that if s1.equals(s2) then s1 and s2 have the same hashes.
     */
    @Override
    public int hashCode() {
        return Objects.hash(man, wolf, goat, cabbage);
    }

}
