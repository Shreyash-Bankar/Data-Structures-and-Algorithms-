import java.util.*;
public class kAncestor{
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
    public static class Tree{
        public static int i = -1;
        public  static Node buildTree(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node newNode = new Node(arr[i]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }
        public static int count = -1;
        public static Node ka(Node root,Node target,int k){
            if(root == null){
                return null;
            }
            if(root == target){
                count++;
                return target ;
                
            }
            Node left = ka(root.left,target,k);
            Node right = ka(root.right,target,k);
            if(count != -1 && count<k){    
                if(left != null){
                    count++;
                    return root;
                }else if(right != null){
                    count++;
                    return root;
                }   
            }
            if(left != null){
                return left;
            }else if(right != null){
                return right;
            }
            return null;
        }

    }
    public static void main(String args[]){
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Tree t = new Tree();
        Node root = t.buildTree(arr);
        System.out.println(t.ka(root,root.right.left,2).data);
    }
}