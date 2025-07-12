import java.util.*;
public class MaximumChainProblem{
    public static int lonestChain(int arr[][]){
        Arrays.sort(arr,Comparator.comparingDouble(o -> o[1]));
        int length = 1;
        int e = arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]>e){
                length++;
                e = arr[i][1];
            }
        }
        return length;
    }
    public static void main(String args[]){
        int arr[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        System.out.println(lonestChain(arr));
    }
}