import java.util.*;
public class binaryString{
    public static void binarystring(int n,int i,String str,int status){
        if(i==n){
            System.out.println(str);
            return;
        }
        binarystring(n,i+1,str+"0",1);
        if(status != -1){
            binarystring(n,i+1,str+"1",-1);
        }
    }
    public static void main(String args[]){
        binarystring(3,0,"",1);
        // System.out.println("Hellow World");
    }
}