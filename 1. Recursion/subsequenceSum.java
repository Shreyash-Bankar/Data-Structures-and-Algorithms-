import java.util.*;
public class subsequenceSum{
    public static int sum(ArrayList<Integer> a){
        int sum = 0;
        for(int i : a){
            sum = sum+i;
        }
        return sum;
    }
    public static void ss(int arr[],int i,int sum, ArrayList <Integer> a){
        if(i>=arr.length){
            if(sum(a) == sum){
                System.out.println(a);
            }
            return;
        }
        a.add(arr[i]);
        ss(arr,i+1,sum,a);
        a.remove(a.size()-1);
        ss(arr,i+1,sum,a);

    }
    public static void main(String args[]){

            int arr [] = {1,2,3,4,5,6};
            ss(arr,0,6,new ArrayList<>());
    }
}