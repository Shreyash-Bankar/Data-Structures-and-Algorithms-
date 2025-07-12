import java.util.*;
public class FractionalKnapsack{
    public static void main(String args[]){
        double capacity = 21;
        int value[] =  {8 ,2 ,10 ,1 ,9 ,7 ,2 ,6 ,4 ,9};
        int weight[] = {10 ,1 ,7 ,7 ,5 ,1 ,8 ,6 ,8 ,7};       
        double arr[][] = new double[weight.length][4];                  
        for(int i=0;i<weight.length;i++){
            arr[i][0] =  i;
            arr[i][1] = value[i];
            arr[i][2] = weight[i];
            arr[i][3] =  (double)value[i] / (double)weight[i];
        }
        Arrays.sort(arr, Comparator.comparingDouble(o -> ((double[]) o)[3]).reversed());
        ArrayList<Double>list = new ArrayList<>();

        double ans = 0;
        for(int i=0;i<weight.length;i++){
            if(arr[i][2]<=capacity){
                capacity = capacity - arr[i][2];
                ans = ans + arr[i][1];
                list.add(arr[i][0]);

            }else{
                ans = ans + arr[i][3] * capacity;
                capacity = 0;
                list.add(arr[i][0]);
                break;
            }
        }
        System.out.println(ans);
        System.out.println(list);
    }
}