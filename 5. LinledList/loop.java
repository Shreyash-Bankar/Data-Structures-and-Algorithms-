import java.util.*;

public class loop{
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
        public static boolean loopDetection(Node head){
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return true;
                }
            }
            return false;
        }
        public static Node loopIdentification(Node head){
            if(loopDetection(head) != true){
                return null;
            }
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    break;
                }
            }
            slow = head;
            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            Node temp = fast.next;
            fast.next = null;
            return temp;
        }
        
       
    } 
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        print(ll.head);
        ll.tail.next = ll.head.next;
        System.out.println(ll.loopDetection(ll.head));
        System.out.println(ll.loopIdentification(ll.head).data);
        System.out.println(ll.loopDetection(ll.head));
        
    }
}