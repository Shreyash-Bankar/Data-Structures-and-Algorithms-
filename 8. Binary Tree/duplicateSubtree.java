import java.util.*;
public class duplicateSubtree{
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
        public static boolean compare(Node root1, Node root2){
            if(root1 == null && root2 == null){
                return true;
            }
            if(root1 == null || root2 == null){
                return false;
            }
            if(root1.data != root2.data){
                return false;
            }
            boolean left = compare(root1.left,root2.left);
            boolean right = compare(root1.right,root2.right);
            return left && right;
        }
        public static HashMap <Integer,Node> list = new HashMap<>();
        public static void duplicate(Node root){
            if(root == null ){
                return;
            }
            if(list.containsKey(root.data) && compare(root,list.get(root.data))){
                System.out.print(root.data+" ");
            }else{
                list.put(root.data,root);
            }
            duplicate(root.left);
            duplicate(root.right);
        }
    }
    public static void main(String args[]){
        int arr[] = {1,4,3,-1,-1,6,-1,-1,3,4,3,-1,-1,6,-1,-1,6,-1,-1};
        tree t = new tree();
        Node root = t.build(arr);
        t.preorder(root);
        System.out.println();
        t.duplicate(root);
        // t.preorder(root);
    }
}