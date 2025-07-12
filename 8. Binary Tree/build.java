import java.util.*;
public class build{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class tree{
        public static int i = -1;
        public static Node buildTree(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node root = new Node(arr[i]);
            root.left = buildTree(arr);
            root.right = buildTree(arr);
            return root;
            
        }
        public static void print(Node root){
            if(root ==  null){
                return;
            }
            System.out.print(root.data+" ");
            print(root.left);
            print(root.right);
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        tree Tree = new tree();
        Node root = Tree.buildTree(arr);
        Tree.print(root);

    }
}