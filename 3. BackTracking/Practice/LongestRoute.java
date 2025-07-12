// Given an N x M matrix, with a few hurdles(denoted by 0) arbitrarily placed, calculate the length of the longest possible route possible from source(xs,ys) to a destination(xd,yd) within the matrix. We are allowed to move to only adjacent cells which are not hurdles. The route cannot contain any diagonal moves and a location once visited in a particular path cannot be visited again.If it is impossible to reach the destination from the source return -1

import java.util.*;
public class LongestRoute{
    
    public static int length = 0;
    public static int maxLength = -1;
    public static void route(int arr[][],int i,int j,int visited[][],int x,int y){
        if(i == x && j == y){
            maxLength = Math.max(maxLength,length);
            return;
        }
        if(i>=arr.length || j>= arr[0].length || i<0 || j<0){
            return;
        }
        if(arr[i][j] == 0 || visited[i][j] == 1){
            return;
        }
        length++;
        visited[i][j] = 1;
        route(arr,i+1,j,visited,x,y);
        route(arr,i,j+1,visited,x,y);
        route(arr,i-1,j,visited,x,y);
        route(arr,i,j-1,visited,x,y);
        visited[i][j] = 0;
        length--;
    }
    public static void main(String args[]){
        int arr [][] = {
                        {1,0,0,1,1,0},
                        {1,1,1,1,1,1}};
        int visited [][] = new int[arr.length][arr[0].length];
        route(arr,0,0,visited,1,3);
        System.out.print(maxLength);
    }
}