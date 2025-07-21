import java.util.*;
public class KnearPointsToOrigin{
    public static class points implements Comparable <points>{
        int x;
        int y;
        int dist;
        points(int x,int y){
            this.x = x;
            this.y = y;
            dist = x*x + y*y;
        }
        public int compareTo(points p){
            return this.dist - p.dist;
        }
    }
    public static void main(String args[]){
        PriorityQueue <points> pq = new PriorityQueue<>();
        int n = 3;
        int k = 2;
        pq.add(new points(3,3)); 
        pq.add(new points(5,-1)); 
        pq.add(new points(-2,4));
        for(int i=0;i<k;i++){
            System.out.println(pq.peek().x+","+pq.peek().y);
            pq.remove();
        } 
    }
}