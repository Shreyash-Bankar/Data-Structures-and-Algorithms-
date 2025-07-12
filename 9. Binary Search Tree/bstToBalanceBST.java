import java.util.*;
public class bstToBalanceBST{
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
        if(newNode.data < root.data){
            root.left = insert(root.left, newNode);
        }
        if(newNode.data >= root.data){
            root.right = insert(root.right, newNode);
        }
        return root;
    }
    public static Node build(int arr[]){
        Node root = null;
        for(int i=0;i<arr.length;i++){
            root = insert(root,new Node(arr[i]));
        }
        return root;
    }
    public static ArrayList inorder(Node root,ArrayList <Integer> list){
        if(root == null){
            return list;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
        return list;

    }
    public static void preorder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
        

    }
    public static Node balanceBST (ArrayList <Integer> list, int si, int ei){
        if(si > ei){
            return null;
        }
        int mid = si + (ei - si) / 2 ; 
        Node root = new Node(list.get(mid));
        root.left = balanceBST(list,si,mid-1);
        root.right = balanceBST(list,mid+1,ei);
        return root;
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;

    }
    public static void main(String args[]){
        int arr[] = {8,6,10,5,11,3,12};
        Node root = build(arr);
        ArrayList <Integer> list = new ArrayList<>();
        inorder(root,list);
        System.out.println(list);
        preorder(root);
        System.out.println();
        System.out.println(height(root));
        root = balanceBST(list,0,list.size()-1);
        list = new ArrayList<>();
        inorder(root,list);
        System.out.println(list);
        preorder(root);
        System.out.println();
        System.out.println(height(root));

    }
}