import java.util.*;
public class keyPad{
    public static char arr[][] = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public static char abc(int i,int j){
        i = i-2;
        return arr[i][j];
    }

    public static void combinations(int a,int b,int i,int j,ArrayList <String> list){
        if(a == 0 || b == 0){
            return;
        }
        if(arr[a-2].length<=i || arr[b-2].length<=j ){
            return;
        }
        String str = ""+(char)abc(a,i) + (char)abc(b,j);
        if(!list.contains(str)){
            list.add(str);
        }
        combinations(a,b,i,j+1,list);
        combinations(a,b,i+1,j,list);
    }
    public static void main(String args[]){
        ArrayList <String> list = new ArrayList<>();
        combinations(2,3,0,0,list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        
    }
}