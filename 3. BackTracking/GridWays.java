import java.util.*;
public class GridWays{
    
    public static int ways(int arr[][],int i,int j){
        if(i>=arr.length || j>= arr[0].length){
            return 0;
        }
        if(i == arr.length-1 && j == arr[0].length-1){
            return 1;
        }
        return ways(arr,i+1,j) + ways(arr,i,j+1);
        
    }
    public static void main(String args[]){
        int arr[][] = new int[3][3];
        System.out.println("Count = " + ways(arr,0,0));
    }
}