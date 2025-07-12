import java.util.*;
public class balanceBST{
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
        }else{
            root.right = insert(root.right,newNode);
        }
        return root;

    }
    public static Node buildTree(int arr[]){
        Node root = null;
        for(int i=0;i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            root = insert(root,newNode);
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

    public static Node build(int arr[],int si,int ei){
        if(si>ei){
            return null;
        }   
        int mid = si + (ei - si)/2;
        Node root = new Node(arr[mid]);
        root.left = build(arr,si,mid-1);
        root.right = build(arr,mid+1,ei);
        return root;

    }
    public static int height2(Node root){
            if(root == null){
                return 0;
            }
            int lh = height2(root.left) ;
            int rh = height2(root.right) ;
            return Math.max(lh, rh) + 1 ;

        }
    public static void main(String args[]){
        int arr[] = {3,5,6,8,10,11,12};
        Node root = build(arr,0,arr.length-1);
        // Node root = buildTree(arr);
        inorder(root);
        System.out.println();
        System.out.println(height2(root));
    }
}