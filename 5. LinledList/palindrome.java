import java.util.*;
public class palindrome{
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
        public static Node reverse(Node Head){
            Node curr = Head;
            Node prev = null;
            Node next;

            while(curr !=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            tail = head;
            head = prev;
            return prev;
        }
        public static boolean palindrome(Node head){
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;
            Node temp1 = head;
            Node temp2 = tail;
            reverse(mid);

            while(temp2 != null){
                if(temp1.data != temp2.data){
                    
                    return false;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            reverse(mid);
            return true;
        }
    } 
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(2);
        ll.insert(4);
        ll.insert(5);
        ll.insert(7);
        ll.insert(2);
        ll.insert(2);
        ll.insert(1);
        print(ll.head);
        Node root = ll.reverse(ll.head);
        print(ll.head);
        System.out.print(ll.palindrome(ll.head));
    }
}