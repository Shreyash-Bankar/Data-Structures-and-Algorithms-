//Move all x to nthe end of the string 
// axbcxxd -> abcdxxx

public class movextoend{
    public static void move(String str,int index,String newStr,int count){
        if(index>=str.length()){
            System.out.print(newStr);
            for(int i=0;i<count;i++){
                System.out.print("x");
                }
            return;
        }
        char currChar = str.charAt(index) ;
        if(currChar == 'x'){
            move(str,index+1,newStr,count+1);
        } else{
            newStr = newStr+currChar;
            move(str,index+1,newStr,count);
        }

    }
    public static void main(String args[]){
        String str = "axbcxxd";
        move(str,0,"",0);
    }
}