import java.util.*;
public class search{
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
                root = new Node(val);
                return root;
            }
            if(val < root.data){
                root.left = insert(root.left,val);
            }
            else if(val > root.data){
                root.right = insert(root.right,val);
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
        public static boolean Search(Node root,int key){
            if(root == null){
                return false;
            }
            if(root.data == key){
                return true;
            }
            if(key < root.data){
                return Search(root.left,key);
            }else{
                return Search(root.right,key);
            }
        }
    }
    public static void main(String args[]){
        int[] val = {};
        Node root = null;
        tree t = new tree();
        for(int i=0;i<val.length;i++){
            root = t.insert(root,val[i]);
        }
        System.out.print(t.Search(root,1));
        // t.inorder(root);

    }   
}