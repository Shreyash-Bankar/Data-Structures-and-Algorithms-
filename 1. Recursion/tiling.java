import java.util.*;
public class tiling{
    public static int tile(int n){
        if(n<0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        int horizontal = tile(n-2);
        int vertical = tile(n-1);
        return horizontal + vertical;
    }
    public static int tiles(int n){
        if(n==0){
            return 0;
        }
        int ans = tile(n);
        return ans;
        
    }
    public static void main(String args[]){
        System.out.print(tiles(5));
    }
}