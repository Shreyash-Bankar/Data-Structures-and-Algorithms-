import java.util.*;
public class MergSort{
    public static void merg(int arr[],int si,int m,int ei){
        int i = si;
        int j = m+1;
        int temp[] = new int[ei+1];
        int t=0;
        while(i<=m && j<=ei){
            if(arr[i]<arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while(i<=m){
            temp[t++] = arr[i++];
        }
        while(j<=ei){
            temp[t++] = arr[j++];
        }
        t=0;
        for(int l=si;l<=ei;l++){            
            arr[l] = temp[t++];
        }
    }
    
    public static void mergSort(int arr[],int si,int ei){
        if(si>=ei){
            return; 
        }
        int mid = (si+ei)/2;
        mergSort(arr,si,mid);
        mergSort(arr,mid+1,ei);
        merg(arr,si,mid,ei);
    }
    public static void main(String args[]){
        int arr [] = {2,4,2,4,8,3,6};
        mergSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}