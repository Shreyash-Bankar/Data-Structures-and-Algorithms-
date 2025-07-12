import java.util.*;
public class LCA{
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
        static int i =-1;
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
        public static void print(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            print(root.left);
            print(root.right);
        }
        public static boolean isContains(Node root,Node target){
            if(root == null){
                return false;
            }
            if(root == target){
                return true;
            }
            
            return isContains(root.left,target) || isContains(root.right,target);
        }
        public static Node LCA(Node root, Node t1, Node t2){
            if(root == null){
                return null;
            }
            if((isContains(root.left,t1) && isContains(root.right,t2)) || (isContains(root.left,t2) && isContains(root.right,t1))){
                return root;
            }
            Node left = LCA(root.left,t1,t2);
            Node right = LCA(root.right,t1,t2);
            if(left != null){
                return left;
            }else if(right != null){
                return right;
            }
            else{
                return null;
            }
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
    }
    public static void main(String args[]){
        int arr[] = {1,2,4,9,-1,-1,10,-1,-1,5,18,-1,-1,13,-1,-1,3,-1,6,-1,-1};
        tree t = new tree();
        Node root = t.buildTree(arr);
                //                    1
                //         2               3
                //     4      5                6
                //   9   10 18  13
        System.out.print(t.LCA(root,root.left.left.left,root.left.right.right).data);


    }
}