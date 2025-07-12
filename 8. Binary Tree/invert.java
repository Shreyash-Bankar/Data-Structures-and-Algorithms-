import java.util.*;
public class invert{
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
        public static int i = -1;
        public static Node build(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node newNode = new Node(arr[i]);
            newNode.left = build(arr);
            newNode.right = build(arr);
            return newNode;
        }
        public static Node invert(Node root){
            if(root == null){
                return null;
            }
            Node left = invert(root.left);
            Node right = invert(root.right);

            Node temp = left;
            root.left = right;
            root.right = temp;
            return root; 
        }
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String args[]){
        // int arr[] = {2,2,5,-1,-1,2,-1,-1,2,-1,-1};
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        tree t = new tree();
        Node root = t.build(arr);
        t.preorder(root);
        root = t.invert(root);
        System.out.println();
        t.preorder(root);
        
    }
}