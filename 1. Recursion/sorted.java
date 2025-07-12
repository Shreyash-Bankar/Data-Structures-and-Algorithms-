import java.util.*;
public class sorted{
    
    public static boolean sorted(int arr[],int i){
        if(i>arr.length-2){
            return true;
        }
        if(arr[i]>=arr[i+1] ){
            return false;
        }
        return sorted(arr,i+1);
    }
    public static void main(String args[]){
        int arr [] = {1,2,3,4,5,6,7};
        System.out.print(sorted(arr,0)) ;
    } 
}