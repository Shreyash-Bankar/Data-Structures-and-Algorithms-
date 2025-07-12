import java.util.*;
public class deleteLeafOfTarget{
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
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        
        public static Node delete(Node root, int target){
            if(root == null){
                return null;
            }
            root.left = delete(root.left, target);
            root.right = delete(root.right, target);
            if(root.left == null && root.right == null && root.data == target ){
                return null;
            }
            return root;

        }
    }
    public static void main(String args[]){
        int arr[] = {1,3,3,-1,-1,2,-1,-1,3,-1,-1};
        tree t = new tree();
        Node root = t.build(arr);
        t.preorder(root);
        System.out.println();
        t.delete(root,3);
        t.preorder(root);
    }
}