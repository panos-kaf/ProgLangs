import java.util.*;
/*
 * A breadth-first search solver implementation.
 */
public class BFSolver implements Solver {

    public State solve(State init) {
        Queue<State> remaining = new ArrayDeque<State>();
        Set<State> visited = new HashSet<State>();
        // add initial state to the queue
        remaining.add(init);
        // add initial state to the visited set
        visited.add(init);

        // while the queue is not empty ...
        while (!remaining.isEmpty()) {
            // ... explore the next state
            State s = remaining.remove();
            // if final state is found, return
            if (s.isFinal()) return s;
            for (State n : s.next()) {
                // if a next state is valid and not visited ...
                if (!visited.contains(n) && n.isValid()){
                    /// ... add it to the queue and mark it as visitied
                    remaining.add(n);
                    visited.add(n);
                }
            }
        }
        // no solution found
        return null;
    }
}
