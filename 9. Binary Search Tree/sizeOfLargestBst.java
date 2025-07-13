import java.util.*;
public class sizeOfLargestBst{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, Node newNode){
        if(root == null){
            return newNode;
        }
        if( newNode.data < root.data){
            root.left = insert(root.left,newNode);
        }else{
            root.right = insert(root.right,newNode);
        }
        return root;
    }
    public static Node build(int arr[]){
        Node root = null;
        for(int i = 0; i < arr.length; i++){
            root = insert(root,new Node(arr[i]));
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static int i = -1;
    public static Node inorderBuild(int arr[]){
        i++;
        if(arr[i] == -1){
            return null;
        }
        Node newNode = new Node(arr[i]);
        newNode.left = inorderBuild(arr);
        newNode.right = inorderBuild(arr);
        return newNode;
    }
    public static boolean isValide(Node root,int min,int max){
        if(root == null){
            return true;
        }
        if(!(min < root.data) || !(root.data < max)){
            return false;
        }
        boolean left = isValide(root.left,min,root.data);
        boolean right = isValide(root.right,root.data,max);
        return left && right;
    }
    public static int number(Node root){
        if(root == null){
            return 0;
        }
        int left = number(root.left);
        int right = number(root.right);
        return left + right + 1;
    }
    public static int max = 0;
    public static int size(Node root){
        if(root == null){
            return max;
        }
        if(isValide(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            max = Math.max(number(root),max);
        }
        size(root.left);
        size(root.right);
        return max;

    }
    public static void main(String args[]){
        int arr[] = {50,30,5,-1,-1,20,-1,-1,60,45,-1,-1,70,65,-1,-1,80,-1,-1};
        Node root = inorderBuild(arr);
        inorder(root);
        System.out.println();
        System.out.print(size(root));
    }
}