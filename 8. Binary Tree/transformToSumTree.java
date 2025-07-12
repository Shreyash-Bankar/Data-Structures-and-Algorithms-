import java.util.*;
public class transformToSumTree{
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
        public static Node buildTree(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node newNode = new Node(arr[i]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }
        public static int sum(Node root){
            if(root == null){
                return 0;
            }
            int left = sum(root.left);
            int right = sum(root.right);
            int temp = root.data;
            root.data = left + right;
            return left + right + temp; 
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
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        tree t = new tree();
        Node root = t.buildTree(arr);
        System.out.println(t.sum(root));
        t.preorder(root);

    }
} 