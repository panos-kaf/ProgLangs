import java.util.*;
public class GridSolver{
    
    int N;
    int[][] Grid;
  
    public GridSolver(int size,int[][] grid){
        this.N = size;
        this.Grid = grid;
    }

    public int solve(){
        Queue<Location> frontier= new LinkedList<>();
        Set<Location> visited = new HashSet<>();
        Location loc = new Location(0,0);
        frontier.add(loc);
        int cost = 0;

        while(!frontier.isEmpty()){
            loc = frontier.remove();
            visited.add(loc);
            for(Location neighbor : Neighbors(loc.x,loc.y))
            {
                if(!visited.contains(neighbor))
                    frontier.add(neighbor);
            }
            

            if (((loc.x==N-1) && (loc.y==N-1))) 
            {
                break;
            }            
            System.out.print( "(" + loc.x + "," + loc.y + ")->" );
            cost++;
        }
        System.out.println("(" + loc.x + "," + loc.y + ")");
        return cost;
    } 
    public Set<Location> Neighbors(int x, int y){
        Set<Location> res = new HashSet<>();
        int val = Grid[x][y];

        int[][] neighbors = { 
            {-1,-1}, 
            {-1, 0}, 
            {0, -1}, 
            {-1,+1}, 
            {+1,-1}, 
            {+1, 0}, 
            {0, +1}, 
            {+1,+1} 
        };

        for (int[] neighbor : neighbors){
            int xn = x + neighbor[0];
            int yn = y + neighbor[1];

            if(xn >=0 && yn >=0 && xn<N && yn<N && Grid[xn][yn]<val){
                res.add(new Location(xn,yn));
            }
        }
        return res;
    }
}