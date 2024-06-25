import java.util.*;

public class Location{
    int x,y;
    public Location(int X,int Y){
        this.x = X;
        this.y = Y;
    }
    
    @Override
    public String toString(){
        String X = String.valueOf(this.x);
        String Y = String.valueOf(this.y);
        return X+","+Y;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location loc = (Location) o;
        return x == loc.x && y == loc.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
}