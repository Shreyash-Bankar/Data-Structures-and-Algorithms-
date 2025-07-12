import java.util.*;
public class DiameterA2{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class tree{
        public static class info{
            int diameter;
            int height;
            info(int diameter,int height){
                this.diameter = diameter;
                this.height = height;
            }
        }
        public static int i = -1;
        public static Node build(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node root = new Node(arr[i]);
            root.left = build(arr);
            root.right = build(arr);
            return root;
        }
        public static void print(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            print(root.left);
            print(root.right);
        }
        public static info diameter(Node root){
            if(root == null){
                info newinfo = new info(0,0);
                return newinfo;
            }

            info left = diameter(root.left);
            info right = diameter(root.right);
            return new info(Math.max(left.height+right.height+1,Math.max(left.diameter,right.diameter)),Math.max(left.height,right.height)+1);
        }


    }
    public static void main(String args[]){
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        tree t = new tree();
        Node root = t.build(arr);
        // t.print(root);
        tree.info newinfo = t.diameter(root);
        System.out.print(newinfo.diameter +" "+ newinfo.height);         
    }
}