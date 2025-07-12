import java.util.*;
public class fibonacci{
    public static int fibo(int n){
        if( n == 0 || n==1 ){
            return 1;
        }

        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String args[]){
        System.out.print(fibo(5));
    }   
}