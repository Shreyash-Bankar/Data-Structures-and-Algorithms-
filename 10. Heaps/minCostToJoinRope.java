import java.util.*;
public class minCostToJoinRope{
    
    public static void main(String args[]){
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        pq.add(2); 
        pq.add(3); 
        pq.add(3); 
        pq.add(4); 
        pq.add(6); 
        int cost = 0;
        while(pq.size()!=1){
            int first = pq.remove(); 
            int second = pq.remove(); 
            int sum = first + second;
            cost = cost + sum;
            pq.add(sum);
        }
        System.out.print(cost);
    }
}