import java.util.*;
public class height{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left = null;
            right = null;
        }
    }
    public static class tree{
        public  int i = -1;
        public  Node build(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node root = new Node(arr[i]);
            root.left = build(arr);
            root.right = build(arr);
            return root;
        }
        public  void print(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            print(root.left);
            print(root.right);
        }
        int heigh = 0;
        public void height(Node root,int count){
            heigh = Math.max(heigh,count);
            if(root == null){
                return ;
            }
            height(root.left,count+1);
            height(root.right,count+1);
        }
        public int height2(Node root){
            if(root == null){
                return 0;
            }
            int lh = height2(root.left) ;
            int rh = height2(root.right) ;
            return Math.max(lh, rh) + 1 ;

        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int arr2[] = {1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};
        tree Tree1 = new tree();
        tree Tree2 = new tree();
        Node root1 = Tree1.build(arr);
        Node root2 = Tree2.build(arr2);
        Tree1.print(root1);
        System.out.println();
        Tree2.print(root2);
        System.out.println();
        // Tree1.height(root1,0);
        // Tree2.height(root2,0);
        // System.out.println(Tree1.heigh);
        // System.out.println(Tree2.heigh);
        System.out.println(Tree1.height2(root1));
        System.out.println(Tree2.height2(root2));
        
    }
}