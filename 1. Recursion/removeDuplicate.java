//Remove Duplicates in String
// abccda -> abcd
import java.util.*;
public class removeDuplicate{
    public static HashSet<Character> set = new HashSet<>();
    public static void rd(String str,String newStr ,int i){
        if(i>=str.length()){
            System.out.print(newStr);
            return;
        }
        if(!set.contains(str.charAt(i))){
             set.add(str.charAt(i));
             rd(str,newStr+str.charAt(i),i+1);
        }else{
            rd(str,newStr,i+1);
        }
    }
    public static void main(String args[]){
        rd("shreyash","",0);
    }
}