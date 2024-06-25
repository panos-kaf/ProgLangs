import java.util.*;

public class Grid{
    public static void main(String[] args){
        System.out.println("insert size");
        Scanner userInput = new Scanner(System.in);
        int N = userInput.nextInt();
        int[][] grid = new int[N][N];
        System.out.println("insert array");

        for(int i = 0; i < N; i++){
            for(int j = 0; j<N; j++){
                grid[i][j] = userInput.nextInt();
            }
        }
        userInput.close();
        GridSolver solver = new GridSolver(N, grid);
        List<Location> path = solver.solve();
        for (Location loc : path){
            System.out.print(loc.toString()+"-->");
        }
        //System.out.println(Arrays.toString(path.toArray()));
        //System.out.println(path);
    }
}
