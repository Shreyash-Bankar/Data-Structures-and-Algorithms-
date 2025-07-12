import java.util.*;
public class Power{
    public static int power(int a,int n){
        if(n == 0){
            return 1;
        }
        if(n <=1){
            return a;
        }
        int left = power(a,n/2);
        int right = power(a,n/2);
        if(n%2 == 0 ){
            return left*right;

        }else{
            return left*right*a;
        }
    }
    
    public static void main(String args[]){
        System.out.print(power(3,8));
    }
}