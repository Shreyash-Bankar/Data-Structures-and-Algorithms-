import java.util.*;
public class NQueen{
    public static void print(char board[][]){
        System.out.println("-----------------------------------------------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }

    public static boolean isSafe(char board[][],int row, int col){
        for(int i = row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = row-1,j = col-1; i>=0 && j>=0;i--,j-- ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row-1,j = col+1; i>=0 && j < board.length;i--,j++ ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static boolean NQueens(char board[][],int row){
        if(row == board.length){
            // print(board);
            return true;
        }

        for(int i=0;i<board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i] = 'Q';
                if(NQueens(board,row+1)){
                    return true;
                }
                board[row][i] = 'X';
            }
        }

        return false;
    }
    public static void main(String args[]){
        char board[][] = new char[4][4];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j] = 'X';
            }
        }
        if(NQueens(board,0)){
            print(board);
        }
    }
}