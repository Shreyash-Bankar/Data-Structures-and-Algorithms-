import java.util.*;
public class mergBST{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
        }
    }
    public static void getInorder(Node root, ArrayList <Integer> list){
        if(root == null){
            return ;
        }
        getInorder(root.left , list);
        list.add(root.data);
        getInorder(root.right , list);
    }
    public static Node buildBST(ArrayList<Integer> list,int si,int ei){
        if(si > ei){
            return null;
        }
        int mid = si + (ei - si) / 2 ;
        Node newNode = new Node(list.get(mid));
        newNode.left = buildBST(list,si,mid-1);
        newNode.right = buildBST(list,mid + 1,ei);
        return newNode;

    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static Node merg(Node root1, Node root2){
        ArrayList <Integer> list1 =new ArrayList<>();
         getInorder(root1 , list1);
        
        ArrayList <Integer> list2 =new ArrayList<>();
         getInorder(root2 , list2);
        
       
        ArrayList  <Integer> list = new ArrayList <>();
        int i = 0; int j = 0;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j) ){
                list.add(list1.get(i));
                i++;
            }else{
                list.add(list2.get(j));
                j++;
            }
        }
        while(i<list1.size()){
                list.add(list1.get(i));
                i++;

        }
        while(j<list2.size()){
                list.add(list2.get(j));
                j++;

        }
        
        Node root = buildBST(list,0,list.size()-1);
        return root;

    }
    public static void main(String args[]){
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = merg(root1,root2);
        preorder(root);

    }
}