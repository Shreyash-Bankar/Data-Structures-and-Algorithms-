// // Question 3 : Given an array of integers. Find the Inversion Count in the array. (HARD)
// // Inversion Count: For an array, inversion count indicates how far (or close) the array is from
// // being sorted. If the array is already sorted then the inversion count is 0. If an array is
// // sorted in the reverse order then the inversion count is the maximum.
// // Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
// // Sample Input 1 : N = 5, arr[ ] = {2, 4, 1, 3, 5}
// // Sample Output 1 : 3, because it has 3 inversions - (2, 1), (4, 1), (4, 3).
// // Sample Input 2 : N = 5, arr[ ] = {2, 3, 4, 5, 6}
// // Sample Output 2 : 0, because the array is already sorted
// // Sample Input 3 : N = 3, arr[] = {5, 5, 5}
// // Sample Output 3 : 0, because all the elements of the array are the same & already in a sorted
// // manner.
// // (Hint : A sorting algorithm will be used to solve this question.)
// // Note - This question is important. Even if you are not able to come up with the approach,
// // please understand the solution.

// // import java.util.*;
// // public class InverseCount{
// //     public static int invereCount(int arr[]){
// //         int count = 0;
// //         for(int i=0;i<arr.length;i++){
// //             for(int j=i;j<arr.length;j++){
// //                 if(arr[i]>arr[j]){
// //                     count++;
// //                 }
// //             }
// //         }
// //         return count;
// //     }
// //     public static void main(String args[]){
// //         int arr[] = {5,5,5};
// //         System.out.println(invereCount(arr));
// //     }
// // }

import java.util.*;
public class InverseCount{

     public static int merge(int arr[], int si,int ei,int mid) {
        int i = si;
        int j = mid+1;
        int inv = 0 ;
        int temp [] = new int[ei-si+1];
        int t=0;
        while(i<=mid && j<=ei){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else{
                inv += mid+1-i;
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
        for(int l=si; l<=ei; l++){
            arr[l] = temp[t++];
        }
        return inv;

    }

    public static int inverseCount(int arr[],int si,int ei){
        if(si >= ei){
            return 0;
        }
        int mid = si + (ei - si)/2;

        int leftCount = inverseCount(arr,si,mid);
        int rightCount = inverseCount(arr,mid+1,ei);
        int jointCount = merge(arr,si,ei,mid);
        return leftCount + rightCount + jointCount;
    }
    public static void main(String args[]){
        int arr[] = {2,4,1,3,5};
        System.out.println(inverseCount(arr,0,arr.length-1));
    }
}
