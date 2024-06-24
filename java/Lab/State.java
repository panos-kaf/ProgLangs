import java.util.*;

/*
 * Generic state interface that will be used by the solver(s).
 */
public interface State {
    // return the next states.
    public Collection<State> next();
    // check if a state is final, i.e. the goal of the search
    public boolean isFinal();
    // check if a state is valid and should be explored
    public boolean isValid();
    // return the parent state
    public State getPrevious();

   // Note #1: If states are to be placed in containers that will be
   // searched, they must implement equality --- they must override
   // method Object.equals.

   // Note #2: If states are to be placed in containers implemented as
   // hash tables (e.g. HashSet), they must implement a valid hash
   // function --- they must override method Object.hashCode.
}
