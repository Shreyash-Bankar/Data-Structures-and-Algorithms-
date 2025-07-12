import java.util.*;
public class kLevel{
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
        public static int index = -1;
        
        public static Node buildTree(int arr[]){
            index++;
            if(arr[index] == -1){
                return null;
            }
            Node newNode = new Node(arr[index]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }
        public static void print(Node root,int t,int k){
            if(root == null ){
                return;
            }
            if(t == k){
                System.out.print(root.data + " ");
            }
                
            print(root.left,t+1,k);
            print(root.right,t+1,k);
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        tree t = new tree();
        Node root = t.buildTree(arr);
        t.print(root,1,3);

    }
}