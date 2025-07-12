import java.util.*;
public class InsertionSort{
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void sort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            int j = i;
            for(j=i; j-1>=0 && temp < arr[j-1] ; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
    public static void main(String args[]){
        int arr[] = {4,1,5,2,3};
        sort(arr);
        print(arr);
    }
}