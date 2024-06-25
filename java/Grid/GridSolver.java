import java.util.*;
public class GridSolver{
    
    int N;
    int[][] Grid;
  
    public GridSolver(int size,int[][] grid){
        this.N = size;
        this.Grid = grid;
    }

    public List<Location> reconstruct(Map<Location,Location> parent, Location end){
        List<Location> path = new LinkedList<>();
        for(Location loc = end; loc!=null; loc= parent.get(loc)){
            path.add(0,loc);
        }
        return path;
    }

    public List<Location> solve(){
        Queue<Location> frontier= new LinkedList<>();
        Set<Location> visited = new HashSet<>();
        Location loc = new Location(0,0);

        Location start = new Location(0, 0);
        Location end = new Location(N-1,N-1);
        Map<Location,Location> parent = new HashMap<>();
        Map<Location, Integer> distance = new HashMap<>();
        distance.put(start,0);
        parent.put(start,null);
        

        frontier.add(loc);
        int cost = 0;

        while(!frontier.isEmpty()){
            loc = frontier.remove();
            visited.add(loc);
            int currentDistance = distance.get(loc);
            //if (((loc.x==N-1) && (loc.y==N-1))) 
            if(loc.equals(end))
            {
                return reconstruct(parent,end);
            }    

            for(Location neighbor : Neighbors(loc.x,loc.y))
            {
                if(!distance.containsKey(neighbor)){
                    frontier.add(neighbor);
                    distance.put(neighbor,currentDistance+1);
                    parent.put(neighbor,loc);
                }
                //if(!visited.contains(neighbor))
                //    frontier.add(neighbor);
            }
            
            //System.out.print( "(" + loc.x + "," + loc.y + ")->" );
            cost++;
        }
        //System.out.println("(" + loc.x + "," + loc.y + ")");
        return null;
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