// import java.util.*;
// public class MajorityElement{
//     public static int majority(int arr[]){
//         int count = 0;
//         int element = -1;
//         int CurrCount = 0;
//         int CurrElement = arr[0];
//         for(int i=0;i<arr.length;i++){
//             if(arr[i] == CurrElement){
//                 CurrCount++;
//             }else{
//                 if(count<CurrCount){
//                     count = CurrCount;
//                     element = CurrElement;
//                 }
//                     CurrElement = arr[i];
//                     CurrCount = 1;
//             }
//         }
//         if(count<CurrCount){
//                     count = CurrCount;
//                     element = CurrElement;
//                 }
        
//         if(count>=arr.length/2){
//             return element;
//         }
//         return -1;
//     }
//     public static void main(String args[]){
//         int arr[] = {1,1,1,2,2,2,2};
//         Arrays.sort(arr);
//         System.out.print(majority(arr));
//     }
// }

// Question 2 : Given an array nums of size n, return the majority element. (MEDIUM)
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
// that the majority element always exists in the array.
// Sample Input 1 : nums = [3,2,3]
// Sample Output 1 : 3
// Sample Input 2 : nums = [2,2,1,1,1,2,2]
// Sample Output 2 : 2
import java.util.*;
public class MajorityElement{
    public static int countInRange(int arr[],int si,int ei,int element){
        int count = 0;
        for(int i= si;i<=ei;i++){
            if(arr[i] == element){
                count++;
            }
        }
        return count;
    }
    public static int MajorityElement(int arr[],int si,int ei){
        if(si==ei){
            return arr[si];
        }
        int mid = si + (ei - si)/2;
        int left = MajorityElement(arr,si,mid);
        int right = MajorityElement(arr,mid+1,ei);

        if(left == right){
            return left;
        }
        int leftElement = countInRange(arr,si,ei,left);
        int rightElement = countInRange(arr,si,ei,right);
        
        return (leftElement>=rightElement)? left: right;

    }
    public static int majority(int arr[]){
        return MajorityElement(arr,0,arr.length-1);
    }
    public static void main(String args[]){

        int arr[] = {2,2,1,1,1,2,2};
        System.out.print(majority(arr));

    }   
}