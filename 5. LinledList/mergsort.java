import java.util.*;
public class mergsort{
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
        return;

    }
    public static class LinkedList{
        public static Node head = null;
        public static Node tail = null;

        public static void insert(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = tail.next;
        }

        public static Node merg(Node left,Node right){
            Node temp = new Node(-1);
            
            Node count = temp;
            while(left != null && right != null){
                if(left.data < right.data){
                    count.next = left;
                    count = count.next;
                    left = left.next;

                }
                else{
                    count.next = right;
                    count = count.next;
                    right = right.next;
                }
            }
            if(left != null){
                count.next = left; 
            }
            if(right != null){
                count.next = right;
            }
            return temp.next;
        }
        public static Node Mergsort(Node head){
            if(head.next == null){
                return head;
            }
            Node slow = head;
            Node fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;
            Node right = mid.next;
            mid.next = null;
            Node Left = Mergsort(head);
            Node Right = Mergsort(right);
            return merg(Left,Right);

        }
        
    } 
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(5);
        ll.insert(4);
        ll.insert(-3);

        print(ll.head);
        ll.head = ll.Mergsort(ll.head);
        print(ll.head);
        
    }
}