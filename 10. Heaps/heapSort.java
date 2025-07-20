import java.util.*;
public class heapSort{
    public static void heapify(int arr[],int i,int size){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }
        if(i != maxIdx){
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
            heapify(arr,maxIdx,size);
        }

    }
    public static void sort(int arr[]){
        //Building maxHeap
        int n = arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        // Swaping
        for(int i = n-1; i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,0,i);
        }
    }
    public static void main(String args[]){
        int arr[] ={1,2,4,5,3};
        sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        } 
    }
}