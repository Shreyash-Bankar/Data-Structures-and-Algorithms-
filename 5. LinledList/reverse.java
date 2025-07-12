import java.util.*;
public class reverse{
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
    } 
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        print(ll.head);
        Node root = ll.reverse(ll.head);
        print(ll.head);
    }
}