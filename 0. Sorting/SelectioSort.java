import java.util.*;
public class SelectioSort{
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minIndx = i;
            
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[minIndx]){
                    
                    minIndx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndx];
            arr[minIndx] = temp;
        }
    }
    public static void main(String args[]){
        int arr[] = {1,0,2,3,5};
        print(arr);
        selectionSort(arr);
        print(arr);
    }
}