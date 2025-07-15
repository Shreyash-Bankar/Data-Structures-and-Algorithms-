import java.util.*;
public class sumOfSubtreeWithBST{
    public static  class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int i = -1;
    public static Node preorderBuild(int arr[]){
        i++;
        if(arr[i] == -1){
            return null;
        }
        Node newNode = new Node(arr[i]);
        newNode.left = preorderBuild(arr);
        newNode.right = preorderBuild(arr);
        return newNode;
    }
    public static class info{
        int min;
        int max;
        boolean isBST;
        int sum;
        info(boolean isBST, int sum, int min, int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    public static int s = Integer.MIN_VALUE;
    public static info sum(Node root){
        if(root == null){
            return new info(true, 0 , Integer.MAX_VALUE,Integer.MIN_VALUE);
        }   
        info left = sum(root.left);
        info right = sum(root.right);
        boolean bst = false;
        if(left.isBST && right.isBST && left.max<root.data && right.min>root.data){
            bst = true;
            s = Math.max(left.sum + right.sum + root.data,s);
            return new info(bst,left.sum + right.sum + root.data, Math.min(root.data,Math.min(left.min,right.min)),Math.max(root.data,Math.max(left.max,right.max)) );
        }
        return new info(bst,0, Math.min(root.data,Math.min(left.min,right.min)),Math.max(root.data,Math.max(left.max,right.max)) );
    }
    
    public static void main(String args[]){
        int arr[] = {5,9,6,8,-1,-1,7,-1,-1,-1,2,-1,3,-1,-1};
        Node root = preorderBuild(arr);
        sum(root);
        System.out.print(s);
    }
}