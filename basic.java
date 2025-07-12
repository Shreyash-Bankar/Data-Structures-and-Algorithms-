import java.util.*;
public class basic{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root,Node newNode){
        if(root == null){
            return newNode;
        }
        if(newNode.data < root.data){
            root.left = insert(root.left,newNode);
        }
        if(newNode.data >= root.data){
            root.right = insert(root.right,newNode);
        }
        return root;
    }
    public static Node buildBST(int arr[]){
        Node root= null;
        for(int i=0;i<arr.length;i++){
            root = insert(root,new Node(arr[i]));
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return ;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void preorder(Node root){
        if(root == null){
            return ;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }   
    public static void main(String args[]){
        int arr[] = {8,5,10,3,6,11};
        int arr2[] = {8,5,3,-1,-1,6,-1,-1,10,-1,11,-1,-1};
        Node root = buildBST(arr);
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        System.out.println("After mirror: ");
        root = mirror(root);
        inorder(root);
        System.out.println();
        preorder(root);
    }   
}