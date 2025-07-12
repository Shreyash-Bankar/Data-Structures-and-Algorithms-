// Binary Search Using Recursion

import java.util.*;
public class BinarySearch{
    public static int search(int arr[],int si,int ei,int key){
        if(si == ei){
            return -1;
        }
        int mid = si + (ei-si)/2;
        if(key == arr[mid]){
            return mid;
        }
        else if(key<arr[mid]){
            return search(arr,si,mid,key);
        }else{
            return search(arr,mid+1,ei,key);
        }
    }
    public static void main(String args[]){
        int arr[] = {4,5,6,7,8,9};
        System.out.print(search(arr,0,arr.length,0));
    }
}