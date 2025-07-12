import java.util.*;
public class printStringInReverse{
    public static void psir(String str,int i){
        if(i < 0){
            return;
        }
        System.out.print(str.charAt(i));
        psir(str,i-1);
    }
    public static void main(String args[]){
        psir("Shreyash",7);
    }
}