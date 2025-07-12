import java.util.*;
public class univalued{
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
        public static ArrayList <Integer> list = new ArrayList<>(); 
        public static boolean univalued(Node root){
            if(root == null){
                return true;
            }
            if(list.contains(root.data)){
                return false;
            }
            list.add(root.data);
            boolean left = univalued(root.left);
            boolean right = univalued(root.right);
            return left && right;
        }
    }
    public static void main(String args[]){
        // int arr[] = {2,2,5,-1,-1,2,-1,-1,2,-1,-1};
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        tree t = new tree();
        Node root = t.build(arr);
        System.out.print(t.univalued(root));
    }
}