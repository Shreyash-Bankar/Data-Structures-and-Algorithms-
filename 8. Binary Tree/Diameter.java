import java.util.*;
public class Diameter{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left = null;
            right = null;
        }
    }
    public static class tree{
        public  int i = -1;
        public  Node build(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node root = new Node(arr[i]);
            root.left = build(arr);
            root.right = build(arr);
            return root;
        }
        public  void print(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            print(root.left);
            print(root.right);
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh) + 1;
        }
       
        public static int diameter(Node root){

            if(root == null){
                return 0;
            }
            int diam = height(root.left)+height(root.right) + 1;
            int left = diameter(root.left);
            int right = diameter(root.right);
            return Math.max(diam,Math.max(left,right));
        }
        
    }
    public static void main(String args[]){
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int arr2[] = {1,2,4,9,-1,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};
        tree Tree = new tree();
        
        Node root = Tree.build(arr);
       
        Tree.print(root);
        System.out.println();
        System.out.print(Tree.diameter(root));
        
       
        
    }
}