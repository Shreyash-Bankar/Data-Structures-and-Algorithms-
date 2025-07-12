import java.util.*;
public class practice{
    public static ArrayList <Integer> makeBoard(char board[][]){
        ArrayList <Integer> list = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j] = 'Q'){
                    list.add(i+1);
                    break;
                }
            }
            
        }
        return list;
    }
    public static boolean isSafe(char board[][],int row,int col){
        for(int i = row-1; i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = col-1; i>=0;i--){
            if(board[row][i] == 'Q'){
                return false;
            }
        }
        for(int i = row-1,j = col -1; i>=0 && j>=0;i--,j--){
            
                if(board[i][j] == 'Q'){
                    return false;
                }
            
        }
        for(int i = row-1,j = col +1; i>=0 && j<=board.length-1;i--,j++){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
        
        return true;
    }
    ArrayList <ArrayList<Integer>> boardList = new ArrayList <> ();
    public static void nQueen(char board[][],int i){
        if(i == board.length){
            boardList.add(new ArrayList <> (makeBoard(board)) );
            return;
        }
        
        for(int j=0;j<board.length;j++){
            if(isSafe(board,i,j)){
                board[i][j] = 'Q';
                nQueen(board,i+1);
                board[i][j] = 'X';
            }
        }
    }
    public static void main(String args[]){
        char board[][] = {{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'}};
        nQueen(board,0);
    }
}