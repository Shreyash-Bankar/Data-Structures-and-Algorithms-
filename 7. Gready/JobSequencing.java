import java.util.*;
public class JobSequencing{
    public static ArrayList<Integer> sequence(int deadline[],int value[]){
        int arr[][] = new int [value.length][4];
        for(int i=0 ; i<arr.length;i++){
            arr[i][0] = i;
            arr[i][1] = value[i];
            arr[i][2] = deadline[i];
            arr[i][3] = value[i]/deadline[i];
        }
        Arrays.sort(arr,Comparator.comparingDouble(o -> ((int[])o)[3]).reversed());

        int time =0;
        int jobs = 0;
        int profit = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i][2]>time){
                profit = profit + arr[i][1];
                jobs++;
                time ++;
            }
        }
        ArrayList <Integer> ans = new ArrayList<>();
        ans.add(jobs);
        ans.add(profit);
        return ans;


    }
    public static void main(String args[]){
        int deadline[] = {4,1,1,1};
        int value[] = {20,10,40,30};
        System.out.print(sequence(deadline,value)); 
    }
}