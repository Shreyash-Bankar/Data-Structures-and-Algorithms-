// Weakest Soldier
// We are given an mxn binary matrix of 1's (soldiers) and 0's (civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
// A row i is weaker than a row j if one of the following is true:
// The number of soldiers in row i is less than the number of soldiers in row j.
// Both rows have the same number of soldiers and i < j.
// Find the K weakest rows.
// Example:
// m = 4, n = 4, k = 2
// 1 0 0 0  
// 1 1 1 1  
// 1 0 0 0  
// 1 0 0 0  
// ans = row0 & row2

import java.util.*;
public class kWeekestSoldiers{
    public static class soldier implements Comparable<soldier>{
        int row[];
        int index;
        int count;
        soldier(int row[],int index){
            this.row = row;
            this.index = index;
            count = 0;
            for(int i=0;i<row.length;i++){
                if(row[i] == 1){
                    count ++;
                }
            }
        }
        public int compareTo(soldier s1){
            if(this.count == s1.count){
                return this.index - s1.index;
            }else{
                return this.count - s1.count;
            }
        }
    }
    public static void main(String args[]){
        PriorityQueue <soldier> pq = new PriorityQueue<>();
        int arr[][] = { {1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0} };
        pq.add(new soldier(arr[0],0));
        pq.add(new soldier(arr[1],1));
        pq.add(new soldier(arr[2],2));
        pq.add(new soldier(arr[3],3));
        int k = 2;
        for(int i=0;i<k;i++){
            System.out.println("Row "+pq.remove().index);
        }
    }
}