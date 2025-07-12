import java.util.*;
public class PrintInRange{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static class tree{
        public static Node insert(Node root, int val){
            if(root == null){
                return new Node(val);
            }
            if(root.data > val){
                root.left = insert(root.left,val);
            }else{
                root.right = insert(root.right,val);
            }
            return root;
        }
        public static Node build(int arr[]){
            Node root  = null;
            for(int i=0;i<arr.length;i++){
                root = insert(root,arr[i]);
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
        public static void printInRange(Node root,int k1,int k2){
            if(root == null){
                return;
            }
            if( root.data > k2 ){
                printInRange(root.left,k1,k2);
            }else if ( root.data < k1 ){
                printInRange(root.right,k1,k2);
            }
            else{
                printInRange(root.left,k1,k2);
                System.out.print(root.data + " ");
                printInRange(root.right,k1,k2);
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {8,5,10,3,6,11,1,4,14};
        tree t = new tree();
        Node root = t.build(arr);
        t.inorder(root);
        System.out.println();
        t.printInRange(root,1,5);
    }
}