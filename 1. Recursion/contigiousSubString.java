import java.util.*;
public class contigiousSubString{
    public static int count = 0;
    public static HashSet <String> set = new HashSet <>(); 
    public static void contiguousSubstrings(String str,int n,int i,int j){
        if(i>n || j>n || i>=j ){
            return;
        }
        String key = i+","+j;
        if(!set.contains(key)){
            set.add(key);
            String sub = str.substring(i,j);
            if(sub.charAt(0) == sub.charAt((sub.length()-1))){
                System.out.println(sub+" ");
                count++;
            }
        }
        contiguousSubstrings(str, n, i+1,j);
        contiguousSubstrings(str, n, i,j+1);
    }
    public static void main(String args[]){
        String str = "abcab";
        int n = str.length();
        contiguousSubstrings(str,n,0,1);
        System.out.print(count);
    } 
}