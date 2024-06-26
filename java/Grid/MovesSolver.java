import java.util.*;
public class MovesSolver{
    
    int N;
    int[][] Grid;
  
    public MovesSolver(int size,int[][] grid){
        this.N = size;
        this.Grid = grid;
    }

    public List<String> reconstruct(Map<Location,Location> parent,Map<Location,String> direction, Location end){
        List<String> path = new LinkedList<>();
        for(Location loc = end; loc!=null; loc= parent.get(loc)){
            if(direction.containsKey(loc)){
            path.add(0,direction.get(loc));
            }
        }
        return path;
    }

    public List<String> solve(){
        Queue<Location> frontier= new LinkedList<>();
        Location loc = new Location(0,0);

        Location start = new Location(0, 0);
        Location end = new Location(N-1,N-1);
        Map<Location,Location> parent = new HashMap<>();
        Map<Location, Integer> distance = new HashMap<>();
        Map<Location, String> directions = new HashMap<>();
        distance.put(start,0);
        parent.put(start,null);

        frontier.add(loc);

        while(!frontier.isEmpty()){
            loc = frontier.remove();
            int currentDistance = distance.get(loc);
            if(loc.equals(end))
            {
                return reconstruct(parent,directions,end);
            }    

            Map<Location,String> neighbors = Neighbors(loc.x,loc.y);
            for(Location neighbor : neighbors.keySet())
            {
                String dir = neighbors.get(neighbor);
                if(!distance.containsKey(neighbor)){
                    frontier.add(neighbor);
                    distance.put(neighbor,currentDistance+1);
                    parent.put(neighbor,loc);
                    directions.put(neighbor,dir);
                }
            } 
        }
        return null;
    } 
    
    public Map<Location,String> Neighbors(int x, int y){
        Map<Location,String> res = new HashMap<>();
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

        Map<int[],String> directions = new HashMap<>();
        directions.put(neighbors[0],"NW");
        directions.put(neighbors[1],"N");
        directions.put(neighbors[2],"W");
        directions.put(neighbors[3],"NE");
        directions.put(neighbors[4],"SW");
        directions.put(neighbors[5],"S");
        directions.put(neighbors[6],"E");
        directions.put(neighbors[7],"SE");

        for (int[] neighbor : neighbors){
            int xn = x + neighbor[0];
            int yn = y + neighbor[1];
            if(xn >=0 && yn >=0 && xn<N && yn<N && Grid[xn][yn]<val){
                res.put(new Location(xn,yn),directions.get(neighbor));
            }
        }
        return res;
    }
}