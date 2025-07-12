import java.util.*;
public class Sudoku{
    public static void print(int board[][]){
        System.out.println("-----------------------------------------------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------"); 
    }
    public static boolean isSafe(int arr[][],int row,int col,int element){
        
        for(int i=0;i<9;i++){
            if(arr[row][i] == element){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(arr[i][col] == element){
                return false;
            }
        }
        int i = row;
        int j = col;
        while(i%3 != 0){
            i--;
        }
        while(j%3 != 0){
            j--;
        }
        for(int l = 0; l <3;l++){
            for(int t = 0; t <3;t++){
                if(arr[l+i][t+j] == element){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean SolveSudoku(int arr[][],int row,int col){

        if(row == 9){
            return true;
        }
        
        int nextRow = row ; int nextcol = col+1;
        if(nextcol == 9){
            nextRow = row+1;
            nextcol = 0;
        }
        if(arr[row][col]!=-1){
                return SolveSudoku(arr,nextRow,nextcol);
        }
        
        
            for(int i = 1 ;i<10;i++){
                if(isSafe(arr,row,col,i)){
                    arr[row][col] = i;
                    if(SolveSudoku(arr,nextRow,nextcol)){
                        return true;
                    }
                    arr[row][col] = -1;
                }
            }

            return false;
        
    }
    public static void main(String args[]){
        int arr[][] = {
            {-1, -1,  8, -1, -1, -1, -1, -1, -1},
            { 4,  9, -1,  1,  5,  7, -1, -1,  2},
            {-1, -1,  3, -1, -1,  4,  1,  9, -1},
            { 1,  8,  5, -1,  6, -1, -1, 2,-1  },
            {-1, -1, -1, -1,  2, -1, -1, 6,-1  },
            { 9,  6, -1,  4, -1,  5,  3, -1, -1},
            {-1,  3, -1,  -1, 7,  2, -1, -1,  4},
            { -1, 4,  9, -1,  3, -1, -1,  5,  7},
            { 8,  2,  7, -1, -1,9, -1 , 1,  3 }
        };

        if(SolveSudoku(arr,0,0)){
            print(arr);
        }
        // print(arr);
    }
}