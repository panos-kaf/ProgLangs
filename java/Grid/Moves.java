import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Moves{
    public static void main(String[] args){
        try{
            File file = new File(args[0]);
            Scanner fileInput = new Scanner(file);
            int N = fileInput.nextInt();
            int[][] grid = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j<N; j++){
                    grid[i][j] = fileInput.nextInt();
                }
            }
            fileInput.close();
            MovesSolver solver = new MovesSolver(N, grid);
            List<String> path = solver.solve();
            if(path==null){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(Arrays.toString(path.toArray()));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("An error occured");
        }
    }
}
