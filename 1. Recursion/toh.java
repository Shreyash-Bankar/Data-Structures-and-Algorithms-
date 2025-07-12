import java.util.*;
public class toh{
    public static void towerOfHannoi(int n,char a,char b,char c){
        if(n ==0){
            return;
        }
        towerOfHannoi(n-1,a,c,b);
        System.out.println("Move "+n+" from "+a+" to "+c);
        towerOfHannoi(n-1,b,a,c);

    }
    public static void main(String args[]){
        towerOfHannoi(3,'A','B','C');
    }
}