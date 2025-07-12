import java.util.*;
public class validateBST{
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
        if(root.data > newNode.data){
            root.left = insert(root.left,newNode);
        }else{
            root.right = insert(root.right,newNode);
        }
        return root;

    }
    public static Node buildTree(int arr[]){
        Node root = null;
        for(int i=0;i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            root = insert(root,newNode);
        }
        return root;
    }
    public  static int i = -1;
        public  static Node build(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node root = new Node(arr[i]);
            root.left = build(arr);
            root.right = build(arr);
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
    public static int max(Node root){
        if(root == null){
            return -1;
        }
        int left = max(root.left);
        int right = max(root.right);
        return Math.max(Math.max(left,right),root.data);
    }
    public static int min(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int left = min(root.left);
        int right = min(root.right);
        return Math.min(Math.min(left,right),root.data);
    }
    public static boolean isValide(Node root){
        if(root == null){
            return true;
        }
        if(   !(max(root.left)<root.data) || !(min(root.right)>root.data)){
            return false;
        }
        boolean left = isValide(root.left);
        boolean right = isValide(root.right);
        return left && right;
    }
    public static boolean valid(Node root,int max,int min){
        if(root == null){
            return true;
        }
        if(!(min < root.data) || !(max > root.data)){
            return false;
        }
        boolean left = valid(root.left, root.data , min );
        boolean right = valid(root.right, max ,root.data );
        return left && right;
    }
    public static void main(String args[]){
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = build(arr);
        inorder(root);
        System.out.println();
        System.out.println(valid(root,Integer.MAX_VALUE,Integer.MIN_VALUE));
        int arr2[] = {3,2,5,1,4};
        root = buildTree(arr2);
        inorder(root);
        System.out.println();
        System.out.println(valid(root,Integer.MAX_VALUE,Integer.MIN_VALUE));
    }
}