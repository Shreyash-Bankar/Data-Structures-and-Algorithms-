// Find and print all the subset of the given string
import java.util.*;
public class Subset{
    public static void subset(String str,String newStr,int i){
        if(i == str.length()){
            System.out.println(newStr);
            return;
        }
        subset(str,newStr+str.charAt(i),i+1);
        subset(str,newStr,i+1);
    }
    public static void main(String args[]){
        subset("abc","",0);
    }
}