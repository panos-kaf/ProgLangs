import java.util.Scanner;

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
        int cost = solver.solve();
        System.out.println(cost);
    }
}
