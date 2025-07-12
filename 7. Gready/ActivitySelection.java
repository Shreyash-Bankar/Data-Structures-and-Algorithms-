import java.util.*;
public class ActivitySelection{
    public static int selectActivity(int start[],int end[]){

        int act[][] = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            act[i][0] = i;
            act[i][1] = start[i];
            act[i][2] = end[i];

        }
        Arrays.sort(act,Comparator.comparingDouble(o -> o [2]));
        int activity = 1;

        int s = 0;
        int e = act[0][2];
        for(int i=1;i<start.length;i++){
            s = act[i][1];
            if(s>e){
                activity++;
                e = act[i][2];
            }
        }

        return activity;
    }
    public static void main(String args[]){
        int start[] = {1,2,3,5};
        int end[] =   {2,3,4,6};
        System.out.print(selectActivity(start,end));
    }
}