// Given an array of distinct integers arr[] and an integer target, the task is to find a list of all unique combinations of array where the sum of chosen element is equal to target.

// Note: The same number may be chosen from array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
// Examples: 

// Input: arr[] = [2, 4, 6, 8], target = 8
// Output: [[2, 2, 2, 2], 
//                 [2, 2, 4],
//                 [2, 6],
//                 [4, 4],
//                 [8]]

// Input: arr[] = [2, 7, 6, 5], target = 16
// Output: [[2, 2, 2, 2, 2, 2, 2, 2],
//                 [2, 2, 2, 2, 2, 6],
//                 [2, 2, 2, 5, 5],
//                 [2, 2, 5, 7],
//                 [2, 2, 6, 6],
//                 [2, 7, 7],
//                 [5, 5, 6]]

import java.util.*;
public class combinationSum{
    public static ArrayList <ArrayList <Integer>> arrL = new ArrayList<>();
    public static void soln(int arr[],int start,int target,int sum,ArrayList <Integer> li){
        if(sum == target){
            
            arrL.add(new ArrayList<>(li));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<arr.length;i++){
            li.add(arr[i]);
            soln(arr,i,target,sum+arr[i],li);
            li.remove(li.size() - 1);
        }
    }
    public static void main(String args[]){
        int arr[] = {20,10};
        soln(arr,0,5,0,new ArrayList<>());
        
        System.out.print(arrL);
    }
}