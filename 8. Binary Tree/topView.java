import java.util.*;
public class topView{
    public static class Node{
        int data;
        Node left;
        Node right;
        int vi;
        Node(int data,int vi){
            this.data = data;
            this.vi = vi;
            left = null;
            right = null;
        }
    }
    public static class tree{
        public static int index = -1;
        
        public static Node buildTree(int arr[],int vi){
            index++;
            if(arr[index] == -1){
                return null;
            }
            Node newNode = new Node(arr[index],vi);
            newNode.left = buildTree(arr,vi-1);
            newNode.right = buildTree(arr,vi+1);
            return newNode;
        }
        public static void print(Node root){
            if(root == null ){
                return;
            }
            System.out.print(root.data + " ");
            print(root.left);
            print(root.right);
        }

        public static void TopView(Node root){
            Map <Integer,Integer> map = new TreeMap<>();
            
            Queue <Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                if(!map.containsKey(curr.vi)){
                    map.put(curr.vi,curr.data);
                }
            }
            System.out.print(map.values());

            
        }

    }
    public static void main(String args[]){
        int arr[] = {1,2,-1,4,-1,5,-1,6,-1,-1,3,-1,-1};
        tree t = new tree();
        Node root = t.buildTree(arr,0);
        t.print(root);
        t.TopView(root);
    }
}