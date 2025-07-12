import java.util.*;
public class paths{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static class tree{
        public static Node insert(Node root, int val){
            if(root == null){
                return new Node(val);
            }
            if(root.data > val){
                root.left = insert(root.left,val);
            }else{
                root.right = insert(root.right,val);
            }
            return root;
        }
        public static Node build(int arr[]){
            Node root = null;
            for(int i=0;i<arr.length;i++){
                root = insert(root,arr[i]);
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
        // public static ArrayList <Integer> list = new ArrayList<>();
        // public static void paths(Node root){
        //     if(root == null){
        //         return;
        //     }
        //     if(root.left == null && root.right == null){
        //         list.add(root.data);
        //         System.out.println(list);
        //         list.remove(list.size()-1);
        //         return;
        //     }
        //     list.add(root.data);
        //     paths(root.left);
        //     paths(root.right);
        //     list.remove(list.size()-1);
        // }
        
        public static void paths(Node root, ArrayList <Integer> list){
            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                list.add(root.data);
                System.out.println(list);
                list.remove(list.size()-1);
                return;
            }
            list.add(root.data);
            paths(root.left,list);
            paths(root.right,list);
            list.remove(list.size()-1);
        }

    }
    public static void main(String args[]){
        int arr[] = {8,5,10,3,6,11,14};
        tree t = new tree();
        Node root = t.build(arr);
        t.inorder(root);
        System.out.println();
        t.paths(root,new ArrayList<>());

    }
}