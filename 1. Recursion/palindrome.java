import java.util.*;
public class palindrome{
    public static boolean checkPalindrome(String str,int i){
        if(i>str.length()/2){
            return true;
        }
        if(str.charAt(i) != str.charAt(str.length()-1-i)){
            return false;
        }

        return checkPalindrome(str,i+1);
    }
    public static void main (String args[]){
        System.out.print(checkPalindrome("MADAMa",0));
    }
}