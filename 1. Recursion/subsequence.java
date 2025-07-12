import java.util.*;
public class subsequence{
    public static void sub(int arr[],int i,ArrayList <Integer> a){
        if(i>=arr.length){
            System.out.println(a);
            return;
        }
        a.add(arr[i]);
        sub(arr,i+1,a);
        a.remove(a.size()-1);
        sub(arr,i+1,a);
    }
    public static void main(String args[]){
        int arr[] = {1,2,3};
        sub(arr,0,new ArrayList<>());
    }
}