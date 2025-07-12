import java.util.*;
public class QuickSort{
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int partition(int arr[],int si,int ei){
        
        int i=si-1;
        int pivot = arr[ei];
        for(int j=si;j<=ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        return i;
            
    }
    public static void quickSort(int arr[],int si,int ei){
        if(si >= ei){
            return;
        }
        int pi = partition(arr,si,ei);
        print(arr);
        quickSort(arr,si,pi-1);
        quickSort(arr,pi+1,ei);
    }
    public static void main(String args[]){

        int arr[] = {5, 2, 7, 1,3};
        quickSort(arr,0,arr.length-1);

        print(arr);



    }
}