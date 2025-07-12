import java.util.*;
public class minDistance{
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
    public static class Tree{
        public static int i = -1;
        public  static Node buildTree(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node newNode = new Node(arr[i]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }
        public static Node lca2(Node root, Node n1, Node n2){
            if(root == null){
                return null;
            }
            if(root.data == n1.data || root.data == n2.data){
                return root;
            }
            Node left = lca2(root.left,n1,n2);
            Node right = lca2(root.right,n1,n2);

            if((left == n1 && right == n2) || (left == n1 && right == n1)){
                return root;
            }else if(left!=null){
                return  left;
            }else if(right != null){
                return right;
            }
            else{
                return null;
            }
        }
        public static int distance(Node root, Node n1, Node n2,int h){
            if(root == null ){
                return 0;
            }
            if(root == n1 || root == n2){
                return h;
            }
            int left = distance(root.left,n1,n2,h+1);
            int right = distance(root.right,n1,n2,h+1);
            return left + right;
        }
        public static int minDistance(Node root, Node n1, Node n2){
            if(root == null || lca2(root,n1,n2) == null){
                return -1;
            }
            return distance(lca2(root,n1,n2),n1,n2,0);
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Tree t = new Tree();
        Node root = t.buildTree(arr);
        System.out.println(t.minDistance(root,root.left.left,root.right.left));
    }
}