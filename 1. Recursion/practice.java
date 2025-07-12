import java.util.*;
public class practice {
    public static void print( String arr[] ){
        for( int i=0;i<arr.length;i++ ){
            System.out.print( arr[i] + " " );
        }
        System.out.println();
    }
    public static void merg( String arr[],int si,int mid,int ei ){
        int i = si;
        int j = mid+1;
        int t = 0;
        String temp[] = new String[ei-si+1];
        while( i<=mid && j<= ei ){
            if( arr[i].compareTo(arr[j]) < 0 ){
                temp[t++] = arr[i++];
            }
            else{
                temp[t++] = arr[j++];
            }
        }
        while( i<=mid ){
                temp[t++] = arr[i++];
        }
        while( j<=ei ){
                temp[t++] = arr[j++];
        }
        t = 0;
        for(int l = si;l<= ei;l++){
            arr[l] = temp[t++];
        }

    }
    public static void mergSort(String arr[],int si,int ei){
        if(si == ei){
            return;
        }
        int mid = si + ( ei - si)/2;
        mergSort(arr,si,mid);
        mergSort(arr,mid+1,ei);
        merg(arr,si,mid,ei);
    }
    public static void main(String args[]){
        String arr[] = {"sun", "earth", "mars", "mercury"};
        mergSort(arr,0,arr.length-1);
        print(arr);
    }
}