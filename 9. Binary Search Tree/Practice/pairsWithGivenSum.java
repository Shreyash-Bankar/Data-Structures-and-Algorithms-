import java.util.*;
public class pairsWithGivenSum{
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
    public static boolean isContains(Node root, int number){
        if(root == null){
            return false;
        }
        if(root.data == number){
            return true;
        }
        boolean left = isContains(root.left,number);
        boolean right = isContains(root.right,number);
        return left || right;
    }
    public static int noOfPairs(Node mainRoot, Node root, int sum){
        if(root == null){
            return 0;
        }
        int left = noOfPairs(mainRoot,root.left, sum);
        int right = noOfPairs(mainRoot,root.right, sum);
        if(isContains( mainRoot, sum - root.data)){
            return left + right + 1;
        }
        return left + right;
    }

    
    public static void main(String args[]){
        int arr[] = {5,3,7,2,4,6,8};
        Node root = build(arr);
        System.out.println((noOfPairs(root, root, 10) )/2);
    }
}