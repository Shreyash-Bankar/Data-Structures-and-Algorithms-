import java.util.*;
public class ClosestElement{
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
    public static int closest = Integer.MAX_VALUE;
    public static void findClosest(Node root,int number){
        if(root == null){
            return;
        }
        if(Math.abs(number - root.data) < Math.abs(number - closest) ){
            closest = root.data; 
        }
        if(number < root.data){
            findClosest(root.left, number);
        }else{
            findClosest(root.right, number);
        }



    }
    public static void main(String args[]){
        int arr[] = {8,5,11,3,6,20};
        Node root = build(arr);
        findClosest(root,19);
        System.out.println(closest);
    }
}