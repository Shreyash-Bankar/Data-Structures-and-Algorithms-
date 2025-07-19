import java.util.*;
public class MinHeap_Operations{
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
        public int peak(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            if(left < arr.size() && (arr.get(left) < arr.get(minIdx))){
                minIdx = left;
            }
            if(right < arr.size() && (arr.get(right) < arr.get(minIdx))){
                minIdx = right;
            }
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                heapify(minIdx);
            }
        }
        public  void delete(){
            int temp = arr.get(0);
            arr.set(0 , arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            arr.remove(arr.size()-1);
            heapify(0);
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String args[]){
        MinHeap h = new MinHeap();
        System.out.println(h.isEmpty());
        h.insert(2);
        h.insert(3);
        h.insert(4);
        h.insert(5);
        h.insert(10);
        h.insert(1);
        System.out.println(h.arr);
        System.out.println(h.peak());
        h.delete();
       
        System.out.println(h.arr);
        System.out.print(h.isEmpty());

    }
}