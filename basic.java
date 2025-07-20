import java.util.*;
public class basic{
    public static void printBoard(char arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
            System.out.println();
    }
    public static boolean check(char arr[][],int i,int j){

        for(int t = i-1;t>=0;t--){
            if(arr[t][j] == 'Q'){
                return false;
            }
        }
        int p = j;
        for(int t = i-1; t>=0;t--){
            p--;
            if(p == -1){
                break;
            }
            if(arr[t][p]== 'Q'){
                return false;
            }
        }
        p = j;
        for(int t = i-1; t>=0;t--){
            p++;
            if(p == arr.length){
                break;
            }
            if(arr[t][p]== 'Q'){
                return false;
            }
        }
        return true;

    }
    public static boolean NQueen(char arr[][],int t){
        if(t == arr.length){
            printBoard(arr);
            return true;
        }
        for(int i=0;i<arr.length;i++){
            if(check(arr,t,i)){
                arr[t][i] = 'Q';
                boolean ans = NQueen(arr,t+1);
                arr[t][i] = '*';
                if(ans == true){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        int n = 4;
        char arr[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                arr[i][j] = '*';
            }
        }
        NQueen(arr,0);
    }
}