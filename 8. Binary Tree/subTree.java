import java.util.*;
public class subTree{
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
    public static boolean match(Node root1, Node root2){
        
        if(root1 == null && root2 != null ){
            return false;
        }
        else if(root1 != null && root2 == null ){
            return false;
        }

        else if(root1 == null && root2 == null ){
            return true; 
        }
        else if(root1.data != root2.data){
            return false;
        }
        
        return match(root1.left,root2.left) && match(root1.right,root2.right);
         
    }
    public static boolean matchSubTree(Node root1, Node root2){
        if(root1 == null){
            return false;
        }
        if(root2 == null){
            return true;
        }
        if(root1.data == root2.data){
            return match(root1,root2) == true;
        }

        return matchSubTree(root1.left,root2) || matchSubTree(root1.right,root2);  
        

    }
    public static class Tree{
        public static int i = -1;
        public static Node buildTree(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node newNode = new Node(arr[i]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }
        public static void printTree(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            printTree(root.left);
            printTree(root.right);
        }
        
    }
    public static void main(String args[]){
        int arr1[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int arr2[] = {6,-1,-1};
        Tree t = new Tree();
        Node root1 = t.buildTree(arr1);
        t.i = -1;
        Node root2 = t.buildTree(arr2);

        t.printTree(root1);
        System.out.println();
        t.printTree(root2);
        System.out.println();
        System.out.println(matchSubTree(root1,root2));
    }
}