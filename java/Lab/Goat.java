public class Goat {
    public static void main(String args[]) {
        State initial = new GoatState();
        Solver solver = new BFSolver();
        State result = solver.solve(initial);

        if (result == null) {
            System.out.println("No solution found.");
        } else {
            printSolution(result);
        }
    }

    /*
     * Follow the previous links to recursively print the solution
     */
    private static void printSolution(State s) {
        if (s.getPrevious() != null) {
            printSolution(s.getPrevious());
        }
        System.out.println(s);
    }

}
