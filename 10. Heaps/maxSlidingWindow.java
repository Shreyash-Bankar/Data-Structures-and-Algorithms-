import java.util.*;
public class maxSlidingWindow{
    public static class element implements Comparable<element>{
        int data;
        int index;
        element(int data,int index){
            this.data = data;
            this.index = index;
        }
        public int compareTo(element e1){
            return  e1.data - this.data;
        }
    }
    public static void main(String args[]){
        PriorityQueue <element> pq = new PriorityQueue<>();
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int idx = k - 1;
        for(int i=0;i<k;i++){
            pq.add(new element(arr[i],i));
        }
        while (idx < arr.length - 1){
            System.out.print(pq.peek().data+" ");
            while( pq.size()>0  && pq.peek().index <= idx - k ){
                pq.remove();                        
            }
                pq.add(new element(arr[++idx], idx));  
            }
            System.out.print(pq.peek().data+" ");

    }
}
