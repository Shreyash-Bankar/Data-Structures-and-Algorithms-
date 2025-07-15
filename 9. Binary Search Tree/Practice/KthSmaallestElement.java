import java.util.*;
public class KthSmaallestElement{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, Node newNode){
        if(root == null){
            return newNode;
        }
        if(root.data > newNode.data){
            root.left = insert(root.left,newNode);
        }
        else{
            root.right = insert(root.right,newNode);
        }
        return root;
    }
    public static Node build(int arr[]){
        Node root = null;
        for(int i=0;i<arr.length;i++){
            root = insert(root , new Node(arr[i]));
        }
        return root;
    }
    public static int count = 0;
   public static void inorder(Node root, int k){
    if(root == null){
        return;

    }
    inorder(root.left, k);
    count++;
    if(count == k){
        System.out.println(root.data);
    }
    inorder(root.right, k);
   }



    
    public static void main(String args[]){
        int arr[] = {8,5,11,3,6,20};
        Node root = build(arr);
        inorder(root,3);
    }
}