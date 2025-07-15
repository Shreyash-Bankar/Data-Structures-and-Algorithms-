// We have a Binary Search Tree consisting of N nodes and two positive integers L and R, the task is to ﬁnd the sum of values of all the nodes that lie in the range [L, R]
import java.util.*;
public class SumInRange{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root ,Node newNode){
        if(root == null){
            return newNode;
        }
        if(root.data > newNode.data){
            root.left = insert(root.left,newNode);
        }
        if(root.data <= newNode.data){
            root.right = insert(root.right,newNode);
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
    public static int sum(Node root, int L,int R){
        if(root == null){
            return 0;
        }
        int left = sum(root.left,L,R); 
        int right = sum(root.right,L,R); 
        if(root.data < L || root.data > R){
            return left + right;
        }
        return left + right + root.data;
    }
    public static void main(String args[]){
        int arr[] = {8,5,11,3,6,20};
        Node root = build(arr);
        System.out.println(sum(root,4,7));
    }
}