import java.util.*;
public class MinAbsoluteDifference{
    public static int difference(int a[],int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum = sum + Math.abs(a[i] - b[i]);
        }
        return sum;
    }
    public static void main(String args[]){
        int a[] = {1,2,3};
        int b[] = {2,1,3};
        System.out.print(difference(a,b));
    }
}