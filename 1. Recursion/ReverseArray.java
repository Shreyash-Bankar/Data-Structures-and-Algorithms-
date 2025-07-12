import java.util.*;
public class ReverseArray{
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
    public static void reverseArray(int arr[],int i){
        if(i>(arr.length-1)/2){
            return;
        }
        swap(arr,i,arr.length-1-i);
        reverseArray(arr,i+1);
    }
    public static void main (String args[]){
        int arr[] = {1,2,3,4,5,6,7};
        reverseArray(arr,0);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }   
}