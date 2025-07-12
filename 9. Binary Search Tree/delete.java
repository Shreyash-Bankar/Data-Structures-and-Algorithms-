import java.util.*;
public class delete{
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
        public static Node insert(Node root,int val){
            if(root == null){
                Node newNode = new Node(val);
                return newNode;
            }
            if(root.data > val){
                root.left =  insert(root.left,val);
            }
            else{
                root.right =  insert(root.right,val);
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
        public static Node construct(int arr[]){
            Node root = null;
            for(int i=0 ; i<arr.length;i++){
                root = insert(root,arr[i]);
            }
            return root;
        }
        public static Node inorderSucc(Node root){
            if(root.left == null){
                return root;
            }
            Node left = inorderSucc(root.left);
            return left;
        }
        public static Node delete(Node root, int target){
            if(root == null){
                return null; 
            }
            if( root.data > target){
                root.left = delete(root.left,target);
            }else if( root.data < target){
                root.right = delete(root.right,target);
            }else{
                if(root.left == null && root.right == null){
                    return null;
                }
                else if(root.left == null || root.right == null){
                    if(root.left == null){
                        return root.right;
                    }else{
                        return root.left;
                    }
                }else{
                    Node is = inorderSucc(root.right);
                    root.data = is.data;
                    root.right = delete(root.right,is.data);
                    return root;
                }
            }
            return root;
        }
    }
    public static void main(String args[]){
        int arr[] = {20, 10, 5,1};
        tree t = new tree();
        Node root = t.construct(arr);
        t.inorder(root);
        System.out.println();
        root = t.delete(root, 20);
        t.inorder(root);

    }
}