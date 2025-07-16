import java.util.PriorityQueue;
public class Priority_Queue{
    public static void main(String args[]){
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        pq.add(6);       
        pq.add(3);       
        pq.add(5);       
        pq.add(1);       
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
    }
}