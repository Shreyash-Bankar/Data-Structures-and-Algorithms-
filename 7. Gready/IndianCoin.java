import java.util.*;
public class IndianCoin{
    public static void Notes(){
        int coin[] = {2000,500,100,50,20,10,5,2,1};
        int amount = 43;
        int count = 0;
        
        ArrayList <Integer> list = new ArrayList<>();
        for(int i = 0;i<coin.length;i++){
            if(coin[i]<=amount){
                amount = amount - coin[i];
                System.out.print(coin[i]+" ");
                count ++;
                i++;
            }
        }
    }
    public static void main(String args[]){
        int coin[] = {2000,500,100,50,20,10,5,2,1};
        Notes();
    }
}