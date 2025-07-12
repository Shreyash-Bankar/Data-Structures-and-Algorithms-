import java.util.*;
public class Permutation{
    public static void permutation(String str,String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            String newString = str.substring(0,i) + str.substring(i+1) ;
            permutation(newString , ans + str.charAt(i));
        }
    }
    public static void main(String args[]){
        permutation("abcd","");
    }
}