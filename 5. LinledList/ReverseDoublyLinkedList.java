import java.util.*;
public class ReverseDoublyLinkedList{
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
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
    public static void printR(Node tail){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static class DoublyLinkedList{
             static Node head = null;
             static Node tail = null;
        public static Node insert(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return head; 
            }
            tail.next = newNode;
            Node temp = tail;
            tail = tail.next;
            tail.prev = temp;
            return head;
        }
        public static Node reverse(Node Head){
            Node curr = Head;
            Node prev = null;
            Node next;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                curr.prev = next;
                prev = curr;
                curr = next;
            }

            head = prev;
            tail = Head;
            return prev;
        }
        
    }
    public static void main(String args[]){
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        System.out.print("Forward: ");
        print(ll.head);
        System.out.print("Reverse: ");
        printR(ll.tail);
        ll.reverse(ll.head);
        System.out.println("Doing reverse ...............");
        System.out.print("Forward: ");
        print(ll.head);
        System.out.print("Reverse: ");
        printR(ll.tail);
    }
}