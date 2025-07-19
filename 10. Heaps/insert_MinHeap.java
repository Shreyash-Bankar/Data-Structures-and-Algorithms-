import java.util.*;
public class insert_MinHeap{
    public static class MinHeap{
        ArrayList <Integer> arr = new ArrayList<>();
        public void insert(int data){
            arr.add(data);
            int child = arr.size() - 1;
            int par = (child - 1) / 2;
            while(arr.get(child) < arr.get(par) ) {
                int temp = arr.get(par);
                arr.set(par,arr.get(child));
                arr.set(child,temp);
                child = par;
                par = (child - 1)/2;
            }
        }
    }
    public static void main(String args[]){
        MinHeap h = new MinHeap();
        h.insert(2);
        h.insert(3);
        h.insert(4);
        h.insert(5);
        h.insert(10);
        h.insert(1);
        System.out.println(h.arr);
    }
}