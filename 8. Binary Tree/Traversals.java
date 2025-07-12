import java.util.*;
public class Traversals{
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
    public static class Tree {
        public static int i = -1;
        public static Node buildPreorder(int arr[]){
            i++;
            if(arr[i] == -1){
                return null;
            }
            Node root = new Node(arr[i]);
            root.left = buildPreorder(arr);
            root.right = buildPreorder(arr); 
            return root;
            
        }
        public static void preorderTraversal(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        public static void inorderTraversal(Node root){
            if(root == null){
                return;
            }
            inorderTraversal(root.left);
            System.out.print(root.data+" ");
            inorderTraversal(root.right);
        }
        public static void postorderTraversal(Node root){
            if(root == null){
                return;
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelorderTraversal(Node root){
            Queue <Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr!= null){
                    System.out.print(curr.data+" ");
                    if(curr.left!= null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }else{
                    if(q.isEmpty()){
                        System.out.println();
                        break;
                    }
                    System.out.println();
                    q.add(null);
                }
            }

        }
        public static void levelorderTraversal2(Node root){
            Queue <Node> q = new LinkedList<>();
            q.add(root);
           

            while(!q.isEmpty()){
                Node curr = q.remove();
                
                    System.out.print(curr.data+" ");
                    if(curr.left!= null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                
            }

        }
        
    }
    public static void main(String args[]){
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Tree t = new Tree();
        Node root = t.buildPreorder(arr);
        t.levelorderTraversal2(root);

    }
}