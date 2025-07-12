import java.util.*;
public class QuickSort{
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
    public static int partation(int arr[],int si,int ei){
        int pivot = arr[ei];
        int i=si-1;
        for(int j=si;j<=ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    } 
    public static void quickSort(int arr[],int si,int ei){
        if(ei<=si){
            return;
        }
        int pi = partation(arr,si,ei);
        quickSort(arr,si,pi-1);
        quickSort(arr,pi+1,ei);
    }
    public static void main(String args[]){
        int arr[] = {1,4,3,2,5,6};
        quickSort(arr,0,arr.length-1);
        print(arr);
    }
}