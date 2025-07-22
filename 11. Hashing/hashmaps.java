import java.util.*;
public class hashmaps{
    public static void main(String args[]){
        HashMap <String,Integer> hm = new HashMap<>();
        hm.put("India",200);
        hm.put("China",100);
        hm.put("America",50);
        System.out.println(hm);
        System.out.println(hm.isEmpty());
        System.out.println(hm.remove("China"));
        System.out.println(hm);
        System.out.println(hm.size());
        // hm.clear();
        System.out.println(hm.isEmpty());
        System.out.println(hm);
        Set <String> s = hm.keySet(); 
        System.out.println(s);
        for(String key : s ){
            System.out.println("Key = "+ key + ", Value = " + hm.get(key) );
        }
    }
}