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
    
    public static class info{
        boolean isBST;
        int size;
        int max;
        int min;
        info(boolean isBST, int size, int max, int min){
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    public static int s = 0;
    public static info optimalFunction(Node root){
        if(root == null){
            return new info(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        info left = optimalFunction(root.left);
        info right = optimalFunction(root.right);
        info node = new info(left.max < root.data && right.min > root.data ,left.size + right.size + 1, Math.max(root.data,Math.max(left.max,right.max)), Math.min(root.data,Math.min(left.min,right.min)));
        if(node.isBST == true){
            s = Math.max(s,node.size);
        }
        return node;
    }
    
    public static void main(String args[]){
        int arr[] = {50,30,5,-1,-1,20,-1,-1,60,45,-1,-1,70,65,-1,-1,80,-1,-1};
        Node root = inorderBuild(arr);
        inorder(root);
        System.out.println();
        optimalFunction(root);
        System.out.println(s);
    }
}