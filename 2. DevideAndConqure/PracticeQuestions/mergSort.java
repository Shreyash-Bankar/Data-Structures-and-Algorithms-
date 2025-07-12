// Question 1 : Apply Merge sort to sort an array of Strings. (Assume that all the characters in
// all the Strings are in lowercase). (EASY)
// Sample Input 1 : arr = { "sun", "earth", "mars", "mercury" }
// Sample Output 1 : arr = { "earth", "mars", "mercury", "sun"}
import java.util.*;
public class mergSort{
    public static void print(String arr[]){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void merg(String arr[],int si,int ei,int mid){
        int i = si;
        int j = mid +1;
        String temp[] = new String[ei-si+1];
        int t=0;
        while(i<=mid && j<=ei){
            if( ((arr[j]).compareTo(arr[i])) > 0 ){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[t++] = arr[i++];
        }
        while(j<=ei){
            temp[t++] = arr[j++];
        }
        t = 0;
        for(int s=si;s<=ei;s++){
            arr[s] = temp[t++];
        }
    }
    public static void sort ( String arr[] ,int si,int ei ){
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2;
        sort(arr,si,mid);
        sort(arr,mid+1,ei);
        merg(arr,si,ei,mid);
    }
    public static void main(String args[]){

        String arr[] = {"sun", "earth", "mars", "mercury"};
        sort(arr,0,arr.length-1);
        print (arr);

    }
}