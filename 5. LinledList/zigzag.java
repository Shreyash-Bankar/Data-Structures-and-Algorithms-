import java.util.*;
public class zigzag{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static class LinkedList{
        static Node head = null;
        static Node tail = null;

        public static Node insert(int data){
            Node newNode = new Node(data); 
            if(head == null){
                head =tail =  newNode;
                return head;
            }
            tail.next = newNode;
            tail = newNode;
            return head;
        }
        public static Node mid(Node head){
            Node slow = head;
            Node fast = head.next;
            while(fast != null && fast.next != null ){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
        public static Node arrange (Node head){
            Node Mid = mid( head );
            Node right = Mid.next;
            right = reverse(right);
            Mid.next = null;
            Node left = head;
            Node temp = new Node(-1);
            Node curr = temp;
            while(curr != null){
                curr.next = left;
                if(left != null){
                    left = left.next;
                }
                curr = curr.next;
                if(curr == null){
                    break;
                }
                curr.next = right;
                if(right != null){
                    right = right.next;
                }
                curr = curr.next;

            }
            return temp.next;
        }
        public static Node reverse(Node right){
            Node curr = right;
            Node prev = null;
            Node next;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    } 
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        Node root = ll.insert(4);
        // Node root = ll.insert(5);
        print(root);

        root = ll.arrange(root);
        
        print(root);
    }
}