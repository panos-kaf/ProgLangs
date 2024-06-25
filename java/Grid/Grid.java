import java.util.Scanner;

public class Grid{
    public static void main(String[] args){
        System.out.println("insert size");
        Scanner userInput = new Scanner(System.in);
        int N = userInput.nextInt();
        int[][] grid = new int[N+2][N+2];
        for(int i =0; i < N+2; i++){
            grid[0][i]=-1;
            grid[i][0]=-1;
            grid[N+1][i]=-1;
            grid[i][N+1]=-1;
        }
        System.out.println("insert array");
        for(int i = 1; i < N+1; i++){
            
            for(int j = 1; j<N+1; j++){
                grid[i][j] = userInput.nextInt();
            }
        }
        for(int i=0;i<N+2; i++){
            for(int j = 0; j< N+2; j++){
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println("");
        }
        userInput.close();

        Solver solver = new Solver(N, grid);

        int cost = solver.solve();
        System.out.println(cost);
    }
}
