import java.util.*;
public class Solver{
    
    int N;
    int[][] Grid;
  
    public Solver(int size,int[][] grid){
        this.N = size;
        this.Grid = grid;
    }

    public int solve(){
        Queue<int[]> frontier= new LinkedList<>();
        Set<int[]> visited = new HashSet<>();
        int[] loc = new int[2];
        loc[0] = loc[1] = 1;
        frontier.add(loc);
        int cost = 0;

        while(!(loc[0]==N && loc[1]==N)){

            loc = frontier.remove();
            visited.add(loc);
            for(int[] position : Neighbors(loc[0],loc[1]))
            {
                if(!visited.contains(position))
                    frontier.add(position);
            }
            if (frontier.isEmpty()) 
            {
                break;
            }
            cost++;
        }

        return cost;
    } 
    public Set<int[]> Neighbors(int x, int y){
        Set<int[]> res = new HashSet<>();
        int loc = Grid[x][y];
        if (Grid[x+1][y] < loc){
            int[] arr = new int[2];
            arr[0] = x+1;
            arr[1] = y;
            res.add(arr);
        }
        if (Grid[x][y+1] < loc){
            int[] arr = new int[2];
            arr[0] = x;
            arr[1] = y+1;
            res.add(arr);
        }
        if (Grid[x+1][y+1] < loc){
            int[] arr = new int[2];
            arr[0] = x+1;
            arr[1] = y+1;
            res.add(arr);
        }
        if (Grid[x-1][y] < loc){
            int[] arr = new int[2];
            arr[0] = x-1;
            arr[1] = y;
            res.add(arr);
        }
        if (Grid[x][y-1] < loc){
            int[] arr = new int[2];
            arr[0] = x;
            arr[1] = y-1;
            res.add(arr);
        }
        if (Grid[x-1][y-1] < loc){
            int[] arr = new int[2];
            arr[0] = x-1;
            arr[1] = y-1;
            res.add(arr);
        }
        if (Grid[x+1][y-1] < loc){
            int[] arr = new int[2];
            arr[0] = x+1;
            arr[1] = y-1;
            res.add(arr);
        }
        if (Grid[x-1][y+1] < loc){
            int[] arr = new int[2];
            arr[0] = x-1;
            arr[1] = y+1;
            res.add(arr);
        }
        return res;
    } 
}