import java.util.*;
public class practice{
    public static int countInRange(int arr[],int si,int ei,int element){
        int count = 0;
        for(int i= si; i<=ei;i++){
            if(arr[i] == element){
                count++;
            }
        }
        return count;
    }
    public static int majorityElement(int arr[],int si,int ei){
        if(si == ei){
            return arr[si];
        }
        int mid = si + (ei-si)/2;
        int left = majorityElement(arr,0,mid);
        int right = majorityElement(arr,mid+1,ei);
        if(left == right){
            return left;
        }
        int leftCount = countInRange(arr,si,ei,left);
        int rightCount = countInRange(arr,si,ei,right);
        return (leftCount > rightCount) ? left : right;
    }
    public static void main(String args[]){
        int arr[] = {2,2,1,1,1,2,2};
        System.out.print( majorityElement(arr,0,arr.length-1) );
    }
}


